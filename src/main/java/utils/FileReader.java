package utils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public static String readFile(final String fileName) {

        final ClassLoader classLoader = FileReader.class.getClassLoader();

        // Get the URL of the resource
        URL resourceURL = classLoader.getResource(fileName);
        String content = "";
        if (resourceURL != null) {
            // Get the path from the URL
            String resourcePath = resourceURL.getPath();
            try {
                content = readFileToString(resourcePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Resource not found");
        }
        return content;
    }
    private static String readFileToString(String filePath) throws IOException {
        // Read all bytes from the file
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, "UTF-8");
    }


}