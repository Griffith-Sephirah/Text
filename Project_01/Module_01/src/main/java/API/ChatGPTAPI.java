package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ChatGPTAPI {

    private static final String API_ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";

    public static String generateAnswer(String message, String systemRole) {
        try {
            URL url = new URL(API_ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true);

            // 构建请求体
            Map<String, Object> data = new HashMap<>();
            data.put("model", "gpt-3.5-turbo");

            List<Map<String, String>> messages = new ArrayList<>();

            // 添加用户消息
            Map<String, String> userMsg = new HashMap<>();
            userMsg.put("role", "user");
            userMsg.put("content", message);
            messages.add(userMsg);

            // 添加系统消息
            Map<String, String> sysMsg = new HashMap<>();
            sysMsg.put("role", "system");
            sysMsg.put("content", systemRole);
            messages.add(sysMsg);

            data.put("messages", messages);
            data.put("temperature", 0.7);

            Gson gson = new Gson();
            String requestBody = gson.toJson(data);

            // 发送请求
            conn.getOutputStream().write(requestBody.getBytes(StandardCharsets.UTF_8));

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // 设置问题
        String question = "How old are you?";

        String systemRole = "Please tell me tour brithday";
        // 调用 ChatGPTAPI 工具类生成答案
        String answer = ChatGPTAPI.generateAnswer(question, systemRole);

        // 打印答案
        System.out.println("Question: " + question);
        System.out.println("Answer: " + answer);
    }
}

