package us.codecraft.webmagic;
//import us.codecraft.webmagic.scheduler.RedisScheduler;

public class HtmlDownloadRecord {

    /**
     * 可以记录每次的响应内容
     * @param site
     * @param page
     */
    public void record(Site site, Page page) {
//        page.getHtml().allText()
    }

    /**
     * 记录非Site定义接受的httpCode的请求
     * @param site
     * @param page
     */
    public void notAcceptHttpCodeRecord(Site site, Page page) {
//        Jedis jedis = JedisPool.getResource();
//        String value = JSON.toJSONString(request);
//        jedis.sadd("error_"+site.getDomain(), value);
//        jedis.sadd("error_"+site.getDomain(), request.getUrl());
//        jedis.srem("set_"+site.getDomain(), request.getUrl());
    }

    /**
     * 记录非接受的httpCode重试多次还是非接受的httpCode，记录下这个请求URL和request配置信息
     * @param site
     * @param request
     */
    public void notAcceptHttpCodeUrlRecord(Site site, Request request) {
//        Jedis jedis = JedisPool.getResource();
//        String value = JSON.toJSONString(request);
//        request.getExtras().remove(Request.NOT_ACCEPT_HTTP_CODE_TRIED_TIMES);
//        jedis.sadd("error_"+site.getDomain(), value);
//        jedis.sadd("error_"+site.getDomain(), request.getUrl());
//        jedis.srem("set_"+site.getDomain(), request.getUrl());
    }

}