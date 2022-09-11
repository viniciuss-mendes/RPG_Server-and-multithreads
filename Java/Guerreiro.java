package Java;

public class Guerreiro extends Personagem {

    public Guerreiro() {
        super.setClasse("Guerreiro");
        super.setPontosDeVida(4000); 
        super.setPontosDeMana(30);
        super.setManaMaxima(30);
        super.setForcaFisica(100);
        super.setForcaMagica(20);
        super.setArmadura(80);
        super.setResistenciaMagica(20);
        super.setAgilidade(20);
        super.setPontosDeMana(30);
        super.Porrete();
    }

    int selecionarMagia() {
        int escolha;
        System.out.print("\n1 - TEMPESTADE\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE GASTOU 12 DE MANA");
            return Tempestade();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
        return 0;
    }

    void selecionarArma() {
        int escolha;
        System.out.print("\n1 - ESPADA BARROCA\n2 - PORRETE\n\nEscolha: ");
        escolha = Global.scanner.nextInt();

        if (escolha == 1) {
            System.out.println("VOCE EQUIPOU A ESPADA BARROCA!");
            EspadaBarroca();
        } else if (escolha == 2) {
            System.out.println("VOCE EQUIPOU O PORRETE!");
            Porrete();
        } else
            System.out.println("\nERRO! VALOR INVALIDO!");
    }

};
