package org.siberteam.tumasov.workers;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordParser {
    private final Logger log = Logger.getLogger(WordParser.class);
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private File file;

    public WordParser(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.canRead()) {
            throw new IOException("Cannot open file for reading!.");
        }
    }

    public List<String> parse() throws IOException {
        try {
            List<String> words = new ArrayList<String>();
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            StringTokenizer stringTokenizer;
            String line;

            while ((line = bufferedReader.readLine()) != null ) {
                stringTokenizer = new StringTokenizer(line);
                while (stringTokenizer.hasMoreTokens()) {
                    words.add(stringTokenizer.nextToken().toLowerCase());
                }
            }
            return words;
        } catch (IOException e) {
            log.error(e);
            throw new IOException(e);
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
