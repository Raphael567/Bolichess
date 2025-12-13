package bolichess;

import bolichess.models.Tabuleiro;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Bolichess {

	public static void main(String[] args) {
        boolean sair = false;

        Tabuleiro t = new Tabuleiro();
        t.imprimir();

        Scanner scanner = new Scanner(System.in);

        while (!sair) {
            boolean isPeca = false;
            int lo = 0;
            int co = 0;

            System.out.println("\nSelecione sua peça");

            while (!isPeca) {
                System.out.print("LinhaOrigem: ");
                lo = scanner.nextInt();

                System.out.print("ColunaOrigem: ");
                co = scanner.nextInt();

                if (t.getPecaTabuleiro(lo, co) == null) {
                    System.out.println("Não existe peça nesse local");
                } else isPeca = true;
            }

            System.out.println("\nSelecione a jogada");

            System.out.print("LinhaDestino: ");;
            int ld = scanner.nextInt();

            System.out.print("ColunaDestino: ");
            int cd = scanner.nextInt();

            t.mover(lo, co, ld, cd);
            t.imprimir();

            System.out.println("Deseja sair? 1 ou 0: ");
            int escolha = scanner.nextInt();

            if (escolha == 1) sair = true;
        }
	}
}
