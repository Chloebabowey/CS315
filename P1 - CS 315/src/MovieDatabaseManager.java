/**
 * This class manages the MovieList to produce a nice front-end to the movie database.
 * 
 * @author Stansbury and Chloe Brown
 * Programming Assignment 1 - CS 315
 * October 5th, 2017
 */

import java.io.*;

public class MovieDatabaseManager {

	MovieList mList; //You must create an instance of this
	MovieList mo = new MovieList();

	/**
	 * Default constructor - creates a database with a list that is empty
	 */
	public MovieDatabaseManager()
	{
		//Creates a new instance of the list
		MovieList mList;
	}

	/**
	 * Advanced constructor - creates a database with a list of values from an input file
	 * @param file - the input file.
	 */
	public MovieDatabaseManager(String file){	
		this();
		parseInputFile(file); //populates database with list of movies
	}

	/**
	 * Parses the input file so that you can add all of items found in the list in alphabetical order by title.
	 */
	private void parseInputFile(String file){
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
					//calls method to add a movie from the MovieList class		
					mo.addMovie(m);

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
	public void consoleIO(){

		//Prompts to the user
		System.out.println("Please Choose from the Following:");
		System.out.println("\t1. List Movies Ascending");
		System.out.println("\t2. List Movies Descending");
		System.out.println("\t3. List Movies for Year");		
		System.out.println("\t4. List Movies Available");
		System.out.println("\t5. Add Movie");
		System.out.println("\t6. Delete Movie");
		System.out.println("\t7. Print Movie Details");
		System.out.print(">> ");

		//Creates a buffer to read from the console.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//I/O code in a big try/catch to ensure no exceptions occur.
		try {
			String choice = br.readLine();

			//Given the choice, call the appropriate function calls.
			if (choice.equals("1")) {
				//  Calls method to print movies in order from MovieList class	
				mo.printAscend();

			}
			else if (choice.equals("2")) {
				//  Calls method to print movies in reverse order from MovieList class
				mo.printDescend();
			}
			else if (choice.equals("3")) {
				System.out.print("What Year? >>");
				//Coudln't figure out how to get this to work as an int soooo.......
				String year = br.readLine();

				//  Calls method to print all movies that are in a certain year from MovieList class		
				mo.moviesForYear(year);
			}
			else if (choice.equals("4")) {
				//  Calls method to display movies with quantities>0 from MovieList class
				mo.availableMovies();
			}
			else if (choice.equals("5")) {
				System.out.print("Title >> ");
				String title = br.readLine();

				System.out.print("Director >> ");
				String director = br.readLine();

				System.out.print("Year >> ");
				int year = Integer.parseInt(br.readLine());
				System.out.print("Quantity Available >> ");
				int quantity = Integer.parseInt(br.readLine());

				Movie newM = new Movie(title, director, year, quantity);

				//  Calls method to add a movie from MovieList class
				mo.addMovie(newM);
			}
			else if (choice.equals("6")) {
				System.out.print("Title >> ");
				String title = br.readLine();

				//  Calls method to delete a movie from the MovieList class	
				mo.deleteMovie(title);
			}
			else if (choice.equals("7")) {
				System.out.print("Title >> ");
				String title = br.readLine();

				//  Calls method to display all of the details for a movie from the MovieList class		
				mo.movieDetails(title);
			}
			else {
				System.out.println("Invalid Input:  Try again");
			}

		} catch (IOException e) {
			System.out.println("Invalid Input:  Try again");
		}

	}


	public static void main(String [] args){	
		//Create manager and have it populate with input file content.
		MovieDatabaseManager mdm = new MovieDatabaseManager("input.txt");	//UPDATE WITH DIRECT PATH TO YOUR INPUT FILE

		//Console runs in an infinite loop.
		while (true) {
			mdm.consoleIO();
		}	
	}	
}
