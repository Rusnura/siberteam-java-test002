package org.siberteam.tumasov;

/* Задача:

*/

import org.apache.log4j.Logger;
import org.siberteam.tumasov.workers.ConsolePrinter;
import org.siberteam.tumasov.workers.WordParser;

import java.io.IOException;
import java.util.*;

public class Main {
    private final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        WordParser parser;

        if (args.length == 0) {
            System.err.println("Usage: test.jar PathToTXTFile QualifiedClassName");
        } else if (args.length == 1) {
            System.err.println("Please, define a QualifiedClassName for sorting!\nUsage: test.jar PathToTXTFile QualifiedClassName");
            return;
        }

        try {
            parser = new WordParser(args[0]);
        } catch (IOException e) {
            log.error("Cannot opening/reading a file \"" + args[0] + "\": " + e);
            return;
        }

        Comparator<String> sorter;
        try {
            final Class c = Class.forName(args[1]);
            sorter = (Comparator<String>)c.newInstance();
        } catch (Exception e) {
            System.err.println("Problem with loading \"" + args[1] + "\" class. " + e);
            return;
        }

        try {
            final List<String> words = parser.parse();
            Collections.sort(words, sorter);
            ConsolePrinter.print(words);
        } catch (Exception e) {
            log.error("I'm sorry, but error has been occurred: " + e);
        }
    }
}