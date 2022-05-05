import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author: mini
 * @Date: 2022-04-28 10:21
 * @Description: LRU，即 Least Recently Use ，直译为 “最近最少使用”。它是根据数据的历史访问记录来进行数据淘汰的，淘汰掉最先访问的数据，其核心思想是 如果数据最近被访问过，那么将来被访问的几率也会更加高 。
 *
 * 要实现 LRU，需要做到两点：
 *
 * 查询出最近最晚使用的项
 * 给最近使用的项做一个标记
 */

public class LRUTest {
    /**
     *功能描述
     * LinkHashMap  查询之后会把查询的元素放到最后一位
     *
     *
     *
     */

    @Test
    public void test(){
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(10, 0.75f, true);
        linkedHashMap.put("1","a");
        linkedHashMap.put("2","b");
        linkedHashMap.put("3","c");
        linkedHashMap.put("4","d");

        System.out.println("原始数据：");
       for (Iterator<Map.Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();iterator.hasNext();){
           System.out.print(iterator.next().getKey()+" ");
       }
        System.out.println();
       linkedHashMap.get("2");
        System.out.println("访问2之后：");
        for (Iterator<Map.Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();iterator.hasNext();){
            System.out.print(iterator.next().getKey()+" ");
        }


        LinkedHashMap<String, Object> stringObjectLinkedHashMap = new LinkedHashMap<>();


    }
}
