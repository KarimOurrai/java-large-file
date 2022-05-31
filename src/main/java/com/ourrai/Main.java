package com.ourrai;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path fullPath = new File("LargeFile.txt").toPath();
        List<File> files = LargeFileSorter
                .splitAndSortTempFiles(fullPath.toAbsolutePath().toString(), "temp", 15,
                new StringComparator());
        LargeFileSorter.mergeSortedFiles(files, "LargeSortedFile.txt", new StringComparator());
    }
}
