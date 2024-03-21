import json
 
import pika
 
# 验证 用户名和密码
credentials = pika.PlainCredentials('dyrabbitmq', 'zmJ4Fy3Rsho')
# 创建连接 virtual_host: rabbitMQ 使用的虚拟主机(一个broker可以有多个，对不同用户进行权限分离)
conn = pika.BlockingConnection(pika.ConnectionParameters(host='121.37.98.68', port=5672, virtual_host='simpledy', credentials=credentials))
# 建立一个channel
chan = conn.channel()
# 创建一个队列
chan.queue_declare(queue='active')
 
 
def encode_msg(msg):
    """格式化消息"""
    return json.dumps(msg)
 
 
while True:
    # 便于测试
    msg = input('msg: ')
 
    if msg == 'quit':
        break
    # 发送消息 exchange: 把消息发布到指定交换机, 通过这个交换机转发给消费者; 可以不指定
    # exchange 可以在后台创建
    chan.basic_publish(exchange='amq.direct', routing_key='active', body=encode_msg(msg))
 
conn.close()