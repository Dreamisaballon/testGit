package com.atguigu.consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ָ����Topic��Offset��Partition����ȡ����
 * @author Lenovo
 *
 */
public class LowerConsumer {
	public static void main(String[] args) {
		//������ز���
		ArrayList<String> brokers = new ArrayList<String>();
		brokers.add("zk1");
		brokers.add("zk2");
		brokers.add("zk3");
		//�˿ں�
		int port = 9092;
		//����
		String topic = "third";
		//����
		int partition = 0;
		//offset
		long offset = 2;
		
	}
	//�ҷ���leader
	private String findLeader(List<String> brokers, int port, String topic, int partition)	{
		for(String broker : brokers)	{
			//������ȡ����leader�������߶���
		}
		return null;
	}
	//��ȡ����
	
}
