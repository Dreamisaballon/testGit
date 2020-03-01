package com.atguigu.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.alibaba.fastjson.JSON;
import com.atguigu.pojo.Student;



public class ConsumerProducer {
	public static void main(String[] args) {
		Properties properties = new Properties();
		//kafka��Ⱥ
		properties.put("bootstrap.servers", "zk1:9092");
		//Ӧ�𼶱�
		properties.put("acks", "all");
		//���Դ���
		properties.put("retries", 0);
		//������С
		properties.put("batch.size", 16384);
		//�ύ��ʱ
		properties.put("linger.ms", 1);
		//����
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.atguigu.producer.CustomerPartition");
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		Student s1 = new Student();
		s1.setName("Ҷ����");
		s1.setAge(21);
		String message = JSON.toJSONString(s1);
		for(int i = 0; i < 10; i++)	{
			producer.send(new ProducerRecord<String, String>("second", message + "����" + i), new Callback() {
				
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if(exception == null) {
						System.out.println(metadata.partition() + "��������" + metadata.offset());
					}	else	{
						System.out.println("����ʧ�ܣ�");
					}
					
				}
			});
		}
		producer.close();
	}
}
