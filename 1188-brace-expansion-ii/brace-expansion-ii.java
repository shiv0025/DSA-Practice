class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> dfs(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {

            // Handle a group: {...}
            if (s.charAt(i) == '{') {
                int start = i;
                int balance = 0;

                // Find matching '}'
                while (i < s.length()) {
                    if (s.charAt(i) == '{') balance++;
                    if (s.charAt(i) == '}') balance--;

                    if (balance == 0) break;
                    i++;
                }

                String inside = s.substring(start + 1, i);

                // Split by top-level commas
                List<String> parts = split(inside);

                Set<String> group = new HashSet<>();

                for (String part : parts) {
                    group.addAll(dfs(part));
                }

                // Concatenate current results with group results
                result = combine(result, group);

            } else {
                // Normal character
                String ch = String.valueOf(s.charAt(i));
                Set<String> single = new HashSet<>();
                single.add(ch);

                result = combine(result, single);
            }

            i++;
        }

        return result;
    }

    // Split expression by commas that are NOT inside braces
    private List<String> split(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') balance++;
            else if (c == '}') balance--;
            else if (c == ',' && balance == 0) {
                parts.add(s.substring(start, i));
                start = i + 1;
            }
        }

        parts.add(s.substring(start));
        return parts;
    }

    // Cartesian product / concatenation
    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}