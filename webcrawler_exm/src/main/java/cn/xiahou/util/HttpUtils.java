package cn.xiahou.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Component
public class HttpUtils {

    private PoolingHttpClientConnectionManager cm;

    private CloseableHttpResponse response = null;

    public HttpUtils() {
        //连接池管理
        this.cm = new PoolingHttpClientConnectionManager();
        //设置连接池参数
        this.cm.setMaxTotal(100);//最大连接数
        this.cm.setDefaultMaxPerRoute(10);//单个主机最大连接数
    }

    /**
     * 向指定的url中发送请求
     * 并获取返回html的内容
     * @param url
     * @return
     */
    public String doGetHtmml(String url) {
        //打开窗口，创建httpclient
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(this.cm);
        CloseableHttpClient httpClient = httpClientBuilder.build();

        //输入地址，设置请求方式及请求参数，发出请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(this.getConfig());

        try {
            //获取返回内容
            response = httpClient.execute(httpGet);

            //解析返回内容并存储
            if(response.getStatusLine().getStatusCode() == 200){
                //判度响应内容是否不为空
                if(response.getEntity() != null){
                    String context = EntityUtils.toString(response.getEntity(), "utf-8");
                    return context;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  "";
    }

    /**
     * 设置请求参数
     * @return
     */
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)//创建连接最长时间
                .setConnectionRequestTimeout(500)//获取连接最长时间
                .setSocketTimeout(1000).build();//数据传输最长时间
        return  config;
    }

    /**
     * 向指定url中发送请求
     * 并将图片存储后返回图片名称
     * @param url
     * @return
     */
    public String doGetImgs(String url){
        //打开窗口，创建httpclient
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(this.cm);
        CloseableHttpClient httpClient = httpClientBuilder.build();

        //输入地址，设置请求方式及请求参数，发出请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(this.getConfig());

        try {
            //获取返回内容
            response = httpClient.execute(httpGet);

            //解析返回内容并存储
            if(response.getStatusLine().getStatusCode() == 200){
                //判度响应内容是否不为空
                if(response.getEntity() != null){
                    //获取图片后缀
                    String extName = url.substring(url.lastIndexOf("."));

                    //创建图片名，重命名图片s
                    String picRename = UUID.randomUUID().toString() + extName;

                    //下载图片
                    OutputStream out = new FileOutputStream(new File("E:\\ProJectLocalWorkDir\\webcrawler\\picrepo"));
                    response.getEntity().writeTo(out);

                    //返回图片名
                    return picRename;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  "";
    }

}
