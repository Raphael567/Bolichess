package bolichess.models;

public class Peao extends Peca {
    public Peao(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(int lo, int co, int ld, int cd) {
        return (co == cd) && (ld == lo+1 ? lo<ld && getCor().equals("branca") : ld == lo-1);
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♙" : "♟";
    }
}
