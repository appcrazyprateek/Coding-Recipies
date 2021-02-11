import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class FirstUnique {
    private Map<Integer,Integer> map = new LinkedHashMap<>();
    
    public FirstUnique(int[] nums) {
       for(int num:nums){
           add(num);
       }
    }
    public int showFirstUnique() {
        Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
       while(itr.hasNext())
       {
    	   Entry<Integer, Integer> e = itr.next();
    	   if(e.getValue() == 1)
    		   return e.getKey();
       }
        return -1;
    }
    public void add(int value) {
        map.put(value, map.get(value)+1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */