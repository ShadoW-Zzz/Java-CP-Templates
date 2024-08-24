class DisjointSet {
    public int[] parent;
    public int[] size;
    public DisjointSet(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]); // path compression
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_u]+size[ulp_v];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u]+size[ulp_v];
        }
    }
}
