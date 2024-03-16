package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Saver {

    PeopleListModifier peopleListModifier = new PeopleListModifier();
    List<People> peopleCopy = peopleListModifier.getPeople();

    public void saver(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("<root> \n");
            fileWriter.write("\t<people>\n");
            for(int i = 0; i < peopleCopy.size();i++){
                fileWriter.write("\t\t<person>\n");
                if(peopleCopy.get(i).getId() != null) {
                    fileWriter.write("\t\t\t<id> " + peopleCopy.get(i).getId() + " </id>\n");
                }
                if(peopleCopy.get(i).getName() != null) {
                    fileWriter.write("\t\t\t<name> " + peopleCopy.get(i).getName() + " </name>\n");
                }
                if(peopleCopy.get(i).getAddress() != null) {
                    fileWriter.write("\t\t\t<address> " + peopleCopy.get(i).getAddress() + " </address>\n");
                }
                fileWriter.write("\t\t</person>\n");
            }
            fileWriter.write("\t</people>\n");
            fileWriter.write("</root>\n");
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Cannon create/modify file");
        }

    }
}
