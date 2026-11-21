class Solution {
    ArrayList<Integer>[] old;
    ArrayList<Integer>[] finalTree;
    int[] last;
    int[] answer;
    String s;
    public int[] findSubtreeSizes(int[] parent, String str) {
        int n = parent.length;
        s = str;
        old = new ArrayList[n];
        finalTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            old[i] = new ArrayList<>();
            finalTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            old[parent[i]].add(i);
        }
        last = new int[26];
        Arrays.fill(last, -1);
        buildTree(0, -1);
        answer = new int[n];
        dfsSize(0);
        return answer;
    }
    void buildTree(int u, int p) {
        int ch = s.charAt(u) - 'a';
        int previous = last[ch];
        int newParent = p;
        if (previous != -1) {
            newParent = previous;
        }
        if (newParent != -1) {
            finalTree[newParent].add(u);
        }
        last[ch] = u;
        for (int v : old[u]) {
            buildTree(v, u);
        }
        last[ch] = previous;
    }
    int dfsSize(int u) {
        int size = 1;
        for (int v : finalTree[u]) {
            size += dfsSize(v);
        }
        answer[u] = size;
        return size;
    }
}