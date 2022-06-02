

//##################################################
// File: AVL.java
// Author: Richard Cameron
// Description: This file conatins the blueprint for the AVL Tree class.
// Date: April 1, 2022
//#################################################

public class AVL
{
    
    public AVLNode root = null;
    public int size = 0;
    public AVLNode retNode;
    
    //#################################################
    // @par Name
    // AVL
    // @purpose
    // Constructor for the AVL class.
    // @param [in] :
    // None
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVL ()
    {
        root = null;
        size = 0;
    }
    
    //#################################################
    // @par Name
    // insert
    // @purpose
    // Abstracted function, overloaded version of robust insert.
    // @param [in] :
    // String k data
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void insert(Pair k)
    {
        root = insert((String)k.mFirst, k, root);
    }

    //#################################################
    // @par Name
    // insert
    // @purpose
    // Robust insert function, inserts a node into the tree (recursively)
    // @param [in] :
    // String k, String data, AVLNode n
    // @return
    // AVLNode
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode insert(String k, Pair data, AVLNode n)
    {
        if (n == null)
        {
            n = new AVLNode(k, data);
            size++;
            return n;
        }
        else
        {
            if(k.compareTo(n.getKey()) < 0)
            {
                n.setLeft(insert(k, data, n.getLeft()));
                if(height(n.getLeft()) - height(n.getRight ()) == 2)
                {
                    if(k.compareTo((n.getLeft()).getKey()) < 0)
                    {
                        n = rotateWithLeft(n);
                    }
                    else
                    {
                        n = doubleWithLeft(n);
                    }
                }
            }
            else
            {
                if(k.compareTo(n.getKey()) > 0)
                {
                    n.setRight(insert(k, data, n.getRight()));
                    if (height(n.getRight()) - height(n.getLeft()) == 2)
                    {
                        if(k.compareTo((n.getRight()).getKey()) > 0)
                        {
                            n = rotateWithRight(n);
                        }
                        else
                        {
                            n = doubleWithRight(n);
                        }
                    }
                }
            }
        }
        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        return n;
    }

    //#################################################
    // @par Name
    // getRoot
    // @purpose
    // Similair to getHead. Returns anchor of tree.
    // @param [in] :
    // None
    // @return
    // AVLNode root
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode getRoot()
    {
        return root;
    }

    //#################################################
    // @par Name
    // getSize
    // @purpose
    // Getter for size of tree.
    // @param [in] :
    // None
    // @return
    // int
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int getSize()
    {
        return size;
    }
    
    //#################################################
    // @par Name
    // height
    // @purpose
    // returns the height / depth of the tree (abstracted).
    // @param [in] :
    // None
    // @return
    // int height (depth of tree)
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int height()
    {
        return height (root);
    }

    //#################################################
    // @par Name
    // height
    // @purpose
    // Overloaded height method (if tree is empty return -1).
    // @param [in] :
    // AVLNode n
    // @return
    // int
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int height(AVLNode n)
    {
        if (n == null)
        {
            return -1;
        }
        return n.getHeight ();
    }

    //#################################################
    // @par Name
    // isEmpty
    // @purpose
    // Checks if tree is empty or not and returns a boolean.
    // @param [in] :
    // None
    // @return
    // Boolean
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public boolean isEmpty()
    {
        return (size == 0);
    }

    //#################################################
    // @par Name
    // rotateWithLeft
    // @purpose
    // Rotates binary tree node with left child.
    // @param [in] :
    // AVLNode n
    // @return
    // AVLNode newNode
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode rotateWithLeft(AVLNode n)
    {
        AVLNode newNode = n.getLeft();
        n.setLeft(newNode.getRight());
        newNode.setRight(n);
        n.setHeight(max(height(n.getLeft()), height(n.getRight())) + 1);
        newNode.setHeight (max(height(newNode.getLeft()), n.getHeight()) + 1);
        return newNode;
    }
    
