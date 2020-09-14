package bean;

/**
 * @author Lam
 * @ClassName TrieTreeNode
 * @date 2020/9/13
 */
public class TrieTreeNode {
    private int count;
    private int prefix;
    private static final int ASCII_LENGTH = 128;
    private String value;
    private TrieTreeNode[] children;

    public TrieTreeNode() {
        children = new TrieTreeNode[ASCII_LENGTH];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TrieTreeNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieTreeNode[] children) {
        this.children = children;
    }
}
