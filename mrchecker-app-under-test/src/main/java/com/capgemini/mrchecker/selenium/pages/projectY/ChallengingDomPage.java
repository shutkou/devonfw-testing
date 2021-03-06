package com.capgemini.mrchecker.selenium.pages.projectY;

import java.util.List;

import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.selenium.core.newDrivers.elementType.Button;
import com.capgemini.mrchecker.selenium.jsoupHelper.JsoupHelper;
import com.capgemini.mrchecker.selenium.pages.environment.GetEnvironmentParam;
import com.capgemini.mrchecker.selenium.pages.environment.PageSubURLsProjectYEnum;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class ChallengingDomPage extends BasePage {
	
	private final By	selectorTableRows	= By.cssSelector(".large-10 > table > tbody > tr");
	private final By	selectorFirstButton	= By.cssSelector(".large-2.columns > .button:nth-child(1)");
	
	@Override
	public boolean isLoaded() {
		getDriver().waitForPageLoaded();
		return getDriver().getCurrentUrl()
						.contains(PageSubURLsProjectYEnum.CHALLENGING_DOM.getValue());
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("Load 'Challenging DOM' page.");
		getDriver().get(GetEnvironmentParam.THE_INTERNET_MAIN_PAGE.getValue() + PageSubURLsProjectYEnum.CHALLENGING_DOM.getValue());
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		return getActualPageTitle();
	}
	
	public List<String> getTableValues() {
		return JsoupHelper.findTexts(selectorTableRows);
	}
	
	public void clickFirstButton() {
		Button firstButton = getDriver().elementButton(selectorFirstButton);
		firstButton.click();
		getDriver().waitForPageLoaded();
	}
}
