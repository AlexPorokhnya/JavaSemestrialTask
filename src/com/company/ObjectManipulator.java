package com.company;

import java.util.List;

public class ObjectManipulator {
    PeopleListModifier peopleListModifier = new PeopleListModifier();
    List<People> peopleCopy = peopleListModifier.getPeople();

    public void selectElement(String id, String key){
        for(int i = 0; i < peopleCopy.size(); i++){
            if(peopleCopy.get(i).getId().equals(id)) {
                if (key.equals("name")) {
                    System.out.println(peopleCopy.get(i).getName());
                } else if (key.equals("address")) {
                    System.out.println(peopleCopy.get(i).getAddress());
                }
            }
        }
    }

    public void setElement(String id, String key, String value){
        for(int i = 0; i < peopleCopy.size(); i++){
            if(peopleCopy.get(i).getId().equals(id)){
                if(key.equals("name")){
                    peopleCopy.get(i).setName(value);
                    System.out.println("Name successfully changed");
                }else if(key.equals("address")) {
                    peopleCopy.get(i).setAddress(value);
                    System.out.println("Address successfully changed");
                }
            }
        }
    }

    public void deleteElement(String id, String key){
        for(int i = 0; i < peopleCopy.size(); i++){
            if(peopleCopy.get(i).getId().equals(id)) {
                if (key.equals("name")) {
                    peopleCopy.get(i).setName(null);
                    System.out.println("Name successfully deleted");
                } else if (key.equals("address")) {
                    peopleCopy.get(i).setName(null);
                    System.out.println("Name successfully deleted");
                }
            }
        }
    }
}
