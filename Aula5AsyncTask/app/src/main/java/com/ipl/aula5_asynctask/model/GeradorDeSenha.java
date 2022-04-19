package com.ipl.aula5_asynctask.model;

import java.util.Random;

public class GeradorDeSenha {

    public String gerarSenha(int tamanhoDaSenha, boolean usarLetraMaiscula, boolean usarLetraMinuscula, boolean usarNumeros, boolean usarCaraterEspecial) {
        StringBuilder senha = new StringBuilder("");
        String[] letrasMaiusculas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] letrasMinusculas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] caracterEspecial = {"{", "}", "[", "]", "!", "@", "#", "$", "%", "&", "*", "(", ")", "+", "="};

        for (int i = 1; i <= tamanhoDaSenha; i++) {
            int nextRamdomLetra = Math.abs(new Random().nextInt(letrasMaiusculas.length));
            int nextRamdomNumeros = Math.abs(new Random().nextInt(numeros.length));
            int nextRamdomCaracterEspecial = Math.abs(new Random().nextInt(caracterEspecial.length));

            if (usarLetraMaiscula && senha.length() < tamanhoDaSenha) {
                senha.append(letrasMaiusculas[nextRamdomLetra]);
            }
            if (usarLetraMinuscula && senha.length() < tamanhoDaSenha) {
                senha.append(letrasMinusculas[nextRamdomLetra]);
            }
            if (usarNumeros && senha.length() < tamanhoDaSenha) {
                senha.append(numeros[nextRamdomNumeros]);
            }
            if (usarCaraterEspecial && senha.length() < tamanhoDaSenha) {
                senha.append(caracterEspecial[nextRamdomCaracterEspecial]);
            }
        }
        String senhaEmabaralhada = shuffle(senha.toString());

        return senhaEmabaralhada;
    }

    public static String shuffle(String text) {
        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int)(Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
