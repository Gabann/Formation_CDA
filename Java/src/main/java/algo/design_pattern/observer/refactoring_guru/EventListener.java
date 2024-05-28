package algo.design_pattern.observer.refactoring_guru;

import java.io.File;

public interface EventListener
{
	void update(String eventType, File file);
}
