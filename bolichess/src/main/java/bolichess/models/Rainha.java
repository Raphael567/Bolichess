package bolichess.models;

public class Rainha extends Peca {

    public Rainha(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return ((lo > ld || ld > lo) || (co > cd || cd > co));
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♕" : "♛";
    }
}
