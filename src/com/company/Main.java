package com.company;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        boolean isFileOpen = false;
        boolean isFileSaved = false;
        String filePath = null;


        Pattern openPattern  = Pattern.compile("([o][p][e][n])\\s?([a-zA-Z0-9:/\\\\\\\\. ]+)");
        Pattern printPattern = Pattern.compile("([p][r][i][n][t]\\s?)");
        Pattern savePattern = Pattern.compile("([s][a][v][e]\\s?)");
        Pattern selectPattern = Pattern.compile("([s][e][l][e][c][t]+)\\s?([0-9_\\s?]+)\\s?([a-zA-Z]+)");
        Pattern deletePattern = Pattern.compile("([d][e][l][e][t][e]+)\\s?([0-9_]+)\\s?([a-zA-Z]+)");
        Pattern saveAsPattern = Pattern.compile("([s][a][v][e][a][s])\\s?([a-zA-Z0-9:/\\\\\\\\. ]+)");
        Pattern textPattern = Pattern.compile("([t][e][x][t]+)\\s?([0-9_]+)");
        Pattern setPattern = Pattern.compile("([s][e][t]+)\\s?([0-9_\\s?]+)\\s?([a-zA-Z]+)\\s?([a-zA-Z0-9\\s?]+)");
        Pattern closePattern = Pattern.compile("([c][l][o][s][e]\\s?)");
        Pattern exitPattern = Pattern.compile("([e][x][i][t]\\s?)");
        Pattern helpPattern = Pattern.compile("([h][e][l][p]\\s?)");


        System.out.println("Enter your next command(you can write help" +
                " to see list of all commands)");
        while (true) {
            Scanner consoleScanner = new Scanner(System.in);
            String inputData = consoleScanner.nextLine();

            Matcher openMatcher = openPattern.matcher(inputData);
            if (openMatcher.find()) {
                try {
                    if (!isFileOpen) {
                        XMLReader openner = new XMLReader();
                        openner.OpenFile(openMatcher.group(2));
                        filePath = openMatcher.group(2);
                        isFileOpen = true;
                        System.out.println("Successfully opened file");
                    }
                } catch (Exception e) {
                    System.out.println("Cannot open this file or incorrect file name!");
                }
            }

            Matcher printMatcher = printPattern.matcher(inputData);
            if (printMatcher.find()) {
                if (isFileOpen) {
                    Printer printer = new Printer();
                    printer.Printer();
                } else {
                    System.out.println("File is not open");
                }
            }
            Matcher saveMatcher = savePattern.matcher(inputData);
            if(saveMatcher.find()){
                if(isFileOpen){
                    Saver saver = new Saver();
                    saver.saver(filePath);
                    System.out.println("Successfully saved file");
                    isFileSaved = true;
                }else{
                    System.out.println("Cannot save this file!");
                }
            }
            Matcher saveAsMatcher = saveAsPattern.matcher(inputData);
            if(saveAsMatcher.find()){
                if(isFileOpen){
                    Saver saver = new Saver();
                    saver.saver(saveAsMatcher.group(2));
                    System.out.println("Successfully saved file");
                    isFileSaved = true;
                }else{
                    System.out.println("Cannot save this file!");
                }
            }
            Matcher exitMatcher = exitPattern.matcher(inputData);
            if(exitMatcher.find()){
                return;
            }

            Matcher closeMatcher = closePattern.matcher(inputData);
            if(closeMatcher.find()){
                if(isFileOpen){
                    XMLReader closer = new XMLReader();
                    closer.CloseFile();
                    isFileOpen = false;
                    System.out.println("Successfully closed file");
                }
            }

            Matcher selectMatcher = selectPattern.matcher(inputData);
            if(selectMatcher.find()){
                if(isFileOpen) {
                    ObjectManipulator objectManipulator = new ObjectManipulator();
                    objectManipulator.selectElement(selectMatcher.group(2).trim(), selectMatcher.group(3).trim());
                }
            }
            Matcher setMatcher = setPattern.matcher(inputData);
            if(setMatcher.find()){
                if(isFileOpen) {
                    ObjectManipulator objectManipulator = new ObjectManipulator();
                    objectManipulator.setElement(setMatcher.group(2).trim(), setMatcher.group(3).trim(), setMatcher.group(4).trim());
                }
            }

            Matcher deleteMatcher = deletePattern.matcher(inputData);
            if(deleteMatcher.find()){
                if(isFileOpen){
                    ObjectManipulator objectManipulator = new ObjectManipulator();
                    objectManipulator.deleteElement(deleteMatcher.group(2).trim(), deleteMatcher.group(3).trim());
                }
            }

            Matcher textMatcher = textPattern.matcher(inputData);
            if(textMatcher.find()){
                if(isFileOpen){
                    Printer printer = new Printer();
                    printer.TextPrinter(textMatcher.group(2));
                }else{
                    System.out.println("File is not opened!");
                }
            }
            Matcher helpMatcher = helpPattern.matcher(inputData);
            if(helpMatcher.find()){
                System.out.println("The following commands are supported:");
                System.out.println("open <file>                 : opens <file>");
                System.out.println("close                       : close currently opened file");
                System.out.println("save                        : save currently opened file");
                System.out.println("saveas <file>               : save currently opened file in <file>");
                System.out.println("print                       : print information from currently opened file");
                System.out.println("select <id> <key>           : print <attribute> of <id> element");
                System.out.println("set <id> <key> <value>      : change or set <value> of <attribute> " +
                        "of <id> element");
                System.out.println("exit                        : close program");
            }
        }
    }
}
