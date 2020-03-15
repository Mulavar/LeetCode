/**
 * @author Lam
 * @ClassName P278FirstBadVersion
 * @date 2020/2/25
 */
public class P278FirstBadVersion {
    native boolean isBadVersion(int version);

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left<right) {
            int mid = (left+right)/2;
            if (isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
