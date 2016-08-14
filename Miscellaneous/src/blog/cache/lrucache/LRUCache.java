package blog.cache.lrucache;

import java.util.HashMap;

/**
 * LRU Cache implementation
 * @author Prateek
 */
public class LRUCache implements Cache{

//  Item Node structure in the LRU Cache
	  
 class Item	 {
	public Item prev;
	public Item next;
	public String key;
	public String data;

	public Item(){}

	public Item(String key, String data){
		this.key = key;
		this.data = data;
	}
	
	@Override
	public String toString(){
		return this.key+" : "+this.data;
	}
}
	
	public Item head; 
	public Item tail;
	public int maxsize;

	//to hold key for every item
	private HashMap<String,Item> hash;

	public LRUCache(int size) {
		this.maxsize = size ;
		hash = new HashMap<String,Item>();
		head = new Item("0","0");
		tail = new Item("0","0");
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
		if(item!=null)
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
	public void put(String key, String data){
		Item item = hash.get(key);
		if(item==null) //item not found 
		{
			item = new Item(key,data);
			hash.put(key,item);
			addItemAtFirst(item);
			if(hash.size() == maxsize)
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
		// TODO Auto-generated method stub
		return false;
	}
}
