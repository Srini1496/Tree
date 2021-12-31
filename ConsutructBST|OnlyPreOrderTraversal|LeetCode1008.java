/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

 

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder,int l,int r){
        
        if(l==r){ 
            return new TreeNode(preorder[l]);
        }
            
        else if(l>r)
            return null;
        
        TreeNode root=new TreeNode(preorder[l]);
        goodIndex=-1; 
        int leftBound=binarySearch(preorder,l+1,r,preorder[l]);
        
        if(leftBound!=-1){
            root.left=construct(preorder,l+1,leftBound);
            root.right=construct(preorder,leftBound+1,r);
        }else{
            root.right=construct(preorder,l+1,r);
        }            
        return root;
    }
    int goodIndex=-1;
    public int binarySearch(int[] arr,int l,int r, int target){
        
        if(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>target){
                return binarySearch(arr,l,mid-1,target);
            }else{
                goodIndex=mid;
                return binarySearch(arr,mid+1,r,target);
            }
        }else if(l==r){
            if(arr[l]<target)
                return l;
            return goodIndex;
        }else{
            return goodIndex;
        }
        
    }
   
}
