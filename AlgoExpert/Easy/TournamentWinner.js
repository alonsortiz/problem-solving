/*
 * Name: Tournament Winner
 * By: Alonso Ortiz - 19/Apr/2021
 * From: AlgoExpert
 */

// Rules
const HOME = 1;
const WIN = 3;

const tournamentWinner = (competitions, results) => {
	const score = new Map();
	let maxWinner;
	let maxScore = WIN;

	for(let i = 0; i < competitions.length; i++) {
		let matchWinner = results[i] === HOME ? competitions[i][0] : competitions[i][1];

		if(!maxWinner) {
			maxWinner = matchWinner;
		}

		if(score.has(matchWinner)) {
			score.set(matchWinner, score.get(matchWinner) + WIN);

			[maxWinner, maxScore] = updateWinner(score, matchWinner, maxWinner, maxScore);
		} else {
			score.set(matchWinner, WIN);
		}
	}

	return maxWinner;
};

const updateWinner = (score, matchWinner, maxWinner, maxScore) => {	
	if(matchWinner === maxWinner) {
		maxScore += WIN;
	}

	if(score.get(matchWinner) > maxScore) {
		maxWinner = matchWinner;
		maxScore = score.get(matchWinner);
	} 

	return [maxWinner, maxScore];
};