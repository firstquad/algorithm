package ru.firstquad.algorithm.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DVFirstov 29.07.18
 */
public class CopyTreeTest {

    @Test
    public void copy() {
        CopyTree tree = new CopyTree(1);
        tree.left = new CopyTree(2);
        CopyTree right = new CopyTree(3);
        tree.right = right;
        right.right = new CopyTree(4);

        CopyTree copyTree = tree.copy(tree);
        assertEquals(tree.data, copyTree.data);
        assertEquals(tree.left.data, copyTree.left.data);
        assertEquals(tree.right.data, copyTree.right.data);
        assertEquals(tree.right.right.data, copyTree.right.right.data);
    }
}