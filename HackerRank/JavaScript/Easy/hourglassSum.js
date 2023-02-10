/*
 * By: Alonso Ortiz - 27/June/2022
 * From: https://www.hackerrank.com/challenges/2d-array
 *
 * Given a 6x6 2D Array, an hourglass in the array is a subset of values with indices falling in an hourglass pattern. 
 * There are 16 hourglasses in the array. An hourglass sum is the sum of an hourglass' values. 
 * Calculate the hourglass sum for every hourglass in the array, then print the maximum hourglass sum.
 */

const hourglassSum = (arr => {
	const limit = arr.length - 2;
	const hourglassValues = [];

	for(let i = 0; i < limit; i++) {
	    for(let j = 0; j < limit; j++) {
	    	hourglassValues.push(calculateHourglass(i, j));
	    }
	}

	hourglassValues.sort((a,b) => b - a);

	return hourglassValues[0];

});

const calculateHourglass = ((x, y) => {
	const hourglassCoords = [arr[x][y], arr[x][y+1], arr[x][y+2], arr[x+1][y+1], arr[x+2][y], arr[x+2][y+1], arr[x+2][y+2]];
	
	return hourglassCoords.reduce((acc, el) => acc+el, 0);
});