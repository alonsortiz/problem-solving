/*
 * By: Alonso Ortiz - 07/05/2022
 * From: https://www.hackerrank.com/challenges/sparse-arrays
 * 
 * There is a collection of input strings and a collection of query strings. 
 * For each query string, determine how many times it occurs in the list of input strings. 
 * Return an array of the results.
 */

const matchingStrings = ((strings, queries) => {
	const queriesMap = new Map();
	const result = [];

	queries.forEach(el => queriesMap.set(el, 0));

	strings.forEach(el => {
		if(queriesMap.has(el)) {
			queriesMap.set(el, queriesMap.get(el) + 1);
		}
	});

	queries.forEach(el => {
		if(queriesMap.has(el)) {
			result.push(queriesMap.get(el));
		}
	})

	return result;
});
