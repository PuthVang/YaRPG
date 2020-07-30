package net.prosavage.yarpg.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YFileUtil {

    public List<File> getFiles(File folder){
        List<File> files = new ArrayList<>();
        if (folder.exists()) {
            Arrays.asList(folder.listFiles()).forEach(file -> {
                if (file.getName().endsWith(".yml")) {
                    files.add(file);
                }
            });
        }
        return files;
    }

    public List<String> getStringFiles(File folder){
        List<String> files = new ArrayList<>();
        if (folder.exists()) {
            Arrays.asList(folder.listFiles()).forEach(file -> {
                if (file.getName().endsWith(".yml")) {
                    files.add(file.getName());
                }
            });
        }
        return files;
    }

    public int getFilesCount(File folder){
        return folder.exists() ? getFiles(folder).size() : 0;
    }

    public List<File> getFolders(File folder){
        List<File> files = new ArrayList<>();
        if (folder.exists()) {
            Arrays.asList(folder.listFiles()).forEach(file -> {
                if (file.isDirectory()) {
                    files.add(file);
                }
            });
        }
        return files;
    }

    public List<String> getStringFolder(File folder){
        List<String> files = new ArrayList<>();
        Arrays.asList(folder.listFiles()).forEach(file -> {
            if (file.isDirectory()) {
                files.add(file.getName());
            }
        });
        return files;
    }

    public int getFoldersCount(File folder){
        return folder.exists() ? getFolders(folder).size() : 0;
    }

    public int getFolderFileCount(File folder){
        final int[] amount = {0};
        List<File> folders = getFolders(folder);
        if (folders != null) folders.forEach(file -> amount[0] = amount[0] + file.listFiles().length);
        return amount[0];
    }

    public List<String> getFilesWithUnderlinesInsteadOfSpaces(File file){
        List<String> files = getStringFiles(file);
        files.forEach(forEachFile -> {
            String stringFile = forEachFile.replaceAll(" ", " ");
            files.set(files.indexOf(forEachFile), stringFile);
        });
        return files;
    }

    public List<String> getFoldersWithUnderlinesInsteadOfSpaces(File file){
        List<String> files = getStringFolder(file);
        files.forEach(forEachFile -> {
            String stringFile = forEachFile.replaceAll(" ", " ");
            files.set(files.indexOf(forEachFile), stringFile);
        });
        return files;
    }

}
