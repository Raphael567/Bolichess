package bolichess.models;

import bolichess.logic.MovimentoValidator;
import lombok.Data;

@Data
public class Tabuleiro {
    private final Peca[][] matriz = new Peca[8][8];

    public Tabuleiro() {
        inicializar();
    }

    private void inicializar() {
        matriz[5][0] = new Peao("branca");
        matriz[1][1] = new Peao("preta");
    }

    public void mover(int lo, int co, int ld, int cd) {
        Peca p = getPecaTabuleiro(lo, co);

        if (MovimentoValidator.validar(this, lo, co, ld, cd)) {
            matriz[ld][cd] = p;
            matriz[lo][co] = null;
            System.out.println("Movimento realizado");
        } else {
            System.out.println("Movimento não realizado");
        }
    }

    public void imprimir() {
        for (int i = 0; i < 8; i++) {
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
