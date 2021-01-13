package br.com.orange.apostador.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GeradorAposta {
    static int NUMERO_DEZENAS = 6;

    public static String obterNumerosString() {
        int[] numeros = apostar();
        return Arrays.stream(numeros)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int[] apostar() {
        int[] jogoDezenas = new int[NUMERO_DEZENAS];
        for (int i = 0; i < NUMERO_DEZENAS; i++) {
            int dezenaAleatoria;
            boolean repetido = false;
            do {
                dezenaAleatoria = (int) (Math.random()*60)+1;
                repetido = verificaNumRepetido(jogoDezenas, dezenaAleatoria);
            } while(repetido);
            jogoDezenas[i] = dezenaAleatoria;
        }
        return jogoDezenas;
    }

    private static boolean verificaNumRepetido(int[] numeros, int n) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == n) {
                return true;
            }
        }
        return false;
    }
}
