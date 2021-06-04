package id.as.upnyk.tugasfragment.order;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.as.upnyk.tugasfragment.R;
import id.as.upnyk.tugasfragment.addupdate.AddUpdateOrderActivity;
import id.as.upnyk.tugasfragment.db.Order;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    List<Order> orders;
    Context context;

    public OrderListAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrderName, tvOrderQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrderName = itemView.findViewById(R.id.tv_order_list_item_name);
            tvOrderQuantity = itemView.findViewById(R.id.tv_order_list_item_quantity);
        }

        public void bind(int position) {
            tvOrderName.setText(orders.get(position).getName());
            tvOrderQuantity.setText(String.valueOf(orders.get(position).getQuantity()));
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, AddUpdateOrderActivity.class);
                intent.putExtra("EXTRA_ORDER", orders.get(position));
                context.startActivity(intent);
            });
        }
    }
}
