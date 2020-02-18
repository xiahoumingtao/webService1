package cn.xiahou.task;

import cn.xiahou.entity.JdItem;
import cn.xiahou.service.JdItemService;
import cn.xiahou.util.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 定时抓取数据类
 */
@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private JdItemService jdItemService;
    //解析Json工具类
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //间隔多长时间执行，单位ms
    @Scheduled(fixedDelay = 100*1000)   //执行时间100s一次
    public void scheduleCrawlerTask() throws JsonProcessingException {
        long starttime = System.currentTimeMillis();
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA" +
                "&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=shou&s=54&click=0&page=";

        //对投影仪的搜索结果便利
        for (int i = 1; i < 10; i=i+2) {
            String html = httpUtils.doGetHtmml(url + i);
            this.parseJditem(html);
        }
        long finishtime = System.currentTimeMillis();
        System.out.println("手机数据抓取完成，总共耗时"+(finishtime-starttime)/1000+"s");
    }

    /**
     * 解析请求返回的html
     * 解析京东手机数据
     * @param html
     */
    private void parseJditem(String html) throws JsonProcessingException {
        Document document = Jsoup.parse(html);
        //获取商品SPU及SKU
        Elements Eles = document.select("div.J_goodsList >ul >li");
        for (Element ele : Eles) {
            //获取spu
            long spu = Long.parseLong(ele.attr("data-spu"));
            //获取sku
            Elements skuEles = ele.select("li#ps-item");
            for (Element skuEle : skuEles) {
                long sku = Long.parseLong(skuEle.attr("data-sku"));
                //根据sku检查该商品是否为新增或更新
                JdItem item = new JdItem();
                item.setSku(sku);
                List<JdItem> jdItems = jdItemService.find(item);
                if(jdItems.size() > 0 ){
                    //更新
                    continue;
                }else {
                    //新增
                    item.setSpu(spu);

                    String url = "https://item.jd.com/"+sku+".html";
                    item.setUrl(url);

                    String picAttr = "https:"+skuEle.attr("data-lazy-img");
                    picAttr = picAttr.replace("/n9/","/n1/");
                    String picName = this.httpUtils.doGetImgs(picAttr);
                    item.setPic(picName);

                    String priceJson = this.httpUtils.doGetHtmml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                    Double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
                    item.setPrice(price);

                    String detail = this.httpUtils.doGetHtmml(item.getUrl());
                    String title = Jsoup.parse(detail).select("div.sku-name").text();
                    item.setTitle(title);

                    item.setCreatetime(new Date());
                    item.setUpdatetime(item.getCreatetime());

                    //报错商品数据
                    this.jdItemService.save(item);
                }
            }



        }
        

    }
}
