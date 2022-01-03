/*
Given a Binary Search Tree. Convert a given BST into a Special Max Heap with the condition that all the values in the left subtree of a node should be less than all the values in the right subtree of the node. This condition is applied on all the nodes in the so converted Max Heap.

Example 1:

Input :
                 4
               /   \
              2     6
            /  \   /  \
           1   3  5    7  

Output : 1 2 3 4 5 6 7 
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7.
*/
class Solution
{   static int i=0;
    public static void convertToMaxHeapUtil(Node root)
    {   i=0;
        Vector<Integer> arr= new Vector<Integer>();
        dfs(root,arr);
        dfsPost(root,arr);
    }
    public static void dfs(Node root,Vector<Integer> arr){
        if(root==null)
        return;
        
        dfs(root.left,arr);
        arr.add(root.data);
        dfs(root.right,arr);
    }
   
    public static void dfsPost(Node root,Vector<Integer> arr){
        if(root==null)
        return;
        dfsPost(root.left,arr);
        dfsPost(root.right,arr);
        root.data=arr.get(i++);
    }
}
