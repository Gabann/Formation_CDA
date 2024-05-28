package algo.design_pattern.bridge.refactoring_guru.devices;

public interface Device
{
	boolean isEnabled();

	void enable();

	void disable();

	int getVolume();

	void setVolume(int percent);

	int getChannel();

	void setChannel(int channel);

	void printStatus();
}
