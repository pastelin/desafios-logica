export const splitAndAdd = (arr, n) => {
	let arrCopy = [...arr];

	for (let i = 0; i < n; i++) {
		let arrSum = [];
		// Split the array in two
		let arrCopy1 = arrCopy.splice(0, arrCopy.length / 2);

		while (arrCopy.length > 0 || arrCopy1.length > 0) {
			let lastValueArr1 = arrCopy.length > 0 ? arrCopy.pop() : 0;
			let lastValueArr2 = arrCopy1.length > 0 ? arrCopy1.pop() : 0;

			arrSum.unshift(lastValueArr1 + lastValueArr2);
		}
		arrCopy = [...arrSum];
	}

	return arrCopy;
};
