package com.codewars.six;

/**
 * Clase que demuestra el uso de sobrecarga de métodos (method overloading) en Java.
 *
 * PROBLEMA:
 * El desafío es crear métodos con el mismo nombre 'ho()' que tengan diferentes
 * comportamientos según la cantidad de parámetros recibidos.
 *
 * SOLUCIÓN:
 * Se utilizan dos versiones del método ho():
 * 1. ho() - sin parámetros: devuelve "Ho!"
 * 2. ho(String s) - con parámetro String: elimina el último carácter de la cadena
 *    y agrega " Ho!" al final
 *
 * CÓMO FUNCIONA EL FLUJO:
 * En main() se ejecuta: ho(ho(ho()))
 *
 * Paso 1: ho() (sin argumentos)
 *   - Retorna: "Ho!"
 *
 * Paso 2: ho("Ho!") (primer nivel de anidación)
 *   - Recibe: "Ho!"
 *   - Elimina último carácter (!): "Ho"
 *   - Agrega " Ho!": "Ho Ho!"
 *   - Retorna: "Ho Ho!"
 *
 * Paso 3: ho("Ho Ho!") (segundo nivel de anidación)
 *   - Recibe: "Ho Ho!"
 *   - Elimina último carácter (!): "Ho Ho"
 *   - Agrega " Ho!": "Ho Ho Ho!"
 *   - Retorna: "Ho Ho Ho!"
 *
 * SALIDA ESPERADA: Ho Ho Ho!
 */
public class HoHoHoWithFunctions {

    /**
     * Método sin parámetros que devuelve la cadena "Ho!"
     * Este es el caso base de la recursión en la llamada anidada.
     *
     * @return La cadena "Ho!"
     */
    public static String ho() {
        return "Ho!";
    }

    /**
     * Método que recibe un String como parámetro.
     * Elimina el último carácter de la cadena y agrega " Ho!" al final.
     *
     * EJEMPLO:
     * Entrada: "Ho!"
     * - substring(0, length()-1) elimina el '!' → "Ho"
     * - Se concatena " Ho!" → "Ho Ho!"
     * Salida: "Ho Ho!"
     *
     * @param s La cadena a procesar
     * @return La cadena modificada sin el último carácter más " Ho!"
     */
    public static String ho(String s) {
        // Elimina el último carácter de la cadena
        s = s.substring(0, s.length() - 1);
        // Concatena " Ho!" al final
        s = s + " Ho!";
        return s;
    }

    /**
     * Método principal que demuestra el funcionamiento de la sobrecarga.
     * Ejecuta llamadas anidadas de ho() para mostrar cómo se construye
     * una cadena de "Ho Ho Ho!" mediante recursión de métodos sobrecargados.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Llamadas anidadas: desde adentro hacia afuera
        // 1. ho() → "Ho!"
        // 2. ho("Ho!") → "Ho Ho!"
        // 3. ho("Ho Ho!") → "Ho Ho Ho!"
        System.out.println(ho(ho(ho())));
    }
}
