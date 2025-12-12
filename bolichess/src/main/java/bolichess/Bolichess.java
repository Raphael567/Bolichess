package bolichess;

import bolichess.models.Tabuleiro;
import org.springframework.boot.SpringApplication;

public class Bolichess {

	public static void main(String[] args) {
        Tabuleiro t = new Tabuleiro();
        t.imprimir();

        t.mover(6, 2, 5, 1);
        t.imprimir();

        t.mover(5, 1, 4, 1);
        t.imprimir();
	}
}
