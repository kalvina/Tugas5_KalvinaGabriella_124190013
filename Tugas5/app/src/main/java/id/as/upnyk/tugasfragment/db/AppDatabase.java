package id.as.upnyk.tugasfragment.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Order.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract OrderDAO orderDAO();
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context){
        if(appDatabase==null)
            appDatabase= Room.databaseBuilder(context,AppDatabase.class, "KMerchDB").allowMainThreadQueries().build();
        return appDatabase;
    }
}
