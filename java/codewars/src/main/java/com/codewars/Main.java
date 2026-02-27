package com.codewars;

/**
 * Decodificador de strings hexadecimales criptográficos.
 *
 * Objetivo: Decodificar cadenas que contienen datos cifrados en formato hexadecimal.
 * El algoritmo extrae porciones de 3 caracteres hexadecimales, las convierte a enteros,
 * resta 51 y luego convierte el resultado a carácter ASCII.
 *
 * Ejemplo:
 *   "09B0960A70940950A20AB098" decodifica a un string legible
 *   (probablemente credenciales: usuario, contraseña, URL de BD)
 *
 * @author Codewars
 */
public class Main {

    /**
     * Decodifica un string cifrado en hexadecimal.
     *
     * Algoritmo:
     * 1. Convierte la cadena a minúsculas para facilitar el procesamiento
     * 2. Itera desde el final del string hacia el inicio, saltando de 3 en 3 caracteres
     * 3. Extrae una substring de 3 caracteres hexadecimales
     * 4. Convierte de hexadecimal a decimal (parseInt con base 16)
     * 5. Resta 51 al valor decimal
     * 6. Convierte el resultado a carácter ASCII
     * 7. Acumula los caracteres en un StringBuffer
     *
     * Detalles importantes:
     * - El procesamiento es de atrás hacia adelante
     * - La substring se elimina después de procesar
     * - Se crea el mensaje en orden inverso
     *
     * Complejidad temporal: O(n) donde n es la longitud de la cadena
     * Complejidad espacial: O(n) para el StringBuffer
     *
     * @param pCadena string codificado en hexadecimal
     * @return string decodificado
     */
    public static String getCode(String pCadena) {
        int i = 0;
        String strBuscado = "";
        int val = 0;
        StringBuffer strValor = new StringBuffer();
        StringBuffer paso = new StringBuffer(pCadena.toLowerCase());

        // Itera desde el final hacia el inicio, saltando de 3 en 3
        for (i = paso.length() - 1; i >= 0; i -= 3) {
            // Extrae substring de 3 caracteres (desde i-2 hasta i)
            strBuscado = paso.substring(i - 2);
            // Elimina la porción procesada
            paso.delete(i - 2, i + 1);
            // Convierte de hexadecimal a decimal
            val = Integer.parseInt(strBuscado, 16);
            // Resta 51 y convierte a carácter ASCII
            strValor.append((char) (val - 51));
        }
        return strValor.toString();
    }

    /**
     * Decodifica y muestra tres cadenas de prueba.
     *
     * Las cadenas contienen:
     * 1. Usuario (USER)
     * 2. Contraseña (PASSWORD)
     * 3. URL de base de datos (DB URL)
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        System.out.println("USER");
        System.out.println(getCode("09B0960A70940950A20AB098"));

        System.out.println("PASSWORD");
        System.out.println(getCode("07906306507506506706906506706B06A095064099097098"));

        System.out.println("DB URL");
        System.out.println(getCode("0A30960A70920940A509509C09F07008507808908507808608B07C08008508207908107C06D0970A20A00960A109809209509706206406606806406D06806706106506806406106306306406106306806406206206D09C09F0A40A60600AB09C0A00A50A20990A109C06D09609509709D"));
    }
}
