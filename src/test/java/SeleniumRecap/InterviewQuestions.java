package SeleniumRecap;

public class InterviewQuestions {

    /*
    1-What are the advantages and disadvantages of Selenium?

     Advantages: *Free Resource
                 *It supports multiple languages and browsers
                 *It has big community

     Disadvantages: *You cannot automate captcha,pictures,mobile applications etc...
                    *There is no direct call(customer service) for support
                    *It only automates Web application(browsers)
                    *It does not have any system to generate report,so we use
                    external resources(testng,cucumber etc...)

     2-What type of testing can you automate with Selenium?
        *Regression
        *Smoke
        *Functional test(positive and negative testing)

     3-What are the test types you do not automate with Selenium?
        *Performance Testing(Jmeter-->it is not really hard to learn)
        *Manual Testing(captcha,pictures)
        *Non-Functional Testing(stress testing,loading testing,performance...)
        *Adhoc Testing(randomly testing)

     4-What is locator in Selenium? what type of locators do you use in your framework?
         -->Locator is a way to find the element/s from DOM(development tool/page)
      The locators that I am using in my framework are:

        -->ID -->finds the element with ID attribute
        -->Name-->find the element with Name attribute
        -->ClassName-->find the element with ClassName attribute
        -->TagName-->find the element with TagName
        -->LinkText-->find the element with "a" tagname and "text"
        -->PartialLinkText-->find the element with "a" tagname and "partialtext" or fullText
        -->CSS-->find the element with CSS (id or class) -->for id (#), for class(.)
        -->Xpath-->find the element with Xpath.

     5-How do you handle dynamic elements in UI automation? (CVS*****)
        -->In my project,I've faced many dynamic elements during ui automation:
           -->to handle this issue I did:
               **I used parent-child relationship for the elements
               ***I used different ways to locate the elements(like following-sibling
               ,preceding sibling,contains etc...)
               *I found the element with different attribute which is not dynamic

     6-Difference between driver.get() and driver.navigate() ?

       Navigate() -->it doesn't wait webElements to be loaded from page.(it waits for
                     only specific elements that you are looking from page)
                  -->It has methods (to,refresh,back,forward)

       Get()-->It waits all the webelements from page to be loaded
            -->it does not have any methods

      7-Different between driver.close() and driver.quit()?

        Driver.close() -->It specifically closes the window that your driver is pointing.
                           *-->it closes only one tab

        Driver.quit() -->it closes all the tabs that were opened during the automation run.

      8-What is Xpath and can you tell me about types of Xpath? which one do you use the most?

        8.1 -->What is the difference between Absolute and Relative Xpath?

       -->XPATH:Is one of the locators that I use in Selenium to find the element.
          -->There are two types of Xpath:

             1-Absolute Xpath:
                *It goes from all the way top(html) to child.
                *It starts with single slash(/)

             2-Relative Xpath:
                *It goes directly to the child or parent/child
                  example://div[@id='parent']//a[.='child'] //parent child
                  example://div[@id='parent']//following-sibling::a //following sibling
                *it starts with double slash(//)

         NOTE:I use definitely the relative xpath the most since it is more functional
         and effective to locate the elements.

       9-How do you handle drop-downs?(static or dynamic drop-down)

         In my project, I was handling the drop-downs with different ways: First

         *I would definitely check the tag of the webElement(location)
           *If the location has "SELECT" tagName then -->I use Select CLASS
             exp:Select select=new Select(locationofElement);

           *If the location doesn't have "SELECT" tagName then -->I can use

                -->Actions class methods like click or WebElements method click and choose option
                -->I would use sendKeys() to choose the option.

         10-Can you tell me what do you know about Select class and it's methods?

          Select class is a way to handle Drop-downs:
            -->It is really useful for my project.
            -->The WebElement must have Select tagname

           -Select select =new Select(location);
              *select.selectByvisibleText("textValue");
              *select.selectByValue("value);
              *select.selectByindex(indexNumber);
              *select.getFirstSelectedOption()-->it will give you default option selected
              *select.getOptions()-->it will give you all options(List<String>)

          11-What kind of exceptions have you faced in your automation Framework?(at least 5)

             -->NOSUCHELEMENT EXCEPTION
             -->STALE ELEMENT REFERENCE EXCEPTION
             -->ELEMENT INTERCEPTED EXCEPTION
             -->ELEMENT IS NOT INTERACTABLE EXCEPTION
             -->NO SUCH WINDOW EXCEPTION
             -->NO SUCH FRAME EXCEPTION
             -->TESTNG EXCEPTION
             -->UNHANDLED ALERT EXCEPTION
             -->TIMEOUT EXCEPTION
             -->INVALID SELECTOR EXCEPTION]

         12-How do you handle Stale Element Reference Exception?

          In my project, this exception is one of the hard ones that was giving me headache:

             -->This exception happens when:
                *the dom is not updated fast
                *The dom's element values is changed
                *The page is refreshed

            -->Wait times might solve the issue
               -->I would use Thread.sleep or Explicitly wait with condition
             **-->I would reassign and reinitialize the webelement
               -->I would refresh the page

         13:How do you handle pop-ups? and Can you tell me the methods that you handle JS alert?

          There are different types of pop-ups that I've faced during automation?

          1-Operation System(OS):We cannot handle it directly with Selenium

          2-HTML alert/pop-up:I just need to find the element and click on it(like OK or Cancel Button)

          3-JavaScript alert/pop-up:I handle it with Alert interface

             Alert alert=driver.switchTo().alert();

             alert.accept()-->it clicks "OK" button from alert
             alert.dismiss()-->it clicks "CANCEL" button from alert
             alert.getText()-->it gets the text from alert
             alert.sendKeys()-->it sends the key to the alert.

         14-What do you know about iframe ? and how do you handle this in your automation?

           -->Iframe is html inside of html.
           -->It is used for protection purposes.
           -->It is widely used for Ads,documents or videos

           -->First switch your frame based on the value of Webelement:

              -->driver.switchTo.frame(id or name)
              -->driver.switchTo.frame(WebElement)
              -->driver.switchTo.frame(index)
              -->driver.switchTo.ParentFrame()--->it will go to the parent frame
              -->driver.switchTo.defaultContent()-->it will no matter what go to the main html directly
                                                 -->no matter what how many times you switch your frame from parent to child
                                                 with this method, it will directly skip all the parents and go to the main html.

            NOTE:If you do not handle this iframe, you will get NOSUCHElement exception
            NOTE:If the value of switchframe is wrong, you will get NOSUCHFRAME exception

            15-What do you know about Actions class and can you tell me the methods you used the most during automation?

            Actions class basically does the functionality of mouse.I can say it is really useful in some cases during
            my automation to handle some elements.Some of the important methods are:

      IQ  ***** -->ContextClick-->it right clicks on the webelement   IQ:interview question
                -->DoubleClick-->it double clicks the element
                -->DragAndDrop-->it drags and drops the element from one spot the another spot
                -->ClickAndHold-->It clicks and holds the element
              * -->MoveToElement -->it hovers over the element
                -->release -->It releases the element that you are holding(it mostly comes after clickAndHold)
                -->click()-->it clicks the element
                -->sendKeys()-->it sends the key
           *****-->perform()-->it performs the actions method.(WITHOUT THAT IT WILL NOT WORK)

           16-What is the difference between driver.finElement and driver.FindElements?

             *Find Element: 1-driver.findElement(By.locator("); Synthax
                            2-Returns single WebElement
                            3-Once it fails,it throws NOSUCHELEMENT exception

             *Find Elements:1-driver.findElements(By.locator(");Synthax
                            2-Returns List<WebElement>
                            3-once it fails,it returns nothing(empty list)

           17-Can you tell me some driver and WebElement methods you use during automation mostly?(at least 5)

             Driver Methods: *get() *navigate(), *getTitle(),*getCurrentURL(),*switchTo(),*quit(),*close(),*GetWindowHandle/s.*manage()

             WebElement Methods: *click(), *sendKeys(), *getText(),*isDisplayed,*isSelected(),*getAttribute(),*getCSSValue(),*clear(),*submit()

           18-What is the difference between check-box and radio button?

             CheckBox-->you can click multiple boxes

             RadioButton-->you can choose only one

           19-How do you handle multiple windows in automation? and What is the difference between getWindowhandle() and getWindowHandles()?

             -->to be able to handle the windows:

                 -->I need to switch my driver into the specific window with my logic

                    Set<String> allWindows=driver.getWindowHandles();

                    for(String pageID:allWindows){
                    driver.switchTo.window(pageId);
                    if(driver.getTitle.contains(expectedTitle){
                    break;}

               1-Use GetwindowHandles to store all pages id as Set
               2-Loop through all pages and switch
               3-Break the loop when title is what I am looking for.

            NOTE:Get WindowHandle-->return String with single page id
                 Get WindowHandles-->return Set<String> with all unique page ids

             20-How do you scroll down-up in Web Browsers during automation?

         ****** -->I mostly use JS scrollIntoView script.(I store it in my Browser Utils for any time usage)
                -->actions.scrollByAmount(x,y)
                -->Keys.PageUp or Down
                -->Keys.ArrowUp or Down

             21-How do you upload file in Selenium ?

               -->First of all, you need to find the location of CHOOSE Button
               -->Find the path of the file that you are going to attach(//C://Users///usa.png
               -->Then Send the keys of location to the choose button.

              22-What is the difference between Assert and SoftAssert ?

              Assert:is a class that have some methods to validate actual and expected data.
                Assert.assertEquals, assertTrue

                *When it fails, it throws exception right away and do not execute the next line of code.

              SoftAssert:It is a class that have some methods to validate actual and expected data.
                *We need to create an object
                     SoftAssert softAssert=new SoftAssert();
                *When it fails,it does not throw an exception then it keeps executing the next codes.
                *You must use Assert.all() to make it work properly otherwise it will pass all the time.

              23-Can you tell me about your Singleton Pattern design? -->Can you make the constructor private,static final?

              First of all, I appreciate for this question since I like singleton logic because in the past I was working on
              my driver and getting lots of NULLPOINTER exception. With the help of Singleton, I centralize my driver which
              reduces the amount of exception I got which means it is more reliable and safe to use.

                -->I basically Encapsulate my Singleton:

                    -->I need to have Private WebDriver
                    -->I need to have Private Constructor
                    -->Put if condition to check my driver is null or not
                    -->create a public method to call it from other classes.

              24-What kind of TestNG annotation do you use in your project? Can you tell me What is the purpose of @Parameter usage?

              Please check the sublime -->It is explained in details recently

              25-What do you know about @DataProvide and why do you use it?
              Please check the sublime -->It is explained in details recently

              26-What do you know about Wait times and can you tell me the difference between Thread.sleep, implicity,explicity,Fluent wait?
              Please check the Sublime -->It is explained in details recently
































     */
}
