package bolichess.logic;

import bolichess.models.Peca;
import bolichess.models.Tabuleiro;

public class MovimentoValidator {
    public static boolean validar(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca p = t.getPeca(lo, co);

        if (p == null) {
            System.out.println("Não existe peça nesse local");
            return false;
        };

        if (!p.movimentoValido(t, lo, co, ld, cd)) {
            System.out.println("Movimento inválido");
            return false;
        }

        if (temPecaNoCaminho(t, ld, cd)) {
            System.out.println("Tem peça no caminho");
            return !p.movimentoRetoOuDiagonal(co, cd);
        }

        return true;
    }

    private static boolean temPecaNoCaminho(Tabuleiro t, int ld, int cd) {
        return t.getPeca(ld, cd) != null;
    }
}
