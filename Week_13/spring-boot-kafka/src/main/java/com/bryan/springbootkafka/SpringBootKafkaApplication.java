package com.bryan.springbootkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class SpringBootKafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws InterruptedException {
        this.template.send("springboot-kafka-demo", "foo1");
        this.template.send("springboot-kafka-demo", "foo2");
        this.template.send("springboot-kafka-demo", "foo3");

        latch.await(60, TimeUnit.SECONDS);
        log.info("All received");
    }

    @KafkaListener(topics = "springboot-kafka-demo")
    public void listen(ConsumerRecord<?, ?> cr) {
        log.info(cr.toString());
        latch.countDown();
    }
}
