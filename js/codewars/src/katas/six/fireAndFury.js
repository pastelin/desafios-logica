/*
    * The only letters still working are uppercase E, F, I, R, U, Y.
    * If no known words are found, or unexpected letters are encountered, then it must be a "Fake tweet."

*/

export const fireAndFury = (tweet) => {
    let words = [];
    let regex = /^[EFIRUY]*$/;
    let decipherTweet = '';

    if (!regex.test(tweet)) {
        return 'Fake tweet.';
    }

    while (tweet.includes('FURY') || tweet.includes('FIRE')) {
        let index = tweet.indexOf('F');
        let word = tweet.slice(index, index + 4);
        if (word === 'FURY' || word === 'FIRE') {
            words.push(word);
        }
        tweet = tweet.slice(index + 4);
    }

    if (words.length === 0) {
        return 'Fake tweet.';
    }

    while (words.length > 0) {
        if (words[0] === 'FURY') {
            decipherTweet += ' I am ';
            words.shift();
            decipherTweet +=
                decipherTweetArray(words, 'FURY', 'really ') + 'furious.';
        } else {
            decipherTweet += ' You';
            words.shift();
            decipherTweet +=
                decipherTweetArray(words, 'FIRE', ' and you') + ' are fired!';
        }
    }

    return decipherTweet.trim();
};

const decipherTweetArray = (words, condition, word) => {
    let decipherTweet = '';
    while (words[0] === condition) {
        words.shift();
        decipherTweet += word;
    }

    return decipherTweet;
};
