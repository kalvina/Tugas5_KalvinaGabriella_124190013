package id.as.upnyk.tugasfragment.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.as.upnyk.tugasfragment.R;

public class MerchListAdapter extends RecyclerView.Adapter<MerchListAdapter.ViewHolder> {

    ArrayList<KMerchModel> kMerchList;
    Context context;

    public MerchListAdapter(ArrayList<KMerchModel> kMerchList, Context context) {
        this.kMerchList = kMerchList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return kMerchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMerch;
        TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMerch = itemView.findViewById(R.id.iv_list_item);
            tvTitle = itemView.findViewById(R.id.tv_title_list_item);
        }

        public void bind(int position) {
            Glide.with(context)
                    .load(kMerchList.get(position).getImage())
                    .into(ivMerch);
            tvTitle.setText(kMerchList.get(position).getName());
        }
    }
}
