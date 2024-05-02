export const getSecondLargest = (nums) => {
    let sortNums = [...nums].sort((a, b) => a - b);
    let secondLargestNumber = 0;

    for (let i = sortNums.length - 1; i >= 0; i--) {
        if (sortNums[i - 1] < sortNums[i]) {
            secondLargestNumber = sortNums[i - 1];
            break;
        }
    }

    return secondLargestNumber;
};
