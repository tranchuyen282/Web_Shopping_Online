package serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewClass {
    public static void main(String[] args) {
        StringBuilder strBuf = new StringBuilder();  
        
        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{  
            //Declare the connection to weather api url
            URL url = new URL("https://citigo-demo-api.herokuapp.com/product/lavie.json");  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + conn.getResponseCode());
            }
	    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = null;  
            while ((output = reader.readLine()) != null)  
                strBuf.append(output);  
        }catch(MalformedURLException e) {  
            e.printStackTrace();   
        }catch(IOException e){  
            e.printStackTrace();   
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                conn.disconnect();
            }
        }

        System.out.println(strBuf.toString());  
    }
    
    
}