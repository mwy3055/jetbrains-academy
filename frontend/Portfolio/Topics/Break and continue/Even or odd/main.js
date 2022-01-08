function checkEvenOrOdd(numbers) {
    // write your code here
    for (const number of numbers) {
        if (number === 0) {
            break;
        } else if (number % 2 === 0) {
            console.log("even");
        } else {
            console.log("odd");
        }
    }
}