package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

	   public static void main(String[] args) {
	      Toolkit tk = Toolkit.start();
	      
	      String lombrigas[] = tk.recuperaLombrigas();

	      for(int i=0; i < lombrigas.length; i++){

	         Animacao animacao = new Animacao(lombrigas[i]);
	         tk.gravaPasso("=====");
	         tk.gravaPasso(animacao.apresenta());

	         for(int j=6; j < lombrigas[i].length(); j++){
	            animacao.passo();
	            tk.gravaPasso(animacao.apresenta());
	         }
	      }
	      
	      tk.stop();
	   }

	}