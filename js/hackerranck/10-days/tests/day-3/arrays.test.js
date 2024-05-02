import { getSecondLargest } from "../../src/day-3/arrays";

describe('Tests in arrays file', () => {
	
	test('Shoul be pass all tests', () => {
		expect(getSecondLargest([2,3,6,6,5])).toBe(5);
	});
});