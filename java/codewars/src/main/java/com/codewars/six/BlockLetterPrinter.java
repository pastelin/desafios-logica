package com.codewars.six;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BlockLetterPrinter {

    // El mapa pre-cargado con la representación de 7 líneas para cada caracter.
    private static final Map<Character, String[]> ALPHA = new HashMap<>();

    static {
        ALPHA.put('a', new String[]{" AAA ", "A   A", "A   A", "AAAAA", "A   A", "A   A", "A   A"});
        ALPHA.put('b', new String[]{"BBBB ", "B   B", "B   B", "BBBB ", "B   B", "B   B", "BBBB "});
        ALPHA.put('c', new String[]{" CCC ", "C   C", "C    ", "C    ", "C    ", "C   C", " CCC "});
        ALPHA.put('d', new String[]{"DDDD ", "D   D", "D   D", "D   D", "D   D", "D   D", "DDDD "});
        ALPHA.put('e', new String[]{"EEEEE", "E    ", "E    ", "EEEEE", "E    ", "E    ", "EEEEE"});
        ALPHA.put('f', new String[]{"FFFFF", "F    ", "F    ", "FFFFF", "F    ", "F    ", "F    "});
        ALPHA.put('g', new String[]{" GGG ", "G   G", "G    ", "G GGG", "G   G", "G   G", " GGG "});
        ALPHA.put('h', new String[]{"H   H", "H   H", "H   H", "HHHHH", "H   H", "H   H", "H   H"});
        ALPHA.put('i', new String[]{"IIIII", "  I  ", "  I  ", "  I  ", "  I  ", "  I  ", "IIIII"});
        ALPHA.put('j', new String[]{"JJJJJ", "    J", "    J", "    J", "J   J", "J   J", " JJJ "});
        ALPHA.put('k', new String[]{"K   K", "K  K ", "K K  ", "KK   ", "K K  ", "K  K ", "K   K"});
        ALPHA.put('l', new String[]{"L    ", "L    ", "L    ", "L    ", "L    ", "L    ", "LLLLL"});
        ALPHA.put('m', new String[]{"M   M", "MM MM", "M M M", "M   M", "M   M", "M   M", "M   M"});
        ALPHA.put('n', new String[]{"N   N", "NN  N", "N N N", "N  NN", "N   N", "N   N", "N   N"});
        ALPHA.put('o', new String[]{" OOO ", "O   O", "O   O", "O   O", "O   O", "O   O", " OOO "});
        ALPHA.put('p', new String[]{"PPPP ", "P   P", "P   P", "PPPP ", "P    ", "P    ", "P    "});
        ALPHA.put('q', new String[]{" QQQ ", "Q   Q", "Q   Q", "Q   Q", "Q Q Q", "Q  QQ", " QQQQ"});
        ALPHA.put('r', new String[]{"RRRR ", "R   R", "R   R", "RRRR ", "R R  ", "R  R ", "R   R"});
        ALPHA.put('s', new String[]{" SSS ", "S   S", "S    ", " SSS ", "    S", "S   S", " SSS "});
        ALPHA.put('t', new String[]{"TTTTT", "  T  ", "  T  ", "  T  ", "  T  ", "  T  ", "  T  "});
        ALPHA.put('u', new String[]{"U   U", "U   U", "U   U", "U   U", "U   U", "U   U", " UUU "});
        ALPHA.put('v', new String[]{"V   V", "V   V", "V   V", "V   V", "V   V", " V V ", "  V  "});
        ALPHA.put('w', new String[]{"W   W", "W   W", "W   W", "W W W", "W W W", "W W W", " W W "});
        ALPHA.put('x', new String[]{"X   X", " X X ", "  X  ", "  X  ", " X X ", "X   X", "X   X"});
        ALPHA.put('y', new String[]{"Y   Y", "Y   Y", " Y Y ", "  Y  ", "  Y  ", "  Y  ", "  Y  "});
        ALPHA.put('z', new String[]{"ZZZZZ", "    Z", "   Z ", "  Z  ", " Z   ", "Z    ", "ZZZZZ"});
        ALPHA.put(' ', new String[]{"     ", "     ", "     ", "     ", "     ", "     ", "     "});
    }

    public static String blockPrint(String string) {
        // Regla: Ignorar espacios al inicio/final y manejar strings vacíos.
        if (string == null || string.trim().isEmpty()) {
            return "";
        }

        // Regla: Convertir a minúsculas y quitar espacios sobrantes.
        String cleanedInput = string.trim().toLowerCase();

        // 1. Preparamos nuestro "lienzo" con 7 StringBuilders.
        StringBuilder[] lines = new StringBuilder[7];
        for (int i = 0; i < 7; i++) {
            lines[i] = new StringBuilder();
        }

        // Para controlar el espacio entre caracteres.
        boolean isFirstChar = true;

        // 2. Recorremos cada caracter de la entrada limpia.
        for (char c : cleanedInput.toCharArray()) {
            // Regla: Añadir un espacio de separación antes de cada letra (excepto la primera).
            if (!isFirstChar) {
                for (int i = 0; i < 7; i++) {
                    lines[i].append(" ");
                }
            }

            // Obtenemos la representación de 7 líneas del caracter.
            String[] blockLetter = ALPHA.get(c);

            if (blockLetter != null) {
                // 3. "Dibujamos" la letra añadiendo cada una de sus 7 partes a nuestro lienzo.
                for (int i = 0; i < 7; i++) {
                    lines[i].append(blockLetter[i]);
                }
            }

            isFirstChar = false;
        }

        // 4. Unimos las 7 líneas con un salto de línea para formar el resultado final,
        // eliminando los espacios sobrantes al final de cada línea.
        return Arrays.stream(lines)
                .map(line -> line.toString().replaceAll("\\s+$", ""))
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        String testString = "heLLo WorLD";
        System.out.println("Entrada: \"" + testString + "\"\n");
        System.out.println(blockPrint(testString));
    }
}
