package cn.xiahou;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class example {

    public static void main(String[] args) {
        //打开浏览器窗口
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //输入访问地址及请求方式
        HttpGet httpGet = new HttpGet("");

        //执行访问

        //获取响应信息并解析
    }
}
