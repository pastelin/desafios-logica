import { fireAndFury } from '../../../src/katas/six/fireAndFury';

describe('Realiza pruebas en archivo fireAndFury', () => {
    test('Should be pass all tests', () => {
        expect(fireAndFury('FURYYYFIREYYFIRE')).toBe(
            'I am furious. You and you are fired!'
        );
        expect(fireAndFury('FIREYYFURYYFURYYFURRYFIRE')).toBe(
            'You are fired! I am really furious. You are fired!'
        );
        expect(fireAndFury('FYRYFIRUFIRUFURE')).toBe('Fake tweet.');
        expect(fireAndFury('AAFIREBBFURYCC')).toBe('Fake tweet.');
    });
});
