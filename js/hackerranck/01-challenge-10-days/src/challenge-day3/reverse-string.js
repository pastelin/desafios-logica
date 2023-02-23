export const reverseString = (cadena) => {

    try {

        let stringToArray = cadena.split('');
        let reverseArray = stringToArray.reverse();
        
        return reverseArray.join('');
    } catch(error) {
        
        return cadena;
    }
};