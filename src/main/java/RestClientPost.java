import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClientPost {

    private String BASEURL = "https://api.mercadolibre.com/";
    private String ACCESS_TOKEN = "APP_USR-3656094734528544-101717-adb8b5a358285eaccc959d1b004ab2af__A_D__-71109005";


    public void postValidateJSON() {
        //String params = String.format("?access_token=%s", ACCESS_TOKEN);
        String urlBuscarItem = "http://localhost:8080/workshop/abarfod/";
        StringBuffer bf = new StringBuffer();
        JSONArray array = null;

        try {
            URL url = new URL(urlBuscarItem);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            array = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("id","MLU445030900");
            array.put(obj);
            JSONObject main = new JSONObject();
            main.put("msg",array);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(main.toString().getBytes("UTF-8"));
            os.close();

            /**DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(params);
            dataOutputStream.flush();
            dataOutputStream.close();*/

            int respuesta = connection.getResponseCode();
            System.out.println("Codigo de respuesta: " + respuesta);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;

            while ((input = in.readLine()) != null) {
                bf.append(input);
            }
            in.close();
            System.out.println(bf.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException exe) {
            exe.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
