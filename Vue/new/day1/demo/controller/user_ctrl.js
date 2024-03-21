import db from '../db/index.js'
export async function getAllUser(req,res){
    try{
        const [rows] = await db.query('select id, username, nickname,xxx from ev_users');
        res.send({
            status:0,
            message:'success',
            data:rows
        })
        // console.log(rows);
    }catch(err){
        res.send({
            status:1,
            message:'fail',
            desc:err.message
        })
    }
}