package ghn.api;

import ghn.entity.AddressGHN;
import ghn.entity.MethodGHN;
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

public class GHNService {
    public ArrayList<MethodGHN> getMethodGHN(AddressGHN addressGHN){
        ArrayList<MethodGHN> listMethod = new ArrayList<MethodGHN>();
        try{
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            //body
            postRequest.setURI(new URI(Utils.URL_GET_METHOD));
            JSONObject requestBody = new JSONObject();
            setRequestBody(requestBody, addressGHN.getTo_districtID());
            postRequest.setEntity(new StringEntity(requestBody.toString()));
            //header
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);
            //readData
            JSONArray ja = (JSONArray) jobj.get("data");
            for(int i = 0; i < ja.length();i++){
                JSONObject jsonobject = ja.getJSONObject(i);
                if( jsonobject.getInt("service_type_id") != 0){
                    MethodGHN methodGHN = new MethodGHN();
                    methodGHN.setService_id(jsonobject.getInt("service_id"));
                    methodGHN.setShort_name(jsonobject.getString("short_name"));
                    methodGHN.setService_type_id(jsonobject.getInt("service_type_id"));
                    //get leadtime
                    LeadTimeService leadTimeService = new LeadTimeService();
                    methodGHN.setLeadtime(leadTimeService.getLeadTime(addressGHN.getTo_districtID(),addressGHN.getTo_wardCode(),methodGHN.getService_id()));
                    //get fee
                    CaculateFeeService caculateFeeService = new CaculateFeeService();
                    methodGHN.setTotalFee(caculateFeeService.caculateFee(addressGHN.getTo_districtID(),addressGHN.getTo_wardCode(),methodGHN.getService_id(),methodGHN.getService_type_id()));
                    listMethod.add(methodGHN);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return listMethod;


    }
    private void setRequestBody(JSONObject requestBody, int to_district) throws IOException, JSONException {
        requestBody.put("shop_id",Utils.SHOPID);
        requestBody.put("from_district",Utils.FROM_DISTRICT);
        requestBody.put("to_district",to_district);
    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
    }
}
