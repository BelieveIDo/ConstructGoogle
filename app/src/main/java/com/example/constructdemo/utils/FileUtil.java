package com.example.constructdemo.utils;

import java.io.File;

public class FileUtil {
    public static boolean delete(File file) {
        if (file.isFile()) {
            return file.delete();
        }

        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                return file.delete();
            }

            for (File childFile : childFiles) {
                delete(childFile);
            }
            return file.delete();
        }
        return false;
    }
}
