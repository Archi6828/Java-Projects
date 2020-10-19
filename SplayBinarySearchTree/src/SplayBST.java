//Name: Archita Bathole
//Per: 1
//Date: 4/29/18
//AP Computer Science

public class SplayBST<Key extends Comparable<Key>, Value>
{
	Node root; // root of the BST
public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    public Value get(Key key) {
        root = splay(root, key);
        int cmp = key.compareTo((Key) root.key);
        if (cmp == 0) return (Value) root.value;
        else          return null;
    }    

   /***************************************************************************
    *  Splay tree insertion.
    ***************************************************************************/
    public void put(Key key, Value value) {
        // splay key to root
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo((Key) root.key);
        
        // Insert new node at root
        if (cmp < 0) {
            Node n = new Node(key, value);
 //           if(key.compareTo((Key)root.left.key) < 0)
            	n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.value = value;
        }

    }
    
   /***************************************************************************
    *  Splay tree deletion.
    ***************************************************************************/
    /* This splays the key, then does a slightly modified Hibbard deletion on
     * the root (if it is the node to be deleted; if it is not, the key was 
     * not in the tree). The modification is that rather than swapping the
     * root (call it node A) with its successor, it's successor (call it Node B)
     * is moved to the root position by splaying for the deletion key in A's 
     * right subtree. Finally, A's right child is made the new root's right 
     * child.
     */
    public void remove(Key key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int cmp = key.compareTo((Key) root.key);
        
        if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove
    }
    
    
   /***************************************************************************
    * Splay tree function.
    * **********************************************************************/
    // splay key in the tree rooted at Node h. If a node with that key exists,
    //   it is splayed to the root of the tree. If it does not, the last node
    //   along the search path for the key is splayed to the root.
    private Node splay(Node h, Key key) {
        if (h == null) return null;

        int cmp1 = key.compareTo((Key) h.key);

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo((Key) h.left.key);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }
            
            if (h.left == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // key not in tree, so we're done
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo((Key) h.right.key);
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            }
            else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            
            if (h.right == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }


   /***************************************************************************
    *  Helper functions.
    ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    // right rotate
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // left rotate
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
}

/*


public class SplayBST<Key extends Comparable<Key>, Value>
{
	Node root; // root of the BST
	
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	// return value associated with the given key
	// if no such value, return null
	public Value get(Key key)
	{
		root = splay(root, key);
		int cmp = key.compareTo((Key) root.key);
		if(cmp == 0)
			return (Value) root.value;
		else
			return null;
	}
	
	
    //  Splay tree insertion.
	
	public void put(Key key, Value value)
	{
		// splay key to root
		if(root == null)
		{
			root = new Node(key, value);
			return;
		}
		
		root = splay(root, key);
//		System.out.println("splay root: " + root.key + "\n");
		int cmp = key.compareTo((Key) root.key);
		
		// TODO
	//	int RLK = (int) root.left.key;
	//			System.out.println("root.left: " + RLK + "\n");
		// Insert new node at root
			if(cmp < 0) {
					Node n = new Node(key, value);
					n.left = root.left;
					n.right = root;
					root.left = null;
					root = n;
					
			}
		// Insert new node at root
				if(cmp > 0) {
//					System.out.println("root.rightt: " + root.right.key + "\n");
					Node n = new Node(key, value);
					n.right = root.right;
					n.left = root;
					root.right = null;
					root = n;
				}
		// It was a duplicate key. Simply replace the value
			else {
				root.value = value;
			}
	}
	
	
//	   Splay tree deletion.
	
//	 This splays the key, then does a slightly modified Hibbard deletion on
//	  the root (if it is the node to be deleted; if it is not, the key was 
//	  not in the tree). The modification is that rather than swapping the
//	  root (call it node A) with its successor, it's successor (call it Node B)
//	  is moved to the root position by splaying for the deletion key in A's 
//	  right subtree. Finally, A's right child is made the new root's right 
//	  child.
//	 
	public void remove(Key key)
	{
		if(root == null)
			return; // empty tree
			
		root = splay(root, key);
		
		int cmp = key.compareTo((Key) root.key);
		
		// TODO
		if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }
	}
	
	
//	  Splay tree function.
	
	// splay key in the tree rooted at Node h. If a node with that key exists,
	//   it is splayed to the root of the tree. If it does not, the last node
	//   along the search path for the key is splayed to the root.
	private Node splay(Node h, Key key)
	{
		if(h == null)
			return null;
		
		int cmp = key.compareTo((Key) h.key);
		
		// TODO
		if(cmp < 0) {
			
			if(h.left == null) {
				return h;
			}
			
			int cmp1 = key.compareTo((Key)h.left.key);
			if(cmp1 < 0) {
				h.left.left = splay(h.left.left, key);
				h = rotateRight(h);
			}
			else if(cmp1 > 0) {
				h.left.right = splay(h.left.right, key);
				if(h.left.right != null)
					h.left = rotateLeft(h.left);
			}
			if(h.left == null)
				return h;
			else
				rotateRight(h);
	}
	
		else if(cmp > 0) {
			
			if(h.right == null) {
				return h;
			}
			
			int cmp3 = key.compareTo((Key)h.right.key);
			if(cmp3 < 0) {
				h.right.left = splay(h.right.left,key);
				if(h.right.left != null)
					h.right = rotateRight(h.right);
			}
			else if(cmp3 > 0) {
				h.right.right = splay(h.right.right,key);
				h = rotateLeft(h);
			}
			
			if(h.right == null)
				return h;
			else 
				return rotateLeft(h);
		}
		
		return h;
	}
	
	
//	   Helper functions.
	
	
	// height of tree (1-node tree has height 0)
	public int height()
	{
		return height(root);
	}
	
	private int height(Node x)
	{
		if(x == null)
			return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node x)
	{
		if(x == null)
			return 0;
		else
			return 1 + size(x.left) + size(x.right);
	}
	
	// right rotate
	private Node rotateRight(Node h)
	{
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
	}
	
	// left rotate
	private Node rotateLeft(Node h)
	{
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}
}

*/