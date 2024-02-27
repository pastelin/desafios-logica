import { anagramDifference } from '../../../src/katas/six/anagramDifference';

describe('Pruebas en anagramDifference', () => {
    const testCases = [
        // w1     w2   expected
        ['', '', 0],
        ['a', '', 1],
        ['', 'a', 1],
        ['ab', 'a', 1],
        ['ab', 'cd', 4],
        ['aab', 'a', 2],
        ['a', 'aab', 2],
        ['codewars', 'hackerrank', 10],
    ];

    test('Should pass all tests', () => {
        testCases.forEach((testCase) => {
            const [w1, w2, expected] = testCase;
            expect(anagramDifference(w1, w2)).toBe(expected);
        });
    });
});
