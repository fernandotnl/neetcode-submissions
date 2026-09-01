class Solution {
    public boolean isValid(String s) {
       int length = s.length();
       Stack<Character> stack = new Stack<>();
       for(int i=0; i<length; i++) {
        char c = s.charAt(i);
        if ('(' == c || '[' == c || '{' == c) {
            stack.push(c);
        } else {
             if(stack.isEmpty()) return false;
             if (')' == c) {
                char c2 = stack.pop();
                if (c2 != '(') return false;
             } else if (']' == c) {
                char c2 = stack.pop();
                if (c2 != '[') return false;
             } else {
                char c2 = stack.pop();
                if (c2 != '{') return false;
             }
        }
       }
       return stack.isEmpty();
    }
}
