package com.example.conectelas.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.conectelas.Model.UsuarioModel;
import com.example.conectelas.repository.ConectElasRepository;
import com.example.conectelas.service.ConectElasAPI;
import com.example.conectelas.service.RetrofitService;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CadastroViewlModel extends ViewModel {
    private CompositeDisposable disposable = new CompositeDisposable();
    private ConectElasRepository repository = new ConectElasRepository();
    public MutableLiveData<String> resultado = new MutableLiveData();
    public MutableLiveData<String> erro = new MutableLiveData();
    public MutableLiveData<Boolean> progressBar = new MutableLiveData();

    public void cadastrarUsuario(UsuarioModel usuarioModel){
        disposable.add(
                repository.cadastrarUsuario(usuarioModel).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(p -> progressBar.setValue(true))
                        .doOnTerminate(() -> progressBar.setValue(false))
                        .subscribe(s -> {
                                    resultado.setValue("Usuário Cadastrado com Sucesso!");
                                },throwable -> {
                                    erro.setValue("Algo deu errado! Tente novamente.");
                                }
                        )
        );
    }

}
