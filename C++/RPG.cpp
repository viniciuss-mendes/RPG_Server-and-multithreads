#include <iostream>
#include <cstdlib>
#include <random>
#include <time.h>
using namespace std;

int random(int min, int max) //range : [min, max]
{
   static bool first = true;
   if (first) 
   {  
      srand(time(NULL) ); //seeding for the first time only!
      first = false;
   }
   return min + rand() % (( max + 1 ) - min);
}

// ----------------------------------------- PERSONAGENS ----------------------------------------- //

class Personagem{
    private:
        string classe;
        int PontosDeVida;
        int PontosDeMana;
        int ForcaFisica;
        int ForcaMagica;
        int Armadura;
        int ResistenciaMagica;
        int Agilidade;
        string arma;
        int danoMinimo;
        int danoMaximo;
    
    public:

        virtual int selecionarMagia(){}

        virtual void selecionarArma(){}

        virtual string getClasse(){
            return classe;
        }

        virtual int getPontosDeVida(){
            return PontosDeVida;
        }

        virtual void setPontosDeVida(int pontosDeVida){
            PontosDeVida = pontosDeVida;
        }

        virtual int getPontosDeMana(){
            return PontosDeMana;
        }

        virtual void setPontosDeMana(int pontosDeMana){
            PontosDeMana = pontosDeMana;
        }

        virtual int getForcaFisica(){
            return PontosDeMana;
        }

        virtual int getForcaMagica(){
            return PontosDeMana;
        }

        virtual int getArmadura(){
            return PontosDeMana;
        }

        virtual int getResistenciaMagica(){
            return PontosDeMana;
        }
        
        virtual int getAgilidade(){
            return PontosDeMana;
        }

        virtual string getArma(){
            return arma;
        }

        virtual int getDanoMinimo(){
            return danoMinimo;
        }

        virtual int getDanoMaximo(){
            return danoMaximo;
        }

        virtual void GarraLetal(){
            danoMinimo = 100;
            danoMaximo = 300;
            arma = "Garra Letal";
        }

        virtual void TridenteSagrado(){
            danoMinimo = 220;
            danoMaximo = 420;
            arma = "Tridente Sagrado";
        }

        virtual void EspadaBarroca(){
            danoMinimo = 300;
            danoMaximo = 500;
            arma = "Espada Barroca";
        }

        virtual void Porrete(){
            danoMinimo = 180;
            danoMaximo = 380;
            arma = "Porrete";
        }

        virtual void Cajado(){
            danoMinimo = 50;
            danoMaximo = 200;
            arma = "Cajado";
        }

        virtual void Besta(){
            danoMinimo = 220;
            danoMaximo = 420;
            arma = "Besta";
        }

        virtual void EsferaDeAtaque(){
            danoMinimo = 200;
            danoMaximo = 400;
            arma = "Esfera de Ataque";
        }

        virtual int EspadaLendaria(){};
            

        virtual int Tempestade(){
            PontosDeMana -= 12;
            return 200 + (ForcaMagica/100 * 200);
        }

        virtual void PocaoDeVida(){
            PontosDeMana -= 12;
            PontosDeVida += 200;
        }

        virtual int Bio(){
            PontosDeMana -= 14;
            return 360 + (ForcaMagica/100 * 360);
        }

        virtual void Cura(){
            PontosDeMana -= 16;
            PontosDeVida += 400;
        }

        virtual int FlamaGelada(){
            PontosDeMana -= 14;
            return 320 + (ForcaMagica/100 * 360);
        }

        virtual int Intoxicacao(){
            PontosDeMana -= 12;
            return 280 + (ForcaMagica/100 * 280);
        }

        virtual int HalitoDeFogo(){
            PontosDeMana -= 12;
            return 400 + (ForcaMagica/100*400);
        }

};

class Guerreiro : public Personagem{
    private:
        string classe;
        int PontosDeVida;
        int PontosDeMana;
        int ForcaFisica;
        int ForcaMagica;
        int Armadura;
        int ResistenciaMagica;
        int Agilidade;
        string arma;
        int danoMinimo;
        int danoMaximo;

