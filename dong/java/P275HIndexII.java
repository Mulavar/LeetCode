/**
 * @author Lam
 * @ClassName P274HIndexII
 * @date 2020/2/25
 */
public class P275HIndexII {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right) {
            int h = (left + right + 1) / 2;
            if (citations[citations.length- h]>=h) {
                left = h;
            } else {
                right = h - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1, 3, 5, 6};
        System.out.println(new P275HIndexII().hIndex(citations));
    }
}

