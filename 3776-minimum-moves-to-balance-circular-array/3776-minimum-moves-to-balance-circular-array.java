// 
class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int neg = -1;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                neg = i;
                break;
            }
        }

        if (neg == -1) return 0;

        long moves = 0;
        int b = -balance[neg];

        for (int step = 1; step < n && b > 0; step++) {
            int left = (neg - step + n) % n;
            int right = (neg + step) % n;

            int total = 0;
            if (balance[left] > 0) total += balance[left];
            if (left != right && balance[right] > 0) total += balance[right];

            int take = Math.min(b, total);
            moves += (long) step * take;
            b -= take;

            if (balance[left] > 0) {
                int use = Math.min(balance[left], take);
                balance[left] -= use;
                take -= use;
            }

            if (take > 0 && left != right && balance[right] > 0) {
                balance[right] -= take;
            }
        }

        return b == 0 ? moves : -1;
    }
}
