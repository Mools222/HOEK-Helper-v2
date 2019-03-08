package dk.kugelberg.hoek_helper.view.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM data_row ORDER BY id")
    LiveData<List<DataRow>> loadAllTasks();

    @Insert
    void insertTask(DataRow taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(DataRow taskEntry);

    @Delete
    void deleteTask(DataRow taskEntry);

    @Query("SELECT * FROM data_row WHERE id = :id")
    LiveData<DataRow> loadTaskById(int id);


    // Test
    @Query("SELECT * FROM data_row ORDER BY id")
    List<DataRow> loadAll();
}