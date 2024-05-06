package exercices.design_pattern.state.refactoring_guru.states;


import exercices.design_pattern.state.refactoring_guru.ui.Player;

/**
 * EN: They can also trigger state transitions in the context.
 * <p>
 * RU: Они также могут переводить контекст в другие состояния.
 */
public class ReadyState extends State
{

	public ReadyState(Player player)
	{
		super(player);
	}

	@Override
	public String onLock()
	{
		player.changeState(new LockedState(player));
		return "Locked...";
	}

	@Override
	public String onPlay()
	{
		String action = player.startPlayback();
		player.changeState(new PlayingState(player));
		return action;
	}

	@Override
	public String onNext()
	{
		return "Locked...";
	}

	@Override
	public String onPrevious()
	{
		return "Locked...";
	}
}
