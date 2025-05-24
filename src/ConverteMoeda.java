import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {


    public DadosDeCambio FazCambio(String baseCode, String targetCode, String amount)
            throws IOException, InterruptedException, URISyntaxException {


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/164f713e3cb3afac29c25759/pair/" + baseCode + "/"
                + targetCode + "/" + amount);

        try {
         HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

            HttpResponse<String>   response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            return gson.fromJson(response.body(), DadosDeCambio.class);

               } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}

