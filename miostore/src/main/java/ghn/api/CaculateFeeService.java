package ghn.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class CaculateFeeService {
    public int caculateFee(int to_district_id, String to_ward_code, int service_id,int service_type_id){
        int s = 0;
        try {
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            //body
            postRequest.setURI(new URI(Utils.URL_GET_FEE));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody, to_district_id, to_ward_code, service_id, service_type_id);
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            //header
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);
            if (jobj.get("data") == null) {
            }else{
                JSONObject jdata = jobj.getJSONObject("data");
                s = jdata.getInt("total");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }

    private void setRequestBody(JSONObject requestBody, int to_district_id, String to_ware_code, int service_id,int service_type_id) throws IOException, JSONException {
        requestBody.put("from_district_id",Utils.FROM_DISTRICT);
        requestBody.put("service_id",service_id);
        requestBody.put("service_type_id",service_type_id);
        requestBody.put("to_district_id",to_district_id);
        requestBody.put("to_ward_code",to_ware_code);
        requestBody.put("height",10);
        requestBody.put("length",25);
        requestBody.put("weight",350);
        requestBody.put("width",20);
        requestBody.put("insurance_fee",100000);


    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
    }

//    public static void main(String[] args) {
//        CaculateFeeService caculateFeeService = new CaculateFeeService();
//        caculateFeeService.caculateFee(1442,"20102",53320,2);
//    }
}
