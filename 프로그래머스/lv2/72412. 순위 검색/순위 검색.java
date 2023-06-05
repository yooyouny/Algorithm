import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Solution {
    private void forEachKey(int index, String prefix, String[] tokens,
                            Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        scoresMap.values().forEach(Collections::sort);

        return scoresMap;
    }

    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1; 

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return scores.get(start) < score ? scores.size() : start;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scores);
    }

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = Arrays.stream(query)
                .mapToInt(q -> count(q, scoresMap))
                .toArray();

        return answer;
    }
}
