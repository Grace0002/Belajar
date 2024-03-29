package id.co;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) {

            if (retryCount < maxRetryCount) {
                System.out.println(
                        "Retrying Test : Re-running " + result.getName() + " for " + (retryCount + 1) + " time(s).");

                retryCount++; // Increase the maxRetryCount by 1

                result.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);

        }

        return false;
    }
}
