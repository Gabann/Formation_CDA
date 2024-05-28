package algo.design_pattern.command.refactoring_guru.commands;


import algo.design_pattern.command.refactoring_guru.editor.Editor;

public class PasteCommand extends Command
{

	public PasteCommand(Editor editor)
	{
		super(editor);
	}

	@Override
	public boolean execute()
	{
		if (editor.clipboard == null || editor.clipboard.isEmpty())
		{
			return false;
		}

		backup();
		editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
		return true;
	}
}
