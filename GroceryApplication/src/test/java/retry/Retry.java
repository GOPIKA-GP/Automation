package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Retry implements IRetryAnalyzer {
	private static final Logger LOG = LogManager.getLogger("Retry.class");
	private static final int maxTry = 2;
	private int count = 0; // tracks no.of retry attempts

	@Override
	public boolean retry(final ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {
			if (this.count < maxTry) {
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true; // Indicates retry attempt
			}
		}
		return false; // no more retry;test success
	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

}
