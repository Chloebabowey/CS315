/**
 * This class manages the MovieList to produce a nice front-end to the movie database.
 * 
 * @author Stansbury and Chloe Brown & Alex Steinbacher
 */

import java.io.*;

public class MovieDatabaseManager {

	MovieList mList; //You must create an instance of this
	MovieQueue mQueue;
	
	/**
	 * Default constructor - creates a database with a list that is empty
	 */
	public MovieDatabaseManager()
	{
		mList = new MovieList();
		mQueue = new MovieQueue();
	}
	
	/**
	 * Advanced constructor - creates a database with a list of values from an input file
	 * @param file - the input file.
	 */
	public MovieDatabaseManager(String file)
	{
		this();
		parseInputFile(file); //populates database with list of movies
	}
	
	/**
	 * Parses the input file so that you can add all of items found in the list in alphabetical order by title.
	 */
	private void parseInputFile(String file)
	{
		//Create a file input stream
		Movie m;
		String instr;
		try {
			//Create input reader
			BufferedReader in = new BufferedReader(new FileReader(file));
			while (in.ready()) {
				instr = in.readLine();
				
				//Try to parse the movie using the appropriate movie constructor.  If it fails, an exception is caught
				try {
					m = new Movie(instr);
					mList.addAlphabetically(m);

					
					
				} catch (InvalidMovieException e) {
					System.out.println("Invalid movie string " + instr + " in file " + file);
				}

			}
		} catch (IOException io) {
			System.err.println("Error in Parsing file.");
			io.printStackTrace();	
		}
	}
	
	
	
	/**
	 * Provides console I/O to the program for user interaction.
	 */
	public void consoleIO()
	{
		
		//Prompts to the user
		System.out.println("Please Choose from the Following:");
		System.out.println("\t1. List Movies");
		System.out.println("\t2. Print Movie Details");
		System.out.println("\t3. Add movie to Queue");
		System.out.println("\t4. Checkout N Movies");
		System.out.print(">> ");
		
		//Creates a buffer to read from the console.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//I/O code in a big try/catch to ensure no exceptions occur.
		try {
			String choice = br.readLine();
			
			//Given the choice, call the appropriate function calls.
			if (choice.equals("1")) {
				//////////////////////////////////////////////////////
				//  Call list function that prints in ascending order
				//////////////////////////////////////////////////////
				printMovieList();
			}
			else if (choice.equals("2"))	{
				//////////////////////////////////////////////////////
				//  Find movie in movie list and print out details to 
				//  to customer.  Handle error if user requests info 
				//  for invalid move
				//////////////////////////////////////////////////////
				System.out.print("Title >> ");
				String title = br.readLine();
				Movie movie = mList.getMovie(title);
				if (movie == null) {
					System.out.println("Invalid movie title.  Please try again.");
				}
				else {
					System.out.println(movie);
				}
				
			}
			else if (choice.equals("3")) {
				System.out.print("Title >> ");
				String title = br.readLine();
				
				//////////////////////////////////////////////////////
				//  Find movie in movie list.  Add to user's movie queue
				//  --Handle error handling if user requests invalid movie
				//////////////////////////////////////////////////////
				Movie m = mList.getMovie(title);
				mQueue.enqueue(m);				
				

				
			}
			else if (choice.equals("4")) {
				System.out.print("How many? >> ");
				int count = Integer.parseInt(br.readLine());
				
				//////////////////////////////////////////////////////
				//  Call a method that processes the movie queue.
				//  For all movies quantity > 1, print out the movie title
				//  and decrement its quantity available by 1.
				//
				//  If there are not enough available movies, the user
				//  should be notified as such.
				//////////////////////////////////////////////////////
				mQueue.checkOutMovie(count);				
			}
			else {
				System.out.println("Invalid Input:  Try again");
			}
			
		} catch (IOException e) {
			System.out.println("Invalid Input:  Try again");
		}
		
	}
	
	
	/**
	 * Prints the list of movies using the list method.
	 */
	public void printMovieList()
	{
		System.out.println("\nMovies:");
		mList.printList();
		System.out.println();
	}
	
	
	public static void main(String [] args)
	{
		
		//Create manager and have it populate with input file content.
		MovieDatabaseManager mdm = new MovieDatabaseManager("input.txt");	//UPDATE WITH DIRECT PATH TO YOUR INPUT FILE	
		
		//Console runs in an infinite loop.
		while (true) {
			mdm.consoleIO();
		}
		
	}
	
}
