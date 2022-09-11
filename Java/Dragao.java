package Java;

public class Dragao extends Personagem {

    Dragao() {
        super.setClasse("Dragao");
        super.setPontosDeVida(3000);
        super.setPontosDeMana(40);
        super.setManaMaxima(40);
        super.setForcaFisica(100);
        super.setForcaMagica(20);
        super.setArmadura(50);
        super.setResistenciaMagica(50);
        super.setAgilidade(30);
        GarraLetal();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - HALITO DE FOGO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return HalitoDeFogo();
        }

        else
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
