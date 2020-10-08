package workmode.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author:crelle
 * @className:Producer
 * @version:1.0.0
 * @date:2020/8/6
 * @description:XX
 **/
public class Producer {
    private static final String TASK_QUEUE_NAME = "task_queue";
    private static int count = 1;
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.74.4");
        factory.setUsername("crelle");
        factory.setPassword("123456");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            while (true){
                String message = "hello world!:";
                message = message+count;
                channel.basicPublish("", TASK_QUEUE_NAME,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'");
                count++;
            }
        }
    }
}
