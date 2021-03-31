import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author cuijingbo
 * @date 2021/2/7 15:40
 */
public class TestSelenium {
    private WebDriver driver;

    @Test
    public void  testSelenium(){
        //第一步：打开浏览器的debug模式，把浏览器设置为可执行环境变量（可执行文件设置成环境变量）
        ChromeOptions options=new ChromeOptions(); //定义一个optins
        options.setExperimentalOption("debuggerAddre","127.0.0.1:9222");//设置一个参数
        //第二步:把指定的options,传输给chromedriver
        driver= new ChromeDriver(options);
        driver.get("http://www.baidu.com");
        //获取当前界面的cookie信息
       // driver.manage().getCookies();
       // System.out.println(driver.manage().getCookies());
    }


    //cookie保存
    public void  saveCookie(){
        try {
            FileWriter file=new FileWriter("cookie.txt"); //声明一个新的txt文件
            BufferedWriter bufferedWriter=new BufferedWriter(file); //流式写入缓冲
            //遍历cookie，每次取1条进行处理
            for(Cookie cookie:driver.manage().getCookies()){
                //提前Cooke中的字段
                cookie.getName();
                cookie.getValue();
                cookie.getDomain();
                cookie.getPath();
                cookie.getExpiry();//过期时间
                cookie.isSecure();
                //进行保存
                bufferedWriter.write(cookie.getName()+";"+
                        cookie.getValue()
                );

                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从保存的文件中，读取cookie
    public  void  localCookie(){
        //通过分词器，读取cookie.txt文件，并且提取出每个；分隔的字段
        try {
            FileReader fileReader=new FileReader("cookie");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                //分词工具，stringTokenizer
                StringTokenizer tokenizer=new StringTokenizer(line,";");//根据；分隔字符串
                String name=tokenizer.nextToken();//第一个分号前的值
                String value=tokenizer.nextToken();
                String domain=tokenizer.nextToken();
                String path=tokenizer.nextToken();//第二个分号前的值
                String expriy=tokenizer.nextToken();

                //expriy 为data格式，需要把string转换成data
                Date Expriy=null;
                SimpleDateFormat sdf=new SimpleDateFormat("EEE MMMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                String dt = tokenizer.nextToken();
                if (!dt.equals(null)){
                    sdf.parse(dt);  //通过parse方法，转成data类型
                }

                //把string 类型转换成boole类型
                boolean isSecure= Boolean.parseBoolean(tokenizer.nextToken());
                //。。。。。
                //重新组成一个cookie
                Cookie cookie=new Cookie(name,value,domain,path,Expriy,isSecure);
            }
        } catch (Exception e) {
            e.printStackTrace(); }
    }

}
