/*
 * Name: Validate Subsequence
 * By: Alonso Ortiz - 29/Mar/2021
 * From: AlgoExpert
 */

const isValidSubsequence = (arr, seq) => {
    for(let el of arr) {
    	if(el === seq[0]) {
    		seq.shift();
    	}
    }

    return seq.length === 0 ? true : false; 
};
