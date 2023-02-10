/*
 * By: Alonso Ortiz - 22/June/2022
 * From: https://www.hackerrank.com/challenges/array-left-rotation
 * 
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. 
 * Given an integer, d, rotate the array that many steps left and return the result.
 */

const rotateLeft = ((d, arr) => {
	const rotatedArr = [];

	for(let i = d; i < arr.length; i++) {
		rotatedArr.push(arr[i]);
	}

	for(let i = 0; i < d; i++) {
		rotatedArr.push(arr[i]);
	}

	return rotatedArr;
});