package com.bryan.springbootkafka.kafka;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * @author Bryan Zhu
 * @date 2021/1/13 2:23
 */
public class KafkaDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("bootstrap.servers", "129.204.38.228:9001");

        KafkaProducer producer = new KafkaProducer(props);
        for (long i = 0; i < 10; i++) {
            Order data = new Order();
            data.setAmount(new BigDecimal(1));
            data.setId(i);
            data.setType(1);

            ProducerRecord record = new ProducerRecord("test31", JSON.toJSONString(data));

            producer.send(record);
        }
    }

}

@Data
class Order {
    private BigDecimal amount;

    private long id;

    private int type;
}
