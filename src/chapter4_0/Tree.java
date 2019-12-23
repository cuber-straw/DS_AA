package chapter4_0;

import java.util.Stack;

/**
 * 建立一棵二叉树，并输出前序、中序、后序遍历结果
 */
public class Tree {
    private TreeNode root;

    /**
     * 根据后缀表达式构造树
     * 输入格式：数字与数字，数字与符号之间用空格隔开
     */
    public Tree (String suffixStr){
        String[] element = suffixStr.split(" ");
        Stack<TreeNode> stack = new Stack<>();
        // 扫描一遍输入的表达式
        for (int i=0; i<element.length; i++){
            // 如果是运算符 + - * /，就新建一个结点，从栈中弹出一个，是右孩子，再弹出一个，是左孩子
            if (isOperator(element[i])){
                TreeNode node = new TreeNode(element[i]);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
            // 如果遇到数字，就压入栈中
            else {
                stack.push(new TreeNode(element[i]));
            }
        }
        this.root = stack.pop();
    }
    private boolean isOperator(String s){
        return s.equals("+")  || s.equals("-")  || s.equals("*")  || s.equals("/");
    }

    /**
     * 输出树的前序遍历
     */
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.element+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 输出树的中序遍历
     */
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.element+" ");
        inOrder(node.right);
    }

    /**
     * 输出树的后序遍历
     */
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.element+" ");
    }

    public static void main(String[] args) {
        Tree tree = new Tree("43 4 - 5 * 3 4 + -");
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }


}
