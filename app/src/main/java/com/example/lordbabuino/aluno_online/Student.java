package com.example.lordbabuino.aluno_online;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by lordbabuino on 02/03/18.
 */

public class Student implements DatabaseOperations{

    //ATTRIBUTES

    private String name;
    private long registry;
    private String course;
    private String campus;
    private String turn;
    private ArrayList<Interest> interests;

    //CONSTRUCTOR

    public Student(String name, long registry, String course,
                   String campus, String turn, ArrayList<Interest> interests) {
        this.name = name;
        this.registry = registry;
        this.course = course;
        this.campus = campus;
        this.turn = turn;
        this.interests = interests;
    }

    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRegistry() {
        return registry;
    }

    public void setRegistry(long registry) {
        this.registry = registry;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    //INTERFACE IMPLEMENTATION

    @Override
    public void insertInDatabase(String node) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference newStudent = database.getReference(node);

        newStudent.child("name").setValue(this.name);
        newStudent.child("registry").setValue(this.registry);
        newStudent.child("course").setValue(this.course);
        newStudent.child("campus").setValue(this.campus);
        newStudent.child("turn").setValue(this.turn);

        for(Interest interest : interests)
            interest.insertInDatabase(node + "/interests");
    }
}
