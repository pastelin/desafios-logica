import { isPositive } from '../../challenge-day3/throw-positive';

describe('Pruebas de throww-positive.js', () => {
    
    test('isPositive() debe retornar "YES"', () => {

        const number = 5;
        const valueTest = 'YES';
        const value = isPositive(number);

        expect(value).toEqual(valueTest);
    });

    test('isPositive() debe mostrar el mensaje de error "Zero Error"', () => {

        const number = 0; 
        const errorTest = 'Zero Error';

        expect( () => isPositive(number)).toThrow(errorTest);
    })

    test('isPositive() debe mostrar el mensaje de error "Negative Error"', () => {

        const number = -5;
        const errorTest = 'Negative Error';

        expect( () => isPositive(number)).toThrow(errorTest);

    });

});