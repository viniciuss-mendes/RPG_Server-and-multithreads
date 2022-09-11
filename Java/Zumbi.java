package Java;

public class Zumbi extends Personagem {

    public Zumbi() {
        super.setClasse("Zumbi");
        super.setPontosDeVida(2500);
        super.setPontosDeMana(20);
        super.setManaMaxima(20);
        super.setForcaFisica(40);
        super.setForcaMagica(20);
        super.setArmadura(40);
        super.setResistenciaMagica(80);
        super.setAgilidade(50);
        super.Cajado();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - INTOXICACAO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Intoxicacao();
        }

        else
            System.out.println("\nERRO! VALOR INVALIDO!");

        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - GARRA LETAL\n2 - PORRETE\n3 - CAJADO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU A GARRA LETAL!");
            GarraLetal();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU O PORRETE!");
            Porrete();
        } else if (escolha == 3) {
            System.out.println("VOCE EQUIPOU O CAJADO");
            Cajado();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }
};
