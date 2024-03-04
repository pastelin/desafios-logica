export const firstNonRepeatingLetter = (s) => {

	for(let c of s) {
		let coincidence = s.match(new RegExp(c, 'gi')).length;
		if(coincidence === 1) {
			return c;
		}
	}

    return '';
};