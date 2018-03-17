package com.xiao.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;
/*Collection 是抽象类，所以不能创建对象，
   只能通过其子类来学习它里面的方法
  它里面的方法是所有集合实现类中必有的方法
 ArrayList 实现类List接口
 List接口 继承了Collection
  所以ArrayList重写了Collection里面所有的方法
*/
/**
 * @author 笑笑
 * @Date   2018年2月8日上午11:03:39
 *	
 */
public class CollectionDemo {
	
	//void clear() 方法
	@Test
	public void test1(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					//添加元素方法
		coll.add("cde");
		System.out.println(coll);
		coll.clear();						//清除集合中所有元素
		System.out.println(coll);
	}
	
	//boolean contains(Object o) 方法
	@Test
	public void test2(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		boolean b = coll.contains("abc");   //判断对象是否存在于集合中
		System.out.println(b);
	}
	//int size() 方法
	@Test
	public void test3(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		int i = coll.size();				//返回元素个数
		System.out.println(i);
	}
	// Object[] toArray() 方法
	@Test
	public void test4(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		Object[] array = coll.toArray();    //把集合中的元素转成一个数组
		for (Object object : array) {
			System.out.println(object);
		}
	}
	//boolean remove(Object o) 方法  
	@Test
	public void test5(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		boolean b = coll.remove("abc"); 	//移除集合中的指定的元素，如果存在返回true
		System.out.println(b);
	}
	
	//迭代器  Iterator<E>接口    集合通用的迭代方式    
	//boolean hasNext()  //判断集合中是否还有可以被取出的元素，有返回true
	//E next() 			 //取出集合中的下一个元素
    @Test
    public void test6(){
    	Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		Iterator<String> iterator = coll.iterator();
		while(iterator.hasNext()){			//如果有元素，取出来，如果没有结束循环
			String next = iterator.next();
			System.err.println(next);
		}
    }
    //增强for循环 遍历集合 、数组                 
    //弊端：没有索引，不能操作容器里面的元素
    @Test
    public void test7(){
    	Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		for (String string : coll) {
			System.out.println(string.length());	//遍历的时候可以调用对象的方法
		}
    }

}
