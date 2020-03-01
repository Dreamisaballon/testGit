package com.atguigu.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class Student {
	private String name;
	private int age;
}
