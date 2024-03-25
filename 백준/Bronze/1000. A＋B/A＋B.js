const readline = require('readline')
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
})

let input = []

rl.on("line", (line) => {
    input = line.split(" ").map((v) => parseInt(v))
    rl.close()
})

rl.on("close", () => {
    console.log(sum(input[0], input[1]))
    process.exit()
})

function sum(a, b){
    return a + b
}