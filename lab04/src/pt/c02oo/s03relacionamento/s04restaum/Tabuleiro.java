package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    private Peca[][] matrizTabuleiro = new Peca[7][7];
    private char board[][] = {
        {' ', ' ', 'P', 'P', 'P', ' ', ' '},
        {' ', ' ', 'P', 'P', 'P', ' ', ' '},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', '-', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {' ', ' ', 'P', 'P', 'P', ' ', ' '},
        {' ', ' ', 'P', 'P', 'P', ' ', ' '}
    };

    public Tabuleiro(){
        for(int i=0; i < 7; i++){
            for(int j=0; j < 7; j++){
                // se estiver fora do tabuleiro
                if((i == 0 || i == 1 || i == 5 || i == 6) && (j == 0 || j == 1)){
                    matrizTabuleiro[i][j] = new Peca(true, false);
                } else if((i == 0 || i == 1 || i == 5 || i == 6) && (j == 5 || j == 6)){
                    matrizTabuleiro[i][j] = new Peca(true, false);
                // se estiver no tabuleiro
                } else if(i == 3 && j == 3){ // meio
                    matrizTabuleiro[i][j] = new Peca(true, true);
                } else { // outras posições
                    matrizTabuleiro[i][j] = new Peca(false, true);
                }
            }
        }
    }

    public char[][] getBoard(){
        return this.board;
    }

    public char[][] movimento(String comando){
        // transformar as coordenadas em int e alocar cada uma em sua variável
        int sY = comando.charAt(0) - 'a';
        int sX = Integer.parseInt(comando.substring(1, 2)) - 1;
        int tY = comando.charAt(3) - 'a';
        int tX = Integer.parseInt(comando.substring(4, 5)) - 1;

        // se estiver fora dos limites do tabuleiro
        if(sX > 7 || sY > 7 || tX > 7 || tY > 7){
            return board;
        }

        // se o comando não for válido
        if(sX != tX && sY != tY){
            return board;
        }
        if((tX-sX == 2 || sX-tX == 2) && (tY-sY == 2 || sY-tY == 2)){
            return board;
        }

        // verificar se existe peça no source
        if(!matrizTabuleiro[sX][sY].getVazio()){
            // verificar se o target está vazio e se está no tabuleiro
            if(matrizTabuleiro[tX][tY].getVazio() && matrizTabuleiro[tX][tY].getTabuleiro()){
                // mudar os dados da peça que foi "comida" e alterar o board
                matrizTabuleiro[(sX+tX)/2][(sY+tY)/2].setVazio(true);
                board[(sX+tX)/2][(sY+tY)/2] = '-';
                // mudar os dados da peça source e alterar o board
                matrizTabuleiro[sX][sY].setVazio(true);
                board[sX][sY] = '-';
                // mudar os dados da peça target e alterar o board
                matrizTabuleiro[tX][tY].setVazio(false);
                board[tX][tY] = 'P';
            }
        }

        return board;
    }
}