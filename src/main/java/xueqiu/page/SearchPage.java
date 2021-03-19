package xueqiu.page;

import java.util.Arrays;
import java.util.List;

/**
 * @author cuijingbo
 * @date 2021/3/16 17:54
 */
public class SearchPage {

    //进入搜索页
    public SearchPage search(String keyword){
        return this;
    }

    //search搜索校验
    public List<String> getSearchlist(){
        return Arrays.asList("1","3","4");
    }


    //返回搜索结果-获取股价
    public double getPrice(){
        return 1.1;
    }

}
