
 /**@author chloe
 * Chloe Brown
 * Programming Assignment 1 - CS 315
 * October 5, 2017
 *
 */
public class MovieListNode<m> {
    Movie mo;
    public m info;
    public MovieListNode<m> next;
    public MovieListNode<m> prev;
    
    public MovieListNode(m info, MovieListNode<m> prev, MovieListNode<m> next ) {
    	this.info = info;
        this.next = null;
        this.prev = null;
    }
    
    public String toString() {
        return info.toString();
    }


}

