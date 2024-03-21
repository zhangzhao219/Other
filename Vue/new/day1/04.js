import thenFs from 'then-fs'
const promiseArr = [
    thenFs.readFile('./files/1.txt', 'utf-8'),
    thenFs.readFile('./files/2.txt', 'utf-8'),
    thenFs.readFile('./files/3.txt', 'utf-8')
]

Promise.race(promiseArr)
.then((r1) => {
    console.log(r1);
})