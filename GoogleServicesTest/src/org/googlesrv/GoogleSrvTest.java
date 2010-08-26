package org.googlesrv;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.apache.log4j.Logger;

public class GoogleSrvTest{
    private Selenium selenium;
    @BeforeClass
    public void setup(){
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "https://mail.google.com/mail/");
        selenium.start();
    }
    
    static Logger log4j = Logger.getLogger("org.example.google.srv");
  
    @Test
    public void GoogleSrvTest() throws Exception {
    	//1. Open https://mail.google.com/mail/ (Use https protocol)
        selenium.open("https://mail.google.com/mail/");
        selenium.windowMaximize();
      
        if (selenium.isElementPresent("link=Sign out"))
        {
            selenium.click("link=Sign out");
            //selenium.waitForPageToLoad("20000");
        }
        //2. Check that ‘Welcome to Gmail’ page loaded.
        assertTrue(selenium.isTextPresent("exact:Welcome to Gmail"));
        
        if (selenium.isElementPresent("id=Email")) {
        	//3. Enter your account.
        	selenium.type("Email", "itomater@gmail.com");
        	log4j.debug("Entering username");
        }
        else {
        	log4j.debug("No username field");
        }
        
        if (selenium.isElementPresent("id=Passwd")) {
        	//4. Enter your password.
            selenium.type("Passwd", "itomated");
        	log4j.debug("Entering password");
        }
        else {
        	log4j.debug("No password field");
        }
        
        if (selenium.isElementPresent("class=gaia le button")) {
        	//5. Click ‘Sign In’ button
            selenium.click("signIn");
            //selenium.waitForPageToLoad("30000");
            log4j.debug("Logging in");
            //Thread.sleep(5000);
        }
        else {
        	log4j.debug("No 'Sign In' button. Not logging in.");
        }
        Thread.sleep(10000);
        selenium.selectFrame("canvas_frame");
        //6. Verify that your Gmail box is loaded (Check your personal information)
        assertTrue(selenium.isTextPresent("exact:itomater"));
                
        if (selenium.isElementPresent("link=Documents")) {
        	//8. Click ‘Documents’ link in the top  Gmail menu.
            selenium.click("link=Documents");
            log4j.debug("Going to Google Docs");
            Thread.sleep(3000);
        }
        else {
        	log4j.debug("No 'Documents link'");
        }
        Thread.sleep(5000);
        //9. Go to opened Google Docs window.
        selenium.selectWindow("Google Docs - All items");
        //10. Click ‘New’ Link.
        //11. Select ‘Form’ point in menu.
        selenium.open("https://spreadsheets.google.com/newform");
        
        
        selenium.windowMaximize();
        //12. Go to opened ‘Edit form’ window.
        selenium.selectWindow("Edit form - [ Untitled Form ] - Google Docs");
        if (selenium.isElementPresent("form-title")) {
        	//13. Enter ‘Selenium form’ in the first field.
            selenium.type("form-title", "Selenium form");
            log4j.debug("Setting form title 'Selenium form'");
        }
        else {
        	log4j.debug("Cannot set form title");
        }
        
        if (selenium.isElementPresent("form-description")) {
        	//14. Enter ‘Selenium help information’ in the second field.
            selenium.type("form-description", "Selenium help information");
            log4j.debug("Setting form description 'Selenium help information'");
        }
        else {
        	log4j.debug("Cannot set form description");
        }
        
        if (selenium.isElementPresent(":0.fw_tf")) {
        	//15. Enter ‘Selenium Question Title’ in Question title field.
            selenium.type(":0.fw_tf", "Selenium Question Title");
            log4j.debug("Setting Question Title to 'Selenium Question Title'");
        }
        else {
        	log4j.debug("Cannot set Question Title");
        }
        
        if (selenium.isElementPresent(":0.fw_htf")) {
        	//16. Enter ‘Help text’ in ‘Help text’ field.
            selenium.type(":0.fw_htf", "Help text");
            log4j.debug("Setting Help text to 'Help text'");
        }
        else {
        	log4j.debug("Cannot set Help text");
        }
        
        if (selenium.isElementPresent(":0.fw_tdd")) {
        	//17. Select ‘Scale’ in ‘Question type’ dropdown
            selenium.select(":0.fw_tdd", "label=Scale");
            log4j.debug("Setting Question type to 'Scale'");
        }
        else {
        	log4j.debug("Cannot set Question type");
        }
        
        //18. Verify that ‘Scale 1 to’ and ‘Labels’ fields are visible.
        assertTrue(selenium.isElementPresent(":i.se_ldd"));
        assertTrue(selenium.isElementPresent(":i.se_udd"));
        assertTrue(selenium.isElementPresent(":i.se_llf"));
        assertTrue(selenium.isElementPresent(":i.se_ulf"));
        
        //19. Select ‘7’ in ‘Scale 1 to’ field.
        selenium.select(":i.se_udd", "label=7");
        //20. Verify that label for the second field was changed from 5 to 7
        assertTrue(selenium.isTextPresent("7"));
        //21. Enter Label1 in First Label field
        selenium.type(":i.se_llf", "Label 1");
        //22. Enter Label7 in Second Label field
        selenium.type(":i.se_ulf", "Label 7");
        
        if (selenium.isElementPresent("save-button")) {
        	//23. Click ‘Save’ button (On the top of the window)
            selenium.click("save-button");
            log4j.debug("Saving the form");
        }
        else {
        	log4j.debug("Cannot save the form");
        }
        
        //24. Verify that form with required data is saved.
        selenium.click("view-form-link");
        //25. Return to ‘Google Docs’ window.
        selenium.open("https://docs.google.com");
        //27. Enter First Letter of Form Title in Search Docs field
        selenium.type("search", "s");
        //29. Return to your Gmail window.
        selenium.click("link=Gmail");
        //30. Click ‘Sign out’ link.
        selenium.click("link=Sign out");
        Thread.sleep(7000);
        selenium.selectWindow("Gmail: Email from Google");
        //31. Verify that ‘Welcome to Gmail’ page displayed.
        assertTrue(selenium.isTextPresent("exact:Stay signed in"));
                
        Thread.sleep(60000);
    }
  
    @AfterClass
    public void tearDown(){
        selenium.stop();
    }
}

