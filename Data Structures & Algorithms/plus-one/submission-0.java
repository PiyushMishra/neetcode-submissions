class Solution {

    public int[] plusOne(int[] digits) {

        ArrayList<Integer> res = new ArrayList<>();
        int carry = 1; // since we are adding one

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            int r = num % 10;
            carry = num / 10;
            res.add(r);
        }

        if (carry != 0) {
            res.add(carry);
        }

        int[] res1 = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            res1[res.size() - 1 - i] = res.get(i); // reversing the list
        }

        return res1;
    }
}
