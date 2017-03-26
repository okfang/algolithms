package interview;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by tjoe on 2017/3/26.
 * 2017华为面试题，出差问题
 *   1、共有6个城市，某员工现从5号城市，到endCity出差；
     2、如果一个城市遇上大雾，则该城市（既不能到达，也不能离开）；
     3、给定距离矩阵useHours[][6] = { 0,2,10,5,3,INF,
                                     INF,0,12,INF,INF,10,
                                     INF,INF,0,INF,7,INF,
                                     2,INF,INF,0,2,INF,
                                     4,INF,INF,1,0,INF,
                                     3,INF,1,INF,2,0,};其中单位为小时，INF为1000小时
     4、输入：目的地和大雾城市；
     5、输出最短路径长度和路径，无法到达输出-1；
     实例：
     输入：
     2
     4
     输出：
     6
     [5 1 2]
 */
public class ShortestPath {

    final int INF = 1000;

    int userHours[][]= {{0,2,10,5,3,INF},
                        {INF,0,12,INF,INF,10},
                        {INF,INF,0,INF,7,INF},
                        {2,INF,INF,0,2,INF},
                        {4,INF,INF,1,0,INF},
                        {3,INF,1,INF,2,0}};

    public int[] Dijkstra(int startIndex, int endIndex, int missIndex, int[][] map){

        int len = map[0].length;

        //设置不可达的城市
        for (int i = 0; i < len; i++){
            map[missIndex][i] = INF;
            map[i][missIndex] = INF;
        }

        int[] path = new int[len];//记录每个城市的上一个城市
        int[] dist = new int[len];//记录每个城市到起始点的最短距离
        int[] sign = new int[len];//记录是否可达 1为可达，0为不可达
        Arrays.fill(dist, -1);
        Arrays.fill(path, -1);

        //计算某个城市到各个城市的最短距离
        int min = 0;
        int signal;
        for(int i = 0; i< len; i++){
            signal = 0;//初始设为不可达
            for (int j = 0; j < len; j++){
                if (map[startIndex][i] < INF){
                    dist[i] = map[startIndex][i];
                    path[i] = startIndex;
                    sign[i] = 1;
                }
            }
        }




        return path;
    }

    public static void main(String[] args) {

    }
}
