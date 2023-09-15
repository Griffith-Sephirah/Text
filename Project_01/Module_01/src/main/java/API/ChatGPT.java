package API;

import okhttp3.*;

import java.io.IOException;

public class ChatGPT {

    private static final String API_ENDPOINT = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private static final String API_KEY = "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";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        String prompt = "I like to eat pizza because";

        RequestBody requestBody = new FormBody.Builder()
                .add("prompt", prompt)
                .add("max_tokens", "50")
                .add("temperature", "0.5")
                .build();

        Request request = new Request.Builder()
                .url(API_ENDPOINT)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}