/**@author chloe
 * Chloe Brown
 * Programming Assignment 1 - CS 315
 * October 5, 2017
 *
 */
public class MovieList <m>{
	MovieList<m> mList;
	protected MovieListNode<m> head;
	protected MovieListNode<m> tail;
	int size;


	//	 	default constructor for list
	public MovieList() {
		head = null;
		tail = null;
		size = 0;
	}

	//	prints movie details
	public void movieDetails(String title) {
		MovieListNode<m> cur = head;
		while(cur!=null) {
			boolean part = cur.toString().toLowerCase().contains(title.toLowerCase());	//REFERENCE: https://stackoverflow.com/questions/2275004/in-java-how-do-i-check-if-a-string-contains-a-substring-ignoring-case
			//^^checks if the title is in the current movie node
			if(part == true) {
				System.out.println(cur.toString());
				//^^ if the title was in the node, then print the details of that movie node
				break;
			}
			else {
				cur=cur.next;	//goes on to check the next movie node
			}
		}
	}

	//prints all movies for particular year
	public void moviesForYear(String year) {
		boolean success = false;
		MovieListNode<m> cur = head;
		while(cur!=null) {
			boolean part = cur.toString().toLowerCase().contains(year.toLowerCase());	//REFERENCE: https://stackoverflow.com/questions/2275004/in-java-how-do-i-check-if-a-string-contains-a-substring-ignoring-case
			//^^checks if the year is in the current movie node
			if(part ==true) {
				//^^ if the year was in the node, then print the movie details
				success = true;
				System.out.println(cur.toString());
			}
			cur=cur.next;	//goes on to check if there were other movies with that year
		}
		if(cur==null && success!=true) {
			System.out.println("There were no movies for that year.");
			//^^ if no movies with that year were found, then success stays false and the user is informed that there were no movies with the year
		}
	}

	//print available movies
	public void availableMovies() {
		MovieListNode<m> cur = head;
		while(cur!=null) {
			//I couldn't figure out how to get the quantity for each node and the code I had written here was garbage so I deleted it,
			//but here's some pseudo code at least *shrug*
			//				if(quantity>0) {
			//					print movie node
			//				}
			//				cur=cur.next;
		}	
	}

	//	     Prints all elements in the list forward
	public void printAscend()  {
		MovieListNode<m> cur = head;
		while (cur != null) {
			System.out.println(cur);	//prints current node
			cur = cur.next;		//moves on to next node
		}
	}

	//	Prints all elements in the list in reverse   
	//the logic here makes perfect sense so I'm not sure why it's not working. In the addMovie method, I added a check
	//for it to print out the previous movie so cur.prev should be working in this method.
	public void printDescend()  {
		MovieListNode<m> cur = tail;
		while (cur != null) {
			System.out.println(cur);	//prints current node
			cur = cur.prev;		//moves back to previous node
		}
	}

	//adds movies in order they are in text document.. Couldn't get alphabetical to work. Tried many different ways...
	public void addMovie(m value) {
		//Empty List Case
		if (head == null) {
			head = tail = new MovieListNode<>(value, null, null);	//first node added to list
		}
		//if list already has a head - add to tail
		else {
			tail.next = new MovieListNode<>(value, tail, null);	//adds another node directly after the previous node

			//			System.out.println("Previous Movie: " + tail);	
			//^^^^TEST: checks the previous tail to make sure it's pointed to by current
			tail = tail.next;
		}
	}

	//deletes a movie from the list
	public void deleteMovie(String title) {
		MovieListNode<m> cur = head;
		boolean part=false;
		while(cur!=null) {
			part = cur.toString().toLowerCase().contains(title.toLowerCase());	//REFERENCE: https://stackoverflow.com/questions/2275004/in-java-how-do-i-check-if-a-string-contains-a-substring-ignoring-case
			//^^checks if the year is in the current movie node
			if(part == true) {
				if(cur==head) {	//deleting head node
					head = cur.next;
				}
				if(cur==tail) {	//deleting tail node
					tail = cur.prev;
				}
				if(cur.next!=null && cur.prev!=null) {	//deleting anything in middle **this doesn't work although the logic makes sense to me**
					cur.next.prev = cur.prev;
					cur.prev.next = cur.next;
				}
				return;
			}
			else {
				cur=cur.next;
			}
		}
		if(part==false) {
			System.out.println("Sorry, I could not find that movie....");
		}
	}

}

