package com.example.lordbabuino.aluno_online;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.UUID;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Button BUTTON_SAVE = findViewById(R.id.buttonSave);

        BUTTON_SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText EDIT_TEXT_NAME = findViewById(R.id.editTextName);
                final EditText EDIT_TEXT_REGISTRY = findViewById(R.id.editTextRegistry);
                final EditText EDIT_TEXT_COURSE = findViewById(R.id.editTextCourse);
                final EditText EDIT_TEXT_CAMPUS = findViewById(R.id.editTextCampus);
                final EditText EDIT_TEXT_TURN = findViewById(R.id.editTextTurn);
                final EditText EDIT_TEXT_INTERESTS = findViewById(R.id.editTextInterests);

                final ArrayList<Interest> INTERESTS = new ArrayList<>();

                for(String interest : EDIT_TEXT_INTERESTS.getText().toString().split(","))
                    INTERESTS.add(new Interest(interest));

                final Student STUDENT = new Student(
                        EDIT_TEXT_NAME.getText().toString(),
                        Long.parseLong(EDIT_TEXT_REGISTRY.getText().toString()),
                        EDIT_TEXT_COURSE.getText().toString(),
                        EDIT_TEXT_CAMPUS.getText().toString(),
                        EDIT_TEXT_TURN.getText().toString(),
                        INTERESTS
                );

                STUDENT.insertInDatabase("iesb/students/" + UUID.randomUUID().toString());
            }
        });
    }
}
