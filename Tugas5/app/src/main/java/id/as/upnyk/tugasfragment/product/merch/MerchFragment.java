package id.as.upnyk.tugasfragment.product.merch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.as.upnyk.tugasfragment.product.KMerchData;
import id.as.upnyk.tugasfragment.product.MerchListAdapter;
import id.as.upnyk.tugasfragment.R;

public class MerchFragment extends Fragment{

    RecyclerView rvMerch;
    MerchListAdapter merchListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_merch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMerch = view.findViewById(R.id.rv_merch);
        merchListAdapter = new MerchListAdapter(KMerchData.getListDataMerch(), getActivity());

        rvMerch.setHasFixedSize(true);
        rvMerch.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvMerch.setAdapter(merchListAdapter);
    }
}