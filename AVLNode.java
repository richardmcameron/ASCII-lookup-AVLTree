
public class AVLNode<T> implements AVLNodeGraphicalPrint
{
    String key = null;
    T Data = null;
    AVLNode left = null;
    AVLNode right = null;
    int height = 0;
    int count;

    //#################################################
    // @par Name
    // AVLNode
    // @purpose
    // Constructor for the AVLNode class.
    // @param [in] :
    // String key, String data
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode(String key, T data)
    {
        this.key = key;
        this.Data = data;
        left = null;
        right = null;
        height = 0;
        count = 0;
    }

    //#################################################
    // @par Name
    // getKey
    // @purpose
    // getter for key field in class.
    // @param [in] :
    // None
    // @return
    // String key
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public String getKey()
    {
        return key;
    }
    
    //#################################################
    // @par Name
    // getCount
    // @purpose
    // getter for count field in class.
    // @param [in] :
    // None
    // @return
    // String key
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int getCount()
    {
        return count;
    }
    
    //#################################################
    // @par Name
    // setCount
    // @purpose
    // setter for count field in class.
    // @param [in] :
    // None
    // @return
    // String key
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void setCount(int x)
    {
        count = x;
    }
    
    //#################################################
    // @par Name
    // addToCount
    // @purpose
    // Adds to the AVLNodes count (based off word occurrences).
    // @param [in] :
    // None
    // @return
    // String key
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void addToCount(int x)
    {
        count = count + x;
    }
    
    //#################################################
    // @par Name
    // getData
    // @purpose
    // getter for data field of class.
    // @param [in] :
    // None.
    // @return
    // String Data
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public Pair getData()
    {
        return (Pair) Data;
    }

    //#################################################
    // @par Name
    // getLeft
    // @purpose
    // getter for left child.
    // @param [in] :
    // None
    // @return
    // AVLNode left
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode getLeft()
    {
        return left;
    }

    //#################################################
    // @par Name
    // setLeft
    // @purpose
    // setter for leftChild AVLNode.
    // @param [in] :
    // AVLNode n
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void setLeft(AVLNode n)
    {
        left = n;
    }
    
    //#################################################
    // @par Name
    // setRight
    // @purpose
    // getter for right child.
    // @param [in] :
    // None
    // @return
    // AVLNode right
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public AVLNode getRight()
    {
        return right;
    }

    //#################################################
    // @par Name
    // setRight
    // @purpose
    // setter for rightChild AVLNode.
    // @param [in] :
    // None+
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void setRight(AVLNode n)
    {
        right = n;
    }

    //#################################################
    // @par Name
    // getHeight
    // @purpose
    // getter for current height / depth of tree.
    // @param [in] :
    // None
    // @return
    // int height
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public int getHeight()
    {
        return height;
    }

    //#################################################
    // @par Name
    // setHeight
    // @purpose
    // sets the current height / depth of tree.
    // @param [in] :
    // int h
    // @return
    // None
    // @par References
    // None
    // @par Notes
    // None
    //###############################################
    public void setHeight(int h)
    {
        height = h;
    }
}
