public class chapter1_1 {
    private static void func(int n, int r, int[] a, int m){
        if (r == 0){
            for (int i=0; i<m; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        else {
            for (int i=n; i>=r; i--){
                a[m] = i;
                func(i-1, r-1, a, m+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[50];
        func(5, 3, a, 0);
    }
}
