package bolichess.ui;

import bolichess.logic.MovimentoValidator;
import bolichess.models.Tabuleiro;

import java.util.Arrays;
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

    //TODO: Refatorar código
    private void executarJogada(Tabuleiro t) {
        int[] coordenadasOrigem;
        int[] coordenadasFinal;

        while (true) {
            System.out.println("\nSelecione sua peça");
            coordenadasOrigem = lerCoordenada("Digite a coordenada de origem: ");

            System.out.println(Arrays.toString(coordenadasOrigem));
            if (t.getPecaTabuleiro(coordenadasOrigem[0], coordenadasOrigem[1]) != null) break;
            System.out.println("\nNão existe peça nesse local");
        }

        while (true) {
            System.out.println("\nSelecione a jogada");
            coordenadasFinal = lerCoordenada("Digite a coordenada de jogada: ");

            System.out.println(Arrays.toString(coordenadasFinal));
            if (MovimentoValidator.validar(t, coordenadasOrigem[0], coordenadasOrigem[1], coordenadasFinal[0], coordenadasFinal[1])) break;
            System.out.println("\nMovimento inválido");
        }

        t.mover(coordenadasOrigem[0], coordenadasFinal[1], coordenadasFinal[0], coordenadasFinal[1]);
    }

    private boolean perguntarSeDesejaSair() {
        System.out.println("\nDeseja sair? (1 = sim, 0 = não): ");
        int escolha = scanner.nextInt();
        return escolha == 1;
    }

    //TODO: Colocar em classe separada
    private int[] lerCoordenada(String mensagem) {
        char[] colunas = {'A','B','C','D','E','F','G','H'};
        char[] linhas = {'1','2','3','4','5','6','7','8'};

        char[] coordenada;
        int[] coordenadaFinal = new int[2];

        while (true) {
            System.out.println(mensagem);
            coordenada = scanner.next().toCharArray();

            if (coordenada.length != 2) {
                System.out.println("Coordenada inválida");
                continue;
            }

            boolean colunaValida = false;
            boolean linhaValida = false;

            for (char linha : linhas) {
                if (coordenada[1] == linha) {
                    linhaValida = true;
                    coordenadaFinal[0] = '8' - linha;
                    break;
                }
            }

            char letra = Character.toUpperCase(coordenada[0]);
            coordenada[0] = letra;
            for (char coluna : colunas) {
                if (coordenada[0] == coluna ) {
                    colunaValida = true;
                    coordenadaFinal[1] = coluna - 'A';
                    break;
                }
            }

            if (colunaValida && linhaValida) break;

            System.out.println("Coordenada inválida");
        }

        return coordenadaFinal;
    }
}
