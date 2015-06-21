package ru.firstquad.algorithm.func;

import java.io.File;
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
}
