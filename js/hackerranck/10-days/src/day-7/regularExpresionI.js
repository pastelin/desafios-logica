/*
 * La función regexVar en JavaScript está diseñada para probar si una cadena de texto
 * (representada por el parámetro s) comienza y termina con la misma vocal (ya sea a, e, i, o, u).
 */

export const regexVar = (s) => {
    
    

	/*
	     * ^([aeiou]): Este grupo de captura busca cualquiera de las vocales especificadas (a, e, i, o, u) al inicio de la cadena. 
		* El uso de los paréntesis crea un grupo de captura, lo que significa que la vocal que se encuentre se recordará para su uso posterior.

		* .*: El punto significa cualquier carácter excepto una nueva línea, y el asterisco significa cero o más repeticiones del carácter anterior. 
		* Juntos, .* significa "cualquier número de cualquier carácter".

		* \1: Esta es una referencia hacia atrás al primer grupo de captura (la vocal que se encontró al principio de la cadena). 
		* Esto significa que se buscará la misma vocal que se encontró al principio de la cadena.

		* $: Este símbolo representa el final de la cadena.
     */
	const re = /^([aeiou]).*\1$/;

    /*
     * Do not remove the return statement
     */
    return re.test(s);
};