    //#################################################
    // @par Name
    // rotateWithRight
    // @purpose
    // Rotates binary tree node with right child.
    // @param [in] :
    // AVLNode n
    // @return
    // AVLNode newNode
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode rotateWithRight(AVLNode n)
    {
        AVLNode newNode = n.getRight();
        n.setRight(newNode.getLeft());
        newNode.setLeft(n);
        n.setHeight(max(height(n.getLeft()), height (n.getRight())) + 1);
        newNode.setHeight(max(height(newNode.getRight()), n.getHeight()) + 1);
        return newNode;
    }

    //#################################################
    // @par Name
    // doubleWithLeft
    // @purpose
    // Double rotation with left for binary tree.
    // @param [in] :
    // AVLNode n
    // @return
    // AVLNode n
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode doubleWithLeft(AVLNode n)
    {
        n.setLeft(rotateWithRight(n.getLeft()));
        return rotateWithLeft(n);
    }


    //#################################################
    // @par Name
    // doubleWithRight
    // @purpose
    // Double rotation with right for binary tree.
    // @param [in] :
    // AVLNode n
    // @return
    // AVLNode n
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode doubleWithRight(AVLNode n)
    {
        n.setRight(rotateWithLeft(n.getRight()));
        return rotateWithRight(n);
    }

    //#################################################
    // @par Name
    // max
    // @purpose
    // Determine precedence for balance.
    // @param [in] :
    // int first, int second
    // @return
    // int (first or second)
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int max(int first, int second)
    {
        if (first >= second)
        {
            return first;
        }
        else
        {
            return second;
        }
    }

    //#################################################
    // @par Name
    // contains
    // @purpose
    // "Contains" function for binary tree, Overlaoded for abstraction
    // @param [in] :
    // String k
    // @return
    // boolean 
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public boolean contains(String k)
    {
        return contains(k, root);
    }

    //#################################################
    // @par Name
    // contains
    // @purpose
    // Overloaded contains function, checks if node / data exists in tree.
    // @param [in] :
    // Strink k, AVLNode n
    // @return
    // boolean
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public boolean contains(String k, AVLNode n)
    {
        if(n == null)
        {
            return false;
        }

        if(k.compareTo(n.getKey()) < 0)
        {
            return contains(k, n.getLeft());
        }

        if(k.compareTo(n.getKey ()) > 0)
        {
            return contains(k, n.getRight());
        }
        
        return true;
    }
    
    //#################################################
    // @par Name
    // delete
    // @purpose
    // Finds node and deletes it from tree with balancing.
    // @param [in] :
    // String k
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void delete(String k)
    {
        AVLNode p = null;
        AVLNode t = null;
        AVLNode n = root;

        while(t == null && n != null)
        {
            if(k.compareTo(n.getKey()) < 0)
            {
                p = n;
                n = n.getLeft ();
            }
            else if (k.compareTo(n.getKey()) > 0)
            {
                p = n;
                n = n.getRight ();
            }
            else
            {
                t = n;
            }
        }
        if(t == null) 
        {
            return;
        }
        
        AVLNode repl = null;
        
        if(t.getLeft() != null || t.getRight() != null)
        {
            repl = getRepl(t.getLeft(), t, t);
        }
        else
        {
            if(t.getLeft() != null)
            {
                repl = t.getLeft();
            }
            else
            {
                repl = t.getRight();
            }
        }
        if(repl != null)
        {
            repl.setLeft(t.getLeft());
            repl.setRight(t.getRight());
            updateHeight(repl);
        }
        if(root == t)
        {
            root = repl;
        }
        else
        {
            if(p.getLeft() == t)
            {
                p.setLeft(repl);
            }
            else
            {
                p.setRight(repl);
            }
        }
        size--;
    }
    
    //#################################################
    // @par Name
    // getRepl
    // @purpose
    // recursively gets a replacement node.
    // @param [in] :
    // AVLNode n, AVLNode p, AVLNode t
    // @return
    // AVLNode repl
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode getRepl(AVLNode n, AVLNode p, AVLNode t)
    {
        if (n == null)
        {
            return p;
        }
        
        AVLNode repl = getRepl(n.getRight(), n, t);
        
        if (p.getRight() == repl)
        {
            p.setRight(null);
            
            if (p.getLeft() == null && p != t)
            {
                p.setHeight(p.getHeight() -1);
            }
        }
        else
        {
            updateHeight(p);
        }
        return repl;
    }

