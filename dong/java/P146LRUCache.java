import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author Lam
 * @ClassName P146LRUCache
 * @date 2020/2/21
 */
public class P146LRUCache {
    /**
     * 使用哈希表和双向链表组合解决。
     * 哈希表可以快速插入、查询，
     * 双向链表用于按时间排序。
     */
    class LRUCache {
        int capacity;
        // 用于get、put操作
        private Map<Integer, Node> map;
        // 增加头尾节点保证删除、增加节点步骤统一。
        private Node head, tail;

        // 双向链表，time越早放越后面，time越新放前面
        class Node {
            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            int key;
            int value;
            Node pre;
            Node next;

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        "next=" + next +
                        '}';
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        // 每次删除最久未被访问的节点
        private int popTail() {
            Node node = tail.pre;
            removeNode(node);
            return node.key;
        }

        // 将节点移到最前面
        private void moveToHead(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        // 删除节点
        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            removeNode(node);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                removeNode(node);
                moveToHead(node);
                return;
            }

            node = new Node(key, value);
            if (map.size() == capacity) {
                int oldKey = popTail();
                map.remove(oldKey);
            }
            map.put(key, node);
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new P146LRUCache().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println("list:" + cache.head);
        System.out.println("map:" + cache.map);
        cache.put(3, 3);
        System.out.println("list:" + cache.head);
        System.out.println("map:" + cache.map);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
