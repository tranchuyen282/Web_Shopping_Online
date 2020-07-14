package ghn.api;

import dao.DAO;
import ghn.entity.Province;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ProvinceService extends DAO {
    public ProvinceService() {
        getInstance();
    }

    public ArrayList<Province>  getAllProvinceFromApi(){
        ArrayList<Province> listProvinces = new ArrayList<Province>();
        try{
            HttpPost postRequest = new HttpPost();
            HttpClient client = new DefaultHttpClient();
            postRequest.setURI(new URI(Utils.URL_GET_PROVINCE));
            //JSONObject requestBody = new JSONObject();
            //setRequestBody(requestBody);
            // postRequest.setEntity(new StringEntity(requestBody.toString()));
            setHeaders(postRequest);
            HttpResponse response = client.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jobj = new JSONObject(responseBody);
            readProvince(jobj,listProvinces);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return listProvinces;


    }
    private void setRequestBody(JSONObject requestBody) throws IOException, JSONException {

    }
    private void setHeaders(HttpUriRequest request) {
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
        request.setHeader(new BasicHeader("token", Utils.TOKEN));
        request.setHeader(new BasicHeader("Accept-Charset", "UTF-8"));
    }

    private void readProvince(JSONObject jobj,ArrayList<Province> listProvinces){
        try{
            JSONArray jaProvince = (JSONArray) jobj.get("data");
            for(int i = 0; i < jaProvince.length();i++){
                JSONObject jsonobject = jaProvince.getJSONObject(i);
                Province province = new Province();
                province.setProvinceID(Integer.parseInt(jsonobject.getString("ProvinceID")));
                province.setProvinceName(jsonobject.getString("ProvinceName"));
                province.setCode(jsonobject.getString("Code"));
                listProvinces.add(province);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Province>  getAllProvinceFromDB(){
        ArrayList<Province> listProvinces = new ArrayList<Province>();
        try {
            String query = "Select * FROM province";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Province province = new Province();
                province.setProvinceID(rs.getInt("ProvinceID"));
                province.setProvinceName(rs.getString("ProvinceName"));
                province.setCode(rs.getString("Code"));
                listProvinces.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProvinces;
    }

    public Province getProvinceFromDBByName(String ProvinceName){
        Province province = null;
        try {
            String query = "Select * FROM province WHERE ProvinceName LIKE '%"+ProvinceName+"%'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                province = new Province();
                province.setProvinceID(rs.getInt("ProvinceID"));
                province.setProvinceName(rs.getString("ProvinceName"));
                province.setCode(rs.getString("Code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return province;
    }

    private void insertProvincesToDB(ArrayList<Province> listProvinces){
        for(Province province:listProvinces){
            try{
                String query = "INSERT INTO province (ProvinceID,ProvinceName,Code) VALUES (?,?,?)";
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,province.getProvinceID());
                ps.setString(2,province.getProvinceName());
                ps.setString(3,province.getCode());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    System.out.println("Insert success: "+province);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}
