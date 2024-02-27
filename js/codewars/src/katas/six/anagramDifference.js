export const anagramDifference = (w1, w2) => {
    let w1Copy = w1;
    let w2Copy = w2;

    for (let i = 0; i < w1.length; i++) {
        w2Copy = w2Copy.replace(w1[i], '');
    }

    for (let i = 0; i < w2.length; i++) {
        w1Copy = w1Copy.replace(w2[i], '');
    }

    return w2Copy.length + w1Copy.length;
};
