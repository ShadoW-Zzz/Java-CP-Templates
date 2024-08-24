//Template for segment Tree min
class SegmentTree {
    int[] seg;
    public SegmentTree(int n, int[] a) {
        seg = new int[4*n];
        buildTree(0,0, n-1, a);
    }
    
    //this is for the querying sum of the range [l,r]
    public void buildTree(int ind, int low, int high, int[] a) {
        if(low == high) {
            seg[ind] = a[low];
            return;
        }
        int mid = low + (high-low)/2;
        buildTree(2*ind+1, low, mid, a);
        buildTree(2*ind+2, mid+1, high, a);
        seg[ind] = Math.min(seg[2*ind+1],seg[2*ind+2]);
        return;
    }
    
    // left and right for tree, l,r for query
    public int query(int ind, int left, int right, int l, int r) {
        //fully lies in the interval of the query
        if(left >= l && right <= r) {
            return seg[ind];
        }
        // lies out side
        if(right < l || left > r) {
            return Integer.MAX_VALUE;
        }
        //overlaps with the query
        int mid = left + (right-left)/2;
        int leftsum = query(2*ind+1,left,mid,l,r);
        int rightsum = query(2*ind+2,mid+1,right,l,r);
        return Math.min(leftsum,rightsum);
    }
}