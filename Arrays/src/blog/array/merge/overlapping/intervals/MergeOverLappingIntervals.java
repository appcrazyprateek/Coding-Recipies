/**
 * 
 */
package blog.array.merge.overlapping.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval{
	int start,end ;
	
	public Interval(){start = 0;end = 0;}
	public Interval(int s, int e) { this.start = s; this.end = e; }
}

/**
 * 
 * @author rpratee
 *
 */
public class MergeOverLappingIntervals {


	
	class IntervalCompartor implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
				int diff = o1.start - o2.start;
				if(diff == 0)
					diff = o1.end - o2.end ;
				return diff;
		}
	}
	
	public static void main(String[] args) {
		MergeOverLappingIntervals obj = new MergeOverLappingIntervals();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(1, 3));
		
		obj.mergeOverLappingIntervals(intervals);
	}
	
	/*
	 * Merging the interval
	 */
	List<Interval> mergeOverLappingIntervals(List<Interval> intervals){
	
		List<Interval> result  = new ArrayList<Interval>();
		Collections.sort(intervals, new IntervalCompartor());
		
		int len  = intervals.size();
		for(int i=0;i<len;){
			Interval currInterval = new Interval(intervals.get(i).start,intervals.get(i).end);
			Interval nextInterval = null;
			i++;
			while(i<len)
			{
				nextInterval = intervals.get(i); 
				if(isOverlap(currInterval, nextInterval)){
					currInterval.start = Math.min(currInterval.start, nextInterval.start);
					currInterval.end = Math.max(currInterval.end, nextInterval.end);
				}
				else
					break;
			}
			result.add(currInterval);
		}	
		return result;
	}
	
	public boolean isOverlap(Interval a, Interval b){
		if(Math.max(a.start, b.start)  > Math.min(a.end,b.end)){
			return true;
		}
		return false;
	}
	
}
