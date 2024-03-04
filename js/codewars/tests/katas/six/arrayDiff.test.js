import { arrayDiff } from "../../../src/katas/six/arrayDiff";

describe('Pruebas en arrayDiff', () => {
	test('should pass all test', () => {
		expect(arrayDiff([1,2], [1])).toStrictEqual([2]);
		expect(arrayDiff([1,2,2], [1])).toStrictEqual([2,2]);
		expect(arrayDiff([1,2,2], [2])).toStrictEqual([1]);
		expect(arrayDiff([1,2,2], [])).toStrictEqual([1,2,2]);
		expect(arrayDiff([], [1,2])).toStrictEqual([]);
		expect(arrayDiff([1,2,3], [1,2])).toStrictEqual([3]);
	});
});