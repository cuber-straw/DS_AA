package chapter1_2;

public class HanoiTower {
    private static void moveDISKs(int n, char fromTower, char toTower, char auxTower){
        if (n == 1){
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
        }
        else {
            moveDISKs(n-1, fromTower, auxTower, toTower);
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
            moveDISKs(n-1, auxTower, toTower, fromTower);
        }
    }

    public static void main(String[] args) {
        moveDISKs(3, 'A', 'B', 'C');
    }
}
