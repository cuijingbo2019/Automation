package xueqiu.page;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cuijingbo
 * @date 2021/3/19 15:33
 */
class StockPageTest {
    static MainPage mainPage;
    static StockPage stockPage;

    @BeforeAll
    static void BeforeAll() throws MalformedURLException {
       stockPage=new MainPage().toStock();
    }

    @ParameterizedTest
    @CsvSource({
            "jd,京东"
    })
    //添加股票--返回stock--查看是否添加成功
    void  addStock(String keyword,String name){
        Assert.assertEquals(stockPage.toSearchPage().addStock(keyword).getName(name),name);
    }

    @ParameterizedTest
    @CsvSource({
            "阿里巴巴"
    })
    void delStock(String name){

        Assert.assertNull(stockPage.StockDetail(name).delStock().getSearch(name),name);
    }


}