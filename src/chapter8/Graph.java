package chapter8;

import java.util.*;

/**
 * 判别一个有向图中是否有环路，并把所有环路打印 出来。
 */
public class Graph {

    private static int[][] edges = {
          // 0  1  2  3  4  5  6
            {0, 1, 0, 0, 0, 0, 0}, // 0
            {0, 0, 1, 0, 0, 0, 0}, // 1
            {1, 0, 0, 1, 0, 0, 0}, // 2
            {1, 0, 0, 0, 0, 0, 0}, // 3
            {0, 1, 0, 0, 0, 1, 0}, // 4
            {0, 0, 1, 0, 0, 0, 1}, // 5
            {0, 0, 0, 0, 1, 0, 0}  // 6
    };

    private static boolean[] isVisited = new boolean[edges.length]; // 标记结点是否被访问过
    private static ArrayList<Integer> trace = new ArrayList<>(); // 记录访问行进路线

    // 深度优先搜索
    private static void dfs(int vertices){
        isVisited[vertices] = true;
        trace.add(vertices);
        // 对所有相邻的结点进行遍历
        for (int i=0; i<edges.length; i++){
            // 如果与一个没有访问过的结点直接连通，去访问它
            if (edges[vertices][i] == 1 && !isVisited[i]){
                dfs(i);
            }
            // 如果与开始的结点直接连通，那么就找到里一条回路
            else if (edges[vertices][i] == 1 && i == trace.get(0)){
                trace.add(i);
                System.out.println(trace);
                trace.remove(trace.size()-1);
            }
        }
        // 找到头了，清除访问痕迹，返回上一级，接着找
        trace.remove(trace.size()-1);
        isVisited[vertices] = false;
    }
    private static void clear(boolean[] a){
        for (int i=0; i<a.length; i++){
            a[i] = false;
        }
    }
    public static void main(String[] args) {
        for (int i=0; i<edges.length; i++){
            dfs(i);
            trace.clear();
            clear(isVisited);
        }
    }

}
