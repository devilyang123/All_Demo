package com.xiao.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
/**
 * @author 笑笑
 * @Date   2018年2月8日下午2:09:55
 *	
 */
public class SetDemo {
	
	//set接口的实现类 HashSet来演示
	//set是存取无序的集合
	
	@Test
	public void test1(){
		Set<String> set = new HashSet<>();		
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");							
		set.add("ddd");							//不允许存储重复  自动忽略重复的元素（根据哈希值来判断是否重复 ，相等则表示重复）
		for (String string : set) {				//取出元素的顺序与存的顺序不一致
			System.out.println(string);			
		}
		
	}
	//set接口的实现类 LinkedHashSet
	//LinkedHashSet有自身的特性，具有顺序，存、取的顺序一致
	@Test
	public void test2(){
		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		link.add(1);
		link.add(2);
		link.add(3);
		for (Integer integer : link) {
			System.out.println(integer);
		}
		
	}
}
