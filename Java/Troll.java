package Java;

public class Troll extends Personagem {

    Troll() {
        super.setClasse("Troll");
        super.setPontosDeVida(2800);
        super.setPontosDeMana(20);
        super.setManaMaxima(20);
        super.setForcaFisica(100);
        super.setForcaMagica(20);
        super.setArmadura(80);
        super.setResistenciaMagica(20);
        super.setAgilidade(20);
        Cajado();
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
        System.out.print("\n1 - PORRETE\n2 - CAJADO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU O PORRETE!");
            Porrete();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU O CAJADO!");
            Cajado();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }

};
