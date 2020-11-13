import java.util.HashMap;

public class Judge {
    public static int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> candidates = new HashMap<Integer, Integer>();

        for (int[] pairs : trust) {
            /* if a candidate is found trusting, candidate gets removed */
            if (candidates.containsKey(pairs[0])) {
                candidates.remove(pairs[0]);
            }
            /* key = townJudgeCandidate, val = trusters */
            if (!candidates.containsKey(pairs[1])) {
                candidates.put(pairs[1], 1);
            }
            /* increment number of people who trust the candidate judge */
            else if (candidates.containsKey(pairs[1])) {
                candidates.put(pairs[1], candidates.get(pairs[1]) + 1);
            }
        }

        /* there can only be one town judge */
        if (candidates.size()==1) {
            /* (Only runs once) gets each key from candidates */
            for (int key : candidates.keySet()) {
                /* A valid judge must have N-1 trustees */
                if (candidates.get(key)==(N-1)) {
                    return key;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] trust01 = new int[][]{{1,2}};
        System.out.println("Example 1: N=2, trust=[[1,2]]");
        System.out.println("Output: " + Judge.findJudge(2, trust01));

        int[][] trust02 = new int[][]{{1,3},{2,3}};
        System.out.println("\nExample 2: N=3, trust=[[1,3], [2,3]]");
        System.out.println("Output: " + Judge.findJudge(3, trust02));

        int[][] trust03= new int[][]{{1,3}, {2,3}, {3,1}};
        System.out.println("\nExample 3: N=3, trust=[[1,3], [2,3], [3,1]]");
        System.out.println("Output: " + Judge.findJudge(3, trust03));

        int[][] trust04 = new int[][]{{1,2}, {2,3}};
        System.out.println("\nExample 4: N=3, trust=[[1,2], [2,3]]");
        System.out.println("Output: " + Judge.findJudge(3, trust04));

        int[][] trust05 = new int[][]{{1,3}, {1,4}, {2,3}, {2,4}, {4,3}};
        System.out.println("\nExample 5: N=4, trust=[[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]]");
        System.out.println("Output: " + Judge.findJudge(4, trust05));
    }
}
