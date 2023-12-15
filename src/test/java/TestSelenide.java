import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenide {

    /**
     * Тестирование добавления карточки пользователя в избранное
     */

    @Test
    public void addObject() throws InterruptedException {
        login();
        $x("//span[@id='favorite']").click();
        $x("//div[@id='gwt-debug-apply']").click();
        $x("//div[@id='gwt-debug-fcd6e34b-17fa-082b-0000-000026daef8c']/div").click();
        Thread.sleep(5000);
        mouseOver("//td[2]/div/div/div[2]/div");
        $x("//td[2]/div/div/div[2]/div").click();
        $x("//*[contains(@class,'gwt-Anchor GIEYS3IB5')]").shouldHave(text("employee1 \"Богданов Георгий\"/Карточка сотрудника"));
        delFromFav();
        Thread.sleep(5000);
        $x("//div[@id='gwt-debug-collapseNavTreeButton']/div").click();
        $x("//a[@id='gwt-debug-logout']").click();
    }

    /**
     * Тестирование удаления карточки пользователя из избранного
     */

    @Test
    public void dellObject()throws InterruptedException {
        login();
        $x("//span[@id='favorite']").click();
        $x("//div[@id='gwt-debug-apply']").click();
        $x("//div[@id='gwt-debug-fcd6e34b-17fa-082b-0000-000026daef8c']/div").click();
        Thread.sleep(5000);
        mouseOver("//td[2]/div/div/div[2]/div");
        $x("//td[2]/div/div/div[2]/div").click();
        delFromFav();
        $x("//*[contains(@class,'scroll-control GIEYS3IEX GIEYS3ILX flex-greedy')]")
                .shouldNotHave(text("employee1 \"Богданов Георгий\"/Карточка сотрудника"));
        $x("//div[@id='gwt-debug-collapseNavTreeButton']/div").click();
        $x("//a[@id='gwt-debug-logout']").click();
    }







    private static void delFromFav() throws InterruptedException {
        mouseOver("//*[contains(@class,'GIEYS3IM4 actionsForceEnabled')]");
        $x("//span[@id='gwt-debug-editFavorites']").click();
        $x("//table[@id='gwt-debug-favoritesEditTable']/tbody/tr/td[6]/div/span").click();
        $x("//div[@id='gwt-debug-YES']").click();
        $x("//div[@id='gwt-debug-apply']").click();
    }

    private static void login() throws InterruptedException {
        open("https://test-m.sd.nau.run/sd/");
        $x("//input[@id='username']").setValue("BogdanovGeorgy");
        $x("//input[@id='password']").setValue("123")
                .pressEnter();
        Thread.sleep(5000);
    }

    public static void mouseOver(String xpath) throws InterruptedException {
        SelenideElement element =  $x(xpath);
        actions().moveToElement(element);
        Thread.sleep(5000);
    }



}
