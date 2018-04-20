package com.preccydev.directory;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.preccydev.directory.data.DirectoryDbHelper;
import com.preccydev.directory.model.DirectoryAdapter;

import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry.TABLE_NAME;
import static com.preccydev.directory.data.DirectoryContract.DirectoryEntry._ID;

public class MainActivity extends AppCompatActivity implements DirectoryAdapter.DirectoryItemClickListener {

    DirectoryAdapter mAdapter;
    RecyclerView mDirectoryList;
    SQLiteDatabase mDb;
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDirectoryList = (RecyclerView) findViewById(R.id.all_directory_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mDirectoryList.setLayoutManager(layoutManager);
        mDirectoryList.setHasFixedSize(true);

        DirectoryDbHelper directoryDbHelper = new DirectoryDbHelper(this);

        mDb = directoryDbHelper.getReadableDatabase();

        Cursor cursor = getAllDirectory();

        mAdapter = new DirectoryAdapter(this, cursor, this);

        mDirectoryList.setAdapter(mAdapter);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DirectoryUpdate.class);
                startActivity(intent);


            }
        });
    }


    @Override
    public void onDirectoryItemClick(int ClickedItemIndex) {
        if (mToast != null) {
            mToast.cancel();
        }
        String RoastToast = "Item" + ClickedItemIndex;
        mToast = Toast.makeText(this, RoastToast, Toast.LENGTH_SHORT);
        mToast.show();

    }


    public Cursor getAllDirectory() {
        return mDb.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                _ID);
    }
}
