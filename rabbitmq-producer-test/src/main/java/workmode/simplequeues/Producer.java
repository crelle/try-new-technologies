package workmode.simplequeues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:crelle
 * @className:Send
 * @version:1.0.0
 * @date:2020/8/6
 * @description:消息生产者
 **/
public class Producer {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        int count = 0;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.74.4");
        factory.setUsername("crelle");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        while (true){
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
            System.out.println(++count);
            Thread.sleep(1000);
        }
    }
}
