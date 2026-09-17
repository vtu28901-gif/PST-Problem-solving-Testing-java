import java.util.*;

enum Color {
    RED,
    GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % 1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % 1000000007;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {
    static Tree solve(Scanner sc) {
        int n = sc.nextInt();

        int[] values = new int[n + 1];
        Color[] colors = new Color[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        return buildTree(1, 0, 0, values, colors, graph);
    }

    static Tree buildTree(int node, int parent, int depth, int[] values, Color[] colors, List<Integer>[] graph) {
        boolean leaf = node != 1 && graph[node].size() == 1;

        if (leaf) {
            return new TreeLeaf(values[node], colors[node], depth);
        }

        TreeNode treeNode = new TreeNode(values[node], colors[node], depth);

        for (int next : graph[node]) {
            if (next != parent) {
                treeNode.addChild(buildTree(next, node, depth + 1, values, colors, graph));
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Tree root = solve(sc);

        SumInLeavesVisitor visitor1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor visitor2 = new ProductOfRedNodesVisitor();
        FancyVisitor visitor3 = new FancyVisitor();

        root.accept(visitor1);
        root.accept(visitor2);
        root.accept(visitor3);

        System.out.println(visitor1.getResult());
        System.out.println(visitor2.getResult());
        System.out.println(visitor3.getResult());
    }
}

/*
Input:
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

Output:
24
40
15
*/
