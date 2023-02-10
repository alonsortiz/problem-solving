/*
 * By: Alonso Ortiz - 21/June/2022
 * From: https://www.hackerrank.com/challenges/save-the-prisoner
 */

const saveThePrisoner = ((n, m, s) => {
	const round = m % n || 0;
	const chair = (!round && (s-1 === 0)) ? n : (s-1);
	const result = chair + round;

	return (result > n) ? (result % n) : result;
});

