package com.ssh.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class QueryStringUtil {

	/**
	 *	将链接参数按字母顺序进行升序排序
	 * @param queryMap
	 * @return key1=value1&key2=value2....
	 */
    public static String createQueryString(Map<String, String> queryMap) {
        if (queryMap == null) {
            return null;
        }

        if (queryMap.size() == 0) {
            return "";
        }

        try {
            StringBuilder sb = new StringBuilder();
            //将key值和value值，按升序组装key1=value1&key2=value2....
            //这里的Map直接按顺序取值，是因为传过来的是TreeMap
            for (Map.Entry<String, String> entry : queryMap.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                String key = entry.getKey().trim();
                //QueryString中的value值需要utf-8编码
                String value = URLEncoder.encode(entry.getValue().trim(), "utf-8");
                sb.append(String.format("%s=%s&", key, value));
            }
            return sb.substring(0, sb.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    /**
     * 	获取最终进行Http通信的字符串
     * @param queryMap
     * @param time
     * @param salt
     * @return 最终进行Http通信的字符串
     */
    public static String createHashedQueryString(Map<String, String> queryMap, long time, String salt) {
    	//将Map转换成TreeMap，按顺序取值，是升序。
        Map<String, String> map = new TreeMap<String, String>(queryMap);
        //第一步 获得升序排序后的qs
        String qs = QueryStringUtil.createQueryString(map);
        if (qs == null) {
            return null;
        }

        String hash;
        String htqs;
        if (!qs.equals("")) {
        	//第二步 附加time值和salt值
            //第三步 对字符串取md5值 得到hash
            hash = Hashlib.md5(String.format("%s&time=%d&salt=%s", qs, time, salt));
            //将hash放到最后，得到最终进行Http通信的字符串为htqs
            htqs = String.format("%s&time=%d&hash=%s", qs, time, hash);
        } else {
            hash = Hashlib.md5(String.format("time=%d&salt=%s", time, salt));
            htqs = String.format("time=%d&hash=%s", time, hash);
        }
        return htqs;
    }
}