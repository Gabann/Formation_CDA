package algo.design_pattern.abstract_factory.car_race;

import java.util.ArrayList;
import java.util.List;

public final class RacePositionChangedEvent
{
	private static final List<RacePositionListener> racePositionListeners = new ArrayList<>();

	private RacePositionChangedEvent()
	{
	}

	public static void raiseEvent(Car car, int position)
	{
		for (RacePositionListener listener : racePositionListeners)
		{
			listener.onCarPositionChange(car, position);
		}
	}

	public static void addListener(RacePositionListener listener)
	{
		racePositionListeners.add(listener);
	}

	public static void removeListener(RacePositionListener listener)
	{
		racePositionListeners.remove(listener);
	}
}
