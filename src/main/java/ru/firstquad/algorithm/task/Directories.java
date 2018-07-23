package ru.firstquad.algorithm.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 21.06.2015.
 */
public class Directories {

    public static List<String> getDirs(String path, List<String> dirs) {
        File file = new File(path);
        if (file.isDirectory()) {
            dirs.addAll(getOnlyDirs(file));
            String[] parent = path.split(file.getName());
            if (parent.length > 0)
                getDirs(parent[0], dirs);
        }
        return dirs;
    }

    public ArrayList<File> findEmptyDirs(File rootDir, ArrayList<File> emptyDirs) {
        File[] childs = rootDir.listFiles();
        if (childs == null || childs.length == 0) {
            if (rootDir.isDirectory())
                emptyDirs.add(rootDir);
            return emptyDirs;
        }
        for (File child : childs) {
            if (child.isDirectory() && (child.listFiles() == null || child.listFiles().length == 0)) {
                emptyDirs.add(child);
            } else {
                findEmptyDirs(child, emptyDirs);
            }
        }
        return emptyDirs;
    }

    private static List<String> getOnlyDirs(File file) {
        if (file == null)
            return null;
        List<String> dirs = new ArrayList<String>();
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory())
                dirs.add(file1.getName());
        }
        return dirs;
    }
}
