package com.company.Main;
import com.company.Student.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var Faculty = "Photography art";
        var Group = "SS42";
        var YearAfter = 2001;

        Consumer<Student[]> Print = (Student[] arr) -> {
            for(Student a : arr){
                if(a == null)
                    break;
                System.out.println(a.toString());
            }
            System.out.println();
        };
        Student[] stud = CreateStudentArr();
        Predicate<Student> BornAfter = x-> x.getBirthday().get(Calendar.YEAR) >= YearAfter;
        Predicate<Student> OnFaculty = x-> x.getFaculty() == Faculty;
        Predicate<Student> InGroup   = x-> x.getGroup() == Group;

        System.out.println();
        System.out.println("Students born after " + String.valueOf(YearAfter) + ":");
        Print.accept(Select(stud, BornAfter));

        System.out.println("Students of " + Faculty + " faculty:");
        Print.accept(Select(stud, OnFaculty));

        System.out.println("Students of " + Group + " group:");
        Print.accept(Select(stud, InGroup));

        return;
    }

    private  static Student[] CreateStudentArr() {
        Student[] res = {
            new Student(12345, 1, "Max", "","Caulfield", "Arcadia bay", "+011683934", "Photography art", "PA11", new GregorianCalendar(2002, 3, 25) ),
            new Student(33939, 1, "Chloe", "Mae",  "Price", "Arcadia bay", "+034857294", "Photography art", "PA11", new GregorianCalendar(2001, 4, 19) ),
            new Student(84829, 3, "Rachel", "Renee", "Amber", "Arcadia bay", "+093867239", "Photography art", "PA31", new GregorianCalendar(2001, 10, 1) ),
            new Student(39484, 3, "Nathan", "Joseph", "Prescott", "Arcadia bay", "+034395957", "Photography art", "PA31", new GregorianCalendar(2001, 7, 4) ),
            new Student(23493, 2, "Kyle", "Lee", "Broflovski", "South Park", "+023485733", "Social studies", "SS24", new GregorianCalendar(2007, 2, 10) ),
            new Student(34349, 2, "David", "Robert", "Madsen", "Arcadia bay", "+086729596", "Social studies", "SS24", new GregorianCalendar(1998, 1, 12) ),
            new Student(23943, 4, "Stan", "James", "Marsh", "South Park", "+027439439", "Social studies", "SS42", new GregorianCalendar(2005, 2, 6) ),
            new Student(98385, 4, "Randy", "", "Marsh", "South Park", "+086330712", "Social studies", "SS42", new GregorianCalendar(2000, 7, 20) ),
            new Student(34803, 2, "Eric", "Joseph ", "Cartman", "South Park", "+025967284", "Philosophy", "PH24", new GregorianCalendar(2007, 9, 15) ),
            new Student(39485, 2, "Victoria", "Lynn", "Chase", "Arcadia bay", "+037885375", "Philosophy", "PH24", new GregorianCalendar(2002, 5, 4) ),
            new Student(96567, 3, "Kenny", "", "McCormick", "South Park", "+078340873", "Philosophy", "PH32", new GregorianCalendar(2004, 8, 14) ),
            new Student(83757, 3, "Mark", "", "Jefferson", "Arcadia bay", "+096734967", "Philosophy", "PH34", new GregorianCalendar(1995, 8, 22) )
        };
        // Shuffle the array:
        Random rand = new Random();
        for (int i = 0; i < res.length; ++i) {
            int randomIndexToSwap = rand.nextInt(res.length);
            var temp = res[randomIndexToSwap];
            res[randomIndexToSwap] = res[i];
            res[i] = temp;
        }

        return res;
    }

    private static Student[] Select(Student[] stud, Predicate<Student> Pred){
        int sz = stud.length, j = 0;
        Student[] res = new Student[sz];
        for(int i = 0; i < sz; ++i) {
            if(Pred.test(stud[i])){
                res[j++] = stud[i];
            }
        }

        return res;
    }
}
