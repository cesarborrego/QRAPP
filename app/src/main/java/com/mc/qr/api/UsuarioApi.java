package com.mc.qr.api;

import com.mc.qr.entity.service.Usuario;
import com.mc.qr.entity.GenericResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class UsuarioApi {

    //RUTA DEL CONTROLADOR USUARIO
    String base = "/api/login";

    //RUTA DEL CONTROLADOR USUARIO + LA RUTA DEL MÉTODO
    @FormUrlEncoded
    @POST("/api/login")
    Call<GenericResponse<Usuario>> login(@Field("username") String username, @Field("password") String password);

    @POST(base)
    Call<GenericResponse<Usuario>> save (@Body Usuario u);


}
