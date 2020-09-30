package utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 */
public class RestClient {

    private static final Gson GSON = new Gson();

    public static <T> T get(String url, Type typeReturn) throws IOException, InterruptedException {
        HttpRequest.Builder request = createRequest(url).GET();
        return GSON.fromJson(getResponseBody(request), typeReturn);
    }

    public static <T> T post(String url, Object body, Type typeReturn) throws IOException, InterruptedException {
        HttpRequest.Builder request = createRequest(url).POST(createBody(body));
        return GSON.fromJson(getResponseBody(request), typeReturn);
    }

    private static String getResponseBody(HttpRequest.Builder request) throws IOException, InterruptedException {
        request.version(HttpClient.Version.HTTP_1_1);
        // request.setHeader("Authorization", "Bearer " + "adsasd.qweqwe.zxczxc");
        request.setHeader("Content-type", "application/json; charset=UTF-8");
        return HttpClient.newHttpClient().send(request.build(), HttpResponse.BodyHandlers.ofString()).body();
    }

    private static HttpRequest.Builder createRequest(String url) {
        return HttpRequest.newBuilder(URI.create(url));
    }

    private static HttpRequest.BodyPublisher createBody(Object body) {
        return HttpRequest.BodyPublishers.ofString(GSON.toJson(body));
    }
}
