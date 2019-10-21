package chapter1_2;

public class HanoiTower {
    private static void moveDISKs(int n, char fromTower, char toTower, char auxTower){

        // 当A中只剩一个盘子时，直接将它从A移动到B即可
        if (n == 1){
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
        }

        // 当A中还剩多个盘子时
        else {
            // 首先将上面的所有盘子从A移动到C
            moveDISKs(n-1, fromTower, auxTower, toTower);
            // 然后将最底下一块盘子从A移动到B
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
            // 最后将上面的所有盘子从C移动到B
            moveDISKs(n-1, auxTower, toTower, fromTower);
        }
    }

    public static void main(String[] args) {
        moveDISKs(3, 'A', 'B', 'C');
    }
}
