package web_wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;


/**
 * @author cuijingbo
 * @date 2021/2/23 18:25
 */
public class ContactPage extends BasePage {
    By addMembers=By.linkText("添加成员");
    By deleteMember=By.linkText("删除");
    By edit=By.linkText("编辑");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    //添加成员
    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo:控件延迟、隐藏控件查找,可以优化封装
    /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //显示等待
        new WebDriverWait(driver, 10)
                .until((ExpectedConditions.visibilityOfElementLocated(addMembers)));
        //做个判断，当找到的元素存在，一直进行点击
        while (driver.findElements(addMembers).size() > 0) {
            driver.findElement(addMembers).click();
        } */


        while (driver.findElements(By.name("username")).size() == 0) {
            click(addMembers);}
        sendKeys(By.name("username"),username);
        sendKeys(By.name("acctid"),acctid);
        sendKeys(By.name("mobile"),mobile);

       // driver.findElement(By.name("username")).sendKeys(username);
       // driver.findElement(By.name("acctid")).sendKeys(acctid);
       // driver.findElement(By.name("mobile")).sendKeys(mobile);
        //driver.findElement(By.cssSelector(".js_btn_save")).click();
        click(By.cssSelector(".js_btn_save"));
        return this;
    }
    //搜索成员
    public ContactPage search(String keyword){
        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
      // new WebDriverWait(driver, 10)
       //      .until((ExpectedConditions.elementToBeClickable(edit)));
       //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
         //   e.printStackTrace();
       // }
        return this;
    }

    //获取当前用户的内容
    public String getUserName() {
        //todo:定位方式不对
        return driver.findElement(By.name("username")).getText();
    }

    //删除成员
    public ContactPage delete(){

        wait.until((ExpectedConditions.elementToBeClickable(edit)));
        click(deleteMember);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));

        //driver.findElement(deleteMember).click();
        // driver.findElement(By.linkText("确认")).click();
        //driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }


    //添加部门




    //添加子部门
    public ContactPage AddSubParty(String depament){
        click(By.linkText("组织架构"));
        click(By.xpath("//*[@class='js_add_sub_party']"));
        sendKeys(By.name("name"),depament);
        click(By.linkText("确定"));
        return this;
    }

    //获取部门的“id”
    public String getPartyId() {
        String id=driver.findElement(By.className("ww_searchResult_item_Curr")).getAttribute("data-id");
        return id;
    }

    //删除子部门
    public ContactPage deleSubParty(String party_id) {
        //点击清除按钮，清除搜索内容
        click(By.id("clearMemberSearchInput"));

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //把party_id 组装成xpath定位的内容
        click(By.linkText("组织架构"));
        String b="\'"+party_id+"_anchor"+"\'";
        System.out.println(b);
        //部门对应的坐标
        String oneopint="//a[@id="+b+"]";
        System.out.println(oneopint);
        //span对应的坐标
        String twoopint="//a[@id="+b+"]/span";
        System.out.println(twoopint);

        //先点击部门
        click(By.xpath(oneopint));
        //再点击span
        click(By.xpath(twoopint));
        //点击删除
        click(By.xpath("(//a[contains(text(),'删除')])[3]"));
        click(By.linkText("确定"));
        return this;
    }




    public ContactPage importFromeFile(URL path){
        //todo:操作
        System.out.println(path.getPath());
        System.out.println("111111111111111111111111");

        String path_url="";
        try {
            path_url= URLDecoder.decode(path.getFile(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_btnWithMenu_Open_Up .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));

       // uplod(By.name("file"),path_url);
        System.out.println("uplod");
        System.out.println(path_url);

       // click(By.linkText("导入"));
       // click(By.linkText("完成"));

        return this;
    }


    //
    public ContactPage addTable(String name) {
        click(By.linkText("标签"));
        return this;
    }


}
