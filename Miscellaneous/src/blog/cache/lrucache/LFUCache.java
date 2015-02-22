package blog.cache.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Item implements Comparable<Item>{
	public String key;
	public String val;
	public int count;
	
	public Item(String key, String val) {
	this.key = key;
	this.val= val;
	}
	
	@Override
	public String toString(){
		return key + ":" + val + ":" + count ;
	}

	@Override
	public int compareTo(Item that) {
		return this.count - that.count;
	}
}
/**
 * LFU Cache implementation 
 * @author Prateek
 */
public class LFUCache implements Cache{

	private Queue<Item> pq;
	private Map<String,Item> map;
	private static final int DEFAULT_SIZE = 5;
	private int size;

	public LFUCache() {
		this.size= DEFAULT_SIZE;
		pq = new PriorityQueue<Item>(size);
		map = new HashMap<String, Item>(size);
	}

	public LFUCache(int size) {
		this.size=size;
		pq = new PriorityQueue<Item>(size);
		map = new HashMap<String, Item>(size);
	}

	@Override
	public String get(String key){
		Item item= null;
		if(map.containsKey(key)){
				 item = map.get(key);
				pq.remove(item);
				item.count++;
				pq.add(item);
				return item.val;
		}
		else //hit DB to get Data
			return null;
		
	}

	@Override
	public void put(String key, String data){
		if(map.containsKey(key))
		{
			Item item = map.remove(key);
			pq.remove(item);
		}
		if(pq.size() > size)
		{
			Item item= pq.remove();
			map.remove(item.key);
		}
		//updating or adding value for the key
		Item item = new Item(key,data);
		map.put(key, item);
		pq.add(item);
	}
	
	@Override
	public boolean isFull(){
		return map.size()>=size;
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache();
		cache.put( "1","One");
		cache.put( "2","two");
		cache.put( "3","three");
		cache.put( "3","four");
		cache.put( "4","four");
		cache.put( "5","five");
		cache.get( "5");
		cache.get( "5");
		cache.get( "3");
		cache.get( "3");
		cache.get("4");
	}
}