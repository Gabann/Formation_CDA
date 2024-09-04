package org.example.ex_02;

import org.example.ex_02.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListChangeManager
{
	private static final List<PersonListListener> listeners = new ArrayList<>();

	private PersonListChangeManager()
	{
	}

	public static void addListener(PersonListListener listener)
	{
		listeners.add(listener);
	}

	public static void removeListener(PersonListListener listener)
	{
		listeners.remove(listener);
	}

	public static void raiseEvent(List<Person> person)
	{
		for (PersonListListener listener : listeners)
		{
			listener.OnPersonListChanged(person);
		}
	}
}
