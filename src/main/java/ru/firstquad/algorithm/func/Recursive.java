package ru.firstquad.algorithm.func;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dima on 21.06.2015.
 */
public class Recursive {


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

    public static void deleteEmptyDirs(File root, File dir, ArrayList<File> checkedDirs) throws IOException {
        if (checkedDirs.contains(root)) {
            return;
        }
        File[] childs = dir.listFiles();
        if (childs == null || childs.length == 0) {
            File parentFile = dir.getParentFile();
            dir.delete();
            if (parentFile != null) {
                deleteEmptyDirs(root, dir.getParentFile(), checkedDirs);
                return;
            }
        }
        if (checkedDirs.containsAll(Arrays.asList(childs)) && dir.getParentFile() != null) {
            checkedDirs.add(dir);
            deleteEmptyDirs(root, dir.getParentFile(), checkedDirs);
        } else {
            for (File child : childs) {
                if (checkedDirs.contains(child)) {
                    continue;
                }
                if (child.isDirectory() && (child.listFiles() == null || child.listFiles().length == 0)) {
                    File parentFile = child.getParentFile();
                    if (child.exists())
                        child.delete();
                    deleteEmptyDirs(root, parentFile, checkedDirs);
                } else if (child.isFile()) {
                    checkedDirs.add(child.getParentFile());
                } else {
                    deleteEmptyDirs(root, child, checkedDirs);
                }
            }
        }
    }
}
