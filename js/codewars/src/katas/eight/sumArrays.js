const sum = (numbers) => {
   return numbers.length ? numbers.reduce( (a, b) => a + b) : 0.0;
}

console.log(sum([]));