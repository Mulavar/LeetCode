import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P77Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 1, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int idx, int k) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
//        if (idx > n) {
//            return;
//        }

        // n - (k - combination.size() - 1)是为了剪枝，不剪枝速度值只超过30%多，剪枝后达到99%
        for (int i = idx; i <= n - (k - combination.size() - 1); i++) {
            combination.add(i);
            backtrack(result, combination, n, i + 1, k);
            combination.remove(combination.size() - 1);
        }

        //另一种写法，直接使用递归分解为有idx和无idx的情况
//        combination.add(idx);
//        backtrack(result, combination, n, idx +1, k);
//        combination.remove(combination.size()-1);
//        backtrack(result,combination, n, idx+1, k);
    }
}
