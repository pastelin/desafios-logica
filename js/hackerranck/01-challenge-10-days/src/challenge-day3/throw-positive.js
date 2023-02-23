export const isPositive = (number) => {

    if(!isNaN(number)) {
        
        if(number > 0) {
            return 'YES'
        } else if(number === 0) {
            throw new Error('Zero Error');
        } else {
            throw new Error('Negative Error');
        }
        
    }

}