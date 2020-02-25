import java.util.Arrays;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * <p>
 * h 指数的定义: “h 代表“高引用次数”（high citations），
 * 一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * @author Lam
 * @ClassName P274HIndex
 * @date 2020/2/25
 */
public class P274HIndex {
    /**
     * 暴力破解，先排序，在计算出h-index
     */
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int i = citations.length - 1;
        for (; i > 0; i--) {
            if (citations[i] >= citations.length - i) {
                continue;
            }
            break;
        }

        return citations[i] >= citations.length - i ? citations.length - i : citations.length - i - 1;
    }

    /**
     * 桶排序
     */
    public int hIndex1(int[] citations) {
        int length = citations.length;
        int[] bucks = new int[length + 1];
        for (int i = 0; i < length; i++) {
            citations[i] = citations[i] > length ? length : citations[i];
            bucks[citations[i]]++;
        }

        int papers = 0;
        int result = length;
        for (int i = length; i >= 0; i--) {
            papers += bucks[i];
            if (papers >= i) {
                return i;
            }
        }
        return result;
    }

    /**
     * 二分法
     */
    public int hIndex2(int[] citations) {
        int left = 0;
        int right = citations.length;

        while (left < right) {
            int papers = 0;
            int mid = (left + right + 1) / 2;
            for (int citation : citations) {
                if (citation >= mid) {
                    papers++;
                }
            }
            if (papers >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(new P274HIndex().hIndex(citations));
        System.out.println(new P274HIndex().hIndex1(citations));
        System.out.println(new P274HIndex().hIndex2(citations));
    }
}
