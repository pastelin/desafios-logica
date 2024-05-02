import { getDayName } from '../../src/day-6/dates';

describe('Tests in dates ', () => {
    test('Should pass all tests', () => {
        expect(getDayName('10/11/2009')).toBe('Sunday');
    });
});
