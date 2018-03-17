package com.xiao.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
/**
 * @author 笑笑
 * @Date   2018年2月8日上午11:03:45
 *	
 */
public class ListDemo {
	
	// void add(int index, E element) 根据索引插入元素
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		System.out.println(list);
		list.add(1, "cde");					//根据索引插入元素，索引上原有的数据往后顺延
		System.out.println(list);
	}
	// E get(int index) 返回集合中指定位置的元素
	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		list.add("abc");
		String a = list.get(2);			    //根据索引取元素
		System.out.println(a);
	}
	// E remove(int index)   移除指定位置上的元素，返回移除的元素
	@Test
	public void test3(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		String remove = list.remove(1);		//移除指定位置的元素  返回移除的元素
		System.out.println(remove);
		System.out.println(list);
	}
	// E set(int index, E element)    修改指定位置的元素  返回修改之前的元素
	@Test
	public void test4(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		String set = list.set(1, "123");	//修改指定位置的元素  返回修改之前的元素
		System.out.println(set);
		System.out.println(list);
	}
	//迭代器的并发修改异常
	@Test
	public void test5(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string = iterator.next();
			if(string.equals("fff")){
				list.add("ccc");				//如果取出来的元素等于fff  就添加一个ccc  这样会出现并发修改异常
			}
			System.out.println(list);
		}
		
	}
	
	
	//LinkedList的特性
	//void addFirst(E e)  在列表的开头添加元素
	//void addLast(E e)   在列表的结尾添加元素
	// E getFirst() 	     获取链表的第一个元素
	// E getLast() 	  	     获取链表的第一个元素
	// E removeFirst 	    移除并返回此列表的第一个元素
	// E removeLast 	    移除并返回此列表的最后一个元素
	 
	@Test
	public void test6(){
		LinkedList<String> list = new LinkedList<>();
		list.add("abc");
		list.addFirst("ced");					//在列表的开头添加元素
		list.addLast("ccc"); 					//在列表的结尾添加元素
		System.out.println(list);
		
		if(list.isEmpty()){						//如果链表为空  则不能取元素   
			String first = list.getFirst();		//获取链表的第一个元素
			String last = list.getLast();		//获取链表的第一个元素
			System.out.println(first);
			System.out.println(last);
		}
	}
	
	
}
