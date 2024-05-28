package algo.design_pattern.iterator.refactoring_guru.social_networks;

import algo.design_pattern.iterator.refactoring_guru.iterators.ProfileIterator;

public interface SocialNetwork
{
	ProfileIterator createFriendsIterator(String profileEmail);

	ProfileIterator createCoworkersIterator(String profileEmail);
}
