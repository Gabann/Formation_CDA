package algo.design_pattern.command.refactoring_guru.commands;


import algo.design_pattern.command.refactoring_guru.editor.Editor;

public class CopyCommand extends Command
{

	public CopyCommand(Editor editor)
	{
		super(editor);
	}

	@Override
	public boolean execute()
	{
		editor.clipboard = editor.textField.getSelectedText();
		return false;
	}
}
