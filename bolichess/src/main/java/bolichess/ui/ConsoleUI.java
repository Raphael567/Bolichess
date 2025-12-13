package bolichess.ui;

import bolichess.logic.MovimentoValidator;
import bolichess.models.Tabuleiro;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        Tabuleiro tabuleiro = new Tabuleiro();
        boolean sair = false;

        tabuleiro.imprimir();

        while (!sair) {
            executarJogada(tabuleiro);
            tabuleiro.imprimir();
            sair = perguntarSeDesejaSair();
        }
    }

    private void executarJogada(Tabuleiro t) {
        int lo, co, ld, cd;

        while (true) {
            System.out.println("\nSelecione sua peça");
            lo = lerInt("LinhaOrigem: ");
            co = lerInt("ColunaOrigem: ");

            if (t.getPecaTabuleiro(lo, co) != null) break;
            System.out.println("\nNão existe peça nesse local");
        }

        while (true) {
            System.out.println("\nSelecione a jogada");
            ld = lerInt("LinhaDestino: ");
            cd = lerInt("ColunaDestino: ");

            if (MovimentoValidator.validar(t, lo, co, ld, cd)) break;
            System.out.println("\nMovimento inválido");
        }

        t.mover(lo, co, ld, cd);
    }

    private boolean perguntarSeDesejaSair() {
        int escolha = lerInt("\nDeseja sair? (1 = sim, 0 = não): ");
        return escolha == 1;
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }
}
