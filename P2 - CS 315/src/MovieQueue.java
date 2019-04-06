import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Defines a queue for movies. 
 * 
 * @author Chloe Brown & Alex Steinbacher
 *
 */

public class MovieQueue {
	//Define local variables
	static MovieList list = new MovieList();
	MovieListNode head;
	MovieListNode tail;


	public MovieQueue ()
	{
		//define constructor code here
		list = new MovieList();		 
	}

	public void enqueue(Movie m)
	{
		//Write code here
		if(m.getQuantity()<=0) {
			System.out.println("Can't add this movie...");
			
		}else {
		list.addToTail(m);
		System.out.println(m);
		}

		
	}

	public Movie dequeue()
	{
		Movie choice = list.head.info;
		choice.checkOut();
		list.head = list.head.next;
		return choice;
	}

	/**
	 * Returns front of queue
	 * @return
	 */
	public Movie front()
	{
		//Write code here		
		MovieListNode cur = list.head;
		if (list.head==null) {
			System.out.println("Cannot return front.  Queue is empty.");
			return null;
		}else 
		return list.getMovie(0);
	}

	public MovieListNode checkOutMovie(int count) {
		if(list.size==0) {
			System.out.println("Nothing in queue");
			return null;
		}

//		System.out.println(front());
		// ^^^^ this is where you test the front() method, couldn't see the point in using it anywhere 
		
		System.out.println("Movies checked out:");
		for(int j=0; j<count;j++) {	
			if(j>list.size) {
				System.out.println("not enough items in queue");
			}
			System.out.println(dequeue().getTitle());
		}
		return null;	
	}

}
