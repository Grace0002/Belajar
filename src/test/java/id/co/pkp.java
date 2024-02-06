package id.co;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;

public class pkp {

    @Test
    @DisplayName("Test Web PKP")
    public void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
//        page.navigate("https://pkp.co.id");
        page.navigate("https://www.google.co.id/");
        System.out.println("Page Title nya adalah: " + page.title());
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
    public void checkPlaceHolder() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");

        Locator searchBar = page.locator("#edit-keys--2");
        String placeText = searchBar.getAttribute("search");

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

    @Test
    @DisplayName("Maximize Browser")
    public void maximizeBrowserTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        int width2 = (int) screenSize.getWidth();
        int height2 = (int) screenSize.getHeight();
        BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width2, height2));
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("How to Refresh Page")
    public void howtoRefreshPageTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/popup/");
        page.reload();
        page.locator("//a[normalize-space()='JQuery Popup Model']").click();
        String textContent = page.locator("//p[normalize-space()='This is Sample Popup.']").textContent();
        System.out.println(textContent);
        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get First and Last Element in Playwright Java")
    public void getFirstAndLastElementTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle = page.locator("//h3[@class='search-result__title']");
//        Find the First Element using the first method
        listEle.first().click();

//        Find the First Element using Nth Method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle2 = page.locator("//h3[@class='search-result__title']");
        listEle2.nth(0).click();

//        Find the Last Element using the last method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle3 = page.locator("//h3[@class='search-result__title']");
        listEle3.last().click();

//        Find the Last Element using Nth Method
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        Locator listEle4 = page.locator("//h3[@class='search-result__title']");
        listEle4.nth(-1).click();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Get List of Elements in Playwright Java")
    public void getListOfElements() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");

        Locator listEle = page.locator("//h3[@class='search-result__title']");

        int count = listEle.count();
        Assertions.assertEquals(count, 10);

//        Nth content filter
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        String textContent = listEle.nth(1).textContent();
        System.out.println(textContent);

//        Display a list of texts
        page.navigate("https://www.programsbuzz.com/search/node?keys=playwright+java");
        java.util.List<String> allTextContents = listEle.allTextContents();
        System.out.println(allTextContents);
        allTextContents.forEach(System.out::println);

        for (int i = 0; i < allTextContents.size(); i++) {
            System.out.println(i + 1 + " -->" + allTextContents.get(i));
        }

        page.close();
        browser.close();
        playwright.close();

    }

    @Test
    @DisplayName("Using XPath")
    public void usingPathTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.programsbuzz.com/user/login");
        page.locator("//input[@id= 'edit-name']").type("Naruto");
//        page.locator("xpath=//input[@id= 'edit-name']").type("Naruto");
        page.locator("//input[@id= 'edit-pass']").type("Sasuke");

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Using ComboBox")
    public void usingComboboxTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/dropdown1/");
        page.selectOption(".custom-select", "item2");

        // Dynamic DropDown
        page.navigate("http://autopract.com/selenium/dropdown4/");
        page.locator("//span[@class='caret']").click();
        Locator countries = page.locator("//div[@role='combobox']");
        java.util.List<String> allInnerTexts = countries.allInnerTexts();

        allInnerTexts.forEach(System.out::println);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Auto Complete Test")
    public void autoCompleteTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        String expectedText = "Indonesia";

        page.navigate("https://demo.automationtesting.in/AutoComplete.html");
        Locator autoC = page
                .locator("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget ui-state-active']");
        int autoCcount = autoC.count();
        System.out.println("autoCcount: " + autoCcount);

        page.pause();

        for (int i = 0; i < autoCcount; i++) {
            String autoCText = autoC.nth(i).textContent();
            System.out.println("Yg dicari: " + autoCText);
            if (autoCText == expectedText) {
                autoC.nth(i).click();
                break;
            }
        }

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Check and Uncheck Checkbox in Playwright Java")
    public void checkNUncheckCheckboxTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

//        Using Click
        page.navigate("http://autopract.com/selenium/form5//");
        page.locator("//input[@value='two']").click();

