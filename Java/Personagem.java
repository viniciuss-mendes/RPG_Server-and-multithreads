package Java;

public class Personagem {
    private String classe;
    private int PontosDeVida;
    private int PontosDeMana;
    private int ManaMaxima;
    private int ForcaFisica;
    private int ForcaMagica;
    private int Armadura;
    private int ResistenciaMagica;
    private int Agilidade;
    private String arma;
    private int danoMinimo;
    private int danoMaximo;

    public Personagem() {

    }

    String getClasse() {
        return this.classe;
    }

    void setClasse(String classe) {
        this.classe = classe;
    }

    int getPontosDeVida() {
        return this.PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida) {
        this.PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana() {
        return this.PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana) {
        this.PontosDeMana = pontosDeMana;
    }

    int getForcaFisica() {
        return this.ForcaFisica;
    }

    void setForcaFisica(int forcaFisica) {
        this.ForcaFisica = forcaFisica;
    }

    int getForcaMagica() {
        return this.ForcaMagica;
    }

    void setForcaMagica(int forcaMagica) {
        this.ForcaMagica = forcaMagica;
    }

    int getArmadura() {
        return this.Armadura;
    }

    void setArmadura(int armadura) {
        this.Armadura = armadura;
    }

    int getResistenciaMagica() {
        return this.ResistenciaMagica;
    }

    void setResistenciaMagica(int resistenciaMagica) {
        this.ResistenciaMagica = resistenciaMagica;
    }

    int getAgilidade() {
        return this.Agilidade;
    }

    void setAgilidade(int agilidade) {
        this.Agilidade = agilidade;
    }

    String getArma() {
        return this.arma;
    }

    void setArma(String arma) {
        this.arma = arma;
    }

    int getDanoMinimo() {
        return this.danoMinimo;
    }

    void setDanoMinimo(int danoMinimo) {
        this.danoMinimo = danoMinimo;
    }

    int getDanoMaximo() {
        return this.danoMaximo;
    }

    void setDanoMaximo(int danoMaximo) {
        this.danoMaximo = danoMaximo;
    }

    int getManaMaxima() {
        return this.ManaMaxima;
    }

    void setManaMaxima(int manaMaxima) {
        this.ManaMaxima = manaMaxima;
    }

    int selecionarMagia() {
        return 0;
    }

    void selecionarArma() {

    }

    // ARMAS

    void GarraLetal() {
        this.danoMinimo = 100;
        this.danoMaximo = 300;
        this.arma = "Garra Letal";
    }

    void TridenteSagrado() {
        this.danoMinimo = 220;
        this.danoMaximo = 420;
        this.arma = "Tridente Sagrado";
    }

    void EspadaBarroca() {
        this.danoMinimo = 300;
        this.danoMaximo = 500;
        this.arma = "Espada Barroca";
    }

    void Porrete() {
        this.danoMinimo = 180;
        this.danoMaximo = 380;
        this.arma = "Porrete";
    }

    void Cajado() {
        this.danoMinimo = 50;
        this.danoMaximo = 200;
        this.arma = "Cajado";
    }

    void Besta() {
        this.danoMinimo = 220;
        this.danoMaximo = 420;
        this.arma = "Besta";
    }

    void EsferaDeAtaque() {
        this.danoMinimo = 200;
        this.danoMaximo = 400;
        this.arma = "Esfera de Ataque";
    }

    // MAGIAS

    int EspadaLendaria() {
        int dano = Global.random(500, 900);
        boolean acertoCritico = Global.random(0, 100) < 30;
        if (acertoCritico == true) {
            System.out.println("**ACERTO CRITICO**");
            return dano * 2;
        } else
            return dano;
    }

    int Tempestade() {
        if (this.PontosDeMana >= 12) {
            this.PontosDeMana -= 12;
            return 200 + (this.ForcaMagica * 200 / 100);
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
            return 0;
        }
    }

    void PocaoDeVida() {
        if (this.PontosDeMana >= 12) {
            this.PontosDeMana -= 12;
            this.PontosDeVida += 200;
            System.out.println("\nRECUPEROU 200 DE VIDA!");
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
        }
    }

    int Bio() {
        if (this.PontosDeMana >= 14) {
            this.PontosDeMana -= 14;
            return 360 + (this.ForcaMagica * 360 / 100);
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
            return 0;
        }
    }

    void Cura() {
        if (this.PontosDeMana >= 16) {
            this.PontosDeMana -= 16;
            this.PontosDeVida += 400;
            System.out.println("\nRECUPEROU 400 DE VIDA!");
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
        }
    }

    int FlamaGelada() {
        if (this.PontosDeMana >= 14) {
            this.PontosDeMana -= 14;
            return 320 + (this.ForcaMagica * 360 / 100);
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
            return 0;
        }
    }

    int Intoxicacao() {
        if (this.PontosDeMana >= 12) {
            this.PontosDeMana -= 12;
            return 280 + (this.ForcaMagica * 280 / 100);
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
            return 0;
        }
    }

    int HalitoDeFogo() {
        if (this.PontosDeMana >= 12) {
            this.PontosDeMana -= 12;
            return 400 + (this.ForcaMagica / 100 * 400);
        } else {
            System.out.println("\nMANA INSUFICIENTE!");
            return 0;
        }
    }
}
