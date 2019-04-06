/**
 * 
 */

/**
 * @ Chloe Brown & Alex Steinbacher
 *
 */
public class MovieList {

	MovieListNode head;
	MovieListNode tail;
	int size=0;

	/**
	 * default constructor.
	 */
	public MovieList() 
	{
		head = tail = null;
	}

	/**
	 * Adds node to end of list.
	 * @param newMovie
	 */
	public void addToTail(Movie newMovie)
	{
		if (head == null) {
			head = tail = new MovieListNode(newMovie);
		size++;
		}else {
			tail = tail.next = new MovieListNode(newMovie);
		size++;
		}
	}

	/**
	 * Adds in ascending alphabetical order
	 * @param newMovie
	 */
	public void addAlphabetically(Movie newMovie)
	{
		//Empty List check
		if (head == null) {
			head = tail = new MovieListNode(newMovie);
			return;
		}

		String newTitle = newMovie.getTitle();

		//Locate insertion point
		MovieListNode cur = head;
		MovieListNode prev = null;
		while (cur != null)
		{
			//If the new title is less than the current, it must go
			//in front of it.
			if (newTitle.compareTo(cur.info.getTitle()) < 0)
				break;
			prev = cur;
			cur = cur.next;
		}

		//New Title comes before current head
		if (cur == head) {
			head = new MovieListNode(newMovie, head);
		}
		//New title comes after entire list
		else if (cur == null) {
			addToTail(newMovie);
		}
		//New title goes somewhere in the middle.
		else {
			prev.next = new MovieListNode(newMovie, cur);
		}
	}


	/**
	 * Prints the list.
	 */
	public void printList()
	{
		MovieListNode cur = head;
		while (cur != null) {
			System.out.print(cur.info);
			cur = cur.next;
		}
	}

	/**
	 * @param location - location in list of movie of interest
	 * @return Movie at location, or null if out of bounds
	 */
	public Movie getMovie(int location)
	{
		MovieListNode cur = head;
		int loc = 0;
		while (loc != location && cur != null) {
			cur = cur.next;
		}

		if (cur == null) return null;
		else return cur.info;
	}

	/**
	 * Returns movie object with matching title 
	 * @param title - title to search for
	 * @return movie with matching title; otherwise, null
	 */
	public Movie getMovie(String title)
	{
		MovieListNode cur = head;		
		while (cur != null) {
			if (cur.info.getTitle().equals(title))
				break;
			cur = cur.next;
		}

		if (cur == null) return null;
		else return cur.info;
	}

}
