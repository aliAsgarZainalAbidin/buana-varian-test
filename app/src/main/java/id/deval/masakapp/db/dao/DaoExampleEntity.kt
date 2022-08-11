package id.deval.masakapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import id.deval.masakapp.db.models.ExampleEntity

@Dao
interface DaoExampleEntity {
    @Query("SELECT * FROM ExampleEntity")
    fun selectAll():List<ExampleEntity>
}