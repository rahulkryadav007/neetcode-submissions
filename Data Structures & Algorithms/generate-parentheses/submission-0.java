
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    public void backtrack(List<String> result, StringBuilder current,
                          int open, int close, int n) {

        // Base Case: All parentheses are used
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add opening bracket if open < n
        if (open < n) {
            current.append('(');

            backtrack(result, current, open + 1, close, n);

            current.deleteCharAt(current.length() - 1);
        }

        // Add closing bracket if close < open
        if (close < open) {
            current.append(')');

            backtrack(result, current, open, close + 1, n);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
