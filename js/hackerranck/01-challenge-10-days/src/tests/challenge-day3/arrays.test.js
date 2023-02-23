import { getSecondLargest } from '../../challenge-day3/arrays';

describe('Pruebas de arrays.js', () => {

    test('getSecondLargest debe retornar 5', () => {

        const numbers = [2, 3, 6, 6, 5];

        const resultado =  getSecondLargest(numbers);

        expect(resultado).toBe(5);

    });

});