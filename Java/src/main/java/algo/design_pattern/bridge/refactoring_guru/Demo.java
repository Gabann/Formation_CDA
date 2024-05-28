package algo.design_pattern.bridge.refactoring_guru;

import algo.design_pattern.bridge.refactoring_guru.devices.Device;
import algo.design_pattern.bridge.refactoring_guru.devices.Radio;
import algo.design_pattern.bridge.refactoring_guru.devices.Tv;
import algo.design_pattern.bridge.refactoring_guru.remotes.AdvancedRemote;
import algo.design_pattern.bridge.refactoring_guru.remotes.BasicRemote;

public class Demo
{
	public static void main(String[] args)
	{
		testDevice(new Tv());
		testDevice(new Radio());
	}

	public static void testDevice(Device device)
	{
		System.out.println("Tests with basic remote.");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();

		System.out.println("Tests with advanced remote.");
		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		advancedRemote.power();
		advancedRemote.mute();
		device.printStatus();
	}
}
