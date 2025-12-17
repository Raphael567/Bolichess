package bolichess.ui;

import java.util.Scanner;

public class CoordenadaInput {
    private final Scanner scanner;

    public CoordenadaInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[] ler(String mensagem) {
        char[] colunas = {'A','B','C','D','E','F','G','H'};
        char[] linhas = {'1','2','3','4','5','6','7','8'};

        char[] coordenada;
        int[] resultado = new int[2];

        while (true) {
            System.out.println(mensagem);
            coordenada = scanner.next().toUpperCase().toCharArray();

            if (coordenada.length != 2) {
                System.out.println("Coordenada inválida");
                continue;
            }

            boolean colunaValida = false;
            boolean linhaValida = false;

            for (char linha : linhas) {
                if (coordenada[1] == linha) {
                    linhaValida = true;
                    resultado[0] = '8' - linha;
                    break;
                }
            }

            for (char coluna : colunas) {
                if (coordenada[0] == coluna) {
                    colunaValida = true;
                    resultado[1] = coluna - 'A';
                    break;
                }
            }

            if (linhaValida && colunaValida) {
                return resultado;
            }

            System.out.println("Coordenada inválida");
        }
    }
}
