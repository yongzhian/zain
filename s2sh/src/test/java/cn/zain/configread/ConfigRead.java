package cn.zain.configread;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Controller
@Configuration
@ComponentScan("cn.zain.configread")//扫描目录
@PropertySource("classpath:test.properties")
public class ConfigRead {
    @Value("注解名字") //普通字符串
    private String name;

    @Value("#{systemProperties['os.name']}")  //操作系统属性
    private String osName;

    @Value("#{T(Math).random() * 100.0}") //表达式数值
    private double randomNumber;

    @Value("#{springService.nameInClass}")  //其他类字段
    private String antherName;

    @Value("${spring.name}") //配置文件中属性
    private String springName;

    @Value("${spring.version}") //配置文件中属性
    private double springVersion;

    @Autowired //读取配置文件
    private Environment environment;

    @Value("classpath:test.txt")  //读取文件内容
    private Resource textFile;

    @Value("http://www.baidu.com")  //读取网页内容
    private Resource testUrl;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ConfigRead{");
        sb.append("name='").append(name).append('\'');
        sb.append(", osName='").append(osName).append('\'');
        sb.append(", randomNumber=").append(randomNumber);
        sb.append(", antherName='").append(antherName).append('\'');
        sb.append(", springName='").append(springName).append('\'');
        sb.append(", springVersion=").append(springVersion);
        sb.append(", environment=").append(environment);
        sb.append(", textFile=").append(textFile);
        try {
            sb.append(", textFile content=").append(IOUtils.toString(textFile.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append(", testUrl=").append(testUrl);
        try {
            sb.append(", testUrl content=").append(IOUtils.toString(testUrl.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append('}');
        return sb.toString();
    }
}
