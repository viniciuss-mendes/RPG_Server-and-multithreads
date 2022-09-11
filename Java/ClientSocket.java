package Java;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Permite enviar e receber mensagens por meio de um socket cliente.
 */
public class ClientSocket implements Closeable {
    /**
     * Login do cliente.
     */
    private String login;

    /**
     * Socket da conexão de um cliente com o servidor.
     */
    private final Socket socket;

    /**
     *  Permite ler mensagens recebidas ou enviadas pelo cliente.
     */
    private final BufferedReader in;

    /**
     *  Permite enviar mensagens do cliente para o servidor ou do servidor para o cliente.
     */
    private final PrintWriter out;

    /**
     * Instancia um ClientSocket.
     *
     * @param socket socket que representa a conexão do cliente com o servidor.
     * @throws IOException quando não for possível obter os objetos que permitem,
     * respectivamente, receber e enviar mensagens pelo socket.
     */
    public ClientSocket(final Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Envia uma mensagem e não espera por uma resposta.
     * @param msg mensagem a ser enviada
     * @return true se o socket ainda estava aberto e a mensagem foi enviada, false caso contrário
     */
    public boolean sendMsg(String msg) {
        out.println(msg);
        
        return !out.checkError();
    }

    /**
     * Obtém uma mensagem de resposta.
     * @return a mensagem obtida ou null se ocorreu erro ao obter a resposta (como falha de conexão)
     */
    public String getMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    /**
     * Fecha a conexão do socket e os objetos usados para enviar e receber mensagens.
     */
    @Override
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch(IOException e){
            System.err.println("Erro ao fechar socket: " + e.getMessage());
        }
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    public boolean isOpen(){
        return !socket.isClosed();
    }
}