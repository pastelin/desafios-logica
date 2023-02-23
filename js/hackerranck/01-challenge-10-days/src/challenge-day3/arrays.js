/**
 *   Return the second largest number in the array.
 *   @param {Number[]} nums - An array of numbers.
 *   @return {Number} The second largest number in the array.
 **/
export function getSecondLargest(nums) {
	let secondLargets;

	while (true) {
		let counter = 0;

		for (let i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				let tempNumber = nums[i];

				nums[i] = nums[i + 1];
				nums[i + 1] = tempNumber;
				counter++;
			}
		}

		if (counter === 0) {
			break;
		}
	}

	for (let i = nums.length - 1; i > 0; i--) {
		if (nums[i] === nums[i - 1]) {
			continue;
		} else {
			secondLargets = nums[i - 1];
			break;
		}
	}

	return secondLargets;
}
