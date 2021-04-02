package test_framwework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author cuijingbo
 * @date 2021/3/30 19:01
 */

//自动化建模
public class BasePage {

    List<PageObjectModel> pages=new ArrayList<>();


    public void click(HashMap<String,Object> map){
        System.out.println("click");
        System.out.println(map);

    }



    public void action(HashMap<String,Object> map){
        System.out.println("action");
        System.out.println(map);
        //如果是page级别的,执行下列操作
        if (map.containsKey("page")){
            //判断是否包含page
            String action=map.get("action").toString();
            String pageName=map.get("page").toString();
            pages.forEach(pom->{
                System.out.println(pom.name);
            });
            //从pages里边把每个pom对象过滤出来，取第一个；
            //找到init方法，然后把每一步（step）取出，然后继续调用action
            pages.stream()
                    .filter(pom->pom.name.equals(pageName))
                    .findFirst()
                    .get()
                    .methods.get(action).forEach(step->{
                        action(step);});

            System.out.println( pages.stream().filter(pom->pom.name.equals(pageName)).findFirst());
        }else{
            //如果不是page,则执行api级别操作
            if (map.containsKey("click")){
                HashMap<String,Object> by= (HashMap<String, Object>) map.get("click");
                click(by);
            }

            if(map.containsKey("sendKeys")){
                sendKeys(map);
            }

        }

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

    //自动化领域建模
    public PageObjectModel loadPage(String path){
        //读取yaml文件，解析成单个页面的PO模型
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        PageObjectModel pom=null;
        try {
            pom=mapper.readValue(
                    new File(path),
                    PageObjectModel.class//填写yaml文件地址
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pom;
    }
    //解析路径下的所有文件，把每个PO加载到pages里边
    public void loadPages(String dir){
        Stream.of(new File(dir).list(new FilenameFilter() {
            @Override
            //如果包含_page，则会被加载进来
            public boolean accept(File dir, String name) {
                return name.contains("_page");
            }
        })).forEach(path->{

            path=dir+ "/"+path;
            System.out.println(path);
            pages.add(loadPage(path));
        });
    }


}


