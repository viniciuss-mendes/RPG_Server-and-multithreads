package Java;

class Animal extends Personagem {

    Animal() {
        super.setClasse("Animal");
        super.setPontosDeVida(3200);
        super.setPontosDeMana(30);
        super.setManaMaxima(30);
        super.setForcaFisica(80);
        super.setForcaMagica(20);
        super.setArmadura(80);
        super.setResistenciaMagica(20);
        super.setAgilidade(50);
        super.GarraLetal();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - BIO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 14 DE MANA");
            return Bio();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");

        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - GARRA LETAL\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU A GARRA LETAL!");
            GarraLetal();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }
};

