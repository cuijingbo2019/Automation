package test_framwework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author cuijingbo
 * @date 2021/3/30 19:01
 */

//自动化建模
public class BasePage {

    public void click(HashMap<String,Object> map){
        System.out.println("click");
        System.out.println(map);

    }



    public void action(HashMap<String,Object> map){
        System.out.println("action");
        System.out.println(map);
    }

    public void sendKeys(HashMap<String,Object> map){
        System.out.println("sendkeys");
        System.out.println(map);


    }

    public void getText(){

    }

    public void run(UIAuto uiauto){
        uiauto.steps.stream().forEach(m->{
            //读取每一步骤

            if (m.containsKey("click")){
                HashMap<String,Object> by= (HashMap<String, Object>) m.get("click");
                click(by);
            }

            if(m.containsKey("sendKeys")){
                sendKeys(m);
            }


            if(m.containsKey("action")){
                action(m);
            }

        });
    }

    public UIAuto load(String path){
        //读取yaml文件，返回uiauto类
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UIAuto uiauto=null;
        try {
            uiauto=mapper.readValue(
                    BasePage.class.getResourceAsStream(path),UIAuto.class//填写yaml文件地址
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uiauto;
    }

}


