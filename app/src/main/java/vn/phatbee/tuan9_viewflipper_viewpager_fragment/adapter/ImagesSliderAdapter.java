package vn.phatbee.tuan9_viewflipper_viewpager_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.R;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.model.ImageSlider;

public class ImagesSliderAdapter extends RecyclerView.Adapter<ImagesSliderAdapter.ViewHolder> {
    private List<ImageSlider> imageSliderList;
    private Context context;
    public ImagesSliderAdapter(List<ImageSlider> imageSliderList, Context context) {
        this.imageSliderList = imageSliderList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesSliderAdapter.ViewHolder holder, int position) {
        ImageSlider imageSlider = imageSliderList.get(position);
        Glide.with(context).load(imageSlider.getAvatar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageSliderList == null ? 0 : imageSliderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public void updateData(List<ImageSlider> newData)
    {
        this.imageSliderList = newData;
        notifyDataSetChanged();
    }
}
