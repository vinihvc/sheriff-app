package com.vs.sheriff.controller.database_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vs.sheriff.controller.database_room.dao.ProductDao;
import com.vs.sheriff.controller.database_room.dao.StockDao;
import com.vs.sheriff.controller.database_room.dao.UserDao;
import com.vs.sheriff.controller.database_room.entity.ProductEntity;
import com.vs.sheriff.controller.database_room.entity.StockEntity;
import com.vs.sheriff.controller.database_room.entity.UserEntity;

@Database(entities = {UserEntity.class, ProductEntity.class, StockEntity.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {
    private static final String DATABASE_NAME = "sheriff";
    private static DatabaseRoom instance;

    public synchronized static DatabaseRoom getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, DatabaseRoom.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        return instance;
    }

    public abstract ProductDao productDao();

    public abstract UserDao userDao();

    public abstract StockDao stockDao();
}
