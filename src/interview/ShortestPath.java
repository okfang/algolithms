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

    final static int INF = 1000;

    final static int userHours[][]= {{0,2,10,5,3,INF},
                        {INF,0,12,INF,INF,10},
                        {INF,INF,0,INF,7,INF},
                        {2,INF,INF,0,2,INF},
                        {4,INF,INF,1,0,INF},
                        {3,INF,1,INF,2,0}};

    public int[] dijkstra(int start, int end, int miss, int[][] map){

        int startIndex = start -1 ;
        int endIndex = end - 1;
        int missIndex = miss -1;

        int len = map[0].length;

        //设置不可达的城市
        for (int i = 0; i < len; i++){
            map[missIndex][i] = INF;
            map[i][missIndex] = INF;
        }

        int[] path = new int[len];//记录每个城市的上一个城市
        int[] dist = new int[len];//记录每个城市到起始点的最短距离
        int[] sign = new int[len];//记录是否已经测量，1为已经测量，0为未测量
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);
        Arrays.fill(sign, 0);

        //初始化起始城市到各个城市的最短距离
        dist[endIndex] = 0;
        path[endIndex] = INF;//起点
        sign[endIndex] = 1; //终点城市首先加入已测量城市队列

        for (int k = 0; k < len-1; k++){//正常情况，循环len-1次，剩余的为测量的城市测量完

            int min = INF;
            int nextCity = -1;//初始化为不可达
            int signalIndex = -1;
            int temp = 0;

            for (int j = 0; j < len; j++){//找出所有已测量城市并遍历
                if (sign[j] == 1){
                    for (int i = 0; i < len; i++){
                        if (sign[i] == 0){//跳过已经测量过的城市
                            if (map[i][j] < INF){//如果能通行，则考虑是不是最短距离
                                if (map[i][j] + dist[j] < min){
                                    min = map[i][j] + dist[j];
                                    nextCity = j;
                                    signalIndex = i;
                                }
                            }
                        }
                    }
                }
            }
            if (signalIndex == -1){//如果所有未测量城市不能通过已测量城市到达终点，说明这些城市均不可达
                break;
            }
            dist[signalIndex] = min;
            path[signalIndex] = nextCity;
            sign[signalIndex] = 1;
        }

        if (path[startIndex] == -1){
            System.out.println("无法到达");
            for (int i:path){
                System.out.println(i);
            }
            return path;
        }

        System.out.printf("最短路径长度为：%d\n",dist[startIndex]);
        int index = startIndex;
        System.out.printf("路径为:%d",startIndex+1);
        while(path[index] != INF){
            System.out.print(path[index]+1);
            index = path[index];
        }

        return path;
    }



    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        sp.dijkstra(5,2,1,userHours);
    }
}
