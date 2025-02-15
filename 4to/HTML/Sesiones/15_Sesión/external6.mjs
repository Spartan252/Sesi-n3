import chalk from "chalk";

const log = console.log;

// Combine styled and normal strings
log(chalk.blue('Hello') + ' World' + chalk.red('!'));

// Compose multiple styles using the chainable API
log(chalk.blue.bgRed.bold('Hello world!'));

// Pass in multiple arguments
log(chalk.blue('Hello', 'World!', 'Foo', 'bar', 'biz', 'baz'));

// Nest styles
log(chalk.red('Hello', chalk.underline.bgBlue('world') + '!'));

// Nest styles of the same type even (color, underline, background)
log(chalk.green(
	'I am a green line ' +
	chalk.blue.underline.bold('with a blue substring') +
	' that becomes green again!'
));

// ES2015 template literal
log(`
CPU: ${chalk.red('90%')}
RAM: ${chalk.green('40%')}
DISK: ${chalk.yellow('70%')}
`);

// Use RGB colors in terminal emulators that support it.
log(chalk.rgb(123, 45, 67).underline('Underlined reddish color'));
log(chalk.hex('#DEADED').bold('Bold gray!'));


import asciiCats from  "ascii-cats";
for  (let i=0 ; i<1000; i++) {
    log(chalk.blue(asciiCats('nyan')));
    console.clear();
    log(chalk.red(asciiCats('nyan_up')));
    console.clear();
    log(chalk.green(asciiCats('nyan')));
    console.clear();
    log(chalk.yellow(asciiCats('nyan')));
    console.clear();
};



import * as fs from 'node:fs';
let fileReadedCB = function (error, data){
    if (error) {
        console.log("error")
    }
    console.log("MIRA INFO")
    console.table(JSON.parse(data));
}
fs.readFile('./db1.json', 'utf8', fileReadedCB);