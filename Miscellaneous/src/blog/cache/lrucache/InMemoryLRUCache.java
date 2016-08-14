package blog.cache.lrucache;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import blog.cache.lrucache.LRUCache.Item;

public class InMemoryLRUCache implements Cache {

//  Item Node structure in the LRU Cache
	  
 class Item	extends TimerTask {
	public long ttl; 
	public boolean isAlive = true;
	public Item prev;
	public Item next;
	public String key;
	public String data;

	public Item(){}

	public Item(String key, String data, long ttl){
		this.key = key;
		this.data = data;
		this.ttl=ttl;
	}
	
	@Override
	public String toString(){
		return this.key+" : "+this.data;
	}

	@Override
	public void run() {
		isAlive = true;
		try {
			this.wait(ttl);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isAlive = false;
	}
}
	
	public Item head; 
	public Item tail;
	public int maxsize;

	//to hold key for every item
	private HashMap<String,Item> hash;

	public InMemoryLRUCache(int size) {
		this.maxsize = size ;
		hash = new HashMap<String,Item>();
		head = new Item("0","0",0l);
		tail = new Item("0","0",0l);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Add item to the beggining of Linked List
	 * @param item
	 */
	public void addItemAtFirst(Item item){
		item.next = head.next;
		item.prev = head;
		head.next.prev = item;
		head.next = item;
		Timer t = new Timer();
		t.schedule(item, item.ttl);
	}

	/**
	  Remove item from the Linked List
	  @param item
	 */
	public void removeItem(Item item){
		item.prev.next = item.next;
		item.next.prev = item.prev ;
	}

	/**
	 * @return the value , and remove the node from between and add to the 
	  *                    the beggining
	 */
	public String get(String key){

		Item item= hash.get(key);
		if(item!=null && item.isAlive)
		{
			if(hash.size()==1)
				return item.data;
			
			removeItem(item);
			addItemAtFirst(item);
			return item.data;
		}
		else
			return null;
	}

	/**
	 * Insert to hashmap and linkedlist, if size is exceeded remove the tail element
	*/
	public void put(String key, String data, long ttl){
		Item item = hash.get(key);
		if(item==null) //item not found 
		{
			item = new Item(key,data, ttl);
			hash.put(key,item);
			addItemAtFirst(item);
			if(isFull())
			{
				hash.remove(tail.prev.key);
				removeItem(tail.prev);
			}
		}
		else //item found in the hashmap, update data
		{   item.data = data;
			removeItem(item);
			addItemAtFirst(item);
		}
	}
	
	/**
	 * Display Cache Content
*/
	public void displayLRUCache(){
		System.out.println("Items in the Cache");
		Item temp=head.next;
		while(temp.next!=null)
		{
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		int size= 9 ;
		LRUCache cache = new LRUCache(size);
		cache.put( "1","1");
		cache.put( "2","2");
		cache.put( "3","3");
		cache.put( "4","4");
		cache.put( "5","5");
		cache.put( "5","15");
		cache.put( "6","6");
		cache.put( "7","7");
		cache.put( "8","8");
		cache.put( "9","9");
		cache.put( "10","10");
		cache.put( "11","11");
		cache.put( "12","12");
		
		cache.displayLRUCache();
	}

	@Override
	public boolean isFull() {
		return hash.size() == maxsize;
		
	}

	@Override
	public void put(String key, String val) {
		// TODO Auto-generated method stub
		
	}
}

class ABC extends TimerTask{

	long time = 0l;
	boolean isAlive = true;
	
	public ABC(long time){
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Time Passed");
		isAlive = false;
	}
	
}
