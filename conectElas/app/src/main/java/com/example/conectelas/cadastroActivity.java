package com.example.conectelas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.conectelas.Model.UsuarioModel;
import com.example.conectelas.viewmodel.CadastroViewlModel;
import com.google.android.material.textfield.TextInputEditText;

public class cadastroActivity extends AppCompatActivity {

    String[] tiposUsuarios = {"Comum", "Administrador"};
    AutoCompleteTextView select_usuario;
    ArrayAdapter<String> adapterItems;
    private CadastroViewlModel cadastroViewModel;

    private TextInputEditText et_email;
    private TextInputEditText et_nome;
    private TextInputEditText et_senha;
    private TextInputEditText et_verificarSenha;
    private TextInputEditText et_foto;
    private String tipoUsuario;
    private EditText et_token;
    private ProgressBar progressobar;
    private AppCompatButton btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();
        initViewModel();
        initActions();

        adapterItems = new ArrayAdapter<String>(this,R.layout.tipo_user_list, tiposUsuarios);
        select_usuario.setAdapter(adapterItems);
        select_usuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Tipo de Usuário:" +item, Toast.LENGTH_SHORT).show();
                tipoUsuario = item;
                if(item.equals("Administrador")){
                    et_token.setVisibility(View.VISIBLE);
                } else {
                    et_token.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void initActions() {
        btn_cadastrar.setOnClickListener(v -> {
                    String email = et_email.getText().toString();
                    String nome = et_nome.getText().toString();
                    String senha = et_senha.getText().toString();
                    String verificarSenha = et_verificarSenha.getText().toString();
                    String fotoUser = et_foto.getText().toString();
                    String token = et_token.getText().toString();

                    if ( email.isEmpty() || nome.isEmpty() || tipoUsuario.isEmpty() || senha.isEmpty() || verificarSenha.isEmpty()){
                        Toast.makeText(this, "Todos os campos obrigatórios devem ser preenchidos", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (senha.length()<=7) {
                        Toast.makeText(this, "A senha precisa ter 8 caracteres!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (!senha.equals(verificarSenha)){
                        Toast.makeText(this, "As senhas precisam ser iguais!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (!token.equals("vitorlindao") && tipoUsuario.equals("Administrador")){
                        Toast.makeText(this, "Apenas administradores podem acessar", Toast.LENGTH_LONG).show();
                        return;
                    }
                    UsuarioModel usuario = new UsuarioModel(email, fotoUser, 0L, nome, senha, tipoUsuario );
                    cadastroViewModel.cadastrarUsuario(usuario);
                }
        );
    }

    private void initViewModel() {
        cadastroViewModel = ViewModelProviders.of(this).get(CadastroViewlModel.class);
        cadastroViewModel.resultado.observe(this, result -> Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show());
        cadastroViewModel.erro.observe(this, result -> Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show());
        cadastroViewModel.progressBar.observe(this, progress -> {
            if (progress){
                progressobar.setVisibility(View.VISIBLE);
                btn_cadastrar.setEnabled(false);
            }else{
                progressobar.setVisibility(View.GONE);
                btn_cadastrar.setEnabled(true);
            }

        } );
    }

    private void initViews() {
        et_email = findViewById(R.id.emailRegistro);
        et_nome = findViewById(R.id.nomeCompleto);
        select_usuario = findViewById(R.id.tipo_usuario);
        et_senha = findViewById(R.id.senhaRegistro);
        et_verificarSenha = findViewById(R.id.compararSenha);
        et_foto = findViewById(R.id.fotoRegistro);
        et_token = findViewById(R.id.et_token);
        progressobar = findViewById(R.id.progressBar);
        btn_cadastrar = findViewById(R.id.btn_registrar);
    }
}