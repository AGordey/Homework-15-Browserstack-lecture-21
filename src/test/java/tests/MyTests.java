package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;

public class MyTests extends TestBase {
    @Test
    void searchTest() {
        String searchValue = "Ubuntu";
        //back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchValue);
        });
        step("Verify content found", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(text(searchValue));
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                    .shouldHave(text("Debian-based Linux operating system"));
        });
/*          Проходит на Pixel 6
//        step("Open page with article about" + searchValue, () -> {
//            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
//                    .find(Condition.text(searchValue)).click();
//        });
//        step("Verify article about " + searchValue, () -> {
//            $(AppiumBy.className("android.view.View")).shouldHave(text(searchValue));
       }); */
    }
}