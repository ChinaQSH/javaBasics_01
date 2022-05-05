import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>
 *
 * @author: mini
 * @Date: 2022-05-05 14:11
 * @Description:
 */

public class HttpTest {
    public final static int READ_TIME_OUT = 120000;	 //读取超时时间
    public final static int CONNECT_TIME_OUT = 30000;	//链接超时时间 30s
    public final static String GET = "GET";	// 请求方式：get
    public final static String CHARSET = "utf-8";	//编码格式
    public static void main(String[] args) throws IOException {
        String userInfoBytoke = getUserInfoByToke(token);
        System.out.println(userInfoBytoke);
        System.out.println("---------------------------------------------------------");
        JSONObject jsonObject = new JSONObject(userInfoBytoke);

        System.out.println("---------------------------------------------------------");
        System.out.println(jsonObject);
        JSONObject datas = jsonObject.getJSONObject("datas");

        System.out.println("---------------------------------------------------------");
        System.out.println(datas);

    }

    public static String getUserInfoByToke(String toke) {

        HttpURLConnection mHttpURLConnection = null;
        BufferedReader read = null;
        try {

            mHttpURLConnection = (HttpURLConnection) new URL(USER_INFO_URL).openConnection();
            //设置请求参数
            mHttpURLConnection.setRequestMethod(GET);
            //设置连接超时时间s  30s
            mHttpURLConnection.setConnectTimeout(CONNECT_TIME_OUT);
            //设置读取超时时间  120s
            mHttpURLConnection.setReadTimeout(READ_TIME_OUT);
            //添加请求头
            mHttpURLConnection.setRequestProperty("Authorization", toke);
            mHttpURLConnection.connect();
            int responseCode = mHttpURLConnection.getResponseCode();
            if (responseCode != 200) {
                return null;
            }
            //获取服务器返回的输入流
            InputStream inputStream = mHttpURLConnection.getInputStream();
            //读取输入流s
            read = new BufferedReader(new InputStreamReader(inputStream, CHARSET));
            StringBuilder respose = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                respose.append(line);
            }
            return respose.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (mHttpURLConnection != null) {
                //请求结束后关闭HTTP链接
                mHttpURLConnection.disconnect();
            }
        }
        return null;

    }
}
