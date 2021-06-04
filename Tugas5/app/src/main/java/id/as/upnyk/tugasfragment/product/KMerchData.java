package id.as.upnyk.tugasfragment.product;

import java.util.ArrayList;

import id.as.upnyk.tugasfragment.R;
import id.as.upnyk.tugasfragment.product.KMerchModel;

public class KMerchData {
    private static  String[] namaAlbum = new String[]{"You Made My Dawn\n SEVENTEEN", "You Make My Day\n SEVENTEEN", "Teen Age\n SEVENTEEN", "Regular-Irregular\n NCT 127", "We Boom\n NCT DREAM", "Take Off\n WAY V", "Super Human\n NCT 127"};

    private static int[] gambarAlbum = new int[]{R.drawable.album_1, R.drawable.album_2, R.drawable.album_3, R.drawable.album_4, R.drawable.album_5, R.drawable.album_6, R.drawable.album_7};

    private static  String[] namaMerch = new String[]{"T-Shirt Vernon SVT", "Sweater Neozone NCT", "Sweater Resonance NCT", "T-Shirt Resonance NCT (Black)", "T-Shirt Resonance NCT (White)", "T-Shirt StrayKids (Black)", "Sweater StrayKids", "T-Shirt StrayKids (White)", "T-Shirt TheBoyz"};

    private static int[] gambarMerch = new int[]{R.drawable.merch_1, R.drawable.merch_2, R.drawable.merch_3, R.drawable.merch_4, R.drawable.merch_5, R.drawable.merch_6, R.drawable.merch_7, R.drawable.merch_8, R.drawable.merch_9};

    public static ArrayList<KMerchModel> getListDataAlbum(){
        KMerchModel albumModel = null;
        ArrayList<KMerchModel> listAlbum = new ArrayList<>();
        for ( int i = 0; i < namaAlbum.length; i++){
            albumModel = new KMerchModel(
                    gambarAlbum[i],
                    namaAlbum[i]
            );
            listAlbum.add(albumModel);
        }
        return listAlbum;
    }

    public static ArrayList<KMerchModel> getListDataMerch(){
        KMerchModel merchModel = null;
        ArrayList<KMerchModel> listMerch = new ArrayList<>();
        for ( int i = 0; i < namaMerch.length; i++){
            merchModel = new KMerchModel(
                    gambarMerch[i],
                    namaMerch[i]
            );
            listMerch.add(merchModel);
        }
        return listMerch;
    }
}
