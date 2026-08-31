class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<Integer>();
        int result = 0;
        for(int i=0; i<operations.length; i++) {
            String op = operations[i];
            if ("+".equals(op)) {
                int lastScore = record.pop();
                int beforeLastScore = record.pop();
                int sum = lastScore + beforeLastScore;
                record.push(beforeLastScore);
                record.push(lastScore);
                record.push(sum);
                result+=sum;
            } else if ("C".equals(op)) {
                result-=record.pop();
            } else if ("D".equals(op)) {
                int lastScore = record.peek();
                int doubled = 2*lastScore;
                record.push(doubled);
                result+=doubled;
            } else {
                int score = Integer.parseInt(op);
                record.push(score);
                result+=score;
            }
        }
        return result;
    }
}