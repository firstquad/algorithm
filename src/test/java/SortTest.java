import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dima on 19.07.2015.
 */
public class SortTest {

    @Test
    public void testConflictParser() {
        File file = new File("D:/AuditAdmin.page.xml");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            List<String> originContentList = new ArrayList<>();
            List<String> newContentList = new ArrayList<>();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (s.contains("<<<<<<< HEAD")) {
                    while (iterator.hasNext()) {
                        String conflict = iterator.next();
                        if (conflict.equals("======="))
                            break;
                        originContentList.add(conflict);
                    }
                    while (iterator.hasNext()) {
                        String conflict = iterator.next();
                        if (conflict.contains(">>>>>>>"))
                            break;
                        newContentList.add(conflict);
                    }
                } else {
                    originContentList.add(s);
                    newContentList.add(s);
                }
            }
            String originContent = "";
            String newContent = "";
            for (String s: originContentList) {
                originContent += s + "\n";
            }
            for (String s: newContentList) {
                newContent += s + "\n";
            }
            int i = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            File rootDir = new File("D:\\conf");
//            deleteEmptyDirs(rootDir, rootDir, new ArrayList<>());
            ArrayList<File> emptyDirs = findEmptyDirs(rootDir, new ArrayList<>());
            while (emptyDirs.size() != 0) {
                emptyDirs.forEach(File::delete);
                emptyDirs = findEmptyDirs(rootDir, new ArrayList<>());
            }
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<File> findEmptyDirs(File root, ArrayList<File> emptyDirs) {
        File[] childs = root.listFiles();
        if (childs == null || childs.length == 0) {
            if (root.isDirectory())
                emptyDirs.add(root);
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
