package test_framwework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cuijingbo
 * @date 2021/3/31 21:31
 */
class FactoryTest {

    @Test
    void create() {
        BasePage web=Factory.create("web");
        UIAuto uiAuto=web.load("/test_framwework/webauto.yaml");
        web.run(uiAuto);
    }
}