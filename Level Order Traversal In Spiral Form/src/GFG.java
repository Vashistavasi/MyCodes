import java.util.ArrayDeque;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class GFG {

}
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
       if(root==null)
       return new ArrayList<Integer>();
            ArrayDeque<Node> queL=new ArrayDeque<Node> ();
            ArrayDeque<Node> queR=new ArrayDeque<Node>();
        queR.add(root);
        ArrayList<Integer> ans=new ArrayList<Integer> ();
        while(!queL.isEmpty() || !queR.isEmpty()){
            while(!queL.isEmpty()){
            Node n=queL.pop();
            ans.add(n.data);
            if(n.left!=null)
            queR.push(n.left);
            if(n.right!=null)
            queR.push(n.right);
            }
            while(!queR.isEmpty()){
            Node n=queR.pop();
            ans.add(n.data);
            if(n.right!=null)
            queL.push(n.right);
            if(n.left!=null)
            queL.push(n.left);

            }
                        
            
        }
        return ans;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}