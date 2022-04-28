package com.qsh.code.basics;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * CopyOnWriteArrayList的基础结构
 *
 * @author: mini
 * @Date: 2022-04-28 13:41
 * @Description: CopyOnWriteArrayList的基础结构
 */

public class Basics {
    /**
     *功能描述:CopyOnWriteArrayList是ArrayList的线程安全版本，内部也是通过数组实现，每次对数组的修改都完全拷贝一份新的数组来修改，
     * 这样保证了只阻塞写操作，不阻塞读操作，实现读写分离。
     *
     *
     * CopyOnWriteArrayList实现了List, RandomAccess, Cloneable, java.io.Serializable等接口。
     * CopyOnWriteArrayList实现了List，提供了基础的添加、删除、遍历等操作。
     * CopyOnWriteArrayList实现了RandomAccess，提供了随机访问的能力。
     * CopyOnWriteArrayList实现了Cloneable，可以被克隆。
     * CopyOnWriteArrayList实现了Serializable，可以被序列化。
     */

    /**
     * 用于修改时加锁
     * final transient ReentrantLock lock = new ReentrantLock();
     *  真正存储元素的地方，只能通过getArray()/setArray()访问
     * private transient volatile Object[] array;
     **/


    @Test
    public void test(){
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>(10,0.75f,true);
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("c",3);
        hashMap.put("d",4);


        System.out.println("取出来之前的顺序：");
        for ( Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();iterator.hasNext();){
            System.out.print(iterator.next().getKey()+" ");
        }

        hashMap.get("c");
        System.out.println();


        System.out.println("取出来之后的顺序：");
        for ( Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();iterator.hasNext();){
            System.out.print(iterator.next().getKey()+" ");
        }

    }


}
