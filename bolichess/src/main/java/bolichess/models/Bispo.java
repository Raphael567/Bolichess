package bolichess.models;

public class Bispo extends Peca {
    public Bispo(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return (co > cd || cd > co);
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♗" : "♝";
    }
}
