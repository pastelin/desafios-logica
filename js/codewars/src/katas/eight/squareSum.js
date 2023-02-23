const squareSum = (numbers) => {

    return numbers.length ? numbers.map(number => number * number).reduce( (a,b) => a + b ) : 0;

}

export default squareSum;