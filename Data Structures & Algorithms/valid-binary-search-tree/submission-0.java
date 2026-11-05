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
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }
    private boolean validate(TreeNode node,Integer high, Integer low){
        if(node==null){
            return true;
        }
        if(low!=null&&node.val<=low){
            return false;
        }
        if(high!=null&&node.val>=high){
            return false;
        }
        return validate(node.left,node.val,low)&&validate(node.right,high,node.val);
    }
}
