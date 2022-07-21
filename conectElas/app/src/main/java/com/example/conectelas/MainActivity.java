package com.example.conectelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirLogin(View view){
        Intent intent = new Intent(this, EntrarActivity.class);
        startActivity(intent);
    }
    public void cadastrarUsuario(View view){
        Intent intent2 = new Intent(this, cadastroActivity.class);
        startActivity(intent2);
    }

}