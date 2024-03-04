import { firstNonRepeatingLetter } from "../../../src/katas/five/firstNonRepeatingLetter";

describe('Realizar pruebas en firstNonRepeatingLetter', () => {
	test('Should be pass all tests', () => {
		
		expect(firstNonRepeatingLetter('a')).toBe('a');
		expect(firstNonRepeatingLetter('stress')).toBe('t');
		expect(firstNonRepeatingLetter('moonmen')).toBe('e');

	});
});