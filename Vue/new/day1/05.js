import thenFs from 'then-fs'
function getFile(fpath){
    return new Promise(function(resolve,reject){
        thenFs.readFile(fpath,'utf-8',(err,dataStr) => {
            if(err){
                return reject(err);
            }
            resolve(dataStr);
        })
    })
}
getFile('./files/1.txt').then(
    (result) => {
        console.log(result);
    },
    (err) => {
        console.log(err.message);
    }
);