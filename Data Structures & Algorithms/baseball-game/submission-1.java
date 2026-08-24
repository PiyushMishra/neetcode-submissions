class Solution {
    Stack<Integer> stack = new Stack<Integer>();

    public int calPoints(String[] operations) {
        for (String op : operations) {
            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);

            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for (Integer num : stack) {
            sum += num;
        }
        return sum;
    }
}