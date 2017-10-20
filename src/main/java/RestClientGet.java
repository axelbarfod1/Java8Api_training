import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClientGet {

    private String BASEURL = "https://api.mercadolibre.com/";
    private String RESOURCE = "sites/";
    private String SITE = "MLU/";


    public JSONObject getCategories() {
        String url = BASEURL + RESOURCE + SITE + "search?category=MLU1574&official_store_id=all";
        StringBuilder sb = new StringBuilder();

        try {
            //Creo el objecto url con la url que me quiero conectar
            URL u = new URL(url);
            //Abro la connecion
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            if (connection.getResponseCode() != 200) {
                String error = String.format("Error: Codigo %s , mensaje: %s", connection.getResponseCode(), connection.getResponseMessage());
                throw new RuntimeException(error);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));
            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output + '\n');
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = null;


        try {
            obj = new JSONObject(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }


    /**
     * Devuelve el item que uno queire
     * @param id del item que se va a buscar
     * @return
     */
    public JSONObject getItem(String id) {
        String urlBuscarItem = BASEURL + "items/" + id;
        StringBuilder sb = new StringBuilder();
        JSONObject obj = null;
        try {
            URL url = new URL(urlBuscarItem);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            System.out.println();
            if (connection.getResponseCode() != 200) {
                String error = String.format("Error: Codigo %s , mensaje: %s", connection.getResponseCode(), connection.getResponseMessage());
                throw new RuntimeException(error);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));
            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output + '\n');
            }

            obj = new JSONObject(sb.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException exe) {
            exe.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
