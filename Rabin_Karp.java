import java.util.*;


public class Rabin_Karp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            String t = sc.next();
            
            rabin_karp(s, t);
        }
        sc.close();
    }

    public static void rabin_karp(String s, String t) {
        int occurences = 0;
        int mod = (int)(1e9+7);
        int n = t.length();
        int m = s.length();

        int hash_t = 0;
        int hash_s = 0;
        List<Integer> res = new ArrayList<>();

        int base = 26; // base for hash calculation
        int basePower = 1; // base^(n-1) % mod
        for (int i = 0; i < n - 1; i++) {
            basePower = (basePower * base) % mod;
        }

        // Calculate initial hashes for t and the first window of s
        for(int i = 0; i < n; i++) {
            hash_t = (hash_t * base + (t.charAt(i) - 'a')) % mod;
            hash_s = (hash_s * base + (s.charAt(i) - 'a')) % mod;
        }

        int l = 0;
        for(int r = n; r <= m; r++) {
            if(hash_s == hash_t) {
                // Verify by comparing the actual strings
                if (s.substring(l, r).equals(t)) {
                    occurences++;
                    res.add(l + 1);
                }
            }
            if(r < m) {
                hash_s = (hash_s - (s.charAt(l) - 'a') * basePower) % mod;
                hash_s = (hash_s * base + (s.charAt(r) - 'a')) % mod;
                l++;
            }
            
        }
        if(occurences == 0) {
            System.out.println("NOT FOUND");
        }else {
            System.out.println(occurences);
            for(int i : res) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
}
