public class chapter3_2 {
    class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }
    int josephus(int n, int m){
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
            if (current.next == current){
                return current.value;
            }
        }
    }
    ListNode initial(int n){
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
        chapter3_2 chapter3_2 = new chapter3_2();
        System.out.println(chapter3_2.josephus(8, 4));
    }
}
