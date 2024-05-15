import { regexVar } from "../../src/day-7/regularExpresionI";

describe('Tests in regularExpresionI', () => {

	test('Should pass all tests', () => {
		expect(regexVar('bcd')).toBe(false);
		expect(regexVar('abcd')).toBe(false);
		expect(regexVar('abcda')).toBe(true);
		expect(regexVar('abcdo')).toBe(false);
		expect(regexVar('aewxyzae')).toBe(false);
	});
	
});