package com.example.shoesshop.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoesshop.R;
<<<<<<< HEAD
import com.google.android.gms.tasks.OnCompleteListener;
=======
import com.example.shoesshop.activity.ChaneInfoActivity;
import com.example.shoesshop.dao.UserDao;
import com.example.shoesshop.model.User;
>>>>>>> 18f5ee50a301e729aaf3e81ac00c9c66a3d6d390
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyProfileFragment extends Fragment implements View.OnClickListener{

    private ImageView imageAvata;
<<<<<<< HEAD
    private TextView tvInfoEmail, tvInfoName,tvInfoNumber;
    private Button btDangXuat;
=======
    private TextView tvInfoEmail, tvInfoName,tvInfoNumber,tvGender,tvDate;
    private Button btn;
>>>>>>> 18f5ee50a301e729aaf3e81ac00c9c66a3d6d390

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle saveInstanceState){
        View view=  inflater.inflate(R.layout.fragment_my_profile, container,false);
        imageAvata = view.findViewById(R.id.imageInfoProfile);
        tvInfoEmail = view.findViewById(R.id.tvInfoEmail);
        tvInfoName = view.findViewById(R.id.tvInfoName);
        tvInfoNumber = view.findViewById(R.id.tvInfoNumber);
<<<<<<< HEAD
        btDangXuat =  view.findViewById(R.id.btdangxuat);

=======
        tvGender = view.findViewById(R.id.tvGender);
        tvDate = view.findViewById(R.id.tvDate);
        btn = view.findViewById(R.id.buttonEditInfo);
>>>>>>> 18f5ee50a301e729aaf3e81ac00c9c66a3d6d390
        showUserInfomation();
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ChaneInfoActivity.class);
            startActivity(intent);
        });
        return view;
    }


    private void showUserInfomation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user== null){
            return;
        }
        UserDao userDao = new UserDao();

        userDao.findByEmail(user.getEmail(), new UserDao.UserCallback() {

            @Override
            public void onSuccess(User user) {
                String fullName  = user.getFirstName()+" "+user.getLastName();
                tvInfoName.setText(fullName);
                tvGender.setText(user.getGender());
                tvDate.setText(user.getBirth());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();


        tvInfoEmail.setText(email);

        Glide.with(this).load(photoUrl).error(R.drawable.no_image_profile).into(imageAvata);
    }


    @Override
    public void onClick(View view) {

    }
}