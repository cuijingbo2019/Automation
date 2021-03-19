package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

/**
 * @author cuijingbo
 * @date 2021/2/23 18:23
 */
public class MainPage extends BasePage {

    public MainPage(){
        //todo:登录代码
        super();
        String url="https://work.weixin.qq.com/wework_admin/frame";
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo:cookie处理
        driver.manage().addCookie(new Cookie("pgv_pvi", "2807715840"));
        driver.manage().addCookie(new Cookie("pgv_pvid", "7206305654"));
        driver.manage().addCookie(new Cookie("RK", "mIrEZrInHD"));
        driver.manage().addCookie(new Cookie("ptcz", "1d88710dd59c11f883ca712b988ddb82317fcd34d4f18ca252624d130a3d6e48"));
        driver.manage().addCookie(new Cookie("tvfe_boss_uuid", "d55dd624a494b749"));
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.c_gdpr", "0"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.538184951.1611553264"));
        driver.manage().addCookie(new Cookie("Hm_lvt_f2ba645ba13636ba52b0234381f51cbc", "1612749796,1612749890"));
        driver.manage().addCookie(new Cookie("pac_uid", "0_694e336ac2a20"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "22044852311124925"));
        driver.manage().addCookie(new Cookie("Hm_lvt_9364e629af24cb52acc78b43e8c9f77d", "1612842197,1612842280,1613979283,1614673125"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.195745900.1614673125"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970325119097560"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688850945733533"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688850945733533"));
        driver.manage().addCookie(new Cookie("Hm_lpvt_9364e629af24cb52acc78b43e8c9f77d", "1614681139"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "60kan03"));
        driver.manage().addCookie(new Cookie("_gat", "1"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a9381413"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "Ekv_2dfqJ3-ElLtGMs8rxeismuzt5KAXUXkyy-oDwX12-LRXQZol-tqc9sKo5TGa"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "1mtfL-j1T2bugHAVwV_g9rndj1lj441GAbxIyZeDRjMyzxWzde1SPxffDFdK-0UbEg6InJMgqrMwr6OtUBJbA_zkNMlKra8H5sViYlSxwUhvv69tjL2RWskbQsQ7vsE60fJeh30gEmR0jWljhinf6o_B8HbdwW58SDaZD2T5PxaormDFDnF6jrbtfVoys-tbAReXM-RBt5IbAvYyJ3RLStFzUh90K7USGkFZwe2KwjD6jUzsGmJFvsxdJbGeQvaeRAhqt7OUDX491TGU68BbRw"));
        driver.get(url);

    }
    //进入导航
    public ContactPage toContact(){
        //todo
        click(By.cssSelector("#menu_contacts"));
       // driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);
    }


}
