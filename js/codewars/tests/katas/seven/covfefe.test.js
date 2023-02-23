import { covfefe } from '../../../src/katas/seven/covfefe';

describe('Pruebas en covfefe', () => {
    
    test('Should pass fixed tests', () => {
		expect(covfefe('coverage')).toBe('covfefe');
		expect(covfefe('coverage coverage')).toBe('covfefe covfefe');
		expect(covfefe('nothing')).toBe('nothing covfefe');
		expect(covfefe('double space ')).toBe('double space  covfefe');
		expect(covfefe('covfefe')).toBe('covfefe covfefe');
		expect(covfefe('erag')).toBe('erag covfefe');
	});
});