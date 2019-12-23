package chapter4_0;

/**
 * 树的结点类
 */
public class TreeNode {
    protected String element;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(String element){
        this.element = element;
    }

    @Override
    public String toString(){
        return element;
    }
}
