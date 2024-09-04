package org.example.ex_02.entity;


import lombok.Getter;
import lombok.ToString;
import org.example.ex_02.PersonListChangeManager;
import org.example.ex_02.PersonListListener;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Person
{
	private static final List<Person> personList = new ArrayList<>();
	static List<PersonListListener> personListListeners = new ArrayList<>();
	String name;
	String email;
	Gender gender;

	public Person(String name, String email, Gender gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public static void addPerson(Person newPerson)
	{
		personList.add(newPerson);
		PersonListChangeManager.raiseEvent(personList);
	}

	public static void removePerson(Person person)
	{
		personList.removeIf(p -> p.getEmail().equals(person.getEmail()) &&
				p.getName().equals(person.getName()) &&
				p.getGender().equals(person.getGender()));
		PersonListChangeManager.raiseEvent(personList);
	}

	public enum Gender
	{
		MALE,
		FEMALE,
		OTHER
	}
}