    //#################################################
    // @par Name
    // updateHeight
    // @purpose
    // Determines height or depth of the tree.
    // @param [in] :
    // AVLNode n
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void updateHeight(AVLNode n)
    {
        int leftHeight = -1;
        int ileftHeight = -1;
        if (n.getLeft() != null)
        {
            leftHeight = n.getLeft().getHeight();
        }
        
        if (n.getRight() != null)
        {
            ileftHeight = n.getRight().getHeight();
        }
        
        n.setHeight(max(leftHeight, ileftHeight) + 1);
    }
     
    //#################################################
    // @par Name
    // search
    // @purpose
    // Overloaded search function for abstraction.
    // @param [in] :
    // String word
    // @return
    // AVLNode generic
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode search(String word)
    {
        return search(word, root);
    }
    
    //#################################################
    // @par Name
    // search
    // @purpose
    // Traverses the tree until it finds a node (equality).
    // @param [in] :
    // String data, AVLNode node (root)
    // @return
    // AVLNode generic (recursive)
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode search(String word, AVLNode n)
    {
        
        Pair tempPair = (Pair) n.Data;
        String second = (String) tempPair.mSecond;  
        if(n == null || n.Data == null)
        {
            return null;
        }
        else
        {   
            if(second.compareTo(word) == 0)
            {
                return n;
            }
            else if(second.compareTo(word) > 0 )
            {
                return search(word, n.getLeft());
            }
            else
            {
                return search(word, n.getRight());
            }    
        }
    }
    
    //#################################################
    // @par Name
    // trueSearch
    // @purpose
    // Wrapper for trueSearch.
    // @param [in] :
    // String search
    // @return
    // AVLNode recursive
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode trueSearch(String search)
    {
        return trueSearch(root, search);
    }
    
    //#################################################
    // @par Name
    // trueSearch
    // @purpose
    // Robust true search, uses same traversal method as print, searches for 
    // matching node & Pair object's second
    // @param [in] :
    // AVLNode n, String search
    // @return
    // AVLNode retNode
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode trueSearch(AVLNode n, String search)
    {
        if(n != null)
        {  
            Pair p = (Pair)n.Data; 
        
            if (p.mSecond.equals(search))
            {
                retNode = n;
            }
            else if(!(p.mSecond.equals(search)))
            {
                trueSearch(n.getLeft(), search);    
                trueSearch(n.getRight(), search);
            }
        }
        return retNode;
    }
    
    //#################################################
    // @par Name
    // getBinaryEquivalent
    // @purpose
    // Wrapper for robust getBinaryEquivalent, gets length of string argument
    // and loops for each character
    // @param [in] :
    // String str
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void getBinaryEquivalent(String str)
    {
        System.out.println("The binary equivalent of: " + str);
        
        for (int x = 0; x<str.length(); x++)
        {
            this.getBinaryEquivalent(str.charAt(x));
        }
    }
    
    //#################################################
    // @par Name
    // getBinaryEquivalent
    // @purpose
    // Robust getBinaryEquivalent, Searches for character and prints out
    // pairs first data value with 8-bit.
    // @param [in] :
    // char c
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void getBinaryEquivalent(char c)
    {
        String g = Character.toString(c);
        
        AVLNode n = this.trueSearch(g);
        Pair tempPair = (Pair)n.Data;
        String first = (String)tempPair.mFirst;
        
        System.out.print("0" + first + " ");
    }
    
    //#################################################
    // @par Name
    // printTree
    // @purpose
    // prettyPrints the tree's data.
    // @param [in] :
    // AVLNode t
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void printTree(AVLNode n )
    {
        if(n != null)
        {
            printTree(n.getLeft());    
            System.out.println(n.getData());
            printTree(n.getRight());
        }
    } 
}
