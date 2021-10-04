package us.codecraft.webmagic.utils;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.HtmlNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class XpathUtils {

    private static Logger logger = LoggerFactory.getLogger(XpathUtils.class);

    public static List<Node> childNodes(Html html, String xpath) {
        List<Element> elements = elements(html, xpath);
        List<Node> children = new ArrayList();
        if (elements!=null && elements.size()>0) {
            for (Element element:elements) {
                children.addAll(element.childNodes());
            }
        }
        info(elements, xpath);
        return children;
    }

    public static List<String> allTextList(Html html, String xpath) {
        List<Element> elements = elements(html, xpath);
        if (elements!=null && elements.size()>0) {
            return elements.stream().map(item->item.text()).collect(Collectors.toList());
        }
        info(elements, xpath);
        return new ArrayList();
    }

    public static String allText(Html html, String xpath) {
        List<Element> elements = elements(html, xpath);
        if (elements!=null && elements.size()>0) {
            StringBuffer sb = new StringBuffer();
            for (Element element:elements) {
                sb.append(element.text());
            }
            return sb.toString();
        }
        info(elements, xpath);
        return null;
    }

    public static Element firstElement(Html html, String xpath) {
        List<Element> elements = elements(html, xpath);
        if (elements!=null && elements.size()>0) {
            return elements.get(0);
        }
        info(elements, xpath);
        return null;
    }

    public static Map<String, String> firstElementAttributes(Html html, String xpath) {
        Element element = firstElement(html, xpath);
        Map<String, String> attributeMap = new HashMap();
        if (element==null || element.attributes()==null) return attributeMap;
        List<Attribute> attributes = element.attributes().asList();
        if (attributes==null) return attributeMap;
        for (Attribute attribute:attributes) {
            attributeMap.put(attribute.getKey(), attribute.getValue());
        }
        return attributeMap;
    }

    public static String firstText(Html html, String xpath) {
        List<Element> elements = elements(html, xpath);
        if (elements!=null && elements.size()>0) {
            return elements.get(0).text();
        }
        info(elements, xpath);
        return null;
    }

    public static List<Element> elements(Html html, String xpath) {
        return ((HtmlNode)html.xpath(xpath)).getElements();
    }

    public static void info(List<Element> elements, String xpath) {
        if (elements==null || elements.size()==0) {
            logger.info(xpath+" 元素为空");
        }
    }

}
