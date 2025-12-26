package bolichess.models;

//TODO: Fazer xeque-mate
public class Rei extends Peca {

    public Rei(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        return (((cd == co+1) || (cd == co-1) || (cd == co)) && ((ld == lo+1) || (ld == lo-1) || (ld == lo)));
    }

    @Override
    public String toString(){
        return cor.equals("branca") ? "♔" : "♚";
    }
}
