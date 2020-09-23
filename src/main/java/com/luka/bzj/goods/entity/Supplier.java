package com.luka.bzj.goods.entity;

import com.luka.bzj.goods.entitypros.GoodsModelPepeline;
import lombok.Data;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * 供应商
 */
@Data
@HelpUrl("http://www.bzjw.com/supply/11/16/98/page-\\d*")
@TargetUrl("http://www.bzjw.com/supply/SupplyDetail_\\d*_\\d*.cfml")
public class Supplier {

    private Integer id;
    @ExtractBy("//span[@id='span_ShowPara']/table/tbody/tr[1]/td[1]/text()")
    private String brandName;
    @ExtractBy("//div[@class='company_da']/div/h4/a/span/text()")
    private String name;
    @ExtractBy("//span[@id='span_info']/text()")
    private String details;
    @ExtractBy("//ul[@class='txt']/li[3]/text()")
    private String phone;
    @ExtractBy("//div[@class='txt1']/p/em/text()")
    private String model;
    @ExtractBy("//span[@id='span_area3']/text()")
    private String location;

    @ExtractBy("//ul[@class='txt']/li[1]/text()")
    private String contactName;
    @ExtractBy("//ul[@class='txt']/li[2]/text()")
    private String contactTel;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36")
                , new ConsolePageModelPipeline(), Supplier.class)
                .addUrl("http://www.bzjw.com/supply/11/16/98/page-1").thread(5).run();
    }
}
