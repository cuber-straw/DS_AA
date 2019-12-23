package chapter1_1;

public class chapter1_1 {

    /**
     *
     * @param n 从n个数里
     * @param r 选r个数
     * @param a 临时储存被选数的数组，a.size() > r
     * @param index 当前待选数在数组中的下标
     */
    private static void func(int n, int r, int[] a, int index){
        if (r == 0){ // 选完了，可以进行一次输出
            for (int i=0; i<index; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        else {
            for (int i=n; i>=r; i--){
                a[index] = i;
                func(i-1, r-1, a, index+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[50];
        func(6, 4, a, 0);
    }
}
