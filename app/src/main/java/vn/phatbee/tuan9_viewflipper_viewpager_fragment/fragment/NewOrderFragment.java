package vn.phatbee.tuan9_viewflipper_viewpager_fragment.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.databinding.FragmentNeworderBinding;

public class NewOrderFragment extends Fragment {

    // Sử dụng binding trong Fragment
    FragmentNeworderBinding binding;

    public NewOrderFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNeworderBinding.inflate(inflater, container, false);

        // Recyclerview

        return binding.getRoot();
    }
}
