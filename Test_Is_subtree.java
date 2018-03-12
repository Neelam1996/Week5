package Week6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_Is_subtree {

	@Test
	void test_NullTrees() {
		Is_Subtree s_tree=new Is_Subtree();
		assertEquals(true,s_tree.isSubtree(null,null));
	}
	void test_s_null() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode t_root=new TreeNode(2);
		assertEquals(false,s_tree.isSubtree(null,t_root));		
	}
	void test_t_null() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode s_root=new TreeNode(2);
		assertEquals(false,s_tree.isSubtree(s_root,null));		
	}
	void test_ValidCase1() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode s_root=new TreeNode(1);
		s_root.left=new TreeNode(1);
		TreeNode t_root=new TreeNode(1);
		assertEquals(true,s_tree.isSubtree(s_root,t_root));
	}
	void test_ValidCase_False1() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode s_root=new TreeNode(3);
		s_root.left=new TreeNode(4);
		s_root.right=new TreeNode(5);
		s_root.left.left=new TreeNode(1);
		s_root.right.left=new TreeNode(2);
		TreeNode t_root=new TreeNode(3);
		t_root.left=new TreeNode(1);
		t_root.right=new TreeNode(2);
		assertEquals(false,s_tree.isSubtree(s_root,t_root));
	}
	void test_ValidCase_False2() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode s_root=new TreeNode(3);
		s_root.left=new TreeNode(4);
		s_root.right=new TreeNode(5);
		s_root.left.left=new TreeNode(1);
		s_root.left.right=new TreeNode(2);
		s_root.left.right.right=new TreeNode(0);
		TreeNode t_root=new TreeNode(4);
		t_root.left=new TreeNode(1);
		t_root.right=new TreeNode(2);
		assertEquals(false,s_tree.isSubtree(s_root,t_root));
	}
	void test_ValidCase_True() {
		Is_Subtree s_tree=new Is_Subtree();
		TreeNode s_root=new TreeNode(3);
		s_root.left=new TreeNode(4);
		s_root.right=new TreeNode(5);			//				3             4
		s_root.left.left=new TreeNode(1);		//			  /	  \          /  \
		s_root.left.right=new TreeNode(2);		//           4    5         1   2
		s_root.left.right.right=new TreeNode(0);//         /  \    \
		s_root.right.right=new TreeNode(4);     //        1    2     4
		s_root.right.right.left=new TreeNode(2);//             \     / \
		s_root.right.right.right=new TreeNode(1);//            0    1   2
		TreeNode t_root=new TreeNode(4);
		t_root.left=new TreeNode(1);
		t_root.right=new TreeNode(2);
		assertEquals(false,s_tree.isSubtree(s_root,t_root));
		
		
	}

}
