package com.example.mysql_ex1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.LocalDate

val DATABASE_NAME = "the_database.db"
val DATABASE_VERSION = 1
val TABLE_RESERVATION = "reservation"
val COLUMN_RESERVATION_ID = "id"
val COLUMN_RESERVATION_DATE = "date_reservation"
private val CREATE_TABLE_RESERVATION = "CREATE TABLE IF NOT EXISTS ${TABLE_RESERVATION} (${COLUMN_RESERVATION_ID} INTEGER PRIMARY KEY, ${COLUMN_RESERVATION_DATE} INTEGER);"
/* etc */
class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(CREATE_TABLE_RESERVATION)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertReservation(reservationId: Long?, reservationDate: LocalDate): Long {
        val cv = ContentValues()
        if (reservationId!= null) {
            cv.put(COLUMN_RESERVATION_ID,reservationId)
        }
        cv.put(COLUMN_RESERVATION_DATE,reservationDate.toEpochDay())
        return this.writableDatabase.insert(TABLE_RESERVATION,null,cv)
    }
    fun insertReservation(reservationDate: LocalDate): Long = insertReservation(null,reservationDate)

    fun updateReservationDate(reservationId: Long,reservationDate: LocalDate): Int {
        val cv = ContentValues()
        cv.put(COLUMN_RESERVATION_DATE,reservationDate.toEpochDay())
        return this.writableDatabase.update(TABLE_RESERVATION,cv,"${COLUMN_RESERVATION_ID}=?", arrayOf(reservationId.toString()))
    }

    companion object {
        @Volatile
        var instance: DBHelper?=null
        fun getInstance(context: Context): DBHelper {
            if (instance==null) {
                instance=DBHelper(context)
            }
            return instance as DBHelper
        }
    }
}