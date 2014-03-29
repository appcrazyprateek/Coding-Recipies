package blog.mst.prims;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Prims MST Node
 * @author Prateek
 *
 */
class AdjListNode {
 int dest;
 int weight;
 AdjListNode next;


 AdjListNode(int dest,int weight)
 {
  this.dest=dest;
  this.weight=weight;
  this.next=null;
 }

 public String toString()
 {
  return "" + dest + " - " + weight;
 }
}

/**
 * Prims MST graph
 * @author Prateek
 *
 */
public class PrimsMST {

 // Number of vertices in the graph
 int numVertices;
 public static final int INF=9999999;

 // Adjacecny list of vertices
 Map<Integer,LinkedList<AdjListNode>> adjList;

 // Heap , containis all those node which have not been included
 TreeMap<Integer,Integer> heap=new TreeMap<Integer,Integer>();

 public PrimsMST(int numVertices) {
  this.numVertices=numVertices;
  this.adjList=new TreeMap<Integer,LinkedList<AdjListNode>>();
 }

 /**
  * Edge Being added to the graph
  * @param graph
  * @param src : Source Node
  * @param dest : desitination node
  * @param weight: Edge distance
  */
 private void addEdge(PrimsMST graph, int src, int dest, int weight) {
  AdjListNode node=new AdjListNode(dest, weight);
  LinkedList<AdjListNode> list=null;

  // Adding adjacent node for source
  list= adjList.get(src);
  if(list ==null)
   list=new LinkedList<AdjListNode>();

  list.addFirst(node);
  adjList.put(src, list);
  
  //---- Again adjacent node for dest as , graph is undirected ----
  node=new AdjListNode(src, weight);
  
  list=null;
  
  list=adjList.get(dest);
  if(list ==null)
   list=new LinkedList<AdjListNode>();

  list.addFirst(node);

  adjList.put(dest, list);
 }


 /**
  * Method to find Prims MST
  * @param graph
  */
 public void PrimeMST(PrimsMST graph) {
  // List to Store MST formed
  Map<Integer,Integer> MSTholder=new TreeMap<Integer,Integer>();

  // initialize heap Except root
  Set<Integer> set=adjList.keySet();

  // Heap Creation for all keys in adjacency list
  for(Integer i:set)
  {
   createHeap(i,INF);
  }

  // Main Algo starts here , all initialisation over
  while(heap.size()!=0)
  {
   int minEdgeVertex=findMin(); // get the vertex with minimum edge in the heap
   heap.remove(minEdgeVertex);  // node removed from heap and its moves to the Set s.

   LinkedList<AdjListNode> list=adjList.get(minEdgeVertex);
   Iterator<AdjListNode> it=list.iterator();
   
   while(it.hasNext())
   {
    AdjListNode node=it.next();
    int vertex=node.dest;

    if( (heap.containsKey(vertex)) && (node.weight < INF))
    {
     heap.put(vertex,node.weight); // decreasing node value
     MSTholder.put(vertex, minEdgeVertex);
    }
   }
  }

  //TODO : uncomment if u wish to print Node of MST
  //printMST(MSTholder);
  long cost =MSTCost(MSTholder);
  System.out.println("Cost is :" + cost);

 } 

 /**
  * 
  * @param MSTholder
  * @return cost of the spanning tree
  */
 private long MSTCost(Map<Integer,Integer> MSTholder) {
  Set<Map.Entry<Integer,Integer>> set=MSTholder.entrySet();

  long sum=0;
  for (Map.Entry<Integer, Integer> entry :set)
  {

   int key=entry.getKey();
   int value=entry.getValue();
   
   List<AdjListNode> list=adjList.get(value);
   if(list!=null)
   {
    for(int j=0;j<list.size();j++)
    {
     AdjListNode node=list.get(j);
     if((node.dest) == key )
     {
      sum+=node.weight;
     }
    }
   }
  }
  return sum;
 }

 /**
  * Print the Prim;s MST at the end
  * @param MSTholder
  */
 private void printMST(Map<Integer,Integer> MSTholder) {

  System.out.println(" MST is : ");
  Set<Map.Entry<Integer,Integer>> set=MSTholder.entrySet();

  for (Map.Entry<Integer, Integer> entry :set)
  {
   System.out.println(entry.getKey() + " -- " + entry.getValue());
  }
 }

 /**
  * Heap Creation of all nodes in the graph
  * @param vertex
  * @param weight
  */
 public void createHeap(int vertex, Integer weight) {
  if(heap == null)
   heap=new TreeMap<Integer,Integer>();

  heap.put(vertex,weight);
 }

 /**
  * 
  * @return the minimum key for a given value 
  * here key is "node"
  * and value is "weight" of all edges in the heap
  */
 private int findMin() {
  Set<Map.Entry<Integer, Integer>>list=heap.entrySet();

  int minKey=heap.firstKey();
  int minValue=INF;
  if(list !=null)
  {
   for(Map.Entry<Integer, Integer> entry: list)
   {
    if(minValue > entry.getValue())
    {
     minValue=entry.getValue();
     minKey=entry.getKey();
    }
   }
  }
  return minKey;
 }


 public static void main(String[] args) throws Exception {
  helper();
 }

 private static void helper() throws Exception {

  int numvertices=9;

  PrimsMST graph =new PrimsMST(numvertices);
  graph.addEdge(graph, 0, 1, 4);
  graph.addEdge(graph, 0, 7, 8);
  graph.addEdge(graph, 1, 2, 8);
  graph.addEdge(graph, 1, 7, 11);
  graph.addEdge(graph, 2, 3, 7);
  graph.addEdge(graph, 2, 8, 2);
  graph.addEdge(graph, 2, 5, 4);
  graph.addEdge(graph,3, 4, 9);
  graph.addEdge(graph, 3, 5, 14);
  graph.addEdge(graph,  4, 5, 10);
  graph.addEdge(graph,  5, 6, 2);
  graph.addEdge(graph, 6, 7, 1);
  graph.addEdge(graph, 6, 8, 6);
  graph.addEdge(graph, 7, 8, 7);

  graph.PrimeMST(graph);

 }
}