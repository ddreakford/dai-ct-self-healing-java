## Digital.ai Continuous Testing - Appium Self-Healing

Digital.ai AI-Powered Self-Healing uses AI techniques to understand and repair element mismatches autonomously without human intervention.

### Prerequisites

1. Only works on SaaS Hosted Environments
2. If you are a SaaS based customer and Self Healing is not enabled, reach out to support@digital.ai to have it enabled

### Limitations

Self-Healing does not work with Native iOS Tests. It works with iOS Web, Android Native & Web.

Support for Native iOS Tests coming soon . . .

### Test Setup

Provide your Cloud URL and Access Key in ```config.properties``` file.

[Obtain your Access Key](https://docs.digital.ai/bundle/TE/page/obtaining_access_key.html)

### Description of Test Logic

For Demonstration purposes, we will be using an Android APK Application, developed by Digital.ai.

The Automated Script in **SelfHealingTest.java** is a simple test, that will perform the following steps:

- Enter "company" into Username Text Field
- Enter "company" into Password Text Field
- Click on the Login Button
- Verify user landed on Dashboard

When the test runs against the **UNMODIFIED** Application, the test will pass successfully, as the Self-Healing detects no changed or locators different than what is provided in the Automated Test.

When the test runs against the **MODIFIED** Application, the Self-Healing will kick in as it will detect that the Username Text Field locator has changed, automatically finding the most appropriate replacement, and continue running the test.

**Unmodified Application**:

![img.png](images/unmodified.png)

**Modified Application**:

![img.png](images/modified.png)

### Running the Tests

From your Terminal window, run the following command:

```agsl
mvn clean test -DxmlFile=tests.xml
```

### Viewing the Test Results

Navigate to your Continuous Testing Reporter page:

```
https://<your_cloud_url>/reporter/reporter/tests
```

Under "Manage Columns", search for the word Heal, and you should see two attributes, "Healed Locators" and "selfHealing":

![img.png](images/manage_columns_reports.png)

Select both and click on Save.

Once saved, the column will now reflect tests that ran with Self-Healing and if any tests Healed:

![img.png](images/updated_columns_reports.png)

You can also open up the individual Test Reports to find the specific details about what was Healed:

![img.png](images/test_data_individual_report.png)

### References

[Docs - Digital.ai Self Healing Documentation](https://docs.digital.ai/bundle/TE/page/appium_self-healing.html)

[YouTube - Digital.ai Self Healing Demo](https://www.youtube.com/watch?v=pfSQm1NHj4s)

APK files can be downloaded here if needed:

- [SeeTestDemoApp](https://applicationsforselfhealing.s3.us-east-2.amazonaws.com/com.experitest.ExperiBank_.LoginActivity_UNMODIFIED.apk) (UNMODIFIED)

- [SeeTestDemoApp](https://applicationsforselfhealing.s3.us-east-2.amazonaws.com/com.experitest.ExperiBank_.LoginActivity_MODIFIED.apk) (MODIFIED)