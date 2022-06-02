
public class Pair<F,S> 
{
   F mFirst;
   S mSecond;
   
   //#################################################
   // @par Name
   // Pair
   // @purpose
   // Constructor, sets member variables.
   // @param [in] :
   // Templates F and S (first and second)
   // @return
   // None
   // @par References
   // None
   // @par Notes
   // None
   //###############################################
   public Pair(F first, S second) 
   {
       this.mFirst = first;
       this.mSecond = second;
   }

   //#################################################
   // @par Name
   // getFirst
   // @purpose
   // This is an accessor method that will return the first of the pair values.
   // @param [in] :
   // None
   // @return
   // mFirst member variable, presumably of type Integer
   // @par References
   // None
   // @par Notes
   // Getter of the member variable mFirst,set by constructor
   //###############################################
   public F getFirst() 
   {
       return mFirst;
   }

   //#################################################
   // @par Name
   // getSecond
   // @purpose
   // This is an accessor method that will return the first of the pair values.
   // @param [in] :
   // None
   // @return
   // mSecond member variable, presumably of type Integer
   // @par References
   // None
   // @par Notes
   // Getter of the member variable mSecond,set by constructor.
   //###############################################
   public S getSecond() 
   {
       return mSecond;
   }
   
   //#################################################
   // @par Name
   // setFirst
   // @purpose
   // This is an accessor method that will return the first of the pair values.
   // @param [in] :
   // Template F
   // @return
   // None
   // @par References
   // None
   // @par Notes
   // Setter of the member variable mFirst.
   //###############################################
   public void setFirst(F f) 
   {
       this.mFirst = f;
   }

   //#################################################
   // @par Name
   // setSecond
   // @purpose
   // This is an accessor method that will return the first of the pair values.
   // @param [in] :
   // Template S
   // @return
   // None
   // @par References
   // None
   // @par Notes
   // Setter of the member variable mSecond.
   //###############################################
   public void setSecond(S s) 
   {
       this.mSecond = s;
   }

   //#################################################
   // @par Name
   // toString
   // @purpose
   // Format of printing a pair object.
   // @param [in] :
   // None
   // @return
   // Returns a formatted string of both variables mFirst and mSecond.
   // @par References
   // None
   // @par Notes
   // Called whenever printList is called in PairList.java, makes for seamless
   // console output formatting. Overrides default toString func, denoted by @
   //###############################################
   @Override
   public String toString() 
   {
       return "<First:"+this.mFirst+", Second:"+this.mSecond+">";
   }
  
}
