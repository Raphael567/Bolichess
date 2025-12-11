package bolichess;

import bolichess.models.Tabuleiro;
import org.springframework.boot.SpringApplication;

public class Bolichess {

	public static void main(String[] args) {
        Tabuleiro t = new Tabuleiro();
        t.imprimir();

        t.mover(6, 0, 5, 0);
        t.imprimir();
	}
}
