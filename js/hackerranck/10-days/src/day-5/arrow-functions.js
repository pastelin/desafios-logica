export const modifyArray = (nums) => {
    return nums.map((num) => (num = num % 2 === 0 ? num * 2 : num * 3));
};
