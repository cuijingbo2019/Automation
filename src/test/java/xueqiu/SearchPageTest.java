package xueqiu;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import xueqiu.page.MainPage;
import xueqiu.page.SearchPage;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:58
 */
class SearchPageTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    @BeforeAll
    static  void  beforAll(){
        searchPage=new  MainPage().toSearch();
    }

    @Test
    @ParameterizedTest
    @CsvSource({
            "alibaba, 阿里巴巴",
            "jd,     京东"
    })
    void search(String keyword,String name) {
        //判断搜索结果是否正确
        Assert.assertEquals(searchPage.search(keyword).getSearchlist().get(0), name);
        ///testtettt
    }

    @Test
    void getPrice() {
        //获取股价，判断价格大于200
        Assert.assertTrue(searchPage.search("alibaba").getPrice()>200);
    }
}