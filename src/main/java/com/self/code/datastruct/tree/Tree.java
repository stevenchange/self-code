package com.self.code.datastruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: gaobo07
 * @Date: 2020/10/2 10:38 下午
 */
public class Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F");
        root.right.right = new TreeNode("G");

        Tree tree = new Tree();
        List<String> result = new ArrayList<>();
        tree.middle(root, result);
        for (String tmp : result){
            System.out.println(tmp);
        }

        System.out.println("=================>");

        result = new ArrayList<>();
        tree.middle2(root, result);
        for (String tmp : result){
            System.out.println(tmp);
        }
    }

    void before(TreeNode root, List<String> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        before(root.left, result);
        before(root.right, result);
    }

    void before2(TreeNode root, List<String> result){
        if(root == null){
            throw new IllegalArgumentException("root is null!");
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null){
                stack.add(node);
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return ;
    }

    void middle(TreeNode root, List<String> result){
        if(root == null){
            return;
        }

        middle(root.left, result);
        result.add(root.val);
        middle(root.right, result);
    }

    void middle2(TreeNode root, List<String> result){
        if(root == null){
            throw new IllegalArgumentException("root is null!");
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode last = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.left == null){
                result.add(node.val);
                continue;
            }

            if(node.right != null){
                stack.add(node.right);
            }
            stack.add(node);
            if(node.left != null){
                stack.add(node.left);
            }
        }
        return ;
    }

    void after(TreeNode root, List<String> result){
        if(root == null){
            return;
        }

        after(root.left, result);
        after(root.right, result);
        result.add(root.val);
    }

    void after2(TreeNode root, List<String> result){
        if(root == null){
            return;
        }

        before(root.left, result);
        before(root.right, result);
        result.add(root.val);

        return ;
    }

}


class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(String x) { val = x; }
}
