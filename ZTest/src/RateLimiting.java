import java.util.HashMap;
import java.util.Map;

interface RateLimiter {
	boolean isRateLimit(int customerId);
}

public class RateLimiting implements RateLimiter{
	private static final int DEFAULT_TOKENS = 5;
	private static final long RATE_TIME_CONFIG = 5000L;
	private Map<Integer,Integer> tokens = new HashMap<>();
	private Map<Integer,Long> customerTimeMapping = new HashMap<>();
	
	public boolean isRateLimit(int customerId) {
		if(!tokens.containsKey(customerId)) {
			tokens.put(customerId, DEFAULT_TOKENS - 1);
			customerTimeMapping.put(customerId, System.currentTimeMillis());
			return true;
		}
			
		int leftTokens = tokens.get(customerId);
		if(leftTokens > 0) {
			tokens.put(customerId, leftTokens-1);
			customerTimeMapping.put(customerId, System.currentTimeMillis());
			return true;
		}
		else {
			long currentTime = System.currentTimeMillis();
			long lastRequetTime = getLastRequestTime(customerId);
			
			boolean refillBucket = isRefillRequired(currentTime, lastRequetTime);
			if(refillBucket) {
				tokens.put(customerId, DEFAULT_TOKENS-1);
				customerTimeMapping.put(customerId, System.currentTimeMillis());
				return true;
			}
			return false;
		}
	}
	
	private boolean isRefillRequired(long currentTime, long lastRequetTime) {
		long timeDiff = currentTime - lastRequetTime;
		if(timeDiff > RATE_TIME_CONFIG) {
			return true ;
		}
		return false;
	}

	private long getLastRequestTime(int customerId) {
		if(!customerTimeMapping.containsKey(customerId)) {
			return System.currentTimeMillis();
		}
		return customerTimeMapping.get(customerId);
	}
	
	private static void sleep(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}
	  
	
	public static void main(String[] args) throws InterruptedException {
		RateLimiter rateLimiter = new RateLimiting();
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		sleep(5);
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		
		sleep(2);
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
		System.out.println(rateLimiter.isRateLimit(1));
			

	}
	
	
}
