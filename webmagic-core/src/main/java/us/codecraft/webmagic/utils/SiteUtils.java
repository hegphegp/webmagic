package us.codecraft.webmagic.utils;

import us.codecraft.webmagic.Site;

import java.util.HashSet;

public class SiteUtils {

    public static Site getSite() {
        HashSet<Integer> codeSet = new HashSet();
        codeSet.add(200);
        codeSet.add(302);
        codeSet.add(306);
        return Site.me()
                .setUserAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)")
                .setRetryTimes(3)                         // HttpClientGenerator.generateClient()方法配置了 httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(site.getRetryTimes(), true));
                .setCycleRetryTimes(3)                    // httpClient.execute出了异常，重发请求次数
                .setRetrySleepTime(500)                   // httpClient.execute出了异常，重发请求的时间间隔
                .setNotAcceptHttpCodeRetryTimes(3)      // 非接受的httpStatus的重试次数
                .setNotAcceptHttpCodeRetrySleepTime(3)  // 非接受的httpStatus的重发请求的时间间隔
                .setSleepTime(10)
                .setTimeOut(10000)
                .setAcceptStatCode(codeSet);
    }

}
