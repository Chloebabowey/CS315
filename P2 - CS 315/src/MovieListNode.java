/**
 * 
 */

/**
 * Defines a simple Node for a doubly linked movie list.
 * 
 * @author  Richard S. Stansbury 
 * 
 */
public class MovieListNode {

	Movie info;	
	MovieListNode next;
		
	/**
	 * Default constructor
	 * @param m - movie info
	 */
	public MovieListNode(Movie m)
	{
		info = m;
		next = null;
	}
	
	/**
	 * Secondary constructor
	 * @param m - movie info
	 * @param p - previous node
	 * @param n - next node
	 */
	public MovieListNode(Movie m, MovieListNode n)
	{
		info = m;
		next = n;
	}	
	
}
