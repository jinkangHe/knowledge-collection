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
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/8 16:12
 */

public class CommentRunnable implements Runnable {

    public CommentRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建 HttpPost 请求
        HttpPost httpPost = new HttpPost("http://www.josetan.cn/wp-comments-post.php");
        String author = UUID.randomUUID().toString();
        for (int i = 0; i < 3000; i++) {
            author += UUID.randomUUID().toString();
        }

        NameValuePair pair = new BasicNameValuePair("comment", "comment-" + author);
        NameValuePair pair2 = new BasicNameValuePair("author", author);
        NameValuePair pair3 = new BasicNameValuePair("email", "josetan@163.com");
        NameValuePair pair4 = new BasicNameValuePair("submit", "发表评论");
        NameValuePair pair5 = new BasicNameValuePair("comment_post_ID", "94");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(pair);
        params.add(pair2);
        params.add(pair3);
        params.add(pair4);
        params.add(pair5);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        // 设置长连接
        httpPost.setHeader("Connection", "keep-alive");
        // 设置代理（模拟浏览器版本）
        httpPost.setHeader("User-Agent", "PostmanRuntime/7.26.8");
        // 设置 Cookie
        httpPost.setHeader("Cookie", "wordpress_test_cookie=WP+Cookie+check;wordpress_logged_in_e18a16c44104305230e5970ca0d6112b=loop|1646898039|L9zq9Z7D7VLAFb1i1IeIEOKKvwnTIbRjJCSZtV9iWfX|300a2c7c00e56e03cdf20851a5f86f6992b6dac0de72b8ffe1ce6d358826b859; wfwaf-authcookie-d864acbc9bd844d40bbeaf953b7b81b8=4|subscriber|read|8da56a1935c80d342ab55195e2e8cc83d86e01a0084876e4e87a31fbb9d863e0; wp-settings-time-4=1646725628; wp-settings-4=default_password_nag=hide");

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
            //System.out.println(EntityUtils.toString(httpEntity));
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
