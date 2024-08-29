package rin.simrail.web;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Craw {
    public static String[] craw(String args[]) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        var url = "https://panel.simrail.eu:8084/trains-open?serverCode=" + args[0];
        System.out.println("Trying to connect to " + url + " ...\n");
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        String response = call.execute().body().string();
        System.out.println(response);
        return Json.json(response, args[0], args[1]);
    }
}
