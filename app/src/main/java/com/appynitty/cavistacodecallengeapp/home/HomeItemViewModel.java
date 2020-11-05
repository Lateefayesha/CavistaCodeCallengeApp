package com.appynitty.cavistacodecallengeapp.home;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.appynitty.cavistacodecallengeapp.R;
import com.appynitty.cavistacodecallengeapp.common.ViewModel;
import com.appynitty.cavistacodecallengeapp.common.generic.GenericAdapter;
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel;
import com.squareup.picasso.Picasso;


public class HomeItemViewModel implements ViewModel<HomeModel> {
    private GenericAdapter.OnItemClickListner listner;
    private Context context;
     public HomeModel model;
    private static final String TAG = "HomeItemViewModel";

    public HomeItemViewModel(Context context) {
        this.context = context;
    }

    @Override
    public int layoutId() {
        return R.layout.item_rv_home;
    }

    @Override
    public void setModel(HomeModel model) {
this.model = model;
    }

    public void setListener(GenericAdapter.OnItemClickListner listner) {
        this.listner = listner;
    }

    public void onClicked(View view , HomeModel model){
        if(listner!=null){
            listner.onItemClicked(model);
        }
    }


    @BindingAdapter(value = {"imageData"},requireAll = false)
    public static void loadImage(ImageView view, String imageUrl) {
        Log.d(TAG, "loadImage: "+imageUrl);
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.place_holder)
                .into(view);
    }



//     public void startCall(View view, String userNumber){
//         Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", userNumber, null));
//         context.startActivity(intent);
//     }
}
