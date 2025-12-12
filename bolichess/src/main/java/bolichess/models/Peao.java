package bolichess.models;

public class Peao extends Peca {
    public Peao(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return (co == cd) || (cd == co+1) || (cd == co-1) && (ld == lo+1 ? lo<ld && getCor().equals("branca") : ld == lo-1);
    }

    @Override
    public boolean movimentoRetoOuDiagonal(int co, int cd) {

        if (co == cd) {
            System.out.println("Movimento Reto");
            return true;
        }

        System.out.println("Movimento Diagonal");
        return false;
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♙" : "♟";
    }
}
