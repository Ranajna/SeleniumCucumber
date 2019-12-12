package bdd;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import browser.BrowseDriver;
import cucumber.api.Scenario;

public class ScenarionContext {
	
	private String scenarioName;
	private String featureFileName;
//	private long startTimer;
//	private long endTimer;

	public void beforeScenario(Scenario scenario) {
		this.setScenarioName(scenario);
		this.setFeatureFileName(scenario.getId());
		
//		startTimer = System.currentTimeMillis();
//		logger.info("********************************************************************************");
//		logger.info("STARTED Scenario:'" + this.getScenarioName() + "'");
//		logger.info("********************************************************************************");
	}

	public void afterScenario(Scenario scenario) {
		try {
			this.takeScreenShot(scenario);
		} catch (Throwable e) {
			e.printStackTrace();
		}
//		endTimer = System.currentTimeMillis();
//		long totalTime = (endTimer - startTimer) / 1000;
//		logger.info("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
//		logger.info("FINISHED Scenario[" + scenario.getStatus() + "|" + totalTime + "(secs)]:'" + this.getScenarioName()
//				+ "'");
//		logger.info("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
	}

	
	public void beforeStep() {
	}

	private void setScenarioName(Scenario scenario) {
		this.scenarioName = scenario.getName();
	}

	public String getScenarioName() {
		return this.scenarioName;
	}

//	public Scenario getScenarioNameAs() {
//		return this.scenarioName;
//	}

	private void setFeatureFileName(String featureFilePath) {
		String name = featureFilePath.substring(featureFilePath.lastIndexOf("/") + 1,
				featureFilePath.indexOf(".feature"));
		if (!name.equals(featureFileName)) {
			this.featureFileName = name;
//			logger.info("################################################################################");
//			logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			logger.info("STARTED Feature File:'" + this.featureFileName + "'");
//			logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			// setfeatureFileData();
//			logger.info("################################################################################");

		}
	}

	public String getFeatureFileName() {
		return this.featureFileName;
	}

	/*
	 * public List<Map<String,String>> getfeatureFileData() { return
	 * this.featureFileTestData; }
	 * 
	 * private void setfeatureFileData() { featureFileTestData = null; File
	 * featureData = new
	 * File("./src/test/resources/testData/"+featureFileName+".csv");
	 * if(featureData.exists()) {
	 * logger.info("TestData(csv):'"+featureData.getAbsolutePath()+"'"); try {
	 * featureFileTestData = dataContext.readCSVData(featureData.toURI()); } catch
	 * (Exception e) { e.printStackTrace(); } } }
	 */

	public void takeScreenShot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) BrowseDriver.getBrowserDriver()).getScreenshotAs(OutputType.BYTES),
					"image/png");
		}
	}

}
