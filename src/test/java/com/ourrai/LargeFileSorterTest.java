package com.ourrai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LargeFileSorterTest {
    @BeforeEach

    @Test
    public void splitAndSortTempFiles(@TempDir Path tempDir)
            throws IOException {
        Path numbers = tempDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("2", "1", "3","4", "5", "6", "7", "8", "9", "10");
        Files.write(numbers, lines);
        List<File> files = LargeFileSorter
                .splitAndSortTempFiles(numbers.toAbsolutePath().toString(), "temp", 3,
                        new StringComparator());
        assertEquals(3, files.size());
    }

    @Test
    public void merge(@TempDir Path tempDir)
            throws IOException {
        Path numbers = tempDir.resolve("numbers.txt");
        List<String> lines = Arrays.asList("2", "1", "3","4", "5", "6", "7", "8", "9", "10");
        Files.write(numbers, lines);
        List<File> files = LargeFileSorter
                .splitAndSortTempFiles(numbers.toAbsolutePath().toString(), "temp", 3,
                        new StringComparator());
        LargeFileSorter.mergeSortedFiles(files, "LargeSortedFile.txt", new StringComparator());
        assertEquals(3, files.size());
    }
}
