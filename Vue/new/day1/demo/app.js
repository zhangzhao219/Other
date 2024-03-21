import express from 'express'
import userRouter from './router/router.js'
const app = express();
app.use('/api',userRouter);
app.listen(8080,() => {
    console.log('server running at localhost:8080');
})