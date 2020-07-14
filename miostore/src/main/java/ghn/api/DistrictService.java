package ghn.api;

import ghn.entity.District;
import ghn.entity.Province;
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
import java.util.ArrayList;

public class DistrictService {
    public DistrictService() {
        //getInstance();
    }
    public ArrayList<District>  getAllDistrictFromApi(Province province, String DistrictName){
        ArrayList<District> listDistrict = new ArrayList<District>();
        try{
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            postRequest.setURI(new URI(Utils.URL_GET_DISTRICT));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody,province.getProvinceID());
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);

            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return listDistrict;


    }
    private void setRequestBody(JSONObject requestBody, int province_id) throws IOException, JSONException {
        requestBody.put("province_id",province_id);
    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
    }

    public District getDistrictByName(Province province,String DistrictName) {
        District district = null;
        try{
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            postRequest.setURI(new URI(Utils.URL_GET_DISTRICT));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody,province.getProvinceID());
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);
            JSONArray jaDistrict = (JSONArray) jobj.get("data");
            for (int i = 0; i < jaDistrict.length(); i++) {
                JSONObject jsonobject = jaDistrict.getJSONObject(i);
                if (jsonobject.getString("DistrictName").equals(DistrictName)) {
                    district= new District();
                    district.setDistrictID(Integer.parseInt(jsonobject.getString("DistrictID")));
                    district.setDistrictName(DistrictName);
                    district.setCode(jsonobject.getString("Code"));
                    break;

                }

            }
            //System.out.println(district);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return district;
    }

}
