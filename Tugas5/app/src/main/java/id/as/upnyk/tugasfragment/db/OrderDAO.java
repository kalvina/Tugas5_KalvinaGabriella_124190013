package id.as.upnyk.tugasfragment.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    Long insertData(Order order);

    @Query("SELECT * FROM `order`")
    List<Order> getOrderList();

    @Query("SELECT * FROM `order` WHERE id = :id")
    Order getOrderById(int id);

    @Update
    int updateData(Order order);

    @Delete
    void deleteData(Order order);
}
