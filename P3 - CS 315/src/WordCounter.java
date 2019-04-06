/**
 * Implements a word frequency counter using a binary search tree and a heap.
 * @author Chloe Brown & Alex Steinbacher
 * @date 11/26/2017
 */

public class WordCounter {

	//DECLARE CLASS VARIABLES HERE
	static BST bst = new BST();
	static BTNode node;
	static MaxHeap mh;

	public static void countWords(String [] words) {
		BTNode<String, Integer> [] nodes;
		//Implement your solution here
		for(int i=0; i<words.length; i++) {
			if(bst.search(words[i])==null) {	//if node doesn't exist, create new node
				bst.insert(words[i], 1);
			}
			else {	//if node already exists, increment count by 1
				BTNode<String, Integer> tempNode = bst.search(words[i]);
				tempNode.info++;
			}   		
		}
		
		nodes = bst.getTreeData();
		
		mh = new MaxHeap(bst.size);
		
		for (int i = 0; i < nodes.length; i++) {	//prints nodes in alphabetical order & adds them to the queue for the maxheap
			System.out.println(nodes[i].key + " " + nodes[i].info);
			mh.enqueue(nodes[i].info, nodes[i].key);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		String tempinfo;
		for (int i = 0; i < nodes.length; i++) {	//prints maxheap in order of count (priority)
			tempinfo = (String) mh.dequeue();
			BTNode<String, Integer> tempNode = bst.search(tempinfo);
			System.out.println(tempinfo + " "+ tempNode.info);
		}
	}


	public static void main(String [] args) {
		String input = "input.txt";
		WordCounter.countWords(InputReader.parseInputFile(input));
	}
}
