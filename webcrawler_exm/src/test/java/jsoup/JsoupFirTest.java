package jsoup;

import com.sun.jndi.ldap.pool.Pool;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupFirTest {

    private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    @Test
    public void testUri() throws Exception {
        //解析URL地址
        Document document = Jsoup.parse(new URL("https://www.kenzhishi.com/"), 1000);
        String title = "";
        title = document.getElementsByTag("title").first().text();

        Elements elements1 = document.select(".mb-md-3").next();
        title =  elements1.text();

        Elements elements = document.getElementsByTag("a");


        System.out.println(title);
    }

    @Test
    public void searchJDHWPhone() throws Exception {
        //HTTPClient获取数据
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();//打开窗口，创建HttpClient对象
        HttpGet httpGet = new HttpGet("https://search.jd.com/Search?keyword=%E5%8D%8E%E4%B8%BA&enc=utf-8&wq=%E5%8D%8E%E4%B8%BA&pvid=8fe2cfc714114d5db422a8b7271a8b0e");//输入地址，指定访问方式
        CloseableHttpResponse response = client.execute(httpGet);//点击访问，并获取返回信息
        if(response.getStatusLine().getStatusCode() == 200){//访问成功


        }


        //Jsoup解析数据


    }


}
