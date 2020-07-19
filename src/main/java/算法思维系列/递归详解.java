package 算法思维系列;

import domain.TreeNode;

public class 递归详解 {
    //给一课二叉树，和一个目标值，节点上的值有正有负，返回树中和等于目标值的路径条数
    int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int count(TreeNode node, int sum) {
        if (node == null) return 0;
        return ((node.val == sum) ? 1 : 0) + count(node.left, sum - node.val) + count(node.right, sum - node.val);
    }

    //两个有序链表的合并
    public static class Merge {
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) return;
            int mid = lo + (hi - lo) / 2; //有效防止了两个数太大直接相加导致溢出
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k < hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }

        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}
