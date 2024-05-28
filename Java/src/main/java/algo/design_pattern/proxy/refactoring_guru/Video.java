package algo.design_pattern.proxy.refactoring_guru;

public class Video
{
	public String id;
	public String title;
	public String data;

	Video(String id, String title)
	{
		this.id = id;
		this.title = title;
		this.data = "Random video.";
	}
}
