/*
 * Get the teams that played in the UEFA Champions League in a given year
 * @param {number} year - The year of the UEFA Champions League
 * @param {number} k - The minimum number of matches played by a team
 * @return {array} - The names of the teams that played in the UEFA Champions League in a given year
 */

const getTeams = async (year, k) => {
    let url = `https://jsonmock.hackerrank.com/api/football_matches?competition=UEFA%20Champions%20League&year=${year}&page=1`;

    const response = await fetch(url);
    const { total_pages } = await response.json();
    const teams = [];

    for (let i = 1; i <= total_pages; i++) {
        let url = `https://jsonmock.hackerrank.com/api/football_matches?competition=UEFA%20Champions%20League&year=${year}&page=${i}`;
        const response = await fetch(url);
        const { data } = await response.json();
		teams.push(...data.filter((team) => team.team1));
		teams.push(...data.filter((team) => team.team2));
    }

    console.log(teams);
};

getTeams(2011, 3);
