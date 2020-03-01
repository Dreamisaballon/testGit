package com.atguigu.consumer;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;



public class CustomConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		//kafka��Ⱥ
		props.put("bootstrap.servers", "zk1:9092");
		//������id
		props.put("group.id", "test");
		//�����Զ��ύoffset
		props.put("enable.auto.commit", "true");
		//��ʱ�ύ
		props.put("auto.commit.interval.ms", "1000");
		//KV�ķ����л�
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("second", "first", "third"));
		System.out.println("update from ShangHai");
		while(true)	{
			ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
			Set<TopicPartition> partitions = consumerRecords.partitions();
			for(TopicPartition partition : partitions)	{
				List<ConsumerRecord<String, String>> consumerRecord = consumerRecords.records(partition);
				for(ConsumerRecord record : consumerRecord )	{
					System.out.println(record.topic() + "--" + record.partition() + "--" + record.value());
				}
			}
		}
	}
}
