package blog.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RookMovement {


	
	public int solve(int A, int B, int C, int D , ArrayList<String> E) {
		
		int[][] matrix = getMatrix(E);
		
		Point start = new Point(A, B);
		Point end = new Point(C, D);
		
		Set<Point> visitStatus = new HashSet<>();
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		queue.add(null);
		
		while (!queue.isEmpty()) {
				Point polledPoint = queue.poll();
		}
		
		
		return D;
		
	}
	
	public List<Point> getTopChilds(Point point, int[][] matrix) {
		
		List<Point> topChilds = new ArrayList<>();
		for(int i = point.y -1 ; i> 0 ; i--) {
			
			
		}
		
		return null;
		
	}
	
	
	
	public int[][] getMatrix(ArrayList<String> E) {
	
		if(E==null || E.isEmpty())
			return new int[0][0];
		
		int colLength = E.get(0).length();
		int rowLength = E.size();
		
		int[][] matrix = new int[rowLength][colLength];
		
		for(int i = 0 ; i < colLength ; i++) {
			char[] row = E.get(i).toCharArray();
			for(int j = 0 ; j < rowLength ; j++)
				matrix[i][j] = row[j];
		}
		return matrix;
	}
	
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return x * 10 + y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point point = (Point) obj;
				if (point.x == this.x && point.y == this.y)
					return true;
			}
			return false;
		}
	}
}
