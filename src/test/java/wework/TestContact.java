package wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.page.ContactPage;
import wework.page.MainPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author cuijingbo
 * @date 2021/2/23 18:35
 */
public class TestContact {
   static MainPage main;
   static ContactPage contact;

    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddMember(){
        String username= contact.addMember("4","4","17610035090").search("4").getUserName();
        //todo：通过search方法进行assert
        assertEquals(username,"4");
    }



    @Test
    void testSearch(){
        //先添加，再搜索然后进行删除
        contact.addMember("3","3","17610035091").search("3").delete();
    }


    //添加部门


    //删除部门



    //子添加子部门
    @Test
    void addSubParty(){
        contact.AddSubParty("测试");
    }
    
    //删除子部门
    @Test
    void deleSubParty(){
        //传入party_id，根据party_id组装xpath定位参数
        contact.deleSubParty(contact.search("测试").getPartyId());
    }


    //部门，标签
    @Test
    void addTable(){
        contact.addTable("test");
    }


    @Test
    //todo:导入之后，要查询方法，判断是否成功
    void  testImportFromFile(){

       contact.importFromeFile(this.getClass().getResource("/通讯录批量导入模板.xlsx"));
       // System.out.println(this.getClass().getResource("/通讯录批量导入模板.xlsx"));
    }

    @AfterAll
    public static void aftrAll(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        contact.quit();
    }
}
