package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";	                                              
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";

	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV__URL = "https://admin-demo.nopcommerce.com";

	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIP = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHORT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;


	// database account / User/ Pass/ Port
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_UER = "automationfc";
	public static final String DB_DEV_PASS = "P@ssw0rl1@!";

	public static final String DB_TEST_URL = "32.18.195.23:9860";
	public static final String DB_TEST_UER = "automationfc";
	public static final String DB_TEST_PASS = "P@ssw0rl1@!";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;

}
