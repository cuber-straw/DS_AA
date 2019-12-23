package chapter3_2;

public class JosephusList {

    /**
     *
     * @param n 圆桌边所围的总人数编号为1, 2, 3, ..., n-1, n
     * @param m 每m人就淘汰一人
     * @return 最后留下的人的序号
     */
    public int josephus(int n, int m){
        ListNode current = initial(n);
        int count = 1;
        while (true){
            if (count<m-1){
                count ++;
                current = current.next;
            }
            else if (count == m-1){
                current.next = current.next.next;
                count = 1;
                current = current.next;
            }

            // 只剩下最后一人，返回他的编号
            if (current.next == current){
                return current.value;
            }
        }
    }

    // 初始化圆桌，构造一个含有n个结点的环形列表，结点编号从1到n
    private ListNode initial(int n){
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i=2; i<=n; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        current.next = head;
        return head;
    }

    public static void main(String[] args) {
        JosephusList chapter3_2 = new JosephusList();
        System.out.println(chapter3_2.josephus(57, 46));
    }
}
