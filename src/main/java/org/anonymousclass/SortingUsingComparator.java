package org.anonymousclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingUsingComparator {
    public static void main(String[] args){
        Employee e1=new Employee("Deepa",55);
        Employee e2=new Employee("Madhu",20);
        Employee e3=new Employee("Baishali",2);
        ArrayList<Employee> arr=new ArrayList<>();
        arr.add(e1);
        arr.add(e2);
        arr.add(e3);
        System.out.println("ArrayList before : "+ arr);
        Collections.sort(arr,new Comparator<Employee>(){
            @Override
            public int compare(Employee e1,Employee e2){
               // return e1.age-e2.age;
                //for descending do e2-e1
                return Integer.compare(e1.age,e2.age);
            }
        });
        System.out.println("ArrayList after : "+ arr);
    }
}