class Solution {

    class Node {
        char left, right;
        int prefix, suffix, best, len;

        Node() {}

        Node(char ch) {
            left = right = ch;
            prefix = suffix = best = len = 1;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        arr = s.toCharArray();

        tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        build(1, 0, n - 1);

        int q = queryIndices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int index, char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.len = a.len + b.len;

        res.left = a.left;
        res.right = b.right;

        res.prefix = a.prefix;
        res.suffix = b.suffix;

        // Entire left segment has same character
        if (a.prefix == a.len && a.right == b.left) {
            res.prefix = a.len + b.prefix;
        }

        // Entire right segment has same character
        if (b.suffix == b.len && a.right == b.left) {
            res.suffix = b.len + a.suffix;
        }

        // Longest answer can be:
        // 1. Completely inside left
        // 2. Completely inside right
        // 3. Crossing the middle
        res.best = Math.max(a.best, b.best);

        if (a.right == b.left) {
            res.best = Math.max(res.best, a.suffix + b.prefix);
        }

        return res;
    }
}