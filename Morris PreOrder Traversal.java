//Morris pre order traversal
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> res){
       TreeNode curr=root;
       TreeNode prev;
        while(curr!=null){
            if(curr.left==null){
                res.add(curr.val);
                curr=curr.right;
            }else{
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==curr){
                     prev.right=null;
                     curr=curr.right;
                    
                }else{
                    res.add(curr.val);
                    prev.right=curr;
                    curr=curr.left;
                }
            }
        }
    }
}
