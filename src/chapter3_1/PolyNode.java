package chapter3_1;

/**
 * PolyNode类，多项式中的每个结点
 */

public class PolyNode {
    int coef;
    int exp;
    PolyNode next;
    public PolyNode(int coef, int exp){
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }
    public PolyNode(){
        this.coef = 0;
        this.exp = 0;
        this.next = null;
    }
}
