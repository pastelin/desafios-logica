import squareSum from '../../src/katas-eight/squareSum';

describe('Pruebas en squareSum', () => {
    
    test('squareSum debe pasar 3 pruebas', () => {
        
        expect(squareSum([1,2])).toBe(5);
        expect(squareSum([0,3,4,5])).toBe(50);
        expect(squareSum([])).toBe(0);

    });

});