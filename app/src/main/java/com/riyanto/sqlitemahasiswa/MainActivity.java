package com.riyanto.sqlitemahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.riyanto.sqlitemahasiswa.adapter.MahasiswaAdapter;
import com.riyanto.sqlitemahasiswa.helper.DatabaseHelper;
import com.riyanto.sqlitemahasiswa.model.Mahasiswa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMahasiswa;
    List<Mahasiswa> mahasiswaList;
    MahasiswaAdapter mahasiswaAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMahasiswa = findViewById(R.id.lv_mahasiswa);

        simpanDataMahasiswa();

        tampilDataMahasiswa();
    }

    private void simpanDataMahasiswa() {
        databaseHelper = new DatabaseHelper(this);
        databaseHelper.storeData();
    }

    private void tampilDataMahasiswa() {
        databaseHelper = new DatabaseHelper(this);
        mahasiswaList = databaseHelper.getAllMahasiswa();
        mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaList);
        lvMahasiswa.setAdapter(mahasiswaAdapter);
    }
}