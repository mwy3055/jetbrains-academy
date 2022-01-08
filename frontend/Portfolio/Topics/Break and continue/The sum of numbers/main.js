function sum(numbers) {
    // write your code here
    let sum = 0;
    for (const number of numbers) {
        if (number === 0) {
            break;
        }
        sum += number;
    }
    return sum;
}