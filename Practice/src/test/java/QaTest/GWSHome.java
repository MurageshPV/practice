package QaTest;

import org.junit.Test;
import base.BaseTest;
import pageEvents.HomePageEvents;

public class GWSHome extends BaseTest {

	HomePageEvents homepage = new HomePageEvents();

	public void VerifyFreeTailBtn() {
		homepage.FreeTrailIsDisplay();
		homepage.clickOnFreeTrailBtn();
		homepage.verifysignUpPageTitle();

	}

	@Test
	public void validateMenuOPtion() {
		homepage.verifyMenuOption();
	}

}
