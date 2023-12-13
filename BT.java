
import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class BT{
    Node root;
    BT()
    {
        System.out.println("Please enter your binary tree elements to store elements:");
        Scanner sc=new Scanner(System.in);
        root=createtree(sc);
    }
    Node createtree(Scanner sc){
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        Node n=new Node(data);
        n.left=createtree(sc);
        n.right=createtree(sc);
        return n;

    }
    void display()
    {   

        inorder_traversal(root);
    }
    void inorder_traversal(Node root){
        if(root!=null)
        {
            return;
        }
          inorder_traversal(root.left);
            System.out.println(root.data);
            inorder_traversal(root.right);
          }
   public int countNodes()
   {
     return countNodes(root);
    }
      public  static int  countNodes (Node node)
       {
         if (node==null)
           return 0;
           else 
              {
                int count=1;
                count +=countNodes(node.left);
                count +=countNodes(node.right);
                return count;
}
}
public static int countLeaf(Node node)
{
 if (node == null)
  {
    return 0;
    }
    if (node.left==null && node.right==null)
     return 1;
      else 
           return countLeaf(node.left)+ countLeaf(node.right);
        }
static void LeafNodes(Node node)
{
  if (node==null)
       return;
  if (node.left==null  && node.right==null)
   {
    System.out.println(node.data+" ");
      return;
   }
    if (node.left!=null)
    LeafNodes(node.left);
    if (node.right!=null)
    LeafNodes(node.right);
}
int maxDepth(Node  node)
{
  if (node==null)
   return 0;
 else 
     {
       int lDepth=maxDepth(node.left);
       int rDepth=maxDepth(node.right);   
       
    if (lDepth>rDepth)
        return (lDepth+1);
     else 
             return  (rDepth+1);
}
}
public static void main(String   [] args) 
{
        BT b=new BT();
        b.display();
        int  leafNodes=countLeaf(b.root);
        System.out.println("Total no of leaf nodes are:"+ leafNodes);
        System.out.println("Leaf Nodes are:");
        b.LeafNodes(b.root);
        System.out.println("Total nodes are:"+ b.countNodes());
        System.out.println("Total height of tree is:"+b.maxDepth(b.root));
     }
}
