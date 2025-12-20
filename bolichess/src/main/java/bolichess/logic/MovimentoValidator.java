package bolichess.logic;

import bolichess.models.Peao;
import bolichess.models.Peca;
import bolichess.models.Tabuleiro;

public class MovimentoValidator {
    public static boolean validar(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca p = t.getPecaTabuleiro(lo, co);
        if (p == null) return false;

        if (!p.movimentoValido(t, lo, co, ld, cd)) return false;

        if (!(p instanceof Peao)) {
            if (temPecaNoCaminho(t, lo, co, ld, cd)) {
                System.out.println("Existe peça no caminho");
                return false;
            }
        }

        Peca destino = t.getPecaTabuleiro(ld, cd);
        if (destino != null && destino.getCor().equals(p.getCor())) {
            System.out.println("As cores são iguais");
            return false;
        }

        return true;
    }

    private static boolean temPecaNoCaminho(Tabuleiro t, int lo, int co, int ld, int cd) {

        int deltaL = ld - lo;
        int deltaC = cd - co;

        int stepL = Integer.compare(deltaL, 0);
        int stepC = Integer.compare(deltaC, 0);

        int l = lo + stepL;
        int c = co + stepC;

        while (l != ld || c != cd) {
            if (t.getPecaTabuleiro(l, c) != null) return true;

            l += stepL;
            c += stepC;
        }

        return false;
    }
}
