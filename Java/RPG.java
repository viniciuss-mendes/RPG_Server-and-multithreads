package Java;

class RPG {

    static int turnos = 1;

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

    public static Personagem selecionarPlayerAlvo(int jogadorTurno, Personagem player1, Personagem player2,
            Personagem player3) {

        int jogadorAlvo = 0;

        System.out.println("\nESCOLHA O JOGADOR ALVO:");

        if (jogadorTurno == 0) {
            if (player2.getPontosDeVida() > 0) System.out.println("1 - " + player2.getClasse() + " (" + Global.jogador2 + ")" + " - VIDA: " + player2.getPontosDeVida());

            if (player3.getPontosDeVida() > 0) System.out.println("2 - " + player3.getClasse() + " (" + Global.jogador3 + ")" + " - VIDA: " + player3.getPontosDeVida());

            System.out.print("\nESCOLHA: ");
            jogadorAlvo = Global.scanner.nextInt();

            if(jogadorAlvo == 1) return player2;
            else if(jogadorAlvo == 2) return player3;
            else new Exception ("Erro: Alvo inválido!");

        } else if (jogadorTurno == 1) {
            
            if (player1.getPontosDeVida() > 0) System.out.println("1 - " + player1.getClasse() + " (" + Global.jogador1 + ")" + " - VIDA: " + player1.getPontosDeVida());

            if (player3.getPontosDeVida() > 0) System.out.println("2 - " + player3.getClasse() + " (" + Global.jogador3 + ")" + " - VIDA: " + player3.getPontosDeVida());

            System.out.print("\nESCOLHA: ");
            jogadorAlvo = Global.scanner.nextInt();

            if(jogadorAlvo == 1) return player1;
            else if(jogadorAlvo == 2) return player3;
            else new Exception ("Erro: Alvo inválido!");

        } else {
            if (player1.getPontosDeVida() > 0) System.out.println("1 - " + player1.getClasse() + " (" + Global.jogador1 + ")" + " - VIDA: " + player1.getPontosDeVida());

            if (player2.getPontosDeVida() > 0) System.out.println("2 - " + player2.getClasse() + " (" + Global.jogador2 + ")" + " - VIDA: " + player2.getPontosDeVida());

            System.out.print("\nESCOLHA: ");
            jogadorAlvo = Global.scanner.nextInt();

            if(jogadorAlvo == 1) return player1;
            else if(jogadorAlvo == 2) return player2;
            else new Exception ("Erro: Alvo inválido!");
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(
                "x---------------------------------------------x\n|                RPG POR TURNOS               |\nx---------------------------------------------x");

        Personagem player1 = new Personagem();
        Personagem player2 = new Personagem();
        Personagem player3 = new Personagem();

        // escolha player 1
        player1 = playerChoiceMenu(Global.jogador1);
        // escolha player 2
        player2 = playerChoiceMenu(Global.jogador2);
        // escolha player 3
        player3 = playerChoiceMenu(Global.jogador3);

        while ((player1.getPontosDeVida() > 0 && player2.getPontosDeVida() > 0) ||
                (player2.getPontosDeVida() > 0 && player3.getPontosDeVida() > 0)
                || (player1.getPontosDeVida() > 0 && player3.getPontosDeVida() > 0)) {

            int escolha = 0;
            int jogadorTurno = turnos % 3;
            String nomeJogador = "";
            Personagem player;
            Personagem playerAlvo;

            if (jogadorTurno == 0) {
                player = player1;
                nomeJogador = Global.jogador1;
            } else if (jogadorTurno == 1) {
                player = player2;
                nomeJogador = Global.jogador2;
            } else {
                player = player3;
                nomeJogador = Global.jogador3;
            }

            if (player.getPontosDeVida() > 0) {

                System.out.println(
                        "\n===================================================================\n\n       -X- TURNO "
                                + turnos + " -X-");

                System.out.println("\nVEZ DE " + nomeJogador + " - " + player.getClasse() + "\nVIDA: "
                        + player.getPontosDeVida() + "   MANA: " + player.getPontosDeMana());

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

                        playerAlvo = selecionarPlayerAlvo(jogadorTurno, player1, player2, player3);

                        boolean esquivou = (Global.random(0, 100)) < playerAlvo.getAgilidade()/2;

                        if (esquivou == false) {

                            int dano = Global.random(player.getDanoMinimo(), player.getDanoMaximo());
                            dano = dano + ((player.getForcaFisica() * dano) / 100);
                            int danoCausado = dano - ((playerAlvo.getArmadura() * dano) / 100);

                            playerAlvo.setPontosDeVida(playerAlvo.getPontosDeVida() - (int) danoCausado);

                            System.out.print(danoCausado + " DE DANO CAUSADO!");

                        } else
                            System.out.print("\nO ADVERSARIO ESQUIVOU DO ATAQUE!");

                        player = recuperaMana(player);

                        break;
                    }
                    case 2: {
                        int dano = player.selecionarMagia();

                        if (dano != 0) {

                            playerAlvo = selecionarPlayerAlvo(jogadorTurno, player1, player2, player3);

                            boolean esquivou = (Global.random(0, 100)) < player.getAgilidade()/2;

                            if (esquivou == false) {
                                int danoCausado = dano - ((playerAlvo.getResistenciaMagica() * dano) / 100);
                                playerAlvo.setPontosDeVida(playerAlvo.getPontosDeVida() - (int) danoCausado);

                                System.out.println("\n" + danoCausado + " DE DANO CAUSADO!");

                            } else
                                System.out.println("\nO ADVERSARIO ESQUIVOU DO ATAQUE!");
                        }
                        break;
                    }
                    case 3: {
                        player.selecionarArma();
                        player = recuperaMana(player);

                        break;
                    }
                    case 4: {

                        playerAlvo = selecionarPlayerAlvo(jogadorTurno, player1, player2, player3);

                        if (espadaLendaria == true) {
                            int dano = playerAlvo.EspadaLendaria();
                            boolean esquivou = Global.random(0, 100) < player.getAgilidade()/2;

                            if (esquivou == false) {
                                dano = dano + ((player.getForcaFisica() * dano) / 100);
                                int danoCausado = dano - ((playerAlvo.getArmadura() * dano) / 100);
                                playerAlvo.setPontosDeVida(playerAlvo.getPontosDeVida() - (int) danoCausado);
                                System.out.println("\n" + danoCausado + " DE DANO CAUSADO!");

                            } else
                                System.out.println("\nO ADVERSARIO ESQUIVOU DO ATAQUE!");
                        }

                        break;
                    }
                    default:
                        break;
                }

                if (player1.getPontosDeVida() <= 0)
                    System.out.println("\n" + Global.jogador1 + " ABATIDO!");
                if (player2.getPontosDeVida() <= 0)
                    System.out.println("\n" + Global.jogador2 + " ABATIDO!");
                if (player3.getPontosDeVida() <= 0)
                    System.out.println("\n" + Global.jogador3 + " ABATIDO!");

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }

            turnos++;
        }

        if (player1.getPontosDeVida() <= 0 && player2.getPontosDeVida() <= 0 && player3.getPontosDeVida() > 0) {
            System.out.println(
                    "\nx-------------------------------x\n|       VITORIA DO " + Global.jogador3 + "      |\nx-------------------------------x");
        } else if (player1.getPontosDeVida() <= 0 && player2.getPontosDeVida() > 0 && player3.getPontosDeVida() <= 0) {
            System.out.println(
                    "\nx-------------------------------x\n|       VITORIA DO " + Global.jogador2 + "      |\nx-------------------------------x");
        } else if (player1.getPontosDeVida() > 0 && player2.getPontosDeVida() <= 0 && player3.getPontosDeVida() <= 0) {
            System.out.println(
                    "\nx-------------------------------x\n|       VITORIA DO " + Global.jogador1 + "      |\nx-------------------------------x");
        } else {
            System.out.println(
                    "\nx-------------------------------x\n|       EMPATE      |\nx-------------------------------x");
        }
    }
}