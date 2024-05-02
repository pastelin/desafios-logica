import { getMaxLessThanK } from "../../src/day-6/bitwise-operators";

describe('Tests in bitwise-operators', () => {
	test('Should be pass all tests', () => {
		expect(getMaxLessThanK(5, 2)).toBe(1);
	});
});