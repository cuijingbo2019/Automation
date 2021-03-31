package test_wework.page;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cuijingbo
 * @date 2021/3/22 18:36
 */
class SchedulePageTest {
    static Wework wework;
    @BeforeAll
    static  void beforeAll() {
        wework=new Wework();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addSchedule() {
        Assert.assertTrue(
                wework.Schedule()
                        .addSchedule("test",null)
                        .getSchedule("null")
                        .contains("test")
        );
    }

    @Test
    void deleteSchedule() {
        wework.Schedule()
                .toScheduleDetail("test")
                .deleteSchedule();
    }




}