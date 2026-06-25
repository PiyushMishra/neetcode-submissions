class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<Integer>();

        Arrays.stream(operations).forEach(
                (str) -> {
                    switch (str) {
                        case "+" -> {
                            int top = st.pop();
                            int newTop = top + st.peek();
                            st.push(top);
                            st.push(newTop);
                        }
                        case "D" -> st.push(2 * st.peek());
                        case "C" -> st.pop();
                        default -> st.push(Integer.parseInt(str));
                    }
                });

        int sum = 0;

        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }

}
