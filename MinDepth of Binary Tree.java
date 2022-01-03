/*
Given a binary tree, find its minimum depth.

Example 1:

Input:
            1
          /   \
         3     2
        /
       4           

Output: 2

Explanation:
Minimum depth is between nodes 1 and 2 since
minimum depth is defined as  the number of 
nodes along the shortest path from the root 
node down to the nearest leaf node.

Example 2:

Input:
             10
          /     \
        20       30
          \        \   
          40        60 
                   /
                  2 

Output: 3

Explanation:
Minimum depth is between nodes 10,20 and 40.

Your Task:  
You don't need to read input or print anything. Complete the function minDepth() which takes the root node as an input parameter and returns the minimum depth.
*/
class Solution
{
	int minDepth(Node root)
	{
	    if(root.left==null && root.right==null){
	        return 1;
	    }
	    else if(root.left==null){
	        return 1+minDepth(root.right);
	    }else if(root.right==null){
	        return 1+ minDepth(root.left);
	    }
	    return 1+Math.min(minDepth(root.left),minDepth(root.right));
	}
}
