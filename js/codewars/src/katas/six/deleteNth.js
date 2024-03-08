// Delete occurrences of an element if it occurs more than n times

export const deleteNth = (arr, n) => {
    let result = [];

    for (let i = 0; i < arr.length; i++) {
        let coincidencias = result.filter((element) => element === arr[i]).length;
        if (coincidencias < n) {
            result.push(arr[i]);
        }
    }

	console.log(result);
    return result;
};