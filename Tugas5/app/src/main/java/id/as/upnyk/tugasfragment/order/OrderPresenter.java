package id.as.upnyk.tugasfragment.order;

import android.os.AsyncTask;

import java.util.List;

import id.as.upnyk.tugasfragment.db.AppDatabase;
import id.as.upnyk.tugasfragment.db.Order;

public class OrderPresenter {

    private OrderContact.OrderView orderView;

    public OrderPresenter(OrderContact.OrderView orderView) {
        this.orderView = orderView;
    }

    public void getOrders(AppDatabase appDatabase){
        List<Order> orders;
        orders = appDatabase.orderDAO().getOrderList();
        orderView.showOrders(orders);
    }
}
