package bolichess;

import bolichess.models.Tabuleiro;
import org.springframework.boot.SpringApplication;

public class Bolichess {

	public static void main(String[] args) {
        //TODO: ui-console para o usuário digitar as suas jogadas
        Tabuleiro t = new Tabuleiro();
        t.imprimir();

        //Branca
//        t.mover(5, 0, 4, 0);
//        t.imprimir();

        //Preta
//        t.mover(1, 1, 0, 1);
//        t.imprimir();
	}
}
