package id.deval.masakapp.db.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.deval.masakapp.db.Database

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): Database {
        return Room.databaseBuilder(context, Database::class.java, "masakapp-db.db")
            .fallbackToDestructiveMigration().build()
    }

}