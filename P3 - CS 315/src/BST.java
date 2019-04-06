/**
 * @author Richard S. Stansbury & Chloe Brown & Alex Steinbacher
 * @date 10/29/2017
 * @Description:  This is an implementation of a binary tree node.
 */
public class BST<K extends Comparable<K>, T> {
	BTNode<K, T> root;
	int size;

	/**
	 * Default constructor.  Creates an empty tree.
	 */
	public BST() {
		this.root = null;
		this.size = 0;
	}


	/**
	 * Inserts a tree node into the tree as a leaf in the appropriate
	 * location within the tree.
	 * @param key - Key of new node
	 * @param info - Info of new node.
	 */
	public void insert(K key, T info) {

		size++;

		//Special case - empty tree
		if (root == null) {
			root = new BTNode<K,T>(key, info);
			return;
		}

		//Default case - add new node

		//References to track traversal
		BTNode <K, T> prev = null;
		BTNode <K, T> cur = root;

		//Traverse list moving left or right based upon
		// new key's value relative to each node's key.
		while (cur != null) {

			prev = cur;

			//If key's value is less than cur's key, traverse left.
			if (key.compareTo(cur.key) < 0) {
				cur = cur.left;
			}
			//Otherwise, traverse right.
			else {
				cur = cur.right;
			}
		}

		//Insert new key relative to prev (i.e. the last node
		// visited in the traversal
		if (key.compareTo(prev.key) < 0) {
			prev.left = new BTNode<K, T>(key, info);
		}
		else {
			prev.right = new BTNode<K, T>(key, info);
		}
	}

	/**
	 * Returns the info of the node with the target key in the tree.
	 * Null if not found
	 * @param key - target node's key
	 * @return info of target node, or null if not found
	 */
	public BTNode<K, T> search(K key) {

		return search(key, root);
	}

	/**
	 * Recursive method that searches for a key within a subtree
	 * defined by cur as its root.
	 *
	 * @param key - target node's key
	 * @param cur - current root of subtree being searched.
	 * @return info of target node, or null if not found.
	 */
	private BTNode<K, T> search(K key, BTNode<K, T> cur) {
		if (cur == null) return null;

		if (key.compareTo(cur.key) == 0)
			return cur;
		else if (key.compareTo(cur.key) < 0)
			return search(key, cur.left);
		else
			return search(key, cur.right);
	}

	/**
	 * A method that "visits" a node to do some operation
	 * for this example it only prints the node.
	 * @param node - node to visit.
	 */
	public void visit(BTNode<K,T> node) {
		System.out.print(node.info + " ");
	}


	/**
	 *
	 * @return array of all nodes from an inoder traversal
	 */
	public BTNode<K,T> [] getTreeData() {
		BTNode<K,T> [] data = new BTNode[size];
		getTreeData(root, data, 0);
		return data;
	}

	/**
	 * Generates an array of all nodes recursively using inorder traversal
	 * @param cur - current node
	 * @param data - data array
	 * @param index - index for next insert in array
	 * @return updated index for next insert in array
	 */
	private int getTreeData(BTNode<K,T> cur, BTNode<K,T> [] data, int index)
	{
		//Base case
		if (cur == null) return index;

		//Inorder Traversal recursion
		index = getTreeData(cur.left, data, index);
		data[index] = cur;
		index++;
		index = getTreeData(cur.right, data, index);

		return index;
	}
}