package chapter3_2;

public class JosephusArray {
    public static int josephus(int n, int m){
        boolean[] alive = new boolean[n];
        for (int i=0; i<n; i++){
            alive[i] = true;
        }
        int numOfAlivePeople = n; // 标记场上还有几人未被淘汰
        int index = 0;
        int count = 1;
        while (true){

            // 当前序号的人已经淘汰,那么就继续检查下一个人，直到找到没有淘汰的人
            while (!alive[index]){
                index++;
                if (index == n){
                    index = 0;
                }
            }

            // 当前序号的人要被淘汰,如果他是最后一个被淘汰的,那么就是赢家
            if (count == m){
                alive[index] = false;
                numOfAlivePeople --;
                if (numOfAlivePeople == 0){
                    return index+1;
                }
                count = 1;
                index ++;
                if (index == n){
                    index = 0;
                }
            }
            // 当前序号的人不会被淘汰
            else {
                index ++;
                if (index == n){
                    index = 0;
                }
                count ++;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(josephus(35, 46));
    }
}
