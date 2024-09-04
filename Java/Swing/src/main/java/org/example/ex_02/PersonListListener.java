package org.example.ex_02;

import org.example.ex_02.entity.Person;

import java.util.List;

public interface PersonListListener
{
	void OnPersonListChanged(List<Person> personList);
}
