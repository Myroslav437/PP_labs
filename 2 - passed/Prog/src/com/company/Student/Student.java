package com.company.Student;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
    private int id;
    private int Course;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Address;
    private String Phone;
    private String Faculty;
    private String Group;
    private GregorianCalendar Birthday;

    public Student() {
        this(0, 0, "Unknown", "", "Unknown",
                "Unknown", "Unknown", "None", "None", new GregorianCalendar(1970 , 1, 1));
    }

    public Student(int id, int course, String firstName, String middleName, String lastName, String address, String phone, String faculty, String group, GregorianCalendar birthday) {
        this.id = id;
        Course = course;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Address = address;
        Phone = phone;
        Faculty = faculty;
        Group = group;
        Birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public GregorianCalendar getBirthday() {
        return Birthday;
    }

    public void setBirthday(GregorianCalendar birthday) {
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return FirstName + " " + MiddleName + " " + LastName + " (ID" + String.valueOf(id) + ")" + ", " +
               String.valueOf(Birthday.get(Calendar.DAY_OF_MONTH))+"."+String.valueOf(Birthday.get(Calendar.MONTH))+"."+String.valueOf(Birthday.get(Calendar.YEAR))+"\n" +
               Faculty + ", " + Group + ", " + String.valueOf(Course) + " course" + "\n" +
               Address + "\n" +
               Phone + "\n";
    }

}
