export const vowelsAndConsonants = (s) => {
    let vowels = [];
    let consonants = [];

    for (let i = 0; i < s.length; i++) {
        if('aeiou'.includes(s[i])) {
            vowels.push(s[i]);
        } else {
            consonants.push(s[i]);
        }
    }

    return vowels.join('') + consonants.join('');
};
