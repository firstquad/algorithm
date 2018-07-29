package ru.firstquad.algorithm.task;

/**
 * Created by DVFirstov 27.07.18
 */
public class CopyTree {
    public CopyTree left, right;
    public int data;

    public CopyTree(int data) {
        this.data = data;
    }

    public CopyTree copy(CopyTree src) {
        if (src == null)
            return null;
        CopyTree t = new CopyTree(src.data);
        t.left = copy(src.left);
        t.right = copy(src.right);
        return t;
    }
}
