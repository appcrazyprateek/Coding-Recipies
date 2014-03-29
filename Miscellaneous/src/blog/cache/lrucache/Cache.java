package blog.cache.lrucache;

public interface Cache {

	public void put(String key, String val);
	public String get(String key);
	public boolean isFull();
}
