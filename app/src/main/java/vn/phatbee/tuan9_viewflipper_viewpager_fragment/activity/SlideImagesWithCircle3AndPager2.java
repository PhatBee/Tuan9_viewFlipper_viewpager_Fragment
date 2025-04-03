package vn.phatbee.tuan9_viewflipper_viewpager_fragment.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.R;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.adapter.ImageViewPager2Adapter;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.model.Images;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.transformer.DepthPageTransformer;

public class SlideImagesWithCircle3AndPager2 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == imagesList.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
            handler.postDelayed(this, 3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slide_images_with_circle3_and_pager2);

        // anh xạ viewpager2
        viewPager2 = findViewById(R.id.viewPage2);
        circleIndicator3 = findViewById(R.id.circleIndicator3);
        imagesList = getImagesList();
        ImageViewPager2Adapter adapter1 = new ImageViewPager2Adapter(imagesList);
        viewPager2.setAdapter(adapter1);
        circleIndicator3.setViewPager(viewPager2);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });

        viewPager2.setPageTransformer(new DepthPageTransformer());

        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    private List<Images> getImagesList() {
        List<Images> imagesList = new ArrayList<>();
        imagesList.add(new Images(R.drawable.quangcao));
        imagesList.add(new Images(R.drawable.coffee));
        imagesList.add(new Images(R.drawable.companypizza));
        imagesList.add(new Images(R.drawable.themoingon));
        return imagesList;
    }
}