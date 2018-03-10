package com.example.lordbabuino.aluno_online;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/**
 * Created by lordbabuino on 02/03/18.
 */

class Interest implements DatabaseOperations{

    //ATTRIBUTES

    private String id;
    private String tag;

    //CONSTRUCTOR

    public Interest(String tag) {
        this.id = UUID.randomUUID().toString();
        this.tag = tag;
    }

    //GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void insertInDatabase(String node) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference newInterest = database.getReference(node).push();

        newInterest.child("id").setValue(this.id);
        newInterest.child("tag").setValue(this.tag);
    }
}
