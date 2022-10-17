package com.vanik.roomproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vanik.roomproject.entity.Car
import com.vanik.roomproject.entity.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getAllPersons(): List<Person>

    //@Insert(onConflict = OnConflictStrategy.ROLLBACK)
    //стратегия конфликта заключается в откате транзакции

    //@Insert(onConflict = OnConflictStrategy.ABORT)
    //default value,стратегия конфликта заключается в прекращении транзакции

    //@Insert(onConflict = OnConflictStrategy.FAIL)
    //стратегия конфликта - сбой транзакции

    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    //В этом режиме будет оставлена старая запись и операция вставки не будет выполнена.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //В режиме REPLACE старая запись будет заменена новой.
    fun insert(person: Person)

    //https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/531-urok-7-room-insert-update-delete-transaction.html
}