package algo.design_pattern.iterator.refactoring_guru.spammer;

import algo.design_pattern.iterator.refactoring_guru.iterators.ProfileIterator;
import algo.design_pattern.iterator.refactoring_guru.profile.Profile;
import algo.design_pattern.iterator.refactoring_guru.social_networks.SocialNetwork;

public class SocialSpammer
{
	public SocialNetwork network;
	public ProfileIterator iterator;

	public SocialSpammer(SocialNetwork network)
	{
		this.network = network;
	}

	public void sendSpamToFriends(String profileEmail, String message)
	{
		System.out.println("\nIterating over friends...\n");
		iterator = network.createFriendsIterator(profileEmail);
		while (iterator.hasNext())
		{
			Profile profile = iterator.getNext();
			sendMessage(profile.getEmail(), message);
		}
	}

	public void sendSpamToCoworkers(String profileEmail, String message)
	{
		System.out.println("\nIterating over coworkers...\n");
		iterator = network.createCoworkersIterator(profileEmail);
		while (iterator.hasNext())
		{
			Profile profile = iterator.getNext();
			sendMessage(profile.getEmail(), message);
		}
	}

	public void sendMessage(String email, String message)
	{
		System.out.println("Sent message to: '" + email + "'. Message body: '" + message + "'");
	}
}
