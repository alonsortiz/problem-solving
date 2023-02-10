/*
 * By: Alonso Ortiz - 02/08/2023
 * From: https://leetcode.com/problems/roman-to-integer/
 */

const romanToInt = (string => {

	const romanMap = new Map([['I', 1], ['V', 5], ['X', 10], ['L', 50], ['C', 100], ['D', 500], ['M', 1000]]);

	const arabs = string
	.split('')
	.map(el => romanMap.get(el));
	
	const num = arabs.reduce((acc, el, i) => {
		el = (arabs[i+1] && (el < arabs[i+1])) ? -el : el;
		return acc + el;
	}, 0);

	return num;
});