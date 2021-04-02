package test_framwework;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author cuijingbo
 * @date 2021/3/31 21:58
 */
public class WebTest {

    private static BasePage basePage;
    @BeforeAll
    static  void  beforAll(){
        //todo:加载通用配置
    }

    @BeforeEach
    void beforeEach(){
        //todo；每个用例的初始配置

    }


    @ParameterizedTest(name = "{index}{1}")
    @MethodSource
    void classic(UIAuto uiAuto,String path){
        basePage.run(uiAuto);
    }

    //读取文件，进行处理，返回每个文件内容
    static List<Arguments> classic(){
        basePage = UIAutoFactory.create("web");
        basePage.loadPages("src/main/resources/test_framwework");

        // List<UIAuto> all=new ArrayList<UIAuto>();
        List<Arguments> all=new ArrayList<Arguments>();


        //todo:指定目录，执行目录下所有的文件
        Arrays.asList(
//                "/test_framwework/webauto.yaml",
//                "/test_framwework/webauto1.yaml",
                "/test_framwework/webauto2.yaml"
        ).stream().forEach(path->{
            UIAuto uiAuto= basePage.load(path);
            uiAuto.description=path;
            all.add(arguments(uiAuto,uiAuto.description));
        });
        return all;
    }
}
