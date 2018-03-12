/*1. PROBLEM STATEMENT:
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
2. EXAMPLES:
Example 1:
Given tree s:

     1
    / 
 	1
Given tree t:
  1
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:
   4
  / 
 1   
Return false.
3. SOLUTION:
Recursively check 's' tree until 't' is found as a subtree in 's'
*/
package Week6;

import java.util.Scanner;

public class Is_Subtree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeNode s = constructTree();
		TreeNode t = constructTree();
		Subtree_Of_Another_Tree sol = new Subtree_Of_Another_Tree();
		System.out.println(sol.isSubtree(s, t));

	}
	public static TreeNode constructTree() {

		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if (rootData != -1) {
			TreeNode root = new TreeNode(rootData);
			root.left = constructTree();
			root.right = constructTree();
			return root;
		}
		return null;
	}
	public boolean isSubtree(TreeNode s, TreeNode t) {
		return isSubtreeH(s,t,false);
	}
	private boolean isSubtreeH(TreeNode s, TreeNode t,boolean res) {
		if(s==null&&t==null) {
			return true;
		}
		if(s==null||t==null||(res&&s.val!=t.val)) {
			return false;
		}
		if(s.val==t.val) {
			return (isSubtreeH(s.left,t.left,true)&&isSubtreeH(s.right,t.right,true)) || isSubtreeH(s.left,t,false) ||isSubtreeH(s.right,t,false);
		}
		else {
			return isSubtreeH(s.left,t,false)||isSubtreeH(s.right,t,false);
		}
	}

}
