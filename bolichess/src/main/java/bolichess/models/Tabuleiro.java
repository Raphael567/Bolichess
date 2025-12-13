package bolichess.models;

import lombok.Data;

@Data
public class Tabuleiro {
    private final Peca[][] matriz = new Peca[8][8];

    public Tabuleiro() {
        inicializar();
    }

    private void inicializar() {
        matriz[7][0] = new Peao("branca");
        matriz[0][1] = new Peao("preta");
    }

    //TODO: Converter entrada do usuário para coordenadas do xadrez E3 -> matriz[5][4]
    public void mover(int lo, int co, int ld, int cd) {
        Peca p = getPecaTabuleiro(lo, co);

        matriz[ld][cd] = p;
        matriz[lo][co] = null;
    }

    public void imprimir() {
        char[] colunas = {'A','B','C','D','E','F','G','H'};

        System.out.print("   ");
        for (char c : colunas) {
            System.out.print(" " + c + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            int numeroLinha = 8 - i;
            System.out.print(numeroLinha + "  ");

            for (int j = 0; j < 8; j++) {
                System.out.print(matriz[i][j] == null ? " . " : " " + matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Peca getPecaTabuleiro(int lo, int co) {
        return matriz[lo][co];
    }
}
