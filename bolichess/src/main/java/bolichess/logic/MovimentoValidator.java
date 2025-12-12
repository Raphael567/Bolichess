package bolichess.logic;

import bolichess.models.Peca;
import bolichess.models.Tabuleiro;

public class MovimentoValidator {
    public static boolean validar(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca p = t.getPeca(lo, co);

        if (p == null) return false;

        if (!p.movimentoValido(lo, co, ld, cd)) {
            return false;
        }

        if (temPecaNoCaminho(t, lo, co, ld, cd)) {
            System.out.println("Tem peça no caminho");
            return false;
        }

        return true;
    }

    private static boolean temPecaNoCaminho(Tabuleiro t, int lo, int co, int ld, int cd) {
        return t.getPeca(ld, cd) != null;
    }
}
