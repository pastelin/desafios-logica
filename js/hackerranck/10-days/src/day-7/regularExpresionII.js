export const regexVar = () => {
    /*
     * ^ : Este símbolo indica el inicio de la cadena. La cadena debe comenzar con lo que sigue a este símbolo.

	* (Mr|Mrs|Ms|Dr|Er): Este es un grupo que busca las palabras "Mr", "Mrs", "Ms", "Dr" o "Er". 
	* El símbolo | actúa como un operador OR, lo que significa que la cadena puede comenzar con cualquiera de estas opciones.

	* \.: Este es un carácter de escape que permite buscar el carácter punto (.). En las expresiones regulares, 
	* el punto tiene un significado especial (cualquier carácter), por lo que si queremos buscar un punto literal, debemos escaparlo con una barra invertida.

	* [a-zA-Z]: Este es un conjunto de caracteres que busca cualquier letra mayúscula o minúscula.

	* +: Este símbolo indica que el conjunto de caracteres anterior ([a-zA-Z]) debe aparecer al menos una vez.

	* $: Este símbolo indica el final de la cadena. La cadena debe terminar con lo que precede a este símbolo.
     */
    let re = /^(Mr|Mrs|Ms|Dr|Er)\.[a-zA-Z]+$/;

    /*
     * Do not remove the return statement
     */
    return re;
};

3297.77;
