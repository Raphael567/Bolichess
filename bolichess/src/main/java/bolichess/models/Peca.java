package bolichess.models;

import lombok.Data;

@Data
public abstract class Peca {
    protected String cor;

    public Peca(String cor) {
        this.cor = cor;
    }

    public abstract boolean movimentoValido(Tabuleiro t, int linhaOrigem, int colOrigem,
                                            int linhaDestino, int colDestino);

    public abstract boolean movimentoRetoOuDiagonal (int colOrigem, int colDestino);
}
