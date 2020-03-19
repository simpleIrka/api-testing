package retrofit.service;

import entity.ErrorRS;
import entity.UserRS;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{user}")
    Call<UserRS> getSingleUser(@Path("user") String user);

    @POST("user/emails")
    Call<ErrorRS> changeEmail();
}
