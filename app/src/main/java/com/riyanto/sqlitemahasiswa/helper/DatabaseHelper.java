package com.riyanto.sqlitemahasiswa.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.riyanto.sqlitemahasiswa.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mahasiswa.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE mahasiswa (nim TEXT, nama TEXT, prodi TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS mahasiswa";
        db.execSQL(sql);

        onCreate(db);
    }

    public List<Mahasiswa> getAllMahasiswa() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()) {
            mahasiswaList.add(
                    new Mahasiswa(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2)
                    )
            );
        }

        cursor.close();
        db.close();
        return mahasiswaList;
    }

    public void storeData() {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("112233", "Adi Putra", "Manajemen Informatika"));
        mahasiswaList.add(new Mahasiswa("223344", "Budi Santoso", "Teknik Listrik"));
        mahasiswaList.add(new Mahasiswa("334455", "Cindy Saputri", "Manajemen Informatika"));
        mahasiswaList.add(new Mahasiswa("445566", "Dodi Supardi", "Manajemen Informatika"));

        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0; i<mahasiswaList.size(); i++) {
            String sql = String.format("INSERT INTO mahasiswa VALUES ('%s', '%s', '%s')",
                mahasiswaList.get(i).getNim(),
                mahasiswaList.get(i).getNama(),
                mahasiswaList.get(i).getProdi()
            );

            db.execSQL(sql);
        }
        db.close();
    }
}
