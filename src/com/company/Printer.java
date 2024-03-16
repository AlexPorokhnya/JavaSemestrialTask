package com.company;

import java.util.List;

public class Printer {

    PeopleListModifier peopleListModifier = new PeopleListModifier();
    List<People> peopleCopy = peopleListModifier.getPeople();

    public void Printer(){
        peopleListModifier.listCorrection();
        for(int i = 0; i < peopleListModifier.getPeople().size(); i++){
            System.out.println(peopleListModifier.getPeople().get(i).toString());
        }
    }

    public void TextPrinter(String id){
        for(int i = 0; i < peopleCopy.size();i++){
            if(peopleCopy.get(i).getId().equals(id)) {
                if (peopleCopy.get(i).getId() != null) {
                    System.out.println("<id> " + peopleCopy.get(i).getId() + " </id>\n");
                }
                if (peopleCopy.get(i).getName() != null) {
                    System.out.println("<name> " + peopleCopy.get(i).getName() + " </name>\n");
                }
                if (peopleCopy.get(i).getAddress() != null) {
                    System.out.println("<address> " + peopleCopy.get(i).getAddress() + " </address>\n");
                }
            }
        }
    }
}
