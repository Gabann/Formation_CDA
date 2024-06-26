package algo.design_pattern.bridge.refactoring_guru.remotes;

import algo.design_pattern.bridge.refactoring_guru.devices.Device;

public class AdvancedRemote extends BasicRemote
{

	public AdvancedRemote(Device device)
	{
		super.device = device;
	}

	public void mute()
	{
		System.out.println("Remote: mute");
		device.setVolume(0);
	}
}
