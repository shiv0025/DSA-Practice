class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        // Store knowledge as key -> value
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                StringBuilder key = new StringBuilder();
                i++; // move past '('

                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // Replace key with value, or '?' if key doesn't exist
                ans.append(map.getOrDefault(key.toString(), "?"));

            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}