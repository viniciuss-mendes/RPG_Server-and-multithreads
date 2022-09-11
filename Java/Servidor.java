package Java;

import java.io.*;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Servidor {
    /**
     * Porta na qual o servidor vai ficar escutando (aguardando conexões dos clientes).
     */
    public static final int PORT = 4000;
    public int BOSS = 10000;

    /**
     * Objeto que permite ao servidor ficar escutando na porta especificada acima.
     */
    private ServerSocket serverSocket;

    /**
     * Lista de todos os clientes conectados ao servidor.
     */
    private final List<ClientSocket> clientSocketList;

    public Servidor() {
        clientSocketList = new LinkedList<>();
    }

    public static int random(int min, int max) // range : [min, max]
    {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    /**
     * Executa a aplicação servidora que fica aguardando conexões dos clientes.
     * @param args parâmetros de linha de comando (não usados para esta aplicação)
     */
    public static void main(String[] args) {
        final Servidor server = new Servidor();
        try {
            server.start();
        } catch (IOException e) {
            System.err.println("Erro ao iniciar servidor: " + e.getMessage());
        }
    }

    /**
     * Inicia a aplicação, criando um socket para o servidor
     * ficar escutando na porta
     * 
     * @throws IOException quando um erro de I/O (Input/Output) ocorrer
     */
    private void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println(
                "\n|------------------ RPG server ------------------|\n\nServidor de RPG iniciado no endereço [" + serverSocket.getInetAddress().getHostAddress() +
                "] e porta [" + PORT + "]");
        clientConnectionLoop();
    }

    /**
     * Inicia o loop infinito de espera por conexões dos clientes
     * 
     * @throws IOException quando um erro de I/O (Input/Output) ocorrer
     */
    private void clientConnectionLoop() throws IOException {
        try {
            while (true) {
                System.out.println("\n(?) Aguardando conexão de novo jogador ...");
                
                final ClientSocket clientSocket;
                try {
                    clientSocket = new ClientSocket(serverSocket.accept());
                    System.out.println("\n(!) Jogador " + clientSocket.getRemoteSocketAddress() + " conectado!");
                }catch(SocketException e){
                    System.err.println("Erro ao aceitar conexão do cliente. O servidor possivelmente está sobrecarregado:");
                    System.err.println(e.getMessage());
                    continue;
                }

                /*
                Cria uma nova Thread para permitir que o servidor não fique bloqueado enquanto atende às requisições de um único cliente.
                */
                try {
                    new Thread(() -> clientMessageLoop(clientSocket)).start();
                    clientSocketList.add(clientSocket);
                }catch(OutOfMemoryError ex){
                    System.err.println(
                            "Não foi possível criar thread para novo cliente. O servidor possivelmente está sobrecarregdo. Conexão será fechada: ");
                    System.err.println(ex.getMessage());
                    clientSocket.close();
                }
            }
        } finally{
            /*Se sair do laço de repetição por algum erro, exibe uma mensagem
            indicando que o servidor finalizou e fecha o socket do servidor.*/
            stop();
        }
    }

    /**
     * Método executado sempre que um cliente conectar ao servidor.
     * O método fica em loop aguardando mensagens do cliente,
     * até que este desconecte.
     * 
     * @param clientSocket socket do cliente, por meio do qual o servidor
     *                     pode se comunicar com ele.
     */
    private void clientMessageLoop(final ClientSocket clientSocket){
        try {
            String msg;
            while((msg = clientSocket.getMessage()) != null){
                final SocketAddress clientIP = clientSocket.getRemoteSocketAddress();
                if("sair".equalsIgnoreCase(msg)){
                    return;
                }

                if(clientSocket.getLogin() == null){
                    clientSocket.setLogin(msg);
                    System.out.println("*\nNOVO JOGADOR!* ("+ clientIP + ") - BOA SORTE, " + clientSocket.getLogin() +"!");
                    msg = "\n=> O heroi " + clientSocket.getLogin() + " se juntou a batalha!";
                }
                else {
                    System.out.println("(+) Acao recebida de "+ clientSocket.getLogin() +": " + msg);

                    int danoCausado = Integer.parseInt(msg.split(";")[0]);
                    String player = msg.split(";")[1];

                    this.BOSS -= danoCausado;

                    msg = "(ATAQUE) " + danoCausado + " de dano causado ao BOSS por " + player + "! "+ "\n\n[+] VIDA BOSS: " + BOSS;

                    boolean chanceCura = Global.random(0, 100) < 40;
                    if (chanceCura){
                        int cura = Global.random(0,1000);
                        BOSS += cura;
                        sendMsgToAll(clientSocket, "[HP] ++ O BOSS CUROU " + cura + "!");
                    }

                };

                sendMsgToAll(clientSocket, msg);

                if(BOSS <= 0) {
                    sendMsgToAll(clientSocket, "x-----------------------------------x\n" + "|     BOSS DERROTADO! PARABENS!     |\n" + "x-----------------------------------x\n");
                    sendMsgToAll(clientSocket, "Obrigado por Jogar! Voce sera DESCONECTADO.");
                    stop();
                    System.exit(0);
                }
            }
        } finally {
            clientSocket.close();
        }
    }
    
    /**
     * Encaminha uma mensagem recebida de um determinado cliente
     * para todos os outros clientes conectados.
     * 
     * @param sender cliente que enviou a mensagem
     * @param msg mensagem recebida. 
     */
    private void sendMsgToAll(final ClientSocket sender, final String msg) {
       
        final Iterator<ClientSocket> iterator = clientSocketList.iterator();
        /*Percorre a lista usando o iterator enquanto existir um próxima elemento (hasNext)
        para processar, ou seja, enquanto não percorrer a lista inteira.*/
        while (iterator.hasNext()) {
            //Obtém o elemento atual da lista para ser processado.
            final ClientSocket client = iterator.next();
            /*Verifica se o elemento atual da lista (cliente) não é o cliente que enviou a mensagem.
            Se não for, encaminha a mensagem pra tal cliente.*/

                if(client.sendMsg(msg)){}
                else iterator.remove();
        }
    }

    /**
     * Fecha o socket do servidor quando a aplicação estiver sendo finalizada.
     */
    public void stop()  {
        try {
            System.out.println(">> BOSS DERROTADO!");
            System.out.println("Finalizando servidor");
            serverSocket.close();
            
        } catch (IOException e) {
            System.err.println("Erro ao fechar socket do servidor: " + e.getMessage());
        }
    }
}