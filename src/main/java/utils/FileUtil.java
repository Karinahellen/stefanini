package utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class FileUtil {

    private static final String RESOURCE_PATH = "src/main/resources";

    public static File getFile(String path) {
        return getPath(path).toFile();
    }

    public static String getFilePath(String path) {
        return getFile(path).getAbsolutePath();
    }

    private static Path getPath(String path) {
        return Paths.get(RESOURCE_PATH + "/" + path);
    }
}
