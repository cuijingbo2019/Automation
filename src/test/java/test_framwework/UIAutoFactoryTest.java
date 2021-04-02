package test_framwework;

import org.junit.jupiter.api.Test;

/**
 * @author cuijingbo
 * @date 2021/3/31 21:31
 */
class UIAutoFactoryTest {

    @Test
    void create() {
        BasePage web= UIAutoFactory.create("web");
        UIAuto uiAuto=web.load("/test_framwework/webauto.yaml");
        web.run(uiAuto);
    }
}