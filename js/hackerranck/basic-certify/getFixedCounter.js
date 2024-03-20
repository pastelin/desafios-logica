const getFixedCounter = (k) => {
    let counter = 0;
    return {
        increment: () => (counter += k),
        decrement: () => (counter -= k),
        getValue: () => counter,
    };
};
