import { deadAntCount } from "../../../src/katas/six/deadAntCount";

describe('Realizar pruebas en deadAntCount', () => {
	test('Should pass all test', () => {
		expect(deadAntCount("ant ant ant ant")).toBe(0);
		expect(deadAntCount(null)).toBe(0);
		expect(deadAntCount("ant anantt aantnt")).toBe(2);
		expect(deadAntCount("ant ant .... a nt")).toBe(1);
	});
});