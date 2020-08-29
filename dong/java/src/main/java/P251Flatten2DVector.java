import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lam
 * @date 2020/8/30
 */
public class P251Flatten2DVector {
    class Vector2D {
        List<Integer> backup = new ArrayList<>();
        Iterator<Integer> iter;


        public Vector2D(int[][] v) {
            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    backup.add(v[i][j]);
                }
            }

            iter = backup.iterator();
        }

        public int next() {
            return iter.next();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }
    }
}
