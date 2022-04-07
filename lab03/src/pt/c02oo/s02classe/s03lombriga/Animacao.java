package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
    String sequencia;
    int tamanhoAquario;
    int tamanhoLombriga;
    int posicaoCabeca;
    int passo = 6;
    AquarioLombriga aquario;

    Animacao(String sequencia){
        this.sequencia = sequencia;
        tamanhoAquario = Integer.parseInt(sequencia.substring(0, 2));
        tamanhoLombriga = Integer.parseInt(sequencia.substring(2, 4));
        posicaoCabeca = Integer.parseInt(sequencia.substring(4, 6));
        aquario = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoCabeca);
    }

    String apresenta(){
        return aquario.apresenta();
    }

    void passo(){
        String acao = sequencia.substring(passo,passo+1);
        if(acao.equals("C")){
            aquario.crescer();
        } else if(acao.equals("M")){
            aquario.mover();
        } else if(acao.equals("V")){
            aquario.virar();
        }
        passo += 1;
    }
}
