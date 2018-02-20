class TreeNode
{
    int data;
    TreeNode leftChild,rightChild;
    TreeNode(int data)
    {
        this.data=data;
        leftChild=null;
        rightChild=null;
    }
}
public class TreeTest
{
    public TreeNode root;

    public TreeTest() {
    this.root=null;
    }
    
    public void insert(int data)
    {
        TreeNode temp = new TreeNode(data);
        if(root==null)
        {
            root=temp;
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while(true)
        {
            parent=current;
            if(data<current.data)
            {
                current=current.leftChild;
                if(current==null)
                {
                    parent.leftChild=temp;
                    return;
                }
            }
            else
            {
                current=current.rightChild;
                if(current==null)
                {
                    parent.rightChild=temp;
                    return;
                }
            }
        }
    }
    public void displayInOrder(TreeNode root)
    {
        if(root!=null)
        {
            displayInOrder(root.leftChild);
            System.out.print(" "+root.data);
            displayInOrder(root.rightChild);
        }
    }
    public void displayPreOrder(TreeNode root)
    {
        if(root!=null)
        {
            System.out.print(" "+ root.data);
            displayPostOrder(root.leftChild);
            displayPostOrder(root.rightChild);
        }
    }
    public void displayPostOrder(TreeNode root)
    {
        if(root!=null)
        {
            displayPostOrder(root.leftChild);
            displayPostOrder(root.rightChild);
            System.out.print(" "+ root.data);
        }
    }
    
    public int findHeight(TreeNode root)
    {
        if(root==null)
        {
        return 0;
        }
        int left1=findHeight(root.leftChild);
        int right1=findHeight(root.rightChild);
        return (Math.max(left1, right1))+1;
    }
    public void callDisplay(TreeNode root)
    {
        System.out.println("");
        System.out.println("Different nodes at the different level ");
        
        int h = findHeight(root);
        for(int i=1;i<=h;i++)
        {
            displayNode(root,i);
            System.out.println("");
        }
    }
    public void displayNode(TreeNode root,int height)
    {
        if(root==null)
        {
            return;
        }
        if(height==1)
        {
            System.out.print("  " +root.data);
        }
        if(height>1)
        {
            displayNode(root.leftChild, height-1);
            displayNode(root.rightChild, height-1);
        }
    }
    public void treeDiameter(TreeNode root)
    {
        int left=findHeightLeft(root.leftChild);
        int right=findHeightRight(root.rightChild);
        int diameter=left+right+1;
        System.out.println("Diameter of the tree is: " + diameter);
    }
    public int findHeightLeft(TreeNode root)
                {
        if(root==null)
        {
            return 0;
        }
        int left1=findHeightLeft(root.leftChild);
        int right1=findHeightLeft(root.rightChild);
        return (Math.max(left1, right1))+1;
                }
    public int findHeightRight(TreeNode root)
                {
        if(root==null)
        {
            return 0;
        }
        int left1=findHeightLeft(root.leftChild);
        int right1=findHeightLeft(root.rightChild);
        return (Math.max(left1, right1))+1;
                }
    String ancestors;
    public void findAncestor(TreeNode root, int data)
    {
        if(root==null)
        {
            System.out.println("Number "+data+" not found");
            return;
        }
        if(data<root.data)
        {
            ancestors+=" "+root.data;
            findAncestor(root.leftChild, data);
        }
        if(data>root.data)
        {
            ancestors+=" "+root.data;
            findAncestor(root.rightChild, data);
        }
        if(data==root.data)
        {
            
            System.out.println(data+ " found and its ancestors are "+ancestors.replace("null", ""));
        }
    }
    public static void main(String args[])
    {
        TreeTest T = new TreeTest();
        T.insert(13);
        T.insert(3);
        T.insert(1);
        T.insert(23);
        T.insert(33);
        T.insert(10);
        T.insert(12);
        T.insert(9);
        T.insert(11);
        T.insert(14);
        T.displayInOrder(T.root);
        System.out.println("");
        T.displayPreOrder(T.root);
        System.out.println("");
        T.displayPostOrder(T.root);
        System.out.println(""); 
        System.out.println("Height of the tree is: "+T.findHeight(T.root));
        T.callDisplay(T.root);
        System.out.println("");
        T.treeDiameter(T.root);
        T.findAncestor(T.root, 1);
    }
}
