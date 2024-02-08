package temp_list;

import java.util.Arrays;

public class APS기본_Queue2_삽입정렬 {
    public static void main(String[] args) {
        int[] data = { 69, 10, 30, 2, 7, 16, 8, 31, 22 };

        // 정렬되지 않은 집합의 원소를 하나씩 순회
        // 원소의 가장 앞을 정렬된 집합이라고 가정
        // 1번부터 비교
        for (int i = 1; i < data.length; i++) {
            int key = data[i];

            // 정렬된 집합에 접근해 뒤에서 부터 하나씩 비교
            // key가 놓일 위치를 찾음
            int j = i - 1;
            for (; j >= 0 && data[j] > key; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = key;
        }
        System.out.println(Arrays.toString(data));
    }
}
