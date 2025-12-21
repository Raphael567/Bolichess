package bolichess.models;

//TODO: Terminar Cavalo
public class Cavalo extends Peca {
    public Cavalo(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return (((ld == lo-2 || ld == lo+2) && (cd == co+1 || cd == co-1)) || (ld == lo-1 || ld == lo+1) && ((cd == co+2 || cd == co-2)) ? lo > ld && getCor().equals("branca") : (ld == lo+2 || ld == lo+1 || ld == lo-2 || ld == lo-1) && getCor().equals("preta"));
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♘" : "♞";
    }
}
