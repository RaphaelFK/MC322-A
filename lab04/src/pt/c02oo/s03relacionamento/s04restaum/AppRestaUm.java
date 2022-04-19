package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

    public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
    }
   
    public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
        Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
        String commands[] = tk.retrieveCommands();

        // criação do tabuleiro e impressão inicial
        Tabuleiro tabuleiro = new Tabuleiro();
        tk.writeBoard("Tabuleiro inicial", tabuleiro.getBoard());

        // realização dos comandos
        for(int i=0; i < commands.length; i++){
            // chamada do método movimento
            char board[][] = tabuleiro.movimento(commands[i]);

            // formatação do título e impressão
            String titulo = "source: " + commands[i].substring(0, 2) + "; target: " + commands[i].substring(3, 5);
            tk.writeBoard(titulo, board);
        }

        tk.stop();
    }

}