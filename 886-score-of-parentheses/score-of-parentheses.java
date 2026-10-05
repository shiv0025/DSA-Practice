class Solution {
    public int scoreOfParentheses(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char a = s.charAt(i);
            if(a == '('){
                st.push(a);
            }else{
                st.pop();
                if(s.charAt(i-1) == '('){
                count += 1 << st.size();
            }
            }
        }
        return count;
        
    }
}