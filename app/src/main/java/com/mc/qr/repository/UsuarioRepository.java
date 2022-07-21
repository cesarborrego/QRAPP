package com.mc.qr.repository;

import com.mc.qr.api.ConfigApi;
import com.mc.qr.api.userAPI;
import com.mc.qr.entity.GenericResponse;
import com.mc.qr.entity.service.Usuario;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioRepository {
    private static UsuarioRepository repository;
    private final userAPI api;

    public UsuarioRepository() {
        this.api = ConfigApi.getuserAPI();
    }

    public static UsuarioRepository getInstance() {
        if (repository == null) {
            repository = new UsuarioRepository();
        }
        return repository;
    }

    public LiveData<GenericResponse<Usuario>> login(String username, String password) {
        final MutableLiveData<GenericResponse<Usuario>> mld = new MutableLiveData<>();
        this.api.login(username, password).enqueue(new Callback<GenericResponse<Usuario>>() {
            @Override
            public void onResponse(Call<GenericResponse<Usuario>> call, Response<GenericResponse<Usuario>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GenericResponse<Usuario>> call, Throwable t) {
                mld.setValue(new GenericResponse());
                System.out.println("Se ha producido un error al iniciar sesión: " + t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }

    public LiveData<GenericResponse<Usuario>> save(Usuario u) {
        final MutableLiveData<GenericResponse<Usuario>> mld = new MutableLiveData<>();
        this.api.save(u).enqueue(new Callback<GenericResponse<Usuario>>() {
            @Override
            public void onResponse(Call<GenericResponse<Usuario>> call, Response<GenericResponse<Usuario>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GenericResponse<Usuario>> call, Throwable t) {
                mld.setValue(new GenericResponse<>());
                System.out.println("Se ha producido un error : " + t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }

}
