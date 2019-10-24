package chapter3_2;

public class JosephusArray {
    public static int josephus(int n, int m){
        boolean[] alive = new boolean[n]; // 布尔值为false表示已被淘汰
        for (int i=0; i<n; i++){
            alive[i] = true;
        }
        int numOfAlivePeople = n; // 标记场上还有几人未被淘汰
        int index = 0; // 指向当前应该报数的人的下标
        int count = 1; // 当前被指向的人应该报的数
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
                if (numOfAlivePeople == 0){ // 当前index指向的人是最后一个被淘汰的，即赢家
                    return index+1;
                }
                count = 1;
                index ++;
                if (index == n){
                    index = 0;
                }
            }
            // 当前序号的人不被淘汰，继续下一个人报数
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
