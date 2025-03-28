package vn.phatbee.tuan9_viewflipper_viewpager_fragment;

import static androidx.core.view.accessibility.AccessibilityEventCompat.setAction;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.adapter.ViewPager2Adapter;
import vn.phatbee.tuan9_viewflipper_viewpager_fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ViewPager2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // viewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //toolbar
        setSupportActionBar(binding.toolbar);

        FloatingActionButton fab = binding.fabAction;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
            }
        });

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Xác nhận"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Lấy hàng"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Vận chuyển"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Đánh giá"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Huỷ"));

        // Set Adapter cho ViewPager2
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPager2Adapter(fragmentManager, getLifecycle());
        binding.viewPager2.setAdapter(adapter);

        // Chuyển Tab
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager2.setCurrentItem(tab.getPosition());
                changeFabIcon(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
    }

    void changeFabIcon(final int index){
        binding.fabAction.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0:
                        binding.fabAction.setImageResource(R.drawable.ic_baseline_chat_24);
                        break;
                    case 1:
                        binding.fabAction.setImageResource(R.drawable.ic_baseline_camera_alt_24);
                        break;
                    case 2:
                        binding.fabAction.setImageResource(R.drawable.ic_baseline_call_24);
                        break;
                }
                binding.fabAction.show();
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSearch)
        {
            Toast.makeText(this, "Bạn đang chọn Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menuNewGroup){
            Toast.makeText(this, "Bạn đang chọn New Group", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menuBroadcast){
            Toast.makeText(this, "Bạn đang chọn Broadcast", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menuWeb){
            Toast.makeText(this, "Bạn đang chọn WhatsApp Web", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menuMessage){
            Toast.makeText(this, "Bạn đang chọn Started Messages", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.menuSetting){
            Toast.makeText(this, "Bạn đang chọn Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}