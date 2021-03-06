package com.example.ormroomupt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateContact extends AppCompatActivity {
    private ContactDAO mContactDAO;
    @BindView(R.id.firstNameEditText)
    EditText firstNameEditText;
    @BindView(R.id.lastNameEditText)
    EditText lastNameEditText;
    @BindView(R.id.phoneNumberEditText)
    EditText phoneNumberEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        ButterKnife.bind(this);
        mContactDAO = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
                .allowMainThreadQueries() //Allows room to do operation on main thread
                .build()
                .getContactDAO();

    }

    @OnClick(R.id.saveButton)
    public void onViewClicked() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String phoneNumber = phoneNumberEditText.getText().toString();
        if (firstName.length() == 0 || lastName.length() == 0 || phoneNumber.length() == 0) {
            Toast.makeText(CreateContact.this, "Please make sure all details are correct", Toast.LENGTH_SHORT).show();
            return;
        }
        Contacto contact = new Contacto();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setCreatedDate(new Date());
//Insert to database
        try {
            mContactDAO.insert(contact);
            setResult(RESULT_OK);
            finish();
        } catch (SQLiteConstraintException e) {
            Toast.makeText(CreateContact.this, "A cotnact with same phone number already exists.", Toast.LENGTH_SHORT).show();
        }
    }
}