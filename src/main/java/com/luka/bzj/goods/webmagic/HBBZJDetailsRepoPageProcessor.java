package com.luka.bzj.goods.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class HBBZJDetailsRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");


    @Override
    public void process(Page page) {
        String title = page.getHtml().xpath("//h2[@id='span_big_title']/text()").toString();
        System.out.println(title);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new HBBZJDetailsRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.bzjw.com/supply/SupplyDetail_19171_40253.cfml")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
