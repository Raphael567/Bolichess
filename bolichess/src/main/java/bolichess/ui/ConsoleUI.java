package bolichess.ui;

import bolichess.logic.MovimentoValidator;
import bolichess.models.Tabuleiro;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final CoordenadaInput coordenadaInput = new CoordenadaInput(scanner);

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
        int[] origem;
        int[] destino;

        while (true) {
            System.out.println("\nSelecione sua peça");
            origem = coordenadaInput.ler("Digite a coordenada de origem: ");

            if (t.getPecaTabuleiro(origem[0], origem[1]) != null) break;
            System.out.println("\nNão existe peça nesse local");
        }

        while (true) {
            System.out.println("\nSelecione a jogada");
            destino = coordenadaInput.ler("Digite a coordenada de jogada: ");

            if (MovimentoValidator.validar(t, origem[0], origem[1], destino[0], destino[1])) break;
            System.out.println("\nMovimento inválido");
        }

        t.mover(origem[0], origem[1], destino[0], destino[1]);
    }

    private boolean perguntarSeDesejaSair() {
        System.out.println("\nDeseja sair? (1 = sim, 0 = não): ");
        int escolha = scanner.nextInt();
        return escolha == 1;
    }
}
