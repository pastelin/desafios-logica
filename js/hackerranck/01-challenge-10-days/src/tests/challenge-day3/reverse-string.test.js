import { reverseString } from '../../challenge-day3/reverse-string';

describe('Pruebas para reverse-string.js', () => {

    test('reverseString debe retornar una cadena invertida', () => {

        const cadena = "1234";
        const cadenaTest = '4321';
        const cadenaRespuesta = reverseString(cadena);

        expect(cadenaRespuesta).toBe(cadenaTest);
    });

    test('reverseString() debe retornar el parametro recibido si ocurre un error', () => {

        const valorEntero = 1234;
        const cadenaRespuesta = reverseString(valorEntero);
        
        expect(cadenaRespuesta).toBe(valorEntero);
    })

});