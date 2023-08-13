package com.myprojects.vchat.activities;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.myprojects.vchat.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    
    private ActivitySignUpBinding binding;
    private String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setEvents();
    }

    void setEvents() {
        binding.signupButton.setOnClickListener(v -> {
                    if (isValidSignupDetails())
                        signUp();
                }
        );

    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    private void signUp(){}

    private Boolean isValidSignupDetails(){
        if(encodedImage == null){
            showToast("Please add profile image");
            return false;
        }
        else if(binding.inputPassword.getText().toString().trim().isEmpty()){
            showToast("Please Enter password");
            return false;
        }else if(binding.confirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Confirm your password");
            return false;
        } else if(binding.inputName.getText().toString().trim().isEmpty()){
            showToast("Please Enter Name");
            return false;
        }else if(binding.inputEmail.getText().toString().trim().isEmpty()){
            showToast("Please Enter Email");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()){
            showToast("Please Enter valid Email");
            return false;
        }else if(!(binding.inputPassword.getText().toString()).equals(binding.confirmPassword.getText().toString())){
            showToast(" password and comfirm password  must be same");
            return false;
        }
        else{
            return true;
        }
    }

    private void showProgress(Boolean loading) {
        if (loading) {
            binding.signupButton.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.signupButton.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }



}