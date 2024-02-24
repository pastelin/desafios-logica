import { splitAndAdd } from '../../../src/katas/six/splitAndAdd';

describe('Pruebas en splitAndAdd', () => {
	test('should pass all tests', () => {
		expect(splitAndAdd([1, 2, 3, 4, 5], 2)).toStrictEqual([5, 10]);

		expect(splitAndAdd([1, 2, 3, 4, 5], 3)).toStrictEqual([15]);
		expect(splitAndAdd([15], 3)).toStrictEqual([15]);
		expect(splitAndAdd([32, 45, 43, 23, 54, 23, 54, 34], 2)).toStrictEqual([183, 125]);
		expect(splitAndAdd([32, 45, 43, 23, 54, 23, 54, 34], 0)).toStrictEqual([
			32, 45, 43, 23, 54, 23, 54, 34,
		]);
		expect(splitAndAdd([3, 234, 25, 345, 45, 34, 234, 235, 345], 3)).toStrictEqual([305, 1195]);
		expect(
			splitAndAdd(
				[3, 234, 25, 345, 45, 34, 234, 235, 345, 34, 534, 45, 645, 645, 645, 4656, 45, 3],
				4
			)
		).toStrictEqual([1040, 7712]);
		expect(
			splitAndAdd([23, 345, 345, 345, 34536, 567, 568, 6, 34536, 54, 7546, 456], 20)
		).toStrictEqual([79327]);
	});
});
