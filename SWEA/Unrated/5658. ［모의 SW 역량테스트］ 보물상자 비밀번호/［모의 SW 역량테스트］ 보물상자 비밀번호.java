import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int answer = 0;
            String arr = scanner.next();
            List<Character> lst = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                lst.add(arr.charAt(i));
            }
            List<Integer> answer_lst = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int m = 0; m < N; m += N / 4) {
                    String temp = "";
                    for (int j = m; j < m + N / 4; j++) {
                        temp += lst.get(j);
                    }
                    int int_temp = Integer.parseInt(temp, 16);
                    answer_lst.add(int_temp);
                }
                lst.add(0, lst.get(lst.size() - 1));
                lst.remove(lst.size() - 1);
            }
            Set<Integer> answer_set = new HashSet<>(answer_lst);
            List<Integer> a_s = new ArrayList<>(answer_set);
            Collections.sort(a_s, Collections.reverseOrder());
            answer = a_s.get(K - 1);
            System.out.println("#" + tc + " " + answer);
        }
    }
}

