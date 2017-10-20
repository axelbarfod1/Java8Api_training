import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws JSONException {

        RestClientGet restClientGet = new RestClientGet();


        JSONObject aux = restClientGet.getCategories();
        JSONArray jsonArray = null;
        try {
            jsonArray = aux.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray);
        String itemID = jsonArray.getJSONObject(5).getString("id");

        JSONObject item = restClientGet.getItem(itemID);
        System.out.println(item);

        System.out.println(aux);

        System.out.println("··········································");


        RestClientPost restClientPost = new RestClientPost();
        restClientPost.postValidateJSON();
    }


}
