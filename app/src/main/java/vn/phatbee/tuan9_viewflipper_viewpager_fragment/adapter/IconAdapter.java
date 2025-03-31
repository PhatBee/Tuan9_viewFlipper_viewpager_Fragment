package vn.phatbee.tuan9_viewflipper_viewpager_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.R;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.model.IconModel;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder>{
    private Context context;
    private List<IconModel> iconModelList;

    public IconAdapter(Context applicationContext, ArrayList<IconModel> arrayList1) {
        this.context = applicationContext;
        this.iconModelList = arrayList1;
    }

    public void setlistenerList(List<IconModel> iconModelList){
       this.iconModelList = iconModelList;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_icon_promotion, parent, false);
        return new IconHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconAdapter.IconHolder holder, int position) {
        IconModel iconModel = iconModelList.get(position);
        holder.ivImgIcon.setImageResource(iconModel.getImgId());
        holder.tvIcon.setText(iconModel.getDesc());
    }

    @Override
    public int getItemCount() {
        if (iconModelList != null)
            return iconModelList.size();
        return 0;
    }

    public class IconHolder extends RecyclerView.ViewHolder{
        private ImageView ivImgIcon;
        private TextView tvIcon;

        public IconHolder(@NonNull View itemView) {
            super(itemView);
            ivImgIcon = itemView.findViewById(R.id.ivImgIcon);
            tvIcon = itemView.findViewById(R.id.tvIcon);
        }
    }
}
