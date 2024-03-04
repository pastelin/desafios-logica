import { zeros } from '../../../src/katas/five/zeros';

describe('Realizar priebas en zeros', () => {
    test('Should be pass all tests', () => {
        expect(zeros(0)).toBe(0);
        expect(zeros(5)).toBe(1);
        expect(zeros(6)).toBe(1);
        expect(zeros(30)).toBe(7);
        expect(zeros(20)).toBe(4);
    });
});
