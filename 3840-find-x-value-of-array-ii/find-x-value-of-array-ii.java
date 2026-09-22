class Solution {

    class Node {
        int prod;
        int[] remain;

        Node(int k) {
            prod = 1;
            remain = new int[k];
        }
    }

    int k;
    Node[] tree;
    int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        this.tree = new Node[4 * n];

        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1] % k;
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node result = query(1, 0, n - 1, start, n - 1);

            ans[i] = result.remain[x];
        }

        return ans;
    }

    void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(k);
            tree[node].prod = nums[l];

            tree[node].remain[nums[l]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node merge(Node left, Node right) {
        Node result = new Node(k);

        result.prod = (int) (
            (long) left.prod * right.prod % k
        );

        for (int i = 0; i < k; i++) {
            result.remain[i] = left.remain[i];
        }

        for (int i = 0; i < k; i++) {
            int newRem = (int) (
                (long) i * left.prod % k
            );

            result.remain[newRem] += right.remain[i];
        }

        return result;
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node].prod = value;

            tree[node].remain = new int[k];
            tree[node].remain[value] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            return new Node(k);
        }

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        Node left = query(
            node * 2, l, mid, ql, qr
        );

        Node right = query(
            node * 2 + 1, mid + 1, r, ql, qr
        );

        return merge(left, right);
    }
}