import { modifyArray } from "../../src/day-5/arrow-functions";

describe('tests in arrow-funtios file', () => {
	test('should pass all tests', () => {
		expect(modifyArray([1,2,3,4,5])).toStrictEqual([3,4,9,8,15]);
	});
});