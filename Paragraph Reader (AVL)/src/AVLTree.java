//Name: Archita Bathole
//Per: 1
//Date: 4/10/18
//AP Computer Science

// Java program for deletion in AVL Tree
class AVLTree 
{

	Node root;
	
	Node insert(Node node, String key)
	{
		
		/* 1.  Perform the normal BST rotation */
        if (node == null) {
        		//Dictionary test = new Dictionary(key);
        		//return (new Node(key,test.getSavedWord()));
        		return (new Node(key,""));
        }
            
        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else // Equal keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(Utility.height(node.left), Utility.height(node.right));
 
        /* 3. Get the balance factor of this ancestor
           node to check whether this node became Wunbalanced */
        int balance = Utility.getBalance(node);
 
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return Utility.rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return Utility.leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0)
        {
            node.left = Utility.leftRotate(node.left);
            return Utility.rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0)
        {
            node.right = Utility.rightRotate(node.right);
            return Utility.leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
		
		
//		if (node == null) {
//			return (new Node(key));
//					}
//			if (node.key > key) {
//						node.left = insert(node.left, key);
//					} else {
//						node.right = insert(node.right, key);
//					}
//			// update the node height
//					node.height = Math.max(Utility.height(node.left), Utility.height(node.right)) + 1;
//			int balDiff = Utility.getBalance(node);
//			// Left Rotate
//			if (balDiff > 1 && key < node.left.key) {
//			return Utility.rightRotate(node);
//					}
//			// Right Rotate
//			if (balDiff < -1 && key > node.right.key) {
//			return Utility.leftRotate(node);
//					}
//			// Left Right Rotate
//			if (balDiff > 1 && key > node.left.key) {
//						node.left = Utility.leftRotate(node.left);
//			return Utility.rightRotate(node);
//					}
//			// Right Left Rotate
//			if (balDiff < -1 && key < node.right.key) {
//						node.right = Utility.rightRotate(node.right);
//			return Utility.leftRotate(node);
//					}
//			return node;
//	
	}
		
	Node deleteNode(Node root, String key)
	{
		
		// STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key.compareTo(root.key) < 0)
            root.left = deleteNode(root.left, key);
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key.compareTo(root.key) > 0)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
 
            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = Utility.minValueNode(root.right);
 
                // Copy the inorder successor's data to this node
                root.key = temp.key;
 
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(Utility.height(root.left), Utility.height(root.right)) + 1;
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = Utility.getBalance(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && Utility.getBalance(root.left) >= 0)
            return Utility.rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && Utility.getBalance(root.left) < 0)
        {
            root.left = Utility.leftRotate(root.left);
            return Utility.rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && Utility.getBalance(root.right) <= 0)
            return Utility.leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && Utility.getBalance(root.right) > 0)
        {
            root.right = Utility.rightRotate(root.right);
            return Utility.leftRotate(root);
        }
 
        return root;
		
//		// STEP 1: PERFORM STANDARD BST DELETE
//		
//			// If the key to be deleted is smaller than the root's key, then it lies in left subtree
//			if(key < root.key)
//				root.left = deleteNode(root.left, key);
//			// If the key to be deleted is greater than the root's key, then it lies in right subtree
//			if(key > root.key)
//				root.right = deleteNode(root.right, key);
//			// if key is same as root's key, then this is the node to be deleted
//			//if(key == root.key) {
//			// If the tree had only one node then return root
//			if(root.left == null && root.right == null)
//				return root;
//		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
//			root.height = Math.max(Utility.height(root.left), Utility.height(root.right)) + 1;
//		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether this node became unbalanced)
//			int balDiff = Utility.getBalance(root);
//			// Left Rotate
//			if (balDiff > 1 && key < root.left.key) {
//			return Utility.rightRotate(root);
//					}
//			// Right Rotate
//			if (balDiff < -1 && key > root.right.key) {
//			return Utility.leftRotate(root);
//					}
//			// Left Right Rotate
//			if (balDiff > 1 && key > root.left.key) {
//						root.left = Utility.leftRotate(root.left);
//			return Utility.rightRotate(root);
//					}
//			// Right Left Rotate
//			if (balDiff < -1 && key < root.right.key) {
//						root.right = Utility.rightRotate(root.right);
//			return Utility.leftRotate(root);
//					}
//			return root;
	}
	
	//check if tree has node
	public Node Contains(String word) {
	    Node currentNode = root;
	   boolean flag;
	   
	    while(currentNode != null) { // Or whatever you use to signal that there is no node.
	    	 int count = word.compareTo(currentNode.key);
	    	 if(count < 0)
	    		 currentNode = currentNode.left;
	    	 else if(count > 0)
	    		 currentNode = currentNode.right;
	    	 else
	    		 return currentNode;
	        }
	    return currentNode;
	 }
}