package hot100.h9_图论;

import java.util.*;

/**
*@Author CuiChengLong
*@Date 2024/1/25 21:29
*@Description
*/

public class 课程表 {

    int res = 0;
    //每个课程的前置课程，如果没有前置课程的话，说明可以直接学
    // k-某个课，v-某个课的前置课程需要学习的
    HashMap<Integer, Integer> preMap = new HashMap<>();
    // 后置课，k，找前置课
    HashMap<Integer, Integer> suffixMap = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存学过课程
        HashSet<Integer> set = new HashSet<>();
        if (prerequisites.length <= 0) {
            return true;
        }

        prerequisites = removeDuplicates(prerequisites);

        for (int[] arr : prerequisites) {
            preMap.put(arr[0], arr[1]);
            suffixMap.put(arr[1], arr[0]);
        }
        for (int[] arr : prerequisites) {
            if (preMap.get(arr[1]) == null) {
                //从当前可以学的后置课开始深搜
                int temp = 0;
                dfs(arr[1], temp);
            }
        }
        return res >= numCourses;
    }


    public void dfs(int coursesNum, int temp) {
        int preCourses = suffixMap.get(coursesNum);
        temp += 2;
        if (suffixMap.get(preCourses) == null) {
            res = Math.max(res, temp);
            return;
        } else {
            dfs(preCourses, temp);
        }

    }

    public static int[][] removeDuplicates(int[][] inputArray) {
        List<int[]> result = new ArrayList<>();
        c:
        for (int[] pair : inputArray) {
            for (int[] pair2 : inputArray) {
                if (pair[0] == pair2[1] && pair[1] == pair2[0]) {
                    continue c;
                }
            }
            result.add(pair);
        }
        // 将List转换为二维数组
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        课程表 test = new 课程表();
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        test.canFinish(2, prerequisites);
    }

}
