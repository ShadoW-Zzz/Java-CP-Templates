import java.util.Scanner;
public class SegmentTreeSumTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        segmentTree tree = new segmentTree(n,arr);
        for(int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(tree.query(0, 0, n-1, l-1, r-1));
        }
        
        scanner.close();
    }
}


class segmentTree {
    int[] seg;
    public segmentTree(int n, int[] a) {
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
        seg[ind] = seg[2*ind+1]+seg[2*ind+2];
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
            return 0;
        }
        //overlaps with the query
        int mid = left + (right-left)/2;
        int leftsum = query(2*ind+1,left,mid,l,r);
        int rightsum = query(2*ind+2,mid+1,right,l,r);
        return leftsum+rightsum;
    }
}

