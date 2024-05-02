/*
	*  La función getMaxLessThanK(n, k) en JavaScript está diseñada para encontrar el valor máximo de la operación 
	* bit a bit AND (&) para todos los pares de números de 1 a n que sean menores que k.
*/
export const getMaxLessThanK = (n, k) => {
    let max = 0;
    for (let i = 1; i <= n; i++) {
        for (let j = i + 1; j <= n; j++) {
            let result = i & j;
            if (result < k && result > max) {
                max = result;
            }
        }
    }
    return max;
};