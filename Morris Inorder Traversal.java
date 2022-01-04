// Morris Inorder Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {        
        inorder(root);
        return list;       
    }
  
    public void inorder(TreeNode root){
        TreeNode curr=root;
        TreeNode pre=null;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }else{
                pre=curr.left;
                while(pre.right!=null && pre.right!=curr)
                    pre=pre.right;
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }else{
                    pre.right=null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
    
    
}

    

