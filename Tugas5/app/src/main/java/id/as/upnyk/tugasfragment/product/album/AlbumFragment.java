package id.as.upnyk.tugasfragment.product.album;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.as.upnyk.tugasfragment.product.KMerchData;
import id.as.upnyk.tugasfragment.product.MerchListAdapter;
import id.as.upnyk.tugasfragment.R;

public class AlbumFragment extends Fragment{

    RecyclerView rvAlbum;
    MerchListAdapter merchListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvAlbum = view.findViewById(R.id.rv_album);
        merchListAdapter = new MerchListAdapter(KMerchData.getListDataAlbum(), getActivity());

        rvAlbum.setHasFixedSize(true);
        rvAlbum.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvAlbum.setAdapter(merchListAdapter);
    }
}