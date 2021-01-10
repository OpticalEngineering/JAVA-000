package com.bryan.springbootactivemq.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Bryan Zhu
 * @date 2021/1/11 0:13
 */
public class ActiveMqDemo {

    public static final String MQ_NAME = "admin";

    public static final String MQ_PASSWORD = "admin";

    public static final String MQ_BROKERURL = "tcp://129.204.38.228:61616";

    public static void main(String[] args) throws InterruptedException {
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        Thread.sleep(1000);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        Thread.sleep(1000);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldProducer(), false);
        Thread.sleep(1000);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldConsumer(), false);
        thread(new HelloWorldProducer(), false);
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

    public static class HelloWorldProducer implements Runnable {

        @Override
        public void run() {
            try {
                //1. Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_NAME, MQ_PASSWORD, MQ_BROKERURL);

                //2. Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                //3. Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                //4. Create the destination(Topic or Queue)
                Destination destination = session.createQueue("TEST.FOO");

                //5. Create a MessageProducer from the Session to the Topic or Queue
                MessageProducer producer = session.createProducer(destination);

                //6. Create a Messages
                String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
                TextMessage message = session.createTextMessage(text);

                //7. Tell the producer to send the message
                System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
                producer.send(message);

                //8. Clean up
                session.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class HelloWorldConsumer implements Runnable, ExceptionListener {

        @Override
        public void run() {
            try {
                //1. Create a ConnectionFactory
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_NAME, MQ_PASSWORD, MQ_BROKERURL);

                //2. Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();
                connection.setExceptionListener(this);

                //3. Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                //4. Create the destination (Topic or Queue)
                Destination destination = session.createQueue("TEST.FOO");

                //5. Create a MessageConsumer from the Session to the Topci or Queue
                MessageConsumer consumer = session.createConsumer(destination);

                //6. Wait for a Message
                Message message = consumer.receive(1000);
                Thread.sleep(5000);
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
                } else {
                    System.out.println("Received: " + message);
                }

                consumer.close();
                session.close();
                connection.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public synchronized void onException(JMSException e) {
            System.out.println("JMS Exception occured. Shuting down client. ");
        }
    }
}
