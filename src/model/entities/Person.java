package model.entities;

import java.util.Arrays;
import java.util.List;

public class Person {

	private Integer id;
	private String name;
	private Integer age;

	public Person(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Name: " + name + ", Age: " + age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static List<Person> database(){
		return Arrays.asList(new Person(1, "Rafael", 23),
				new Person(2, "Humberto", 35),
				new Person(3, "Joao", 20));
	}
}
