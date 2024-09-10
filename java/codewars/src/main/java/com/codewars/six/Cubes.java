package com.codewars.six;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// We search non-negative integer numbers, with at most 3 digits, such as the
// sum of the cubes of their digits is the number itself; we will call them
// "cubic" numbers.
// 153 is such a "cubic" number : 1^3 + 5^3 + 3^3 = 153
// These "cubic" numbers of at most 3 digits are easy to find, even by hand, so
// they are "hidden" with other numbers and characters in a string.
// The task is to find, or not, the "cubic" numbers in the string and then to
// make the sum of these "cubic" numbers found in the string, if any, and to
// return a string such as:
// "number1 number2 (and so on if necessary) sumOfCubicNumbers Lucky"
// if "cubic" numbers number1, number2, ... were found. The numbers in the
// output are to be in the order in which they are encountered in the input
// string.
// If no cubic numbers are found return the string: "Unlucky".
// Examples:
// - s = "aqdf& 0 1 xyz 153 777.777" must return "0 1 153 154 Lucky"
// - s = "QK29 45[&erui" must return "Unlucky".
// Note: In the string "001234" where 3 digits or more follow each other the
// fist packet to examine is "001" and not "234"
public class Cubes {

	// 1. Crear una función isSumOfCubes que acepte un String como argumento.
	public String isSumOfCubes(String s) {

		// 2. Inicializar una lista vacía para almacenar los números cúbicos
		// encontrados.
		ArrayList<Integer> cubicNumbers = new ArrayList<>();

		// 3. Utilizar una expresión regular para encontrar todas las secuencias de
		// dígitos en el String dado.
		Pattern pattern = Pattern.compile("\\d{1,3}");

		// 4. Para cada secuencia de dígitos encontrada, hacer lo siguiente:
		Matcher matcher = pattern.matcher(s);

		int sum = 0;

		while (matcher.find()) {
			// 4.1 Convertir la secuencia de dígitos a un número entero.
			int number = Integer.parseInt(matcher.group());
			// 4.2 Verificar si el número es un número cúbico (la suma de los cubos de sus
			// dígitos es igual al número mismo).
			if (isCubic(number)) {
				// 4.3 Si es un número cúbico, agregarlo a la lista de números cúbicos
				// encontrados.
				cubicNumbers.add(number);
				sum += number; // Sumar directamente aquí
			}
		}

		// 5. Si la lista de números cúbicos encontrados está vacía, retornar "Unlucky".
		if (cubicNumbers.isEmpty()) {
			return "Unlucky";
		} else {
			StringBuilder result = new StringBuilder();
			for (int num : cubicNumbers) {
				result.append(num).append(" ");
			}
			// Construir la cadena de salida con todos los números cúbicos encontrados
			// seguidos de la suma y la palabra "Lucky".
			result.append(sum).append(" Lucky");
			return result.toString();
		}

	}

	private boolean isCubic(int number) {
		int sum = 0; 
		int temp = number;

		while (temp > 0) {
			int digit = temp % 10;
			sum += Math.pow(digit, 3);
			temp /= 10;
		}
		return sum == number;
	}

	public static void main(String[] args) {
		Cubes cubes = new Cubes();
		System.out.println(cubes.isSumOfCubes("QK29a45[&erui9026315"));
	}
}
