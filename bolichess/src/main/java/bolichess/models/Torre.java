package bolichess.models;

public class Torre extends Peca {

    public Torre(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return (((co == cd) && (lo > ld || ld > lo)) || ((lo == ld) && (co > cd || cd > co)));
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♖" : "♜";
    }
}
