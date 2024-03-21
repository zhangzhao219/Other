import json
 
import pika
 
 
"""
多个消费者的情况下，采用的是轮训机制依次转发给每一个消费者
"""
# 验证
credentials = pika.PlainCredentials('dyrabbitmq', 'zmJ4Fy3Rsho')
# 创建连接 virtual_host rabbitMQ 使用的虚拟主机(可以有多个，对不同用户进行权限分离)
conn = pika.BlockingConnection(pika.ConnectionParameters(host='121.37.98.68', port=5672, virtual_host='simpledy', credentials=credentials))
# 建立一个channel
chan = conn.channel()
# 创建一个队列(生成者没有指定 exchange), 如果确定已经创建了, 可以不在创建
# chan.queue_declare(queue='active')
# 生产者指定exchange, 要绑定队列和exchange, 不绑定，exchange不知道把消息转发给那个队列
chan.queue_bind(queue='active', exchange='amq.direct')
 
 
def callback(chan, method, properties, body):
    """
    消息处理函数 4个参数是固定的
    :param chan: channel对象
    :param method: 交付信息
        包含了:
            consumer_tag: 消费者的标识
            delivery_tag: 消息的索引从1开始
            exchange: 指定的exchange
            redelivered: 是不是重复接收的消息
            routing_key: 队列名称
    :param properties: 消息属性
    :param body: 消息
    :return:
    """
    print('收到', json.loads(body))
    # 手动确认
    chan.basic_ack(delivery_tag=method.delivery_tag)
 
 
# auto_ack 默认是False 不给生产者发确认消息(重启consume时会按顺序读取), 如果设置自动确认, 宕机消息就丢了. 可以手动确认
chan.basic_consume(queue='active', on_message_callback=callback)
 
# 开始监听
chan.start_consuming()