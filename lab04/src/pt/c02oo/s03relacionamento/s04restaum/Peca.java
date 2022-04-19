package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    private boolean vazio;
    private boolean tabuleiro;

    public Peca(boolean vazio, boolean tabuleiro){
        this.vazio = vazio;
        this.tabuleiro = tabuleiro;
    }

    public void setVazio(boolean vazio){
        this.vazio = vazio;
    }
    public boolean getVazio(){
        return this.vazio;
    }

    public void setTabuleiro(boolean tabuleiro){
        this.tabuleiro = tabuleiro;
    }
    public boolean getTabuleiro(){
        return this.tabuleiro;
    }
}
