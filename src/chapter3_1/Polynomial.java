package chapter3_1;

public class Polynomial {
    PolyNode head;
    PolyNode current;

    public Polynomial() {
        this.head = new PolyNode();
        current = head;
        head.next = null;
    }

    /**
     * 项多项式中插入一项
     * @param node 所要新增的项
     */
    public void insert(PolyNode node) {
        current.next = node;
        current = node;
    }

    // 求两多项式之和，利用归并算法的思想
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        p1.current = p1.head.next;
        p2.current = p2.head.next;

        // 当两个多项式都还没有到最后一项时，比较指数大小，
        // 指数相同时系数相加然后insert，指数不同时，insert指数小的那个
        while (p1.current != null && p2.current != null) {
            if (p1.current.exp == p2.current.exp) {
                int newCoef = p1.current.coef + p2.current.coef;
                if (newCoef != 0){
                    result.insert(new PolyNode(newCoef, p1.current.exp));
                }
                p1.current = p1.current.next;
                p2.current = p2.current.next;
            } else if (p1.current.exp < p2.current.exp) {
                result.insert(p1.current);
                p1.current = p1.current.next;
            } else {
                result.insert(p2.current);
                p2.current = p2.current.next;
            }
        }

        // 当p2达到最后一项时，插入p1所有剩下的项
        while (p1.current != null) {
            result.insert(p1.current);
            p1.current = p1.current.next;
        }

        // 当p1达到最后一项时，插入p2所有剩下的项
        while (p2.current != null) {
            result.insert(p2.current);
            p2.current = p2.current.next;
        }
        return result;
    }

    public void print(){
        current = head.next;
        while (current != null){
            System.out.print(" "+current.coef+"x^"+current.exp+" ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.insert(new PolyNode(-8, 2));
        p1.insert(new PolyNode(100, 3));
        p1.insert(new PolyNode(45, 5));
        p1.insert(new PolyNode(3, 20));
        System.out.print("p1 = ");
        p1.print();

        Polynomial p2 = new Polynomial();
        p2.insert(new PolyNode(8, 2));
        p2.insert(new PolyNode(7, 3));
        p2.insert(new PolyNode(4, 4));
        p2.insert(new PolyNode(6, 18));
        p2.insert(new PolyNode(4, 20));
        System.out.print("p2 = ");
        p2.print();

        Polynomial p3 = add(p1, p2);
        System.out.print("p1 + p2 = ");
        p3.print();
    }
}
