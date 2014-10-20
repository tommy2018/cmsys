import cmsys.Common.*;

public class MainController {
	static public void main(String[] args) {
		try {
			Settings settings = Settings.getInstance();
		} catch (CmsysException e) {
			System.err.println(e.getMessage());
		}
	}
}
