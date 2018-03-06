package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {
	public static final String QUEUE = "GREETING";

	public static void main(String... strings) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE, false, false, false, null);
		String message = "Hello India !!!! " ;
		channel.basicPublish("",QUEUE,null, message.getBytes());
		System.out.println(" Sent "+ message);
		channel.close();
		connection.close();
	}
}
