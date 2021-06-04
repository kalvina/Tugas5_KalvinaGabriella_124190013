package id.as.upnyk.tugasfragment.order;

import android.view.View;

import java.util.List;

import id.as.upnyk.tugasfragment.db.AppDatabase;
import id.as.upnyk.tugasfragment.db.Order;

public interface OrderContact {
    interface OrderView{
        void showOrders(List<Order> orders);
    }
}
