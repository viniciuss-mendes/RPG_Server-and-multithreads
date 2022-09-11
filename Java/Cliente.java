package Java;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Cliente implements Runnable {
    
    public Personagem personagem;
    public String login;

    static void playerChoiceOptions(Personagem p) {
        System.out.println("\nVOCE ESCOLHEU " + p.getClasse() + "!\n");
        System.out.print("VIDA:" + p.getPontosDeVida());
        System.out.print(" | MANA:" + p.getPontosDeMana());
        System.out.print(" | FORCA FISICA:" + p.getForcaFisica());
        System.out.print(" | FORCA MAGICA:" + p.getForcaMagica());
        System.out.print(" | ARMADURA:" + p.getArmadura() + "\n");
        System.out.print("RESISTENCIA MAGICA:" + p.getResistenciaMagica());
        System.out.print(" | AGILIDADE:" + p.getAgilidade());
        System.out.print(" | ARMA INICIAL:" + p.getArma());
    }

    static Personagem playerChoiceMenu(String player) {

        Personagem personagem = new Personagem();

        int escolha = 0;
        while (escolha < 1 || escolha > 8) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }

            System.out.println("\n\n           ESCOLHA SEU PERSONAGEM " + player);
            System.out.println("\n-x- HUMANOS -x-\n  1 - GUERREIRO\n  2 - LADRAO\n  3 - MAGO\n  4 - PALADINO");
            System.out.println("\n-x- INUMANOS -x-\n  5 - ANIMAL\n  6 - TROLL\n  7 - DRAGAO\n  8 - ZUMBI");
            
            
            System.out.print("\nESCOLHA: ");
            escolha = Global.scanner.nextInt();

            switch (escolha) {
                case 1: {
                    personagem = new Guerreiro();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 2: {
                    personagem = new Ladrao();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 3: {
                    personagem = new Mago();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 4: {
                    personagem = new Paladino();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 5: {
                    personagem = new Animal();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 6: {
                    personagem = new Troll();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 7: {
                    personagem = new Dragao();
                    playerChoiceOptions(personagem);
                    break;
                }
                case 8: {
                    personagem = new Zumbi();
                    playerChoiceOptions(personagem);
                    break;
                }
                default: {
                    System.out.println("VALOR INVALIDO!");
                    break;
                }
            }
        }

        return personagem;
    }

    public static Personagem recuperaMana(Personagem player) {
        if (player.getPontosDeMana() < player.getManaMaxima()) {

            if (player.getPontosDeMana() + 10 > player.getManaMaxima())
                player.setPontosDeMana(player.getManaMaxima());
            else
                player.setPontosDeMana(player.getPontosDeMana() + 10);
        }

        return player;
    }

    public void danoBoss(){
        
        boolean acertoCritico = Global.random(0, 100) < 30;
        
        int habilidade = Global.random(1, 6);

        int dano, danoCausado;

        switch (habilidade) {
            case 1:
                // Furia do Dragao 
                
                dano = Global.random(400, 600);
                if(acertoCritico) {
                    System.out.println("\n** (BOSS) ACERTO CRITICO **");
                    dano *= 2;

                }
                danoCausado = dano - ((personagem.getArmadura() * dano) / 100);
                personagem.setPontosDeVida(personagem.getPontosDeVida() - danoCausado);
                System.out.println("\nBOSS UTILIZOU FURIA DO DRAGAO!\nDANO CAUSADO:" + danoCausado);

                break;
            
            case 2: 
                // Rabo Chicote

                dano = Global.random(350, 600);
                if(acertoCritico) {
                    System.out.println("\n** (BOSS) ACERTO CRITICO **");
                    dano *= 2;

                }
                danoCausado = dano - ((personagem.getArmadura() * dano) / 100);
                personagem.setPontosDeVida(personagem.getPontosDeVida() - danoCausado);
                System.out.println("\nBOSS UTILIZOU RABO CHICOTE!\n>> DANO CAUSADO:" + danoCausado + "\n");

                break;

            case 3:
                // Tempestade de Fogo

                dano = Global.random(400, 1000);
                if(acertoCritico) {
                    System.out.println("\n** (BOSS) ACERTO CRITICO ** ");
                    dano *= 2;

                }
                danoCausado = dano - ((personagem.getResistenciaMagica() * dano) / 100);
                personagem.setPontosDeVida(personagem.getPontosDeVida() - danoCausado);
                System.out.println("\nBOSS UTILIZOU TEMPESTADE DE FOGO!\n>> DANO CAUSADO:" + danoCausado+ "\n");

                break;

            case 4:
                // Enfraquecimento Mortal

                int reducaoForca = Global.random(1, 5);
                personagem.setForcaFisica(personagem.getForcaFisica() - reducaoForca);
                System.out.println("\nBOSS UTILIZOU ENFRAQUECIMENTO MORTAL!\n>> SUA FORCA FISICA DIMIMUI EM:" + reducaoForca);

                break;
            case 5:
                // Roubo de Mana
                
                int manaRoubada = Global.random(2,5);
                personagem.setPontosDeMana(personagem.getPontosDeMana() - manaRoubada);
                System.out.println("\nBOSS UTILIZOU ROUBO DE MANA!\n>> " + manaRoubada + " DE MANA FOI ROUBADO!"+ "\n");

                break;
            case 6:
                // Anula Magia

                int reducaoMagia = Global.random(1, 3);
                personagem.setForcaMagica((personagem.getForcaMagica() - reducaoMagia));
                System.out.println("\n BOSS UTILIZOU ANULA MAGIA!\n>> SUA FORCA MAGICA DIMIMUI EM:" + reducaoMagia+ "\n");

                break;

            default:
                break;
        }
    }

    /**
     * Endereço IP ou nome DNS para conectar no servidor.
     */
    public static final String SERVER_ADDRESS = "127.0.0.1";

    private final Scanner scanner;
    
    /**
     * Objeto que armazena alguns dados do cliente (como o login)
     */
    private ClientSocket clientSocket;
    
    /**
     * Executa a aplicação cliente.
     * Pode-se executar quantas instâncias desta classe desejar.
     * Isto permite ter vários clientes conectados e interagindo
     * por meio do servidor.
     * 
     * @param args parâmetros de linha de comando (não usados para esta aplicação)
     */
    public static void main(String[] args) {
        try {
            Cliente client = new Cliente();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }
    
    /**
     * Instancia um cliente, realizando o mínimo de operações necessárias.
     */
    public Cliente(){
        scanner = new Scanner(System.in);
    }

    /**
     * Inicia o cliente, conectando ao servidor e entrando no loop de envio e recebimento de mensagens.
     * @throws IOException quando um erro de I/O (Input/Output) ocorrer
     */
    private void start() throws IOException {
        final Socket socket = new Socket(SERVER_ADDRESS, Servidor.PORT);
        clientSocket = new ClientSocket(socket);
        System.out.println(
            "\n(!) Jogador conectado ao servidor no endereço " + SERVER_ADDRESS +
            " e porta " + Servidor.PORT + ".\n");

        login();

        new Thread(this).start();
        messageLoop();
    }

    /**
     * Executa o login no sistema, enviando o login digitado para o servidor.
     * A primeira mensagem que o servidor receber após um cliente conectar é então o login daquele cliente.
     */
    private void login() {
        System.out.print("DIGITE SEU NICKNAME DE HEROI: ");
        this.login = scanner.nextLine();
        clientSocket.setLogin(login);
        clientSocket.sendMsg(login);

    }

    /**
     * Inicia o loop de envio e recebimento de mensagens.
     * O loop é interrompido quando o usuário digitar "sair".
     */
    private void messageLoop() {
        int escolha;
        this.personagem = playerChoiceMenu(this.login);

        while (personagem.getPontosDeVida() > 0) {

            try {
                Thread.sleep(1500);
            } catch (Exception e) {

            }

            System.out.println("\n==================================================");

            System.out.println("\n" + personagem.getClasse() + "\n[+] VIDA: "
                        + personagem.getPontosDeVida() + "   [=] MANA: " + personagem.getPontosDeMana());

                System.out.println("\nx------------------x\n|      ACOES       |\nx------------------x");
                System.out.println("\n1 - ATACAR\n2 - MAGIA\n3 - TROCAR DE ARMA");

                boolean espadaLendaria = (Global.random(0, 100) < 20);

                if (espadaLendaria == true) {
                    System.out.println("4 - VOTO SOLENE DE BUL-KATHOS!");
                }
                
                System.out.print("\nESCOLHA: ");
                escolha = Global.scanner.nextInt();

                switch (escolha) {
                    case 1: {

                        boolean esquivou = (Global.random(0, 100)) < 30;

                        if (esquivou == false) {

                            int dano = Global.random(personagem.getDanoMinimo(), personagem.getDanoMaximo());
                            int danoCausado = dano + ((personagem.getForcaFisica() * dano) / 100);

                            clientSocket.sendMsg(danoCausado + ";" + this.login);
                            //if (Servidor.BOSS <= 0) break;

                        } else
                            System.out.print("\n(~) O BOSS ESQUIVOU DO ATAQUE!\n");

                        personagem = recuperaMana(personagem);

                        break;
                    }
                    case 2: {
                        int dano = personagem.selecionarMagia();

                        if (dano != 0) {

                            boolean esquivou = (Global.random(0, 100)) < 30;

                            if (esquivou == false) {
                                int danoCausado = dano;

                                clientSocket.sendMsg(danoCausado + ";" + login);

                            } else
                                System.out.println("\n(~) O BOSS ESQUIVOU DO ATAQUE!");
                        }
                        break;
                    }
                    case 3: {
                        personagem.selecionarArma();
                        personagem = recuperaMana(personagem);

                        break;
                    }
                    case 4: {

                        if (espadaLendaria == true) {
                            int dano = personagem.EspadaLendaria();
                            boolean esquivou = Global.random(0, 100) < 20;

                            if (esquivou == false) {
                                dano = dano + ((personagem.getForcaFisica() * dano) / 100);
                                int danoCausado = dano;
                                
                                clientSocket.sendMsg(danoCausado + ";" + login);

                            } else
                                System.out.println("\n(~) O BOSS ESQUIVOU DO ATAQUE!");
                        }

                        break;
                    }
                    default:
                        break;
                }

                danoBoss();
        
        }

        System.out.println("\n\nd[x(]> Seu personagem foi de BERÇO - F no chat!");

        System.exit(0);
        clientSocket.close();
    }

    /**
     * Aguarda mensagens do servidor enquanto o socket não for fechado e o cliente não receber uma mensagem null.
     */
    @Override
    public void run() {
        String msg;
        while((msg = clientSocket.getMessage())!=null) {
            System.out.println(msg);

            if(msg.equals("Obrigado por Jogar! Voce sera DESCONECTADO.")) System.exit(0);
        }
    }
}