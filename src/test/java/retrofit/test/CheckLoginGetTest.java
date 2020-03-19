package retrofit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit.service.GitHubService;
import entity.UserRS;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckLoginGetTest {
    private static final String BASE_URL = "https://api.github.com/";

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

    @ParameterizedTest
    @ValueSource(strings = {"simpleIrka"})
    void checkLogin(String login) throws IOException {
        GitHubService service = retrofit.create(GitHubService.class);
        Call<UserRS> repos = service.getSingleUser(login);
        UserRS userRS = repos.execute().body();

        assertEquals(login, userRS.getLogin(), "Login for user " + login);
    }
}
