package com.preccydev.directory;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.preccydev.directory.data.DirectoryDbHelper;

import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_FIRSTNAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_GENDER;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_HALL;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_LASTNAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_LEVEL;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.COLUMN_PHONE_NUMBER;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.GENDER_FEMALE;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.GENDER_MALE;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_AWO;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_BELLO;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_INDEPENDENCE;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_KUTI;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_MELLANBY;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_NNAMDI;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_OFF_CAMPUS;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_QUEEN_ELIZABETH;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_QUEEN_IDIA;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.HALL_TEDDER;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.TABLE_NAME;



public class DirectoryUpdate extends AppCompatActivity {

    private Spinner mGenderSpinner, mHallSpinner, mLevelSpinner;

    private Button mSubmit;

    private int mGender = 0;
    private int mHall = 0;
    private int mLevel = 0;

    private EditText mFirstName, mLastName, mPhoneNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_update);
        GenderSpinner();
        HallSpinner();
        LevelSpinner();

        mFirstName = (EditText) findViewById(R.id.edit_first_name);
        mLastName = (EditText) findViewById(R.id.edit_last_name);
        mPhoneNumber = (EditText) findViewById(R.id.edit_phone_number);

    }



    private void GenderSpinner() {
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Apply the adapter to the spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = GENDER_MALE; // Male
                    } else if (selection.equals(getString(R.string.gender_female))){
                        mGender = GENDER_FEMALE; // Female
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Set the integer mSelected to the constant values

    }

    public void HallSpinner() {
        mHallSpinner = (Spinner) findViewById(R.id.spinner_hall);
        ArrayAdapter HallSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_hall_of_residence_options, android.R.layout.simple_spinner_item);
        HallSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mHallSpinner.setAdapter(HallSpinnerAdapter);
        mHallSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.Kuti))) {
                        mHall = HALL_KUTI;
                    } else if (selection.equals(getString(R.string.Bello))) {
                        mHall = HALL_BELLO;
                    } else if (selection.equals(getString(R.string.Mellanby))) {
                        mHall = HALL_MELLANBY;
                    } else if (selection.equals(getString(R.string.Tedder))) {
                        mHall = HALL_TEDDER;
                    } else if (selection.equals(getString(R.string.Queen_elizabeth))) {
                        mHall = HALL_QUEEN_ELIZABETH;
                    } else if (selection.equals(getString(R.string.Independence))) {
                        mHall = HALL_INDEPENDENCE;
                    } else if (selection.equals(getString(R.string.Nnamdi_azikwe))) {
                        mHall = HALL_NNAMDI;
                    } else if (selection.equals(getString(R.string.Queen_idia))) {
                        mHall = HALL_QUEEN_IDIA;
                    } else if (selection.equals(getString(R.string.Awo))) {
                        mHall = HALL_AWO;
                    } else if (selection.equals(getString(R.string.Off_campus))) {
                        mHall = HALL_OFF_CAMPUS;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void LevelSpinner() {
        mLevelSpinner = (Spinner) findViewById(R.id.spinner_level);
        ArrayAdapter LevelSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_level_options, android.R.layout.simple_spinner_item);
        LevelSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mLevelSpinner.setAdapter(LevelSpinnerAdapter);

        mLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void insertData() {
        String FirstName = mFirstName.getText().toString().trim();
        String LastName = mLastName.getText().toString().trim();
        String PhoneNumber = mPhoneNumber.getText().toString().trim();
        int Pnumber = Integer.parseInt(PhoneNumber);


        if (FirstName.length() > 0) {
            //Initialize Database
            DirectoryDbHelper directoryDbHelper = new DirectoryDbHelper(this);
            SQLiteDatabase db = directoryDbHelper.getWritableDatabase();

            //Add to Database using Content Values

            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRSTNAME, FirstName);
            values.put(COLUMN_LASTNAME, LastName);
            values.put(COLUMN_GENDER, mGender);
            values.put(COLUMN_HALL, mHall);
            values.put(COLUMN_LEVEL, mLevel);
            values.put(COLUMN_PHONE_NUMBER, Pnumber);



            db.insert(TABLE_NAME, null, values);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.add_entry:
                // insert entry
                insertData();
                finish();
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
