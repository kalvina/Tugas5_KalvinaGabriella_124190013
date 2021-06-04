package id.as.upnyk.tugasfragment.order;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import id.as.upnyk.tugasfragment.addupdate.AddUpdateOrderActivity;
import id.as.upnyk.tugasfragment.R;
import id.as.upnyk.tugasfragment.db.AppDatabase;
import id.as.upnyk.tugasfragment.db.Order;

public class OrderFragment extends Fragment implements OrderContact.OrderView {

    private FloatingActionButton fabAdd;
    private RecyclerView rvOrder;
    private OrderListAdapter orderListAdapter;
    private OrderPresenter orderPresenter;
    private AppDatabase appDatabase;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvOrder = view.findViewById(R.id.rv_order_list);
        fabAdd = view.findViewById(R.id.fab_add);
        orderListAdapter = new OrderListAdapter(new ArrayList<>(), getActivity());
        orderPresenter = new OrderPresenter(this);
        appDatabase = AppDatabase.getInstance(getActivity());

        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvOrder.setHasFixedSize(true);
        rvOrder.setAdapter(orderListAdapter);
        fabAdd.setOnClickListener(v -> startActivity(new Intent(getActivity(), AddUpdateOrderActivity.class)));
    }

    @Override
    public void onResume() {
        super.onResume();
        orderPresenter.getOrders(appDatabase);
    }

    @Override
    public void showOrders(List<Order> orders) {
        orderListAdapter.setOrders(orders);
        orderListAdapter.notifyDataSetChanged();
    }
}