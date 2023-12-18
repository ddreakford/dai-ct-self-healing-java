package helpers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Helpers {

    public Helpers() {}

    public void upload_application_api(String filePath, String uniqueName) {
        try {
            HttpResponse<String> response = Unirest.post(new PropertiesReader().getProperty("ct.cloudUrl") + "/api/v1/applications/new-from-url")
                    .header("Authorization", "Bearer " + new PropertiesReader().getProperty("ct.accessKey"))
                    .field("url", filePath)
                    .field("uniqueName", uniqueName)
                    .asString();

            JSONObject responseBody = new JSONObject(response.getBody());

            if (!responseBody.has("message")) {
                System.out.println("upload_application_api() - Android APK Build Uploaded to the Continuous Testing Platform.");
            } else {
                String message = responseBody.getString("message");
                System.out.println("Response Message: " + message);

                if ("Application already exists".equals(message)) {
                    System.out.println("upload_application_api() - Android APK Build Already exists. Avoiding Upload of Duplicate Application.");
                }
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}
