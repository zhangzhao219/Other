import mysql from 'mysql2';
const pool = mysql.createPool({
    host:'localhost',
    port:3306,
    database:'my_db_01',
    user:'root',
    password:'L2fR4l_wzy',
});
export default pool.promise();