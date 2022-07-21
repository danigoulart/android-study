package com.example.conectelas.repository;

import com.example.conectelas.Model.UsuarioModel;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.example.conectelas.service.RetrofitService;
public class ConectElasRepository  {

   public Observable<ResponseBody> cadastrarUsuario(UsuarioModel usuarioModel){
        return RetrofitService.getApiService().cadastrarUsuario(usuarioModel);
    };

}
