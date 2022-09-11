package Java;

public class Ladrao extends Personagem{
    Ladrao() {
        super.setClasse("Ladrao");
        super.setPontosDeVida(2800);
        super.setPontosDeMana(50);
        super.setManaMaxima(50);
        super.setForcaFisica(50);
        super.setForcaMagica(30);
        super.setArmadura(40);
        super.setResistenciaMagica(50);
        super.setAgilidade(80);
        super.Cajado();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - TEMPESTADE\n2 - INTOXICACAO\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Tempestade();
        } else if (escolha == 2) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Intoxicacao();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - CAJADO\n2 - PORRETE\n3 - BESTA\n4 - ESFERA DE ATAQUE\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU O CAJADO!");
            Cajado();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU O PORRETE!");
            Porrete();
        } else if (escolha == 3) {
            System.out.println("VOCE EQUIPOU A BESTA!");
            Besta();
        } else if (escolha == 4) {
            System.out.println("VOCE EQUIPOU A ESFERA DE ATAQUE!");
            EsferaDeAtaque();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }
}
