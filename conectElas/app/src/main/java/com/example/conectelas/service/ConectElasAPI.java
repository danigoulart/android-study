package com.example.conectelas.service;

import com.example.conectelas.Model.UsuarioModel;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ConectElasAPI {

    @POST("usuarios/cadastrar")
    Observable<ResponseBody> cadastrarUsuario(
        @Body UsuarioModel usuarioModel);
}
