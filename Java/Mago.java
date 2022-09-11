package Java;

public class Mago extends Personagem {

    Mago() {
        super.setClasse("Mago");
        super.setPontosDeVida(2500); // 2500
        super.setPontosDeMana(100);
        super.setManaMaxima(100);
        super.setForcaFisica(40);
        super.setForcaMagica(100);
        super.setArmadura(30);
        super.setResistenciaMagica(80);
        super.setAgilidade(40);
        Cajado();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print(
                "\n1 - TEMPESTADE\n2 - INTOXICACAO\n3 - POCAO DE VIDA\n4 - BIO\n5 - CURA\n6 - FLAMA GELADA\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Tempestade();
        } else if (escolha == 2) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Intoxicacao();

        } else if (escolha == 3) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            PocaoDeVida();
            return 0;

        } else if (escolha == 4) {
            System.out.println("VOCE GASTOU 14 DE MANA");
            return Bio();

        } else if (escolha == 5) {
            System.out.println("VOCE GASTOU 16 DE MANA");
            Cura();
            return 0;

        } else if (escolha == 6) {
            System.out.println("VOCE GASTOU 14 DE MANA");
            return FlamaGelada();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - TRIDENTE SAGRADO\n2 - CAJADO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU O TRIDENTE SAGRADO!");
            TridenteSagrado();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU O CAJADO!");
            Cajado();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }
};

