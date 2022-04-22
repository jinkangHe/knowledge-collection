package com.knowledge.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/8 16:32
 */

public class LoveRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public LoveRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpPost 请求
        HttpPost httpPost = new HttpPost("http://www.josetan.cn/wp-admin/admin-ajax.php");
        NameValuePair pair = new BasicNameValuePair("action", "love" );
        NameValuePair pair2 = new BasicNameValuePair("um_id", "94");
        NameValuePair pair3 = new BasicNameValuePair("um_action", "love");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(pair);
        params.add(pair2);
        params.add(pair3);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        // 设置长连接
        httpPost.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpPost.setHeader("User-Agent", "PostmanRuntime/7.26.8");
        // 设置 Cookie
        httpPost.setHeader("Cookie", "love_92=92; love_94=94; wordpress_test_cookie=WP+Cookie+check; wordpress_logged_in_e18a16c44104305230e5970ca0d6112b=jesotan|1646888146|88XOUKwFzHVbQNbRt78D4R0Is5s1MaT5VU9GLe72JHQ|94d5838ee0f000a61d7a7a33152867fc7b4ba3075de4689eddaa67b931b149de; wfwaf-authcookie-d864acbc9bd844d40bbeaf953b7b81b8=2|subscriber|read|4c2d630d08b0ff6980c4aeede883eed2f63166142f71b2d90ee43456a8e66a59; wp-settings-2=mfold=o; wp-settings-time-2=1646715402");

        httpPost.setHeader("Accept-Encoding", "*/*");
        httpPost.setHeader("Accept", "gzip, deflate, br");

        CloseableHttpResponse httpResponse = null;
        try {
            // 设置 HttpPost 参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpResponse = httpClient.execute(httpPost);
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            HttpEntity httpEntity = httpResponse.getEntity();
            // 输出请求结果
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 无论如何必须关闭连接
        finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
