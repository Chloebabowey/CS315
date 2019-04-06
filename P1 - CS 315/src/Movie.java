/**
 * Defines a simple movie class.
 * 
 * @author Richard S. Stansbury
 * Chloe Brown
 * Programming Assignment 1 - CS 315
 * October 5, 2017
 *
 */


public class Movie {

	//Class variables
	private String title;
	private String director;
	private int year;
	private int quantity;

	/**
	 * Default constructor with parameterized data
	 * @param title - movie title
	 * @param director - director's first and last name
	 * @param year - year movie was released
	 * @param quantity - quantity in stock.
	 */
	public Movie(String title, String director, int year, int quantity){
		this.title = title;
		this.director = director;
		this.year = year;
		this.quantity = quantity;
	}

	//Parses a comma delimited string of movie data. Title, Director, Year, Quantity @param iostring
	public Movie(String iostring) throws InvalidMovieException{
		try {
			String [] data = iostring.split(",");
			if (data.length != 4)  throw new InvalidMovieException();
			else {
				title = data[0].trim();
				director = data[1].trim();
				year = Integer.parseInt(data[2].trim());
				quantity = Integer.parseInt(data[3].trim());
			}
		} catch(Exception e) {
			throw new InvalidMovieException();
		}
	}

	//return a string representation of the movie object
	public String toString(){
		return title + ", " + director + ", " + year + ", " + quantity + "\n";	
	}

	//@return title of the movie
	public String getTitle(){
		return title;
	}


	//@return director of the movie
	public String getDirector(){
		return director;
	}

	//@return year movie released
	public int getYear(){
		return year;
	}

	//@return quantity available
	public int getQuantity(){
		return quantity;		
	}

	//Main for testing
	public static void main(String [] args){	
		Movie a = new Movie("Pulp Fiction", "Quintin Tarantino", 1994, 2);
		System.out.print(a);

		try {
			Movie b = new Movie("Forest Gump, Robert Zemekis, 1994, 0");
			System.out.print(b);
		} catch(InvalidMovieException ime) {
			System.out.println("Invalid Movie String");
		}
	}	
}
