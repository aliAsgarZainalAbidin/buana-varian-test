package id.deval.masakapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.deval.masakapp.db.dao.DaoExampleEntity
import id.deval.masakapp.db.models.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun exampleDao(): DaoExampleEntity
}