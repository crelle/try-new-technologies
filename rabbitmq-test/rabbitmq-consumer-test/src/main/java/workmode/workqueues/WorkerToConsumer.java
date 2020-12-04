package workmode.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author:crelle
 * @className:WorkerToConsumer
 * @version:1.0.0
 * @date:2020/8/7
 * @description:使用worker来消费,负载均衡，消息不丢失
 **/
public class WorkerToConsumer {
    private static final String TASK_QUEUE_NAME = "task_queue";
    private static int count = 1;
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.74.4");
        factory.setUsername("crelle");
        factory.setPassword("123456");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        /*queueDeclare参数解释：
         *queue - the name of the queue
         *durable - true if we are declaring a durable queue (the queue will survive a server restart)
         *exclusive - true if we are declaring an exclusive queue (restricted to this connection)
         *autoDelete - true if we are declaring an autodelete queue (server will delete it when no longer in use)
         *arguments - other properties (construction arguments) for the queue
         */
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //accept only one unack-ed message at a time(同一时间只能处理一条未确认的消息)
        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println(" [x] Received '" + message + "'");
            try {
//              doWork(message);
//                Thread.sleep(100);
                System.out.println(count++);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            } finally {
                System.out.println(" [x] Done");
                //Parameters:
                //deliveryTag - the tag from the received AMQP.Basic.GetOk or AMQP.Basic.Deliver
                //multiple - true to acknowledge all messages up to and including the supplied delivery tag;
                //           false to acknowledge just the supplied delivery tag.
//                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                channel.basicNack(delivery.getEnvelope().getDeliveryTag(),false,false);
            }
        };
        //Parameters:
        //queue - the name of the queue
        //autoAck - true if the server should consider messages acknowledged once delivered; false if the server should expect explicit acknowledgements
        //callback - an interface to the consumer object
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
