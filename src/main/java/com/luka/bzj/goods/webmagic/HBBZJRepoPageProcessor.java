package com.luka.bzj.goods.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

public class HBBZJRepoPageProcessor implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
      /*  page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.getHtml().xpath("//div[@id='readme']/tidyText()")*/
        //System.out.println(page.getHtml());
        System.out.println(page.getHtml().links().regex("http://www.bzjw.com/supply/SupplyDetail_\\d*_\\d*.cfml").all());


        // 部分三：从页面发现后续的url地址来抓取     http://www.bzjw.com/supply/SupplyDetail_19171_40253.cfml
        //page.addTargetRequests().all());


    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {
        Spider.create(new HBBZJRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.bzjw.com/supply/11/16/98/page-1")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
