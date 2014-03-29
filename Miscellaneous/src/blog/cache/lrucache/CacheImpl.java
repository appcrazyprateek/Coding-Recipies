/*package blog.cache.lrucache;

public class CacheImpl implements Cache{

	public static final int SCHEME_LFU_CACHE=1;
	public static final int SCHEME_LRU_CACHE=2;
	
	private int DEFAULT_SCHEME = SCHEME_LRU_CACHE;
	private LFUCache lfu;
	private LRUCache lru;
	
	public CacheImpl(int size , int evictionScheme){
		
		this.DEFAULT_SCHEME = evictionScheme;
		
		if(DEFAULT_SCHEME == SCHEME_LFU_CACHE)
			lfu = new LFUCache();
		else if(DEFAULT_SCHEME == SCHEME_LRU_CACHE)
			lru = new LRUCache(size);
	}

	@Override
	public void put(String key, String val) {
		if(DEFAULT_SCHEME == SCHEME_LFU_CACHE)
			lfu.put(key, val);
		else if(DEFAULT_SCHEME == SCHEME_LRU_CACHE)
			lru.put(key, val);
		
	}

	@Override
	public String get(String key) {
		String data = null;
		
		if(DEFAULT_SCHEME == SCHEME_LFU_CACHE)
			data= lfu.get(key);
		else if(DEFAULT_SCHEME == SCHEME_LRU_CACHE)
			data= lru.get(key);
		
		return data;
	}
}
*/