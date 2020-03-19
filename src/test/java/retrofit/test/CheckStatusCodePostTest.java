package retrofit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.ErrorRS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit.service.GitHubService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckStatusCodePostTest {
    private static final String BASE_URL = "https://api.github.com/";
    private static final int STATUS_OK = 200;

    private Retrofit retrofit;

    @BeforeEach
    void init() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Test
    void post() throws IOException {
        GitHubService service = retrofit.create(GitHubService.class);
        Call<ErrorRS> repos = service.changeEmail();
        int statusCode = repos.execute().code();
        assertEquals(STATUS_OK, statusCode, "Status code response ");
    }
}
