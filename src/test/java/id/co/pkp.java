package id.co;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class pkp {
    @Test
    @DisplayName("Test")
    public void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        System.out.println(page.title());
    }

    @Test
    @DisplayName("Check URL or Check HTTPS")
    public void teshttps() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        String currentUrl = page.url();
        String expectedUrl = "https://www.programsbuzzz.com/user/login";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct: " + currentUrl);
        } else {
            System.out.println("URL is incorrect. Expected: " + expectedUrl + ", but got: " + currentUrl);
        }
        // System.out.println(currentUrl);
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Check Place Holder")
    public void checkPlaceholder() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");
        Locator searchBar = page.locator("#edit-keys");
        String placeText = searchBar.getAttribute("placeholder");

        if (placeText.contains("Enter the terms you wish to search for")) {

            System.out.println("PASS");

        } else {
            System.out.println("FAIL! No such texts");
        }
    }

    @Test
    @DisplayName("Assert Checkbox")
    public void assertCheckBox() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown1/");
        Locator locator = page.locator("select.custom-select option >> nth=-2");
        String attributeV = locator.getAttribute("value");

        if (attributeV.equals("item3")) {
            System.out.println("Attribute value is correct!");
        } else {
            System.out.println("Attribute value is incorrect.");
        }
    }

    @Test
    @DisplayName("Tooltip Check Test")

    public void tooltipCheckTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/tooltip/");
        FrameLocator frameOne = page.frameLocator(".demo-frame");
        Locator ageBox = frameOne.locator("#age");
        Locator toolTipText = frameOne.locator(".ui-tooltip-content");
        ageBox.hover();
        String textContent = toolTipText.textContent();
        System.out.println(textContent);
    }

    @Test
    @DisplayName("Assert Title Test")
    public void assertTitleTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com");
        String title = page.title();
        String expectedTitle = "ProgramsBuzz - Online Technical Courses";
        if (title.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Match Verfied");
        } else {
            System.out.println("Not a match!!");
        }
    }

    @Test
    @DisplayName("Get Current URL Java")
    public void getCurrentUrl() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.programsbuzz.com/user/login");
        page.locator("#edit-name").type("Naruto");
        page.locator("#edit-pass").type("uzumaki");
        String currentUrl = page.url();
        System.out.println(currentUrl);
        browser.close();
        playwright.close();
    }
}



