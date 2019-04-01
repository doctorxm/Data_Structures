package Set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author qqg
 * @Date 2019/2/20
 * @Description: PACKAGE_NAME
 */
public class BST<E extends Comparable<E>> {
    public class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根节点的二分搜索树插入元素e,递归算法
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //判断二叉树中是否包含某个元素
    public boolean contains(E e) {
        return contain(root, e);
    }

    //判断以node为根节点二叉树是否包含某个元素
    public boolean contain(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) > 0) {
            return contain(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contain(node.left, e);
        } else {
            return true;
        }
    }

    //先序遍历
    public void preOrder() {
        preOrder(root);
    }

    //以node为根节点的先序遍历,递归算法
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二叉树的前序遍历的非递归写法
    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二叉树的层序遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //以node为根节点的中序序遍历,递归算法
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //以node为根节点的中序序遍历,递归算法
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    //查找二叉树中最小的元素
    public E getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("the bst is empty");
        }
        return getMinum(root).e;
    }

    //返回以node为根的二分搜索树最小值所在的节点
    public Node getMinum(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinum(node.left);
    }

    //寻找二分搜索树中最大的元素
    public E getMax() {
        if (size == 0) {
            throw new IllegalArgumentException("the bst is empty");
        }
        return getMaxnum(root).e;
    }

    //返回以node为根的二分搜索树最大值所在的节点
    public Node getMaxnum(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMaxnum(node.right);
    }

    //删除二分搜索树的最小值,返回最小值
    public E removeMin() {
        E ret = getMin();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根节点的最小值，返回根节点
    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树的最大值,返回最大值
    public E removeMax() {
        E ret = getMax();
        root = removeMaxNum(root);
        return ret;
    }

    //删除以node为根节点的最大值，返回根节点
    public Node removeMaxNum(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxNum(node.right);
        return node;
    }

    //删除树中的任意元素
    public void removeElement(E e) {
        root = removeElement(root, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
          node.right=removeElement(node.right, e);
          return node;
        } else if (e.compareTo(node.e) < 0) {
          node.left=removeElement(node.left, e);
          return node;
        } else {//e==node.e
            //待删除元素为左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除元素右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除元素左右元素均不为空的情况
            Node successor = getMinum(node.right);//后继节点
            successor.right = removeMin(node.right);
            //size++;
            successor.left = node.left;
            node.left = node.right = null;
            //size--;
            return successor;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateString(depth) + "null\n");
            return;
        }
        res.append(generateString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }
}

