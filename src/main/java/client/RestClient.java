package client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RestClient {

	/**
     * Post Service Client
     *
     * @param post
     * @param url
     */
    public static void sendPostRequest(String post, String url) {

        OutputStream outputStream = null;
        byte[] outputBytes = null;
        HttpURLConnection httpConnection = null;
        try {
            System.out.println(post);
            httpConnection = (HttpURLConnection) ((new URL(url).openConnection()));
            httpConnection.setDoOutput(true);
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestMethod("POST");
            httpConnection.connect();
            outputBytes = post.getBytes("UTF-8");
            outputStream = httpConnection.getOutputStream();
            outputStream.write(outputBytes);
            outputStream.close();
            InputStream inputStream = httpConnection.getInputStream();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException");
            System.err.println(ex.getMessage());
        } catch (ProtocolException ex) {
            System.err.println("ProtocolException");
            System.err.println(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            System.err.println("UnsupportedEncodingException");
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException");
            System.err.println(ex.getMessage());
        }

        System.out.println("Request Sent");
    }
}
