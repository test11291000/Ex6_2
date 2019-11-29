package idv.leo.ex6_2;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class DetailFragment extends Fragment {
    private Activity activity;
    private ActionBar actionBar;
    private ImageView imageView;
    private TextView tvName;
    private TextView tvPhone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle("Detail");
        if (activity != null) {
            actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        }
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        tvName = view.findViewById(R.id.tvName);
        tvPhone = view.findViewById(R.id.tvPhone);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Friend friend = (Friend) bundle.getSerializable("friend");
            if (friend != null) {
                imageView.setImageResource(friend.getImageId());
                tvName.setText(friend.getName());
                tvPhone.setText(friend.getPhone());
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.e("TAG","1111111");
                Navigation.findNavController(tvName).popBackStack();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
