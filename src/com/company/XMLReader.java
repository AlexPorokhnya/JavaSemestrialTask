package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReader {

    private String buffId = null;
    private String buffName = null;
    private String buffAddress = null;


    private static Scanner scanner;
    Pattern pattern  = Pattern.compile("[<]([a-zA-Z0-9]+)[>]\\s?([a-zA-z0-9\\s]+)\\s?[<]([/]\\1)[>]");

    PeopleListModifier peopleListModifier = new PeopleListModifier();


    public void OpenFile(String fileName){
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                Matcher matcher = pattern.matcher(text);
                boolean matchFound = matcher.find();

                if (matchFound && matcher.group(1).equals("id")) {
                    buffId = matcher.group(2).trim();
                }
                if (matchFound && matcher.group(1).equals("name")) {
                    buffName = matcher.group(2).trim();
                }
                if (matchFound && matcher.group(1).equals("address")) {
                    buffAddress = matcher.group(2).trim();
                    peopleListModifier.getPeople().add(new People(buffId, buffName, buffAddress));
                    buffId = null;
                    buffName= null;
                    buffAddress = null;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFile(){
        scanner.close();
    }
}
