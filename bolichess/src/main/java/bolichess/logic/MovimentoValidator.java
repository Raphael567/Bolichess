package bolichess.logic;

import bolichess.models.*;

import java.util.ArrayList;
import java.util.List;

public class MovimentoValidator {
    public static boolean validar(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca p = t.getPecaTabuleiro(lo, co);

        if (p == null) return false;

        if (!p.movimentoValido(t, lo, co, ld, cd)) return false;

        if (!(p instanceof Peao) && !(p instanceof Cavalo)) {
            if (temPecaNoCaminho(t, lo, co, ld, cd)) {
                System.out.println("Existe peça no caminho");
                return false;
            }
        }

        if (p instanceof Rei) return !isXeque(t, lo, co, ld, cd);

        Peca destino = t.getPecaTabuleiro(ld, cd);
        if (destino != null && destino.getCor().equals(p.getCor())) {
            System.out.println("As cores são iguais");
            return false;
        }

//        int[] r = t.getReiCoordenada(p.getCor());
//
//        if (isXeque(t, r[0], r[1], ld, cd)) return false;

        return true;
    }

    private static boolean temPecaNoCaminho(Tabuleiro t, int lo, int co, int ld, int cd) {

        int deltaL = ld - lo;
        int deltaC = cd - co;

        int stepL = Integer.compare(deltaL, 0);
        int stepC = Integer.compare(deltaC, 0);

        int l = lo + stepL;
        int c = co + stepC;

        while (l != ld || c != cd) {
            if (t.getPecaTabuleiro(l, c) != null) return true;

            l += stepL;
            c += stepC;
        }

        return false;
    }

    private static Peca[] pecasAoRedor(Tabuleiro t, int l, int c) {
        List<Peca> pecas = new ArrayList<>();

        int[][] direcoes = {
                {-1,  0}, // cima
                { 1,  0}, // baixo
                { 0, -1}, // esquerda
                { 0,  1}, // direita
                {-1, -1}, // diagonal cima-esq
                {-1,  1}, // diagonal cima-dir
                { 1, -1}, // diagonal baixo-esq
                { 1,  1}  // diagonal baixo-dir
        };

        for (int[] d : direcoes) {
            int l_ = l + d[0];
            int c_ = c + d[1];

            while (l_ >= 0 && l_ < 8 && c_ >= 0 && c_ < 8) {
                Peca peca = t.getPecaTabuleiro(l_, c_);
                if (peca != null) {
                    pecas.add(peca);
                    break;
                }

                l_ += d[0];
                c_ += d[1];
            }
        }

        return pecas.toArray(new Peca[0]);
    }

    private static boolean isXeque(Tabuleiro t, int lo, int co, int ld, int cd) {
        Peca[] pecas = pecasAoRedor(t, lo, co);

        for (Peca p : pecas) {
            if (p.movimentoValido(t, lo, co, ld, cd)) {
                System.out.println("Rei em xeque");
                return true;
            }
        }

        Peca[] pecasFuturas = pecasAoRedor(t, ld, cd);

        for (Peca p : pecasFuturas) {
            if (p.movimentoValido(t, lo, co, ld, cd)) {
                System.out.println("Rei estará em xeque");
                return true;
            }
        }

        return false;
    }
}
