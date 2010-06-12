/*
 * Copyright (C) 2010 Otávio Scherer Garcia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jsr303br.util;

/**
 * Métodos utilitários.
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public final class Utils {

    /**
     * Retorna <code>true</code> se a {@link String} de entrada for nula ou vazia, <code>false</code> caso contrário.
     * 
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

    /**
     * Retorna somente os dígitos de uma {@link String}.
     * 
     * @param value
     * @return
     */
    public static String onlyDigits(String value) {
        // I'll never get null value here

        final StringBuilder out = new StringBuilder(value.length());
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                out.append(c);
            }
        }

        return out.toString();
    }

    /**
     * Retorna <code>true</code> se todos os dígitos da {@link String} de entrada forem iguais, <code>false</code> caso
     * contrário.
     * 
     * @param value
     * @return
     */
    public static boolean allDigitsAreEquals(String value) {
        // I'll never get null or empty values here
        for (char c : value.toCharArray()) {
            if (c != value.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidCpfCnpj(String value) {
        // I'll never get null or empty values here
        if (allDigitsAreEquals(value)) {
            return false;
        }

        int[] found = { 0, 0 };
        int d1 = Integer.parseInt(value.substring(value.length() - 2, value.length() - 1));
        int d2 = Integer.parseInt(value.substring(value.length() - 1, value.length()));
        for (int a = 0; a < 2; a++) {
            int d, sum = 0, c = 2;
            for (int b = value.length() - 3 + a; b >= 0; b--) {
                d = Integer.parseInt(value.substring(b, b + 1));
                sum += d * c++;
                if (value.length() == 14 && c > 9) { // cnpj
                    c = 2;
                }
            }
            found[a] = 11 - sum % 11;
            found[a] = (found[a] > 9) ? 0 : found[a];
        }

        return d1 == found[0] && d2 == found[1];
    }
}
