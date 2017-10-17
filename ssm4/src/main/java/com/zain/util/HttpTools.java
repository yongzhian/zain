package com.zain.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class HttpTools {

    private static final int CONN_TIMEOUT = 5 * 1000; // 连接超时时间：5秒
    private static final int CONN_READ_TIMEOUT = 20 * 1000; // 读取超时时间：20秒
    private static final String CHARSET = "UTF-8";

    private static final Logger logger = Logger.getLogger(HttpTools.class);

    /**
     * 功能说明：向给定的 URL POST 二进制数据。 data:username=kevin&password=12345
     *
     * @param toUrl
     * @param data
     * @return 服务器响应信息
     */
    public static String postDataByJdk(String toUrl, String data) {

        StringBuilder sysTip = new StringBuilder("向给定的 URL POST 二进制数据失败。原因：");

        if (StringUtils.isBlank(toUrl)) {
            sysTip.append("参数 toUrl 为空。");
            logger.error(sysTip);
            throw new IllegalArgumentException(sysTip.toString());
        }

        if (StringUtils.isBlank(data)) {
            sysTip.append("参数 data 为空。");
            logger.error(sysTip);
            throw new IllegalArgumentException(sysTip.toString());
        }

        byte[] arrData = data.getBytes();

        URL url;
        String response = "";
        try {
            url = new URL(toUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST"); // 设置请求方式
            conn.setConnectTimeout(CONN_TIMEOUT);
            conn.setReadTimeout(CONN_READ_TIMEOUT);

            conn.setDoOutput(true); // 使用 HttpURLConnection 输出
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(arrData.length));
            conn.setRequestProperty("Cache-Control", "no-cache");

            OutputStream outStream = conn.getOutputStream();
            outStream.write(arrData);
            outStream.flush();
            outStream.close();

            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader((InputStream) conn.getInputStream(), CHARSET));
                response = in.readLine();
                in.close();
            }
            conn.disconnect();// 断开连接

            logger.info("response: " + response);
        } catch (IOException e) {
            logger.error(e);
        }

        return response;
    }

    /**
     * 功能说明 ：基于apache的httpclient进行post 请求
     * author	Zain 2016年7月7日  上午9:04:34
     *
     * @param url
     * @param formParams
     * @return
     */
    public static String postForm(String url, List<NameValuePair> formParams) {
        Map<String, Object> plusInfo = null;
        if (url.indexOf("api.zhumu.me") != -1) {//根据URL确定是zhumu服务
            plusInfo = new HashMap<>();
            plusInfo.put("3part_name", "ZHUMU");
            plusInfo.put("level", "H");
        }
        return postForm(url, formParams, plusInfo);
    }

    /**
     * 功能说明 ：基于apache的httpclient进行post 请求
     * 若plusInfo为空则不发jms
     * plusInfo中记录此次请求的额外参数，如请求的三方名称3part_name、phone_no、robot_sn level
     * plusInfo可加occur_time 建议date类型
     * author	Zain 2016年7月7日  上午9:04:34
     *
     * @param url
     * @param formParams plusInfo
     * @return
     */
    public static String postForm(String url, List<NameValuePair> formParams, Map<String, Object> plusInfo) {
        if (StringUtils.isBlank(url) || null == formParams) {
            logger.info("请求参数为空，url：" + url + "   formParams:" + formParams);
            return null;
        }
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;
        CloseableHttpResponse response = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, CHARSET);
            httpPost.setEntity(uefEntity);
            response = httpclient.execute(httpPost);
            if (null == response || response.getStatusLine().getStatusCode() != 200) {
                logger.error("请求失败，url：" + url + "  formParams:" + "  response:" + response);
                return null;
            }
            HttpEntity entity = response.getEntity();
            logger.debug("http post result:" + entity);
            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("编码不支持，url：" + url + "    formParams:" + formParams, e);
        } catch (ClientProtocolException e) {
            logger.error("请求协议异常，url：" + url + "   formParams:" + formParams, e);
        } catch (IOException e) {
            logger.error("IO异常，url：" + url + "  formParams:" + formParams, e);
            if (null != plusInfo) {
                plusInfo.put("occur_time", new Date());
            }
        } finally {
            close(httpclient);
            close(response);
        }
        return null;

    }

    /**
     * 功能说明 ：基于apache的httpclient进行post 请求
     * author	Zain 2016年10月14日16:00:22
     *
     * @param url
     * @param params
     * @param reqDataType
     * @return
     */
    public static String postByHttpclient(String url, Map<String, String> params, ReqDataType reqDataType, String authorization) {
        if (StringUtils.isBlank(url) || null == params) {
            logger.info("请求参数为空，url：" + url + "    params:" + params);
            return null;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity;
        if (StringUtils.isNotBlank(authorization)) {
            httpPost.setHeader("Authorization", "Basic " + StringTools.byte2BASE64(authorization.getBytes()));
        }
        switch (reqDataType) {
            case FORM:
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
                Set<String> keys = params.keySet();
                List<NameValuePair> list = new ArrayList<>();
                for (String key : keys) {
                    list.add(new BasicNameValuePair(key, params.get(key)));
                }
                try {
                    entity = new UrlEncodedFormEntity(list, CHARSET);
                } catch (UnsupportedEncodingException e) {
                    logger.error("编码不支持，url：" + url + " params:" + params, e);
                    return null;
                } finally {
                    close(httpclient);
                }
                break;
            case JSON:
                String str = JsonSerializeUtils.serialize(params);
                entity = new StringEntity(str, "utf-8");
                entity.setContentEncoding(CHARSET);
                entity.setContentType("application/json");
                break;
            default:
                logger.error("未知请求类型，无法进行post请求，reqDataType：" + reqDataType);
                close(httpclient);
                return null;
        }

        if (null == httpclient) {
            return null;
        }

        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(entity);
            response = httpclient.execute(httpPost);
            int xx = response.getStatusLine().getStatusCode();
            if (response.getStatusLine().getStatusCode() != 200) {
                logger.error("请求失败，url：" + url + " params:" + "  response:" + response);
                return null;
            }
            HttpEntity respEntity = response.getEntity();
            logger.debug("http post result:" + entity);
            if (respEntity != null) {
                return EntityUtils.toString(respEntity, CHARSET);
            }
        } catch (ClientProtocolException e) {
            logger.error("请求协议异常，url：" + url + "  params:" + params, e);
        } catch (IOException e) {
            logger.error("IO异常，url：" + url + "  params:" + params, e);
        } finally {
            close(httpclient);
            close(response);
        }
        return null;
    }

    /**
     * 功能说明:发送get请求
     *
     * @param url
     * @return
     */
    public static String getData(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient hc = HttpClients.createDefault();
        CloseableHttpResponse hr = null;
        try {
            Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(6000); // 连接超时时间
            builder.setSocketTimeout(4000); // 获取数据超时时间，设置时间内未返回数据，直接放弃本次请求

            RequestConfig requestConfig = builder.build();
            httpGet.setConfig(requestConfig);

            hr = hc.execute(httpGet);
            if (hr.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(hr.getEntity(), CHARSET);
            } else {
                logger.error("请求失败，地址错误或已经失效.url: " + url);
                return null;
            }
        } catch (IOException e) {
            logger.error("IO请求异常: " + url, e);
        } catch (Exception e) {
            logger.error("系统异常: " + url, e);
        } finally {
            close(hc);
            close(hr);
        }

        return url;
    }

    private static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                logger.error("closeable关闭，IO异常，closeable：" + closeable, e);
            }
        }
    }

    public enum ReqDataType {
        FORM, //application/x-www-form-urlencoded
        JSON //application/json
    }

    /**
     * .getEncryptName().add("a");即可对输出中a的值进行加密
     * Created by Zain 2016/11/9 .
     */
    public static class BasicNameEncryptValuePair extends BasicNameValuePair { //可加密值

        private boolean encrypt = false;

        /**
         * Default Constructor taking a name and a value. The value may be null.
         *
         * @param name  The name.
         * @param value The value.
         */
        public BasicNameEncryptValuePair(String name, String value) {
            super(name, value);
        }

        public BasicNameEncryptValuePair(String name, String value, boolean encrypt) {
            this(name, value);
            this.encrypt = encrypt;
        }

        @Override
        public String toString() {
            if (this.getValue() == null) {
                return getName();
            }
            final StringBuilder buffer = new StringBuilder();
            buffer.append(this.getName());
            buffer.append("=");
            if (encrypt) {
                buffer.append("******");
            } else {
                buffer.append(this.getValue());
            }
            return buffer.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            if (!super.equals(o)) {
                return false;
            }

            BasicNameEncryptValuePair that = (BasicNameEncryptValuePair) o;
            return encrypt == that.encrypt;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (encrypt ? 1 : 0);
            return result;
        }
    }


}
