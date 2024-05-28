package algo.design_pattern.proxy.refactoring_guru;

import java.util.HashMap;

public interface ThirdPartyYoutubeLib
{
	HashMap<String, Video> popularVideos();

	Video getVideo(String videoId);
}
