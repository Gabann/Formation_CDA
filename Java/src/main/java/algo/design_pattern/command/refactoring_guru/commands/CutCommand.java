package algo.design_pattern.command.refactoring_guru.commands;


import algo.design_pattern.command.refactoring_guru.editor.Editor;

public class CutCommand extends Command
{

	public CutCommand(Editor editor)
	{
		super(editor);
	}

	@Override
	public boolean execute()
	{
		if (editor.textField.getSelectedText().isEmpty())
		{
			return false;
		}

		backup();
		String source = editor.textField.getText();
		editor.clipboard = editor.textField.getSelectedText();
		editor.textField.setText(cutString(source));
		return true;
	}

	private String cutString(String source)
	{
		String start = source.substring(0, editor.textField.getSelectionStart());
		String end = source.substring(editor.textField.getSelectionEnd());
		return start + end;
	}
}
