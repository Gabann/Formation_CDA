package exercices.design_pattern.state.refactoring_guru.states;


import exercices.design_pattern.state.refactoring_guru.ui.Player;

/**
 * EN: Common interface for all states.
 * <p>
 * RU: Общий интерфейс всех состояний.
 */
public abstract class State
{
	Player player;

	/**
	 * EN: Context passes itself through the state constructor. This may help a
	 * state to fetch some useful context data if needed.
	 * <p>
	 * RU: Контекст передаёт себя в конструктор состояния, чтобы состояние могло
	 * обращаться к его данным и методам в будущем, если потребуется.
	 */
	State(Player player)
	{
		this.player = player;
	}

	public abstract String onLock();

	public abstract String onPlay();

	public abstract String onNext();

	public abstract String onPrevious();
}
