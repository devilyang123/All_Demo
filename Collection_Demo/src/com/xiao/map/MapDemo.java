package com.xiao.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;
/**
 * @author 笑笑
 * @Date   2018年2月9日下午8:37:47
 *	
 */
public class MapDemo {
	
	// V put(K key, V value) 方法  添加键值对，返回值一般情况下为null,存储重复键时，返回覆盖之前的值
	@Test
	public void test1(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "笑笑");
		map.put("username", "哈哈");						//键唯一，相同键会覆盖
		map.put("username1", "笑笑");
		String value = map.put("username", "笑笑");		//返回值一般情况下为null,存储重复键时，返回覆盖之前的值
		System.out.println(value);
		System.out.println(map);
	}
	// V get(Object key) 方法  通过键对象 获取值对象
	@Test
	public void test2(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "笑笑"); 
		String string = map.get("username");	// 通过键对象 获取值对象  如果没有这个键，返回null
		System.out.println(string);
	}
	// V remove(Object key) 方法  移除集合中的键值对，返回移除之前的值
	@Test
	public void test3(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "笑笑"); 
		String remove = map.remove("username");	//移除集合中的键值对，返回移除之前的值  如果没有 返回null
		System.out.println(remove);
	}
	
	
	
	//Map集合的遍历	 Set<K> keySet()  把所有的Key放到了一个Set集合中  （键获取值的方式）
	@Test
	public void test4(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "笑笑"); 
		map.put("username1", "哈哈"); 
		map.put("username3", "嘻嘻"); 
		Set<String> set = map.keySet();    //调用keySet()方法 把键存储到Set集合中（是HashMap中的一个内部类实现的）
		
		for (String key : set) {		   //遍历set集合，获取所有的key
			String value = map.get(key);   //调用map的get方法获得key对应的值	
			System.out.println(value);
		}
	
	}
	// Set<Map.Entry<K,V>> entrySet()   通过键值对的映射关系来遍历
	@Test
	public void test5(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "笑笑"); 
		map.put("username1", "哈哈"); 
		map.put("username3", "嘻嘻"); 
		
		Set<Entry<String,String>> set = map.entrySet();		//将映射关系对象存储到se集合
		
		for (Entry<String, String> entry : set) {			//遍历set集合
			//System.out.println(entry);					//获得键值对  对像entry
			/*String key = entry.getKey();					//通过getKet获得键
			System.out.println(key);*/
			String value = entry.getValue();				//通过getValue获得值
			System.out.println(value);
		}
	}
	
	//HashMap 的遍历 与上面方式一致
	@Test
	public void test6(){
		HashMap<String,String> map = new HashMap<>();
		map.put("username", "笑笑"); 
		map.put("username1", "哈哈"); 
		map.put("username3", "嘻嘻");
		
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(value);
		}
		
	}
	//LinkedHashMap,继承自HashMap,保证了迭代的顺序
	@Test
	public void test7(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("a", "笑笑");
		map.put("b", "笑笑1");
		map.put("c", "笑笑2");
		System.out.println(map);
	}
}
