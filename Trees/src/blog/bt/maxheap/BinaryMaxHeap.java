package blog.bt.maxheap;

/**
 * Binary Max Heap operations
 * @author Prateek
 *
 */
public class BinaryMaxHeap {

	private int[] heap; //Heap containing Element
	private int heapSize; // Number of element in the heap

	public BinaryMaxHeap(int size) {
		this.heap=new int[size];
		this.heapSize = 0;
	}

	public boolean isEmpty(){
		return heapSize == 0;
	}
	/**
	 * Insert Key into Heap
	 * @param val : key to be inserted in the heap
	 * @throws HeapException : Incase Heap is full
	 */
	public void insert(int val) throws HeapException{
		if(heapSize  == heap.length)
			throw new HeapException("Heap Leakage , Overflowing");
		else{
			System.out.println("Insert : " +val);
			heap[++heapSize]=val;
			swim(heapSize);
		}
	}

	private void swim(int index) {
		while(index > 1 && isLess(index/2, index))
		{
			swap(index/2 , index) ;
			index = index / 2 ;
		}
	}
	
	/**
	 * @return peek max element of the heap
	 */
	public int getMax(){
		return heap[1];
	}
	
    /**
     * @return max Element from Heap and remove from heap
     */
	public int delMax(){
		int max=heap[1];
		heap[1] = heap[heapSize--] ;
		sink(1);
		return max;
	}

  /**
   * Sink down operation to 
   * @param index : index of the root
   */
	private void sink(int index) {
		while(2*index < heapSize) {

			int child= 2*index;  //first child

			if(child < heapSize && isLess(child, child + 1 )) // to pick the higher child
				child++; //second child

			if(!isLess(index, child)) //break if parent is higher than both children
				break;

			swap(index , child);
			index=child;
		}
	}

	private void swap(int index1, int index2){
		int temp = heap[index1];
		heap[index1] = heap[index2] ;
		heap[index2] = temp;
	}

	/**
	 * @param parentIndex
	 * @param childIndex
	 * @return true if parent is smaller than child
	 */
	private boolean isLess(int parentIndex , int childIndex){
		return Integer.compare(heap[parentIndex], heap[childIndex]) < 0 ? true : false; 
	}

	
	public static void main(String[] args) throws HeapException {
		BinaryMaxHeap bHeap=new BinaryMaxHeap(10);
		bHeap.insert(5);
		bHeap.insert(15);
		bHeap.insert(3);
		bHeap.insert(6);
		bHeap.insert(11);
		bHeap.insert(2);
		bHeap.insert(1);
		bHeap.insert(17);
		bHeap.insert(18);
		
		System.out.println("Max Item :" +bHeap.delMax());
		bHeap.print();
		
	}
	
	public void print(){
		System.out.print("Heap is : ");
		for(int i=1;i< heap.length ;i++)
			System.out.print(heap[i] + "\t" );
	}
	
	class HeapException extends Exception{
		public HeapException(String msg) {
			super(msg);
		}
	}
}