//        Using Check
//        page.navigate("http://autopract.com/selenium/form5//");
        page.locator("//input[@value='four']").check();

//        Using Uncheck
//        page.navigate("http://autopract.com/selenium/form5//");
        page.locator("//input[@value='four']").uncheck();

//        page.navigate("http://autopract.com/selenium/form5/");
        page.locator("input[value='CA']").click();
        page.locator("input[value='mac']").check();

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Frame in Playwright Java")
    @Disabled("Ignore Handle Frame in Playwright Java")
//    @Ignore("Ignore Handle Frame in Playwright Java")
    public void handleFrameTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
        page.navigate("https://testkru.com/Interactions/Frames");

//        FrameLocator middleFrame = page.frameLocator("//frame[@src='message.htm']");
        FrameLocator middleFrame = page.frameLocator("#frame1");

//        middleFrame.locator("//input[@name='name']").type("Naruto Uzumaki");
//        middleFrame.locator("//textarea[@name='suggestions']").type("I Am Inside The Frame");

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Nested Frames in Playwright Java")
    public void handleNestedFramesTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        FrameLocator parentFrame = page.frameLocator("//frame[@name='frame-top']");
        FrameLocator middleFrame = parentFrame.frameLocator("//frame[@name='frame-middle']");
        String textContent = middleFrame.locator("body").textContent();
        System.out.println(textContent);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Multiple Tabs in Playwright Java")
    @Disabled("Ignore Handle Multiple Tabs in Playwright Java")
    // @Ignore("Ignore Handle Multiple Tabs in Playwright Java")
    public void HandleMultipleTabsTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.programsbuzz.com/");

        page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p -> p.context().pages().size() == 2), () -> {
            page.locator("a[href='https://www.ivagus.com']").click();
        });

        java.util.List<Page> pages = page.context().pages();

        for (Page tabs : pages) {
            tabs.waitForLoadState();
            System.out.println(tabs.url());
        }

        Page pbPage = pages.get(0);
        Page ivagusPage = pages.get(1);

        System.out.println(pbPage.url());
        System.out.println(ivagusPage.url());

        page.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Alert Button in Playwright Java")
    public void handleAlertTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext newContext = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280, 720));
        Page page = newContext.newPage();

        page.navigate("http://autopract.com/selenium/alert5/");
        page.onDialog(Dialog::accept);
        page.locator("#alert-button").click();

        newContext.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Alert Confirm in Playwright Java")
    public void handleAlertConfirmTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext newContext = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280, 720));
        Page page = newContext.newPage();

        page.navigate("http://autopract.com/selenium/alert5/");
        page.onDialog(Dialog::dismiss);
        page.locator("#confirm-button").click();

        newContext.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Alert Prompt in Playwright Java")
    public void handleAlertPromptTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext newContext = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280, 720));
        Page page = newContext.newPage();

        page.navigate("http://autopract.com/selenium/alert5/");
        page.onDialog(dialog -> {
            dialog.accept("20");
        });
        page.locator("#prompt-button").click();

        newContext.close();
        playwright.close();
    }

    @Test
    @DisplayName("Handle Popup in Playwright Java")
    public void handlePopup() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://autopract.com/selenium/popup/");

        Page popUp = page.waitForPopup(() -> {
            page.locator("//a[normalize-space()='Open Link in Popup']").click();
        });
        popUp.waitForLoadState();
        System.out.println(popUp.title());

        page.navigate("http://autopract.com/selenium/popup/");
        page.locator("//a[normalize-space()='JQuery Popup Model']").click();
        String textContent = page.locator("//p[normalize-space()='This is Sample Popup.']").textContent();
        System.out.println(textContent);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Take Screenshot in Playwright Java")
    public void takeScreenshotTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://autopract.com/selenium/upload1/");
