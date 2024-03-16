package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleListModifier {

    private static List<People> people = new ArrayList<People>();

    public static List<People> getPeople() {
        return people;
    }

    public void listCorrection(){
        if(people!=null){
            int missedIndex = 0;
            for(int i = 0; i < people.size(); i++) {
                if (people.get(i).getId() == null) {
                    missedIndex++;
                    people.get(i).setId(String.valueOf(people.size() - missedIndex).trim());
                }
            }
            replaceDuplications(people);
        }
    }

    private void replaceDuplications(List<People> list){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < list.size(); i++){
            String element = list.get(i).getId().trim();
            if(map.containsKey(element)){
                int frequency = map.get(element);
                frequency++;
                String temp = element + "_" + frequency;
                list.get(i).setId(temp.trim());
            }else{
                map.put(element, 1);
            }
        }
    }
}
