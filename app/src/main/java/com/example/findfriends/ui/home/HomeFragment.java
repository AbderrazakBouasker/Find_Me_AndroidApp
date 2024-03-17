package com.example.findfriends.ui.home;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.findfriends.MainActivity;
import com.example.findfriends.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnSendHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = binding.ednumberHome.getText().toString();
                //send sms
                if(MainActivity.PERMISSION){
                    SmsManager manager = SmsManager.getDefault();//default sim card
                    manager.sendTextMessage(number,null,"FINDME: I'am being kidnapped help please",null,null);
                }


            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}