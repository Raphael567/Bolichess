package bolichess.models;

import lombok.Data;

@Data
public class Tabuleiro {
    private final Peca[][] matriz = new Peca[8][8];

    public Tabuleiro() {
        inicializar();
    }

    private void inicializar() {
        matriz[0][0] = new Cavalo("preta");
        matriz[7][6] = new Cavalo("branca");

//        for(int l = 0; l <= 3; l++) {
//            for(int c = 1; c <= 6; c++) {
//                if (matriz[l][c] == null)
//                    matriz[l][c] = new Peao("preta");
//            }
//        }
//
//        matriz[7][0] = new Torre("branca");
//        matriz[7][7] = new Torre("branca");
//
//        for(int l = 7; l >= 4; l--) {
//            for(int c = 1; c <= 6; c++) {
//                if (matriz[l][c] == null)
//                    matriz[l][c] = new Peao("branca");
//            }
//        }
    }

    public void mover(int lo, int co, int ld, int cd) {
        Peca p = getPecaTabuleiro(lo, co);

        matriz[ld][cd] = p;
        matriz[lo][co] = null;
    }

    public void imprimir() {
        char[] colunas = {'A','B','C','D','E','F','G','H'};

        System.out.print("\n   ");
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
