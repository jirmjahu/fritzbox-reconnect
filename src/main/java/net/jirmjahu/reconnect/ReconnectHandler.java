package net.jirmjahu.reconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ReconnectHandler {

   public static boolean reconnect() {
       try {
           URL url = new URL("http://fritz.box:49000/igdupnp/control/WANIPConn1");

           HttpURLConnection httpRequest = (HttpURLConnection) url.openConnection();
           httpRequest.setRequestMethod("POST");
           httpRequest.setRequestProperty("SOAPACTION", "urn:schemas-upnp-org:service:WANIPConnection:1#ForceTermination");
           httpRequest.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
           httpRequest.setDoOutput(true);

           String data = "<?xml version=\"1.0\" encoding=\"utf-8\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope\"><s:Body><u:ForceTermination xmlns:u=\"urn:schemas-upnp-org:service:WANIPConnection:1\" /></s:Body></s:Envelope>";

           try (OutputStream outputStream = httpRequest.getOutputStream()) {
               outputStream.write(data.getBytes(StandardCharsets.UTF_8));
           }

           try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpRequest.getInputStream()))) {
               StringBuilder response = new StringBuilder();
               String line;
               while ((line = reader.readLine()) != null) {
                   response.append(line);
               }
           }
           return true;
       } catch (IOException e) {
           return false;
       }
   }
}
