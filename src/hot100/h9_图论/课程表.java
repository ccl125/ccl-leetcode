package hot100.h9_图论;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2024/1/25 21:29
 * @Description
 */

public class 课程表 {

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2)
            return true;
        // 每个节点的入度
        HashMap<Integer, Integer> inComing = new HashMap<>();
        for (int[] arr : prerequisites) {
            if (inComing.get(arr[0]) != null) {
                inComing.put(arr[0], inComing.get(arr[0]) + 1);
            } else {
                inComing.put(arr[0], 1);
            }
            inComing.put(arr[1], inComing.getOrDefault(arr[1], 0));
        }
        // 每个节点的后续节点，k - prerequisites[1], v - List<Integer>
        HashMap<Integer, List<Integer>> nextList = new HashMap<>();
        for (int[] arr : prerequisites) {
            if (nextList.containsKey(arr[1])) {
                nextList.get(arr[1]).add(arr[0]);
            } else {
                nextList.put(arr[1], new ArrayList<>());
                nextList.get(arr[1]).add(arr[0]);
            }
        }

        // Kahn
        Queue<Integer> qu = new LinkedList<>();
        // 入度为0的入队列
        for (Map.Entry<Integer, Integer> incoming : inComing.entrySet()) {
            if (incoming.getValue() == 0) {
                qu.offer(incoming.getKey());
            }
        }
        if (qu.size() == 0)
            return false;
        while (!qu.isEmpty()) {
            // System.out.println(numCourses);
            // 入度为0的节点出队列
            int zeroInComing = qu.poll();
            // 将出队列的入度为0的节点的后续节点的入度
            List<Integer> curNext = nextList.get(zeroInComing);
            if (curNext == null)
                continue;
            for (Integer next : curNext) {
                if (inComing.get(next) != null) {
                    inComing.put(next, inComing.get(next) - 1);
                    if (inComing.get(next) == 0) {
                        qu.offer(next);
                    }
                }
            }

        }
        for (int key : inComing.keySet()) {
            if (inComing.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        课程表 test = new 课程表();
//        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(test.canFinish(2, prerequisites));
    }

}
