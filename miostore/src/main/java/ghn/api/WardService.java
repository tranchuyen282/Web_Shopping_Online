package ghn.api;

import ghn.entity.District;
import ghn.entity.Province;
import ghn.entity.Ward;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WardService {
    private void setRequestBody(JSONObject requestBody, int district_id) throws IOException, JSONException {
        requestBody.put("district_id",district_id);
    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
    }

    public Ward getWardByName(District district, String wardName) {
        Ward ward = null;
        try{
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();

            postRequest.setURI(new URI(Utils.URL_GET_WARD));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody,district.getDistrictID());
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            setHeaders(postRequest);

            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);
            JSONArray jaDistrict = (JSONArray) jobj.get("data");
            for (int i = 0; i < jaDistrict.length(); i++) {
                JSONObject jsonobject = jaDistrict.getJSONObject(i);
                if (jsonobject.getString("WardName").equals(wardName)) {
                    ward = new Ward();
                    ward.setWardCode(jsonobject.getString("WardCode"));
                    ward.setWardName(wardName);
                    break;

                }
            }
           // System.out.println(ward);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ward;
    }
}