//        page.setInputFiles("//input[@type='file']",
//                Paths.get("C:\\Users\\naruto\\git\\Assignments\\Selenium\\target\\CRED.xlsx"));
//        page.screenshot(new Page.ScreenshotOptions()
//                .setPath(Paths.get("C:\\Users\\naruto\\git\\Assignments\\Selenium\\target\\uploadPage.png")));

        //get final screenshot
//        Path screenshotPath = Paths.get("TEST1_" + System.currentTimeMillis() + ".jpg");
        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
        String tanggal = dateTime.format(DateTimeFormatter.ofPattern("ddMMuuuu_HHmmss"));
        System.out.println(tanggal);
        Path screenshotPath = Paths.get("TEST1_" + tanggal + ".jpg");
        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath).setFullPage(true));

        Path screenshotPath2 = Paths.get("TEST2_" + tanggal + ".jpg");
//        page.locator(".class").screenshot(new Locator.ScreenshotOptions().setPath(screenshotPath2));
//        page.locator(".class").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("/Users/hendisantika/IdeaProjects/fincore/demo-playwright/uploadPage.png")));

//        Buffer Capture
        byte[] buffer = page.screenshot();
        System.out.println(Base64.getEncoder().encode(buffer));

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Record Video in Playwright Java")
    public void recordVideoTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext newContext = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280, 720));
        Page page = newContext.newPage();

        page.navigate("https://www.programsbuzz.com/user/login");

        page.locator("#edit-name").type("Naruto");
        page.locator("#edit-pass").type("Madara");

        newContext.close();
        playwright.close();
    }

    @Test
    @DisplayName("Double Click in Playwright Java")
    public void doubleClickTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://testkru.com/Elements/Buttons");
        Locator textClick = page.locator("#doubleClick");
        textClick.dblclick();
        String textContent = page.locator("#doubleClick").textContent();
        System.out.println(textContent);

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Reusing Signed in State in Playwright Java")
    public void reusingSignedInStateTest() {
        Playwright playwright = Playwright.create();
        BrowserContext browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newContext();

        Page page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("//input[@id='username']").type("student");
        page.locator("//input[@id='password']").type("Password123");

        page.locator("//button[@id='submit']").click();
        String textContent = page
                .locator("//strong[contains(text(),'Congratulations student. You successfully logged i')]")
                .textContent();
        System.out.println(textContent);

        browser.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Post API Request using Playwright Java")
    public void postAPIRequestTest() {
        Playwright playwright = Playwright.create();
        APIRequestContext request = playwright.request().newContext();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        HashMap<String, String> data = new HashMap<>();

        data.put("name", "Naruto");
        data.put("job", "Ninja");

        String response = request.post("https://reqres.in/api/users", RequestOptions.create().setData(data)).text();

        System.out.println(response);

        JsonObject j = new Gson().fromJson(response, JsonObject.class);
        System.out.println(j.get("name"));

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Put API Request using Playwright Java")
    public void putAPIRequestJava() {
        Playwright playwright = Playwright.create();
        APIRequestContext request = playwright.request().newContext();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        HashMap<String, String> data = new HashMap<>();

        data.put("name", "Sasuke");
        data.put("job", "Uchiha");

        String response = request.put("https://reqres.in/api/users/2", RequestOptions.create().setData(data)).text();
        System.out.println(response);

        JsonObject j = new Gson().fromJson(response, JsonObject.class);
        System.out.println(j.get("name"));
        System.out.println(j.get("job"));

        page.close();
        browser.close();
        playwright.close();
    }

    @Test
    @DisplayName("Patch API Request using Playwright Java")
    public void patchAPIRequestTest() {
        Playwright playwright = Playwright.create();
        APIRequestContext request = playwright.request().newContext();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        HashMap<String, String> data = new HashMap<>();

        data.put("name", "Sasuke");
        data.put("job", "Uchiha");

        String response = request.put("https://reqres.in/api/users/2", RequestOptions.create().setData(data)).text();
        System.out.println(response);

        JsonObject j = new Gson().fromJson(response, JsonObject.class);
        System.out.println(j.get("name"));
        System.out.println(j.get("job"));

        page.close();
        browser.close();
        playwright.close();
    }
}