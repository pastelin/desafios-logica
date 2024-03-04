export const zeros = (n) => {
    let count = 0;

	// Obtiene el número de ceros que se pueden formar con el factorial de n
    for (let i = 5; n / i >= 1; i *= 5) {
        count += Math.floor(n / i);
    }
    return count;
};
