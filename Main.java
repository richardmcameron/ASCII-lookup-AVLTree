
import java.io.File;
import java.util.Scanner;

public class Main 
{
    
    public static void main(String[] args) 
    {
        boolean cont = true;
        AVL g = new AVL();
        String path = "src\\main\\java\\com\\mycompany\\csis\\project9\\ascii.txt";
        PrettyPrintTree f = new PrettyPrintTree();
        File mFile = new File(path); 
        
        try
        {
            Scanner input = new Scanner(mFile); 
            
            // Populate / balance the tree
            while (input.hasNextLine()) 
            {
                String word  = input.nextLine();

                String decimal =  word.substring(0, word.indexOf("\t")).replaceAll("\\s", "");
                String character = word.substring(word.indexOf("\t"), word.length()).replaceAll("\\s", "");  
                String b = String.format("%7s", Integer.toBinaryString(Integer.parseInt(decimal))).replace(' ', '0');
                Pair tempPair = new Pair(b, character);
                g.insert(tempPair);
            }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
   
        // Pretty Print AVL Tree
        f.graphicalPrint(g.root);
        
        // Binary lookup test
        g.getBinaryEquivalent("1234567890");
        System.out.println();
        g.getBinaryEquivalent("!@#$%^&*()_-+=");
        System.out.println();
        g.getBinaryEquivalent("<>?,./:{}|[]\\");
        System.out.println();
        g.getBinaryEquivalent("abcdefghijklmnopqrstuvwxyz");
        System.out.println();
        g.getBinaryEquivalent("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println();
        
        Scanner reader = new Scanner(System.in);
        while (cont)
        {
            // Lookup or exit the program
            System.out.println("\n");
            System.out.println("L: Lookup");
            System.out.println("X: Exit");
            String input = reader.nextLine();

            switch(input)
            {
                case("X") -> cont = false;
                
                case("L") -> 
                {
                    System.out.println("Please enter some text: ");
                    String find = reader.nextLine();
                    g.getBinaryEquivalent(find);
                    System.out.println();
                }
            } 
        }
    }     
}
