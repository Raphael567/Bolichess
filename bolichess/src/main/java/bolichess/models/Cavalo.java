package bolichess.models;

public class Cavalo extends Peca {
    public Cavalo(String cor) {
        super(cor);
    }

    @Override
    public boolean movimentoValido(Tabuleiro t, int lo, int co, int ld, int cd) {
        int deltaLinha = Math.abs(ld - lo);
        int deltaColuna = Math.abs(cd - co);

        return (deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2);
    }

    @Override
    public String toString() {
        return cor.equals("branca") ? "♘" : "♞";
    }
}
