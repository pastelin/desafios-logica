package com.codewars.six;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class OddDigPrime {

    public static boolean isPrime(long number) {
        // 1. Casos base rápidos
        if (number <= 1) return false;
        if (number == 2) return true;

        // 2. Descartar pares rápidamente:
        // Esto elimina el 50% de los números inmediatamente sin hacer bucles.
        if (number % 2 == 0) return false;

        // 3. Bucle optimizado:
        // - Empieza en 3 (porque ya revisamos el 2).
        // - Llega hasta la raíz cuadrada (suficiente para descartar divisores).
        // - Avanza de 2 en 2 (i -> i + 2) para saltarse todos los números pares.
        // Nota: Usamos (long) Math.sqrt para evitar desbordamiento si el número es muy grande.
        return LongStream.iterate(3, i -> i <= (long) Math.sqrt(number), i -> i + 2)
                .noneMatch(i -> number % i == 0);
    }

    public static boolean hasOnlyOddDigits(long number) {
        // Optimización matemática:
        // Usamos módulo (%) y división (/) en lugar de convertir a String.
        // Esto evita crear objetos en memoria, haciéndolo mucho más veloz.
        while (number > 0) {
            if ((number % 10) % 2 == 0) {
                return false; // Cortocircuito: si vemos un par, salimos inmediatamente.
            }
            number /= 10; // Pasamos al siguiente dígito
        }
        return true;
    }

    public static long[] onlyOddDigPrimes(long n) {
        // Generación de Primos:
        List<Long> primes = LongStream.iterate(3, i -> i + 2) // Generamos solo impares
                .filter(OddDigPrime::hasOnlyOddDigits) // FILTRO 1: El más rápido (matemáticas simples)
                .filter(OddDigPrime::isPrime)          // FILTRO 2: El más lento (bucles)
                .takeWhile(number -> number <= n)      // Límite
                .boxed()
                .toList();

        // Búsqueda del siguiente número mayor a N:
        long pureOddDigitLargerThanN;
        long tempN = n;

        while (true) {
            tempN++;
            // Aplicamos la misma lógica de "Cortocircuito":
            // Primero verificamos los dígitos (rápido). Si falla, Java no ejecuta isPrime (lento).
            if (hasOnlyOddDigits(tempN) && isPrime(tempN)) {
                pureOddDigitLargerThanN = tempN;
                break;
            }
        }

        // Manejo seguro por si la lista está vacía (aunque empezando en 3 es raro, es buena práctica)
        long lastPrime = primes.isEmpty() ? 0 : primes.get(primes.size() - 1);

        return new long[]{primes.size(), lastPrime, pureOddDigitLargerThanN};
    }

    public static void main(String[] args) {
        // Prueba rápida
        System.out.println(Arrays.toString(onlyOddDigPrimes(20)));
        // Debería salir: [7, 19, 31] (Primos: 3, 5, 7, 11, 13, 17, 19)
    }
}
