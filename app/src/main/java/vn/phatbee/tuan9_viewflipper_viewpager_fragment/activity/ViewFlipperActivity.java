package vn.phatbee.tuan9_viewflipper_viewpager_fragment.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.List;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.R;

public class ViewFlipperActivity extends AppCompatActivity {
    ViewFlipper viewFlipperMain;
    Button btnNextSlideImages2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_flipper);
        btnNextSlideImages2 = findViewById(R.id.btnNextSlideImages2);
        btnNextSlideImages2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewFlipperActivity.this, SlideImagesWithCircleIndicatorAndViewPagerActivity.class);
                startActivity(intent);
            }
        });


        // 🛠 THÊM DÒNG NÀY: Khởi tạo viewFlipperMain
        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        actionViewFlipper();

    }

    private void actionViewFlipper(){
        List<String> listUrl = new ArrayList<>();
        listUrl.add("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png");
        listUrl.add("http://app.iotstar.vn:8081/appfoods/flipper/coffee.jpg");
        listUrl.add("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg");
        listUrl.add("http://app.iotstar.vn:8081/appfoods/flipper/themoingon.jpeg");

        for (String url : listUrl) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(getApplicationContext())
                    .load(url)
                    .placeholder(R.drawable.loading) // 🛠 Ảnh placeholder khi tải
                    .error(R.drawable.error) // 🛠 Ảnh hiển thị khi lỗi
                    .into(imageView);

            viewFlipperMain.addView(imageView);
        }
        viewFlipperMain.setFlipInterval(3000);
        viewFlipperMain.setAutoStart(true);

        // Thiet lap Amination cho filipper
        Animation slide_in = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation(slide_out);
    }
}