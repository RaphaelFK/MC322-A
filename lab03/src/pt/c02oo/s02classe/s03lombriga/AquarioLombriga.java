package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int posicaoCabeca;
    int posicaoFim;
    int tamanhoLombriga;
    String lado = "esq"; // esquerdo (esq) ou direito (dir)
    String aquario = "";
    int tamanhoAquario;

    AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoCabeca) {
        this.posicaoCabeca = posicaoCabeca;
        this.tamanhoLombriga = tamanhoLombriga;
        this.tamanhoAquario = tamanhoAquario;
        this.posicaoFim = posicaoCabeca + tamanhoLombriga - 1;
    }

    void crescer(){
        if (lado.equals("esq")){ // se a lombriga esta virada para a esquerda
            if(posicaoFim < tamanhoAquario){
                posicaoFim += 1;
                tamanhoLombriga += 1;
            }
        } else { // se a lombriga esta virada para a direita
            if(posicaoFim > 1) {
                posicaoFim -= 1;
                tamanhoLombriga += 1;
            }
        }
    }

    void mover() {
        if (lado.equals("esq")){ // se a lombriga estiver virada para a esquerda
            if(posicaoCabeca > 1){ // se tiver espaço para a lombriga se mover
                posicaoCabeca -= 1;
                posicaoFim -= 1;
            } else { // se não houver espaço para a lombriga andar
                virar();
            }
        } else { // se a lombriga estiver virada para a direita
            if(posicaoCabeca < tamanhoAquario){ // se tiver espaço para ela andar
                posicaoCabeca += 1;
                posicaoFim += 1;
            } else { // se não houver espaço
                virar();
            }
        }
    }

    void virar() {
        // inverter posições da cabeça e do fim
        int aux = posicaoCabeca;
        posicaoCabeca = posicaoFim;
        posicaoFim = aux;
        // mudança do lado
        if(lado.equals("esq")){
            lado = "dir";
        } else {
            lado = "esq";
        }
    }
    
    String apresenta() {
        aquario = "";
        if(lado.equals("esq")){
            for (int i=1; i < posicaoCabeca; i++) { // preencher aquario até a cabeça
                this.aquario += "#";
            }
            this.aquario += "O"; // posicionar a cabeça
            for (int i=0; i < tamanhoLombriga-1; i++) { // preencher o corpo
                this.aquario += "@";
            }
            for (int i=0; i < tamanhoAquario - posicaoCabeca - tamanhoLombriga+1; i++) { // preencher o resto do aquario
                this.aquario += "#";
            }
        } else {
            for(int i=1; i < posicaoFim; i++){ // preencher aquario até o fim da lombriga
                this.aquario += "#";
            }
            for(int i=0; i < tamanhoLombriga-1; i++){ // preencher o corpo
                this.aquario += "@";
            }
            this.aquario += "O"; // posicionar a cabeça
            for (int i=0; i < tamanhoAquario - posicaoCabeca; i++) { // preencher o resto do aquario
                this.aquario += "#";
            }
        }
 
        return this.aquario;
    }
}