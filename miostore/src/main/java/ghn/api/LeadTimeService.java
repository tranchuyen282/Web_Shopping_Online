package ghn.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class LeadTimeService {
    public String getLeadTime(int to_district_id, String to_ward_code, int service_id){
        String s = "";
        try {
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            //body
            postRequest.setURI(new URI(Utils.URL_GET_LEAD_TIME));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody, to_district_id, to_ward_code,service_id);
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            //header
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);

            JSONObject jdata = jobj.getJSONObject("data");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            s = dateFormat.format(new java.util.Date((long)jdata.getInt("leadtime")*1000));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }

    private void setRequestBody(JSONObject requestBody, int to_district_id, String to_ware_code, int service_id) throws IOException, JSONException {
        requestBody.put("from_district_id",Utils.FROM_DISTRICT);
        requestBody.put("to_district_id",to_district_id);
        requestBody.put("to_ward_code",to_ware_code);
        requestBody.put("service_id",service_id);
    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
    }

//    public static void main(String[] args) {
//        LeadTimeService leadTimeService = new LeadTimeService();
//        leadTimeService.getLeadTime(1750,"511110",53320);
//    }
}
