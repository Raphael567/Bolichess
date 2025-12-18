package bolichess.models;

public class Peao extends Peca {
    public Peao(String cor) {
        super(cor);
    }

//    @Override
//    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
//        if (((co == cd) || (cd == co+1) || (cd == co-1)) && ((ld == lo-1) && (lo>ld && getCor().equals("branca")))) {
//            System.out.println(ld == lo+1);
//            return true;
//        } else if (ld == lo+1) {
//            System.out.println(lo<ld);
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return ((co == cd) || (cd == co+1) || (cd == co-1)) && (ld == lo-1 ? lo>ld && getCor().equals("branca") : ld == lo+1 && getCor().equals("preta"));
    }

    @Override
    public boolean movimentoDiagonal(int co, int cd) { return co == cd; }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♙" : "♟";
    }
}
