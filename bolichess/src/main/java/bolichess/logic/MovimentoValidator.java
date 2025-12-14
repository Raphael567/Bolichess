package bolichess.logic;

import bolichess.models.Peca;
import bolichess.models.Tabuleiro;

public class MovimentoValidator {
    public static boolean validar(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca p = t.getPecaTabuleiro(lo, co);

        if (p == null) return false;

        if (!p.movimentoValido(t, lo, co, ld, cd)) return false;

        if (!p.movimentoRetoOuDiagonal(co, cd)) {
            if (!temPecaNoCaminho(t, ld, cd)) {
                System.out.println("Não tem peça no caminho");
                return false;
            }
        }

        return true;
    }

    private static boolean temPecaNoCaminho(Tabuleiro t, int ld, int cd) {
        return t.getPecaTabuleiro(ld, cd) != null;
    }
}
