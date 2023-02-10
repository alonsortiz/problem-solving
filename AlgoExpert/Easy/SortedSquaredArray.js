/*
 * Name: Sorted Squared Array
 * By: Alonso Ortiz - 05/Apr/2021
 * From: AlgoExpert
 */

const sortedArray = arr => {
	const squaredArr = sortedSquaredArrayRecursive(arr);

	return squaredArr.sort((a,b) => a - b);
};

// Iterative

const sortedSquaredArrayFor = arr => {
	for(let i = 0; i < arr.length; i++) {
		arr[i] *= arr[i];
	}

	return arr;
};

// Higher Order Functions

const sortedSquaredArrayEach = arr => {
	arr.forEach((el, index) => arr[index] = el * el);

	return arr;
};

const sortedSquaredArrayMap = arr => {
	return arr.map(el => el * el);
};

// Recursive

const sortedSquaredArrayRecursive = arr => {
	if(arr.length === 0) return arr;

	return [arr[0] * arr[0], ...sortedSquaredArrayRecursive(arr.slice(1))];
};
