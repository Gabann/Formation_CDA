package exercices.design_pattern.iterator.refactoring_guru.iterators;


import exercices.design_pattern.iterator.refactoring_guru.profile.Profile;

public interface ProfileIterator
{
	boolean hasNext();

	Profile getNext();

	void reset();
}
