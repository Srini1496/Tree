/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.


*/
class Solution {
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res=new ArrayList<TreeNode>();
        mapSubTree(root,new HashMap<String,Integer>());
        return res;
    }
    public String mapSubTree(TreeNode root,Map<String,Integer> map){
        if(root==null)
            return "N";
        String left=mapSubTree(root.left,map);
        String right=mapSubTree(root.right,map);
        String stringRoot=root.val+"l"+left+"r"+right;
        map.put(stringRoot,map.getOrDefault(stringRoot,0)+1);
        if(map.get(stringRoot)==2)
            res.add(root);
        return stringRoot;
    }
}
