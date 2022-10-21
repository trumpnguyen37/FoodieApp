package com.example.androidproject;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignupTabFragment extends Fragment {

    private FirebaseAuth mAuth;

    EditText email, number, pass , confirmPass ;
    Button signup;
    float v=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();

        email = root.findViewById(R.id.email1);
        pass = root.findViewById(R.id.pass1);
        number = root.findViewById(R.id.number);
        confirmPass = root.findViewById(R.id.confirmPass);
        signup = root.findViewById(R.id.btn_Signup);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        number.setTranslationX(800);
        confirmPass.setTranslationX(800);
        signup.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        number.setAlpha(v);
        confirmPass.setAlpha(v);
        signup.setAlpha(v);


        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(550).start();
        number.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = email.getText().toString().trim();
                String sdt = number.getText().toString().trim();
                String mk = pass.getText().toString().trim();
                String xacnhanmk = confirmPass.getText().toString().trim();

                if (taikhoan.isEmpty()){
                    email.setError("Vui lòng nhập tài khoản!");
                    email.requestFocus();
                    return;
                }

                if (sdt.isEmpty()){
                    email.setError("Vui lòng nhập SĐT!");
                    email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(taikhoan).matches()){
                    email.setError("Vui lòng nhập tài khoản dạng email!");
                    email.requestFocus();
                    return;
                }

                if (mk.isEmpty()){
                    email.setError("Vui lòng nhập mật khẩu!");
                    email.requestFocus();
                    return;
                }

                if (xacnhanmk.isEmpty()){
                    email.setError("Vui lòng nhập xác nhận mật khẩu!");
                    email.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(taikhoan,mk)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    User user = new User(taikhoan,sdt,mk,xacnhanmk);

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(getActivity(), "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                                                    }else   {
                                                        Toast.makeText(getActivity(), "Tạo tài khoản thất bại!", Toast.LENGTH_SHORT).show();

                                                    }
                                                }
                                            });
                                } else{
                                    Toast.makeText(getActivity(), "Tạo tài khoản thất bại!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });



        return root;
    }


}
