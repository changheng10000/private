package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by changheng on 17/11/16.
 */
public class TestConcurrentHashMap{
    public static void main(String[] args){
        Map<String,String> msgMap = new ConcurrentHashMap<>(8); //初始化ConcurrentHashMap
        //新增个人信息
        msgMap.put("realName", "asdf");
        msgMap.put("investDate", "2018-09-11");
        msgMap.put("title", "2344");
        msgMap.put("quitAmount", "5153215");
        //获取姓名
//        String name = map.get("name");
//        Assert.assertEquals(name,"andy");
        //计算大小
//        int size = map.size();
//        Assert.assertEquals(size,1);
        System.out.println(msgMap);
    }
}
