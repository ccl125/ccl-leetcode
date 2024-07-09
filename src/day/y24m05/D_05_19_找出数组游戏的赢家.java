package day.y24m05;

import java.util.HashMap;

/**
 * @Author CuiChengLong
 * @Date 2024/5/19 14:49
 * @Description
 */
public class D_05_19_找出数组游戏的赢家 {

    public int getWinner(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (true) {
            if (arr[0] > arr[1]) {if (map.get(arr[0]) == k) {
                    return arr[0];
                }
                swap(arr, 1);
            } else {
                map.put(arr[1], map.getOrDefault(map.get(arr[1] + 1), 1));
                if (map.get(arr[1]) == k) {
                    return arr[1];
                }
                swap(arr, 0);
            }
        }
    }

    public void swap(int[] arr, int index) {
        int temp = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }


    public static void main(String[] args) {
        D_05_19_找出数组游戏的赢家 test = new D_05_19_找出数组游戏的赢家();
        test.getWinner(new int[]{2,1,3,5,4,6,7},2);
    }

}
