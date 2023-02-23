import { countBy } from '../../src/katas-eight/counntByX';

describe('Probando archivo countByX', () => {
    
    test('countBy debe pasar tres pruebas', () => {
        expect(countBy(1,10)).toStrictEqual([1,2,3,4,5,6,7,8,9,10]);
        expect(countBy(2,5)).toStrictEqual([2,4,6,8,10]);
    });

});