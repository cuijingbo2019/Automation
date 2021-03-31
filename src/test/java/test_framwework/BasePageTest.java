package test_framwework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author cuijingbo
 * @date 2021/3/30 19:19
 */
class BasePageTest {


    private static BasePage basePage;

    @BeforeAll
    static  void befroeall(){
        basePage = new BasePage();
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void click() {

    }

    @Test
    void find() {
    }

    @Test
    void send() {
    }

    @Test
    void getText() {
    }

    @Test
    void run() {
        UIAuto uiauto =basePage.load("/test_framwework/uiauto.yaml");
        basePage.run(uiauto);
    }

    @Test
    void load() throws JsonProcessingException {
      UIAuto uiauto =basePage.load("/test_framwework/uiauto.yaml");
      ObjectMapper mapper=new ObjectMapper();
      System.out.println(mapper.writeValueAsString(uiauto));
    }
}