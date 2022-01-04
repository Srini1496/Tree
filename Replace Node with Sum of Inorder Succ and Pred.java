/*
Given a binary tree containing n nodes. The problem is to replace each node in the binary tree with the sum of its inorder predecessor and inorder successor.

Examples: 

Resolution Days 2022 GeeksforGeeks

Input :          1
               /   \
              2     3
            /  \  /  \
           4   5  6   7

Output :        11
              /    \
             9      13
            / \    /  \
           2   3   4   3
                  
For 1:
Inorder predecessor = 5
Inorder successor  = 6
Sum = 11

For 4:
Inorder predecessor = 0
(as inorder predecessor is not present)
Inorder successor  = 2
Sum = 2

For 7:
Inorder predecessor = 3
Inorder successor  = 0
(as inorder successor is not present)
Sum = 3
*/
// function to store the inorder traversal
// of the binary tree in 'arr'
static void storeInorderTraversal( Node root,
                                Vector<Integer> arr)
{
    // if root is null
    if (root==null)
        return;
  
    // first recur on left child
    storeInorderTraversal(root.left, arr);
  
    // then store the root's data in 'arr'
    arr.add(root.data);
  
    // now recur on right child
    storeInorderTraversal(root.right, arr);
}
  
// function to replace each node with the sum of its
// inorder predecessor and successor
static void replaceNodeWithSum( Node root,
                        Vector<Integer> arr, INT i)
{
    // if root is null
    if (root==null)
        return;
  
    // first recur on left child
    replaceNodeWithSum(root.left, arr, i);
  
    // replace node's data with the sum of its
    // inorder predecessor and successor
    root.data = arr.get(i.data - 1) + arr.get(i.data + 1);
  
    // move 'i' to point to the next 'arr' element
    i.data++;
  
    // now recur on right child
    replaceNodeWithSum(root.right, arr, i);
}
  
// Utility function to replace each node in binary
// tree with the sum of its inorder predecessor
// and successor
static void replaceNodeWithSumUtil( Node root)
{
    // if tree is empty
    if (root==null)
        return;
  
    Vector<Integer> arr= new Vector<Integer>();
  
    // store the value of inorder predecessor
    // for the leftmost leaf
    arr.add(0);
  
    // store the inorder traversal of the tree in 'arr'
    storeInorderTraversal(root, arr);
  
    // store the value of inorder successor
    // for the rightmost leaf
    arr.add(0); 
  
    // replace each node with the required sum
    INT i = new INT();
     
    i.data=1;
     
    replaceNodeWithSum(root, arr, i);
}
