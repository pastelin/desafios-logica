import { sides } from "../../src/day-5/template-literals";

describe('tests in template literals', () => {

	test('should pass all tests', () => {
		expect(sides`The area is: ${14 * 10}.\nThe perimeter is: ${2 * (14 + 10)}.`).toStrictEqual([10,14]);
	});
	
});