package workmode.publishsubscribe.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author:crelle
 * @className:EmitLog
 * @version:1.0.0
 * @date:2020/8/8
 * @description:发布订阅模式生产者
 **/
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";
    private static int count = 1;
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.74.4");
        factory.setUsername("crelle");
        factory.setPassword("123456");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
             channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            while (true){
                String message = "publishAndSubscribeMode>hello world!:";
                message = message+count;
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'");
                count++;
                Thread.sleep(10);
            }

        }
    }
}
