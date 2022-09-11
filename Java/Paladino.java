package Java;

public class Paladino extends Personagem {

    Paladino() {
        super.setClasse("Paladino");
        super.setPontosDeVida(3200);
        super.setPontosDeMana(80);
        super.setManaMaxima(80);
        super.setForcaFisica(60);
        super.setForcaMagica(50);
        super.setArmadura(60);
        super.setResistenciaMagica(60);
        super.setAgilidade(60);
        super.Besta();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - TEMPESTADE\n2 - POCAO DE VIDA\n3 - FLAMA GELADA\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Tempestade();
        } else if (escolha == 2) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            PocaoDeVida();
            return 0;

        } else if (escolha == 3) {
            System.out.println("VOCE GASTOU 14 DE MANA");
            return FlamaGelada();

        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - TRIDENTE SAGRADO\n2 - BESTA\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU O TRIDENTE SAGRADO!");
            TridenteSagrado();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU A BESTA!");
            Besta();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }
};