    public:
        Guerreiro(){
            classe = "Guerreiro";
            PontosDeVida = 4000;
            PontosDeMana = 30;
            ForcaFisica = 100;
            ForcaMagica = 20;
            Armadura = 80;
            ResistenciaMagica = 20;
            Agilidade = 20;
            Porrete();
    }

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - TEMPESTADE\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Tempestade();
        }
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - ESPADA BARROCA\n2 - PORRETE\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU A ESPADA BARROCA!";
            EspadaBarroca();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU O PORRETE!";
            Porrete();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }
    
    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void EspadaBarroca(){
        danoMinimo = 300;
        danoMaximo = 500;
        arma = "EspadaBarroca";
    }

    void Porrete(){
        danoMinimo = 180;
        danoMaximo = 380;
        arma = "Porrete";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Tempestade(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 200 + (ForcaMagica*200/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
        
    }
};
class Ladrao : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Ladrao(){
        classe = "Ladrao";
        PontosDeVida = 2800;
        PontosDeMana = 50;
        ForcaFisica = 50;
        ForcaMagica = 30;
        Armadura = 40;
        ResistenciaMagica = 50;
        Agilidade = 80;
        Cajado();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - TEMPESTADE\n2 - INTOXICAÇÃO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Tempestade();
        }
        else if (escolha == 2){
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Intoxicacao();
        }
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - CAJADO\n2 - PORRETE\n3 - BESTA\n4 - ESFERA DE ATAQUE\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU O CAJADO!";
            Cajado();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU O PORRETE!";
            Porrete();
        } else if (escolha == 3){
            cout << "VOCÊ EQUIPOU A BESTA!";
            Besta();
        } else if (escolha == 4){
            cout << "VOCÊ EQUIPOU A ESFERA DE ATAQUE!";
            EsferaDeAtaque();
        } 
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void Porrete(){
        danoMinimo = 180;
        danoMaximo = 380;
        arma = "Porrete";
    }

    void Cajado(){
        danoMinimo = 50;
        danoMaximo = 200;
        arma = "Cajado";
    }

    void Besta(){
        danoMinimo = 220;
        danoMaximo = 420;
        arma = "Besta";
    }

    void EsferaDeAtaque(){
        danoMinimo = 200;
        danoMaximo = 400;
        arma = "EspadaLendaria";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Tempestade(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 200 + (ForcaMagica*200/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }

    int Intoxicacao(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 280 + (ForcaMagica*280/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};
class Mago : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Mago(){
        classe = "Mago";
        PontosDeVida = 2500;
        PontosDeMana = 100;
        ForcaFisica = 40;
        ForcaMagica = 100;
        Armadura = 30;
        ResistenciaMagica = 80;
        Agilidade = 40;
        Cajado();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - TEMPESTADE\n2 - INTOXICAÇÃO\n3 - POÇÃO DE VIDA\n4 - BIO\n5 - CURA\n6 - FLAMA GELADA\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Tempestade();
        }
        else if (escolha == 2){
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Intoxicacao();

        } else if (escolha == 3){
            cout << "VOCÊ GASTOU 12 DE MANA";
            PocaoDeVida();
            return 0;

        } else if (escolha == 4){
            cout << "VOCÊ GASTOU 14 DE MANA";
            return Bio();

        } else if (escolha == 5){
            cout << "VOCÊ GASTOU 16 DE MANA";
            Cura();
            return 0;

        } else if (escolha == 6){
            cout << "VOCÊ GASTOU 14 DE MANA";
            return FlamaGelada();
        }
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - TRIDENTE SAGRADO\n2 - CAJADO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU O TRIDENTE SAGRADO!";
            TridenteSagrado();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU O CAJADO!";
            Cajado();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void TridenteSagrado(){
        danoMinimo = 220;
        danoMaximo = 420;
        arma = "TridenteSagrado";
    }

    void Cajado(){
        danoMinimo = 50;
        danoMaximo = 200;
        arma = "Cajado";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Tempestade(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 200 + (ForcaMagica*200/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }

    int Intoxicacao(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 280 + (ForcaMagica*280/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }

    void PocaoDeVida(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            PontosDeVida += 200;
            cout << "\nRECUPEROU 200 DE VIDA!" << endl;
        } else {
            cout << "\nMANA INSUFICIENTE!";
        }
    }

    int Bio(){
        if (PontosDeMana >= 14){
            PontosDeMana -= 14;
            return 360 + (ForcaMagica*360/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }

    void Cura(){
        if (PontosDeMana >= 16){
            PontosDeMana -= 16;
            PontosDeVida += 400;
            cout << "\nRECUPEROU 400 DE VIDA!" << endl;
        } else {
            cout << "\nMANA INSUFICIENTE!";
        } 
    }

    int FlamaGelada(){
        if (PontosDeMana){
            PontosDeMana -= 14;
            return 320 + (ForcaMagica*360/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};
class Paladino : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Paladino(){
        classe = "Paladino";
        PontosDeVida = 3200;
        PontosDeMana = 80;
        ForcaFisica = 60;
        ForcaMagica = 50;
        Armadura = 60;
        ResistenciaMagica = 60;
        Agilidade = 60;
        Besta();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - TEMPESTADE\n2 - POÇÃO DE VIDA\n3 - FLAMA GELADA\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Tempestade();
        }
        else if (escolha == 2){
            cout << "VOCÊ GASTOU 12 DE MANA";
            PocaoDeVida();
            return 0;

        } else if (escolha == 3){
            cout << "VOCÊ GASTOU 14 DE MANA";
            return FlamaGelada();

        }
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - TRIDENTE SAGRADO\n2 - BESTA\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU O TRIDENTE SAGRADO!";
            TridenteSagrado();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU A BESTA!";
            Besta();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void TridenteSagrado(){
        danoMinimo = 220;
        danoMaximo = 420;
        arma = "TridenteSagrado";
    }

    void Besta(){
        danoMinimo = 220;
        danoMaximo = 420;
        arma = "Besta";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Tempestade(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 200 + (ForcaMagica*200/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }

    void PocaoDeVida(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            PontosDeVida += 200;
            cout << "\nRECUPEROU 200 DE VIDA!" << endl;
        } else {
            cout << "\nMANA INSUFICIENTE!";
        }
    }

    int FlamaGelada(){
        if (PontosDeMana){
            PontosDeMana -= 14;
            return 320 + (ForcaMagica*360/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};

class Animal : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Animal(){
        classe = "Animal";
        PontosDeVida = 3200;
        PontosDeMana = 30;
        ForcaFisica = 80;
        ForcaMagica = 20;
        Armadura = 80;
        ResistenciaMagica = 20;
        Agilidade = 50;
        GarraLetal();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - BIO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 14 DE MANA";
            return Bio();
        }
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - GARRA LETAL\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU A GARRA LETAL!";
            GarraLetal();
        } 
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }
    
    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void GarraLetal(){
        danoMinimo = 100;
        danoMaximo = 300;
        arma = "GarraLetal";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Bio(){
        if (PontosDeMana >= 14){
            PontosDeMana -= 14;
            return 360 + (ForcaMagica*360/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};
class Troll : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Troll(){
        classe = "Troll";
        PontosDeVida = 2800;
        PontosDeMana = 20;
        ForcaFisica = 100;
        ForcaMagica = 20;
        Armadura = 80;
        ResistenciaMagica = 20;
        Agilidade = 20;
        Cajado();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - INTOXICACAO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Intoxicacao();
        }
        
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - PORRETE\n2 - CAJADO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU O PORRETE!";
            Porrete();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU O CAJADO!";
            Cajado();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void Porrete(){
        danoMinimo = 180;
        danoMaximo = 380;
        arma = "Porrete";
    }

    void Cajado(){
        danoMinimo = 50;
        danoMaximo = 200;
        arma = "Cajado";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Intoxicacao(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 280 + (ForcaMagica*280/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};
class Dragao : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Dragao(){
        classe = "Dragao";
        PontosDeVida = 3000;
        PontosDeMana = 40;
        ForcaFisica = 100;
        ForcaMagica = 20;
        Armadura = 50;
        ResistenciaMagica = 50;
        Agilidade = 30;
        GarraLetal();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - HALITO DE FOGO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return HalitoDeFogo();
        }
        
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - GARRA LETAL\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU A GARRA LETAL!";
            GarraLetal();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void GarraLetal(){
        danoMinimo = 100;
        danoMaximo = 300;
        arma = "GarraLetal";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int HalitoDeFogo(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 400 + (ForcaMagica*400/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};
class Zumbi : public Personagem{
private:
    string classe;
    int PontosDeVida;
    int PontosDeMana;
    int ForcaFisica;
    int ForcaMagica;
    int Armadura;
    int ResistenciaMagica;
    int Agilidade;
    string arma;
    int danoMinimo;
    int danoMaximo;

public:
    Zumbi(){
        classe = "Zumbi";
        PontosDeVida = 2500;
        PontosDeMana = 20;
        ForcaFisica = 40;
        ForcaMagica = 20;
        Armadura = 40;
        ResistenciaMagica = 80;
        Agilidade = 50;
        Cajado();
    };

    int selecionarMagia(){
        int escolha;
        cout << "\n1 - INTOXICAÇÃO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ GASTOU 12 DE MANA";
            return Intoxicacao();
        }
        
        else cout << "\nERRO! VALOR INVALIDO!";
    }

    void selecionarArma(){
        int escolha;
        cout << "\n1 - GARRA LETAL\n2 - PORRETE\n3 - CAJADO\n\nEscolha: ";
        cin >> escolha;
        
        if (escolha == 1) {
            cout << "VOCÊ EQUIPOU A GARRA LETAL!";
            GarraLetal();
        } else if (escolha == 2){
            cout << "VOCÊ EQUIPOU O PORRETE!";
            Porrete();
        } else if (escolha == 3){
            cout << "VOCÊ EQUIPOU O CAJADO";
            Cajado();
        } else cout << "\nERRO! VALOR INVALIDO!";
    }

    string getClasse(){
        return classe;
    }

    int getPontosDeVida(){
        return PontosDeVida;
    }

    void setPontosDeVida(int pontosDeVida){
        PontosDeVida = pontosDeVida;
    }

    int getPontosDeMana(){
        return PontosDeMana;
    }

    void setPontosDeMana(int pontosDeMana){
        PontosDeMana = pontosDeMana;
    }

    int getForcaFisica(){
        return ForcaFisica;
    }

    int getForcaMagica(){
        return ForcaMagica;
    }

    int getArmadura(){
        return Armadura;
    }

    int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
    int getAgilidade(){
        return Agilidade;
    }

    string getArma(){
        return arma;
    }

    int getDanoMinimo(){
        return danoMinimo;
    }

    int getDanoMaximo(){
        return danoMaximo;
    }

    void Porrete(){
        danoMinimo = 180;
        danoMaximo = 380;
        arma = "Porrete";
    }

    void Cajado(){
        danoMinimo = 50;
        danoMaximo = 200;
        arma = "Cajado";
    }

    int EspadaLendaria(){
        int dano = random(500,900);
        bool acertoCritico = (rand() % 100) < 30;
        if (acertoCritico == true){
            return dano*2;
        } else return dano;
    }

    int Intoxicacao(){
        if (PontosDeMana >= 12){
            PontosDeMana -= 12;
            return 280 + (ForcaMagica*280/100);
        } else {
            cout << "\nMANA INSUFICIENTE!";
            return 0;
        }
    }
};

int turnos = 1;

int main(){

    int escolha = 0;
    cout << "x---------------------------------------------x\n|             RPG POR TURNOS                  |\n|        by Lucas Bottrel        |\nx---------------------------------------------x";
    Personagem *player1;
    Personagem *player2;

    // escolha player 1
    while(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5 && escolha != 6 && escolha != 7 && escolha != 8){
        cout << "\n\n           ESCOLHA SEU PERSONAGEM";
        cout << "\n\n-x- HUMANOS -x-\n  1 - GUERREIRO\n  2 - LADRÃO\n  3 - MAGO\n  4 - PALADINO";
        cout << "\n\n-x- INUMANOS -x-\n  5 - ANIMAL\n  6 - TROLL\n  7 - DRAGÃO\n  8 - ZUMBI";
        cout << "\n\nESCOLHA: ";
        cin >> escolha;
        
        switch (escolha) {
            case 1:{
                cout << "\nVOCÊ ESCOLHEU GUERREIRO!\n\nVIDA: 4000   MANA: 30   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 20";
                player1 = new Guerreiro();
                break;
            }
            case 2:{
                cout << "\nVOCÊ ESCOLHEU LADRÃO!\n\nVIDA: 2800   MANA: 50   FORÇA FÍSICA: 50   FORÇA MÁGICA: 30\nARMADURA: 40   RESISTÊNCIA MÁGICA: 50   AGILIDADE: 80";
                player1 = new Ladrao();
                break;
            }
            case 3:{
                cout << "\nVOCÊ ESCOLHEU MAGO!\n\nVIDA: 2500   MANA: 100   FORÇA FÍSICA: 40   FORÇA MÁGICA: 100\nARMADURA: 30   RESISTÊNCIA MÁGICA: 80   AGILIDADE: 40";
                player1 = new Mago();
                break;
            }
            case 4:{
                cout << "\nVOCÊ ESCOLHEU PALADINO!\n\nVIDA: 3200   MANA: 80   FORÇA FÍSICA: 60   FORÇA MÁGICA: 50\nARMADURA: 60   RESISTÊNCIA MÁGICA: 60   AGILIDADE: 60";
                player1 = new Paladino();
                break;
            }
            case 5:{
                cout << "\nVOCÊ ESCOLHEU ANIMAL!\n\nVIDA: 3200   MANA: 30   FORÇA FÍSICA: 80   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 50";
                player1 = new Animal();
                break;
            }
            case 6:{
                cout << "\nVOCÊ ESCOLHEU TROLL!\n\nVIDA: 2800   MANA: 20   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 20";
                player1 = new Troll();
                break;
            }
            case 7:{
                cout << "\nVOCÊ ESCOLHEU DRAGÃO!\n\nVIDA: 3000   MANA: 40   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 50   RESISTÊNCIA MÁGICA: 50   AGILIDADE: 30";
                player1 = new Dragao();
                break;
            }
            case 8:{
                cout << "\nVOCÊ ESCOLHEU ZUMBI!\n\nVIDA: 2500   MANA: 20   FORÇA FÍSICA: 40   FORÇA MÁGICA: 20\nARMADURA: 40   RESISTÊNCIA MÁGICA: 80   AGILIDADE: 50";
                player1 = new Zumbi();
                break;
            }
            default:{
                cout << "VALOR INVÁLIDO!";
                break;
            }
        }
    }
    escolha = 0;
    // escolha player 2
    while(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5 && escolha != 6 && escolha != 7 && escolha != 8){
        
        cout << "\n\n           ESCOLHA SEU PERSONAGEM";
        cout << "\n\n-x- HUMANOS -x-\n  1 - GUERREIRO\n  2 - LADRÃO\n  3 - MAGO\n  4 - PALADINO";
        cout << "\n\n-x- INUMANOS -x-\n  5 - ANIMAL\n  6 - TROLL\n  7 - DRAGÃO\n  8 - ZUMBI";
        cout << "\n\nESCOLHA: ";
        cin >> escolha;

        switch (escolha) {
            case 1:{
                cout << "\nVOCÊ ESCOLHEU GUERREIRO!\n\nVIDA: 4000   MANA: 30   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 20";
                player2 = new Guerreiro();
                break;
            }
            case 2:{
                cout << "\nVOCÊ ESCOLHEU LADRÃO!\n\nVIDA: 2800   MANA: 50   FORÇA FÍSICA: 50   FORÇA MÁGICA: 30\nARMADURA: 40   RESISTÊNCIA MÁGICA: 50   AGILIDADE: 80";
                player2 = new Ladrao();
                break;
            }
            case 3:{
                cout << "\nVOCÊ ESCOLHEU MAGO!\n\nVIDA: 2500   MANA: 100   FORÇA FÍSICA: 40   FORÇA MÁGICA: 100\nARMADURA: 30   RESISTÊNCIA MÁGICA: 80   AGILIDADE: 40";
                player2 = new Mago();
                break;
            }
            case 4:{
                cout << "\nVOCÊ ESCOLHEU PALADINO!\n\nVIDA: 3200   MANA: 80   FORÇA FÍSICA: 60   FORÇA MÁGICA: 50\nARMADURA: 60   RESISTÊNCIA MÁGICA: 60   AGILIDADE: 60";
                player2 = new Paladino();
                break;
            }
            case 5:{
                cout << "\nVOCÊ ESCOLHEU ANIMAL!\n\nVIDA: 3200   MANA: 30   FORÇA FÍSICA: 80   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 50";
                player2 = new Animal();
                break;
            }
            case 6:{
                cout << "\nVOCÊ ESCOLHEU TROLL!\n\nVIDA: 2800   MANA: 20   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 80   RESISTÊNCIA MÁGICA: 20   AGILIDADE: 20";
                player2 = new Troll();
                break;
            }
            case 7:{
                cout << "\nVOCÊ ESCOLHEU DRAGÃO!\n\nVIDA: 3000   MANA: 40   FORÇA FÍSICA: 100   FORÇA MÁGICA: 20\nARMADURA: 50   RESISTÊNCIA MÁGICA: 50   AGILIDADE: 30";
                player2 = new Dragao();
                break;
            }
            case 8:{
                cout << "\nVOCÊ ESCOLHEU ZUMBI!\n\nVIDA: 2500   MANA: 20   FORÇA FÍSICA: 40   FORÇA MÁGICA: 20\nARMADURA: 40   RESISTÊNCIA MÁGICA: 80   AGILIDADE: 50";
                player2 = new Zumbi();
                break;
            }
            default:
                cout << "VALOR INVÁLIDO!";
                break;
        }
    }

    int manaMaximaP1 = player1 -> getPontosDeMana();
    int manaMaximaP2 = player2 -> getPontosDeMana();

    while (player1->getPontosDeVida() > 0 && player2->getPontosDeVida() > 0)
    {
        escolha = 0;
        cout << "\n===================================================================\n\n       -X- TURNO " << turnos << " -X-" << endl;
        cout << "\n >> VEZ DE PLAYER1\n" << player1->getClasse() <<  "\nVIDA: " << player1->getPontosDeVida() <<"   MANA: " << player1->getPontosDeMana() << endl; 
        cout << "\nx------------------x\n|       AÇÕES      |\nx------------------x";
        cout << "\n1 - ATACAR\n2 - MAGIA\n3 - TROCAR DE ARMA";

        bool espadaLendaria = (rand() % 100) < 20;

        if (espadaLendaria == true){
            cout << "\n4 - VOTO SOLENE DE BUL-KATHOS!";
        }

        cout << "\n\nESCOLHA: ";
        cin >> escolha;

        if (espadaLendaria == true && escolha == 4){
            int dano = player1 -> EspadaLendaria();
            cout << dano;
            bool esquivou = (rand() % 100) < player2->getAgilidade();
            if (esquivou == false){
                dano = dano + ((player1->getForcaFisica()*dano)/100);
                int danoCausado = dano - ((player2->getArmadura()*dano)/100);
                player2->setPontosDeVida(player2->getPontosDeVida() - (int)danoCausado);
                cout << "\n" << danoCausado << " DE DANO CAUSADO!";
            } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
        }

        switch (escolha)
        {
        case 1:{
            
            bool esquivou = (rand() % 100) < player2->getAgilidade();
            if (esquivou == false){
                int dano = random(player1->getDanoMinimo(),player1->getDanoMaximo());
                dano = dano + ((player1->getForcaFisica()*dano)/100);
                int danoCausado = dano - ((player2->getArmadura()*dano)/100);
                player2->setPontosDeVida(player2->getPontosDeVida() - (int)danoCausado);
                cout << "\n" << danoCausado << " DE DANO CAUSADO!";
            } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
            
            // Recupera mana
            if (player1->getPontosDeMana() < manaMaximaP1){
                if (player1->getPontosDeMana() + 10 > manaMaximaP1) player1->setPontosDeMana(manaMaximaP1);
                else player1->setPontosDeMana(player1->getPontosDeMana() + 10);
            }

            break;
        }
        case 2:{
            int dano = player1->selecionarMagia();

            if (dano != 0){
                bool esquivou = (rand() % 100) < player1->getAgilidade();
                if (esquivou == false){
                    int danoCausado = dano - ((player2->getResistenciaMagica()*dano)/100);
                    player2->setPontosDeVida(player2->getPontosDeVida() - (int)danoCausado);
                    cout << "\n" << danoCausado << " DE DANO CAUSADO!";
                } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
            }
            break;
        }
        case 3:{
            player1->selecionarArma();

            // Recupera mana
            if (player1->getPontosDeMana() < manaMaximaP1){
                if (player1->getPontosDeMana() + 10 > manaMaximaP1) player1->setPontosDeMana(manaMaximaP1);
                else player1->setPontosDeMana(player1->getPontosDeMana() + 10);
            }

            break;
        }
        default:
            break;
        }

        if (player2 -> getPontosDeVida() > 0) {

            cout << "\n===================================================================\n\n       -X- TURNO " << turnos << " -X-" << endl;
            cout << "\n >> VEZ DE PLAYER2\n" << player2->getClasse() <<  "\nVIDA: " << player2->getPontosDeVida() <<"   MANA: " << player2->getPontosDeMana() << endl; 
            cout << "\nx------------------x\n|       AÇÕES      |\nx------------------x";
            cout << "\n1 - ATACAR\n2 - MAGIA\n3 - TROCAR DE ARMA";

            bool espadaLendaria = (rand() % 100) < 20;

            if (espadaLendaria == true){
                cout << "\n4 - VOTO SOLENE DE BUL-KATHOS!";
            }

            cout << "\n\nESCOLHA: ";
            cin >> escolha;

            if (espadaLendaria == true && escolha == 4){
                int dano = player2 -> EspadaLendaria();
                bool esquivou = (rand() % 100) < player1->getAgilidade();
                if (esquivou == false){
                    dano = dano + ((player2->getForcaFisica()*dano)/100);
                    int danoCausado = dano - ((player1->getArmadura()*dano)/100);
                    player1->setPontosDeVida(player1->getPontosDeVida() - (int)danoCausado);
                    cout << "\n" << danoCausado << " DE DANO CAUSADO!";
                } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
            }

            switch (escolha)
            {
            case 1:{
                bool esquivou = (rand() % 100) < player1->getAgilidade();
                if (esquivou == false){
                    int dano = random(player2->getDanoMinimo(),player2->getDanoMaximo());
                    dano = dano + ((player2->getForcaFisica()*dano)/100);
                    int danoCausado = dano - ((player1->getArmadura()*dano)/100);
                    player1->setPontosDeVida(player1->getPontosDeVida() - (int)danoCausado);
                    cout << "\n" << danoCausado << " DE DANO CAUSADO!";
                } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
                
                if (player2->getPontosDeMana() < manaMaximaP2){
                    if (player2->getPontosDeMana() + 10 > manaMaximaP2) player2->setPontosDeMana(manaMaximaP2);
                    else player2->setPontosDeMana(player2->getPontosDeMana() + 10);
                } 

                break;
            }
            case 2:{
                int dano = player2->selecionarMagia();

                if (dano != 0){
                    bool esquivou = (rand() % 100) < player1->getAgilidade();
                    if (esquivou == false){
                        int danoCausado = dano - ((player1->getResistenciaMagica()*dano)/100);
                        player1->setPontosDeVida(player1->getPontosDeVida() - (int)danoCausado);
                        cout << "\n" << danoCausado << " DE DANO CAUSADO!";
                    } else cout << "\nO ADVERSÁRIO ESQUIVOU DO ATAQUE!" << endl;
                }
                break;
            }
            case 3:{
                player2->selecionarArma();
                
                if (player2->getPontosDeMana() < manaMaximaP2){
                    if (player2->getPontosDeMana() + 10 > manaMaximaP2) player2->setPontosDeMana(manaMaximaP2);
                    else player2->setPontosDeMana(player2->getPontosDeMana() + 10);
                }  

                break;
            }
            default:
                break;
            }
            turnos++;
        }
    }

    if (player1->getPontosDeVida() <= 0 && player2->getPontosDeVida() > 0){
        cout << "\nx-------------------------------x\n|       VITÓRIA DO PLAYER2      |\nx-------------------------------x" << endl;
    } else cout << "\nx-------------------------------x\n|       VITÓRIA DO PLAYER1      |\nx-------------------------------x" << endl;
}