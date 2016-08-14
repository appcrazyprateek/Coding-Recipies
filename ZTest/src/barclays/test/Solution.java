package barclays.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	// T[]={9,1,4,9,0,4,8.9,0,1}
		static class VertexD implements Comparable<VertexD>{
			public String label;
			public int index;
			public int weight;
			public VertexD prev;
			public boolean visited;
			public VertexD(String label, int index){
				this.label=label;
				visited=false;
				prev=null;
				weight=1;
				this.index=index;
			}
			
			public String toString(){
				return this.label+"";
			}

			@Override
			public int compareTo(VertexD v) {
				// TODO Auto-generated method stub
				if(this.weight<v.weight)
					return -1;
				else if(this.weight==v.weight)
					return 0;
				else
					return 1;
			}
		}
		
		
		private int maxVer;
		private VertexD vertexList[];
		private int adjMatrix[][];
		private int verCount;
		private int dis[];
		private PriorityQueue<VertexD> q; 
		

		/*public Solution(int n){
			maxVer=n;
			vertexList= new VertexD[maxVer];
			adjMatrix = new int[maxVer][maxVer];
			dis = new int[maxVer];
			verCount=0;
			for(int i=0;i<maxVer;i++){
				for(int j=0;j<maxVer;j++){
					adjMatrix[i][j]=0;
				}
			}
			for(int i=0;i<maxVer;i++)
				dis[i]=-1;
			q= new PriorityQueue<VertexD>();
		}*/

		public void addVertex(String label){
			vertexList[verCount]=new VertexD(label,verCount++);
		}
		
		public void addDirectedEdge(int start,int end,int priority){
			adjMatrix[start][end]=1;	
			vertexList[end].weight=priority;
		}
		
		public int getAdjUnvisitedVer(int v){
			for(int i=0;i<verCount;i++)
				if(adjMatrix[v][i]==1 && (!vertexList[i].visited))
					return i;
			return -1;
		}
		
		public int[] traverse(int s){
			q.add(vertexList[s]);
			vertexList[s].weight=0;
			dis[s]=0;
			VertexD temp;
			int v,d;
			while(!q.isEmpty()){
				temp=q.poll();
				while((v=getAdjUnvisitedVer(temp.index))!=-1){
					vertexList[v].visited=true;
					d=dis[temp.index]+vertexList[v].weight;
					if(dis[v]==-1){
						dis[v]=d;
						q.add(vertexList[v]);
						vertexList[v].weight=d;
						vertexList[v].prev=temp;
					}
						
					if(d<dis[v]){
						dis[v]=d;
						vertexList[v].weight=d;
						vertexList[v].prev=temp;
					}
						
				}
				
				
			}
			
					Arrays.sort(this.dis);
			
			return this.dis;
		}
		
		
		
		public static void main(String[] args){
			int[] T= new int[]{9,1,4,9,0,4,8,9,0,1};
			Solution g= new Solution();
			g.solution(T);
			//System.out.println(T);
			//return new int[]{};
		}
		
		public int[] solution(int[] T)
		{
			maxVer=T.length;
			vertexList= new VertexD[maxVer];
			adjMatrix = new int[maxVer][maxVer];
			dis = new int[maxVer];
			verCount=0;
			for(int i=0;i<maxVer;i++){
				for(int j=0;j<maxVer;j++){
					adjMatrix[i][j]=0;
				}
			}
			for(int i=0;i<maxVer;i++)
				dis[i]=-1;
			q= new PriorityQueue<VertexD>();
			
			//int[] T= new int[]{9,1,4,9,0,4,8,9,0,1};
			//Solution g= new Solution(T.length);
			int capital=0;
			for(int i=0;i<T.length;i++){
				addVertex(i+"");
				if(i==T[i])
					capital=i;
			}
			
			for(int i=0;i<T.length;i++){
				addDirectedEdge(i, T[i], 1);
				addDirectedEdge(T[i], i, 1);
			}	
			int[] dist = traverse(capital);
		//	System.out.println(Arrays.toString(dist));
			
			int[] result = new int[T.length-1];
			for(int i=0;i<dist.length;i++)
			{
				int num = dist[i]-1;
				if(num>=0)
					result[num]++;
			}
			
			
			System.out.println(Arrays.toString(result));
			return result;
		}
		
	}
