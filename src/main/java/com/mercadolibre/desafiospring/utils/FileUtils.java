package com.mercadolibre.desafiospring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils<T> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public void writeFile(String filePath, T object) throws IOException {
        objectMapper.writeValue(new File(filePath), object);
    }

    public static String GetFileToString(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }

}
