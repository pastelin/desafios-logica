export const deadAntCount = (ants) => {
    if (ants === null) return 0;

    ants = ants.replace(/ant/g, '');

    let coincidenceA = ants.match(/a/gi);
    let coincidenceN = ants.match(/n/gi);
    let coincidenceT = ants.match(/t/gi);

    return Math.max(
        coincidenceA ? coincidenceA.length : 0,
        coincidenceN ? coincidenceN.length : 0,
        coincidenceT ? coincidenceT.length : 0
    );
};
