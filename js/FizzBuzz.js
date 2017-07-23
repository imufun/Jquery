var output = '';
for (var i = 1; i <= 100; i++) {
    if (i % 3 && i % 5) {
        output += i + '';
    }


    if (i % 3 == 0) {
        output += 'fizz';
    }

    if (i % 5 == 0) {
        output += 'Buzz';
    }
}

console.log(output);