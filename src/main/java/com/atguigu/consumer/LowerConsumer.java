package com.atguigu.consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据指定的Topic、Offset、Partition来获取数据
 * @author Lenovo
 *
 */
public class LowerConsumer {
	public static void main(String[] args) {
		//定义相关参数
		ArrayList<String> brokers = new ArrayList<String>();
		brokers.add("zk1");
		brokers.add("zk2");
		brokers.add("zk3");
		//端口号
		int port = 9092;
		//主题
		String topic = "third";
		//分区
		int partition = 0;
		//offset
		long offset = 2;
		
	}
	//找分区leader
	private String findLeader(List<String> brokers, int port, String topic, int partition)	{
		for(String broker : brokers)	{
			//创建获取分区leader的消费者对象
		}
		return null;
	}
	//获取数据
	
}
