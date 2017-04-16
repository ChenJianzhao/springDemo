package org.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * Created by jzchen on 2017/3/5 0005.
 */
public class MyConsumer {


    public static void main(String[] args) {
        /**
         * 策略：自动提交，间隔1000ms
         * "at-most once delivery" guarantees
         * 劣势：在数据读入内存，consumer提交后程序失败，数据未持久化，丢失信息
         */
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "test");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//        consumer.subscribe(Arrays.asList("my-topic"));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
//        }

        /**
         * 策略：手动提交，
         * "at-least once delivery" guarantees
         * 劣势：在数据读入内存并持久化，consumer提交前程序失败，下次将从之前的offset读取数据，造成数据重复
         */
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
//        final int minBatchSize = 200;
//        List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                buffer.add(record);
//            }
//            if (buffer.size() >= minBatchSize) {
////                insertIntoDb(buffer);
//                consumer.commitSync();  //手动提交，标识records
//                buffer.clear();
//            }
//        }

        TopicPartition topicPartition = new TopicPartition("my-topic",0);
        consumer.assign(Arrays.asList(topicPartition));
        consumer.seekToBeginning(Arrays.asList(topicPartition));
        try {
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
                for (TopicPartition partition : records.partitions()) {
                    List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
                    for (ConsumerRecord<String, String> record : partitionRecords) {
                        System.out.println(record.offset() + ": " + record.value());
                    }
                    long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                    consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
                }
            }
        } finally {
            consumer.close();
        }
    }
}
