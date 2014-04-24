package blog.linkedlist.misc;

/**
 * Interface to access comparator 
 */
interface SortableObject {
/**
 * @paramotherObj – other SortableObject being compared to the current
 * @return
 * 1 if otherObj is “less than” the current object
 * 0 if otherObj is “equal” to the current object
 * -1 if otherObj is “greater than” the current object.
 */
	int compare(SortableObject otherObj);
}

 class DataLink {

	public DataLink m_next;	// next Link in chain or null if none
	public DataLink m_prev;	// prev link in chain or null if none
	public SortableObject m_object;// the object stored in the link
}

 class DataChain {
		
	 DataLink m_first;// the first DataLink in the chain, or null if empty.
	 	
	 /**
	  * DataChain constructor
	  */
	 	public DataChain() {
	 		m_first = null;
	 }

	 /**
	  * Adds the provided SortableObject to the front of the DataChain. 
	  * m_first will point to this object upon completion
	  * @paramnewObj – the object being added
	  */
	 public void addToFront(SortableObject newObj) {
	 	// TODO
	 if(m_first==null)
	 { 
	 		m_first = new DataLink();
	 		m_first.m_object=newObj;
	 		m_first.m_next=m_first;
	 		m_first.m_prev=m_first;
	 }
	 //if not the first element create new datalink and update the next and prev links
	 else{
	 	DataLink newlink=new DataLink();
	 	newlink.m_object=newObj;
	 	DataLink m_last=m_first.m_prev;
	 	m_last.m_next=newlink;
	 	newlink.m_next=m_first;
	 	m_first.m_prev=newlink;
	 	}
	 }

	 /**
	  * Adds the provided SortableObject to the back of the DataChain. 
	  * @paramnewObj – the object being added
	  */
	 public void addToBack(SortableObject newObj) {

	 	// TODO
	 DataLink newlink=new DataLink();
	 newlink.m_object=newObj;
	 newlink.m_prev=m_first.m_next;


	 }

	 /**
	  * Inserts the provided SortableObject in front of the first DataLink that 
	  * is “less than” the new object.
	  * @paramnewObj – the object being added
	  */
	 public void insert(SortableObject newObj) {

	 	// TODO
	 DataLink newlink=new DataLink();
	 newlink.m_object=newObj;

	 if(m_first==null)
	 {
	 m_first = new DataLink();
	 m_first.m_object=newObj;
	 m_first.m_next=m_first;
	 m_first.m_prev=m_first;
	 }
	 //loop till the end to find the greater obj and insert before that
	 else	{
	 DataLink m_last=m_first.m_next;

	 	/*while(m_last.m_object < newlink.m_object)
	 {
	 		m_last.m_next=
	 }*/
	 }
	 }

	 /**
	  * Returns the first SortableObject in the chain that is “equal to” targetObj
	  * @paramtargetObj – the object being compared to
	  */
	 public SortableObject get(SortableObject targetObj) {
	 	return targetObj;

	 	// TODO

	 }

	 /**
	  * Removes all DataLinks from the chain where the stored SortableObject
	  * is “equal to” targetObj 
	  * @paramtargetObj – the object being compared to
	  */
	 	public void remove(SortableObject targetObj) {

	 	// TODO

	 		}
	 }