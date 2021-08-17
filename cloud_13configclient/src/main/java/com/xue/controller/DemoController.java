package com.xue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //在不重启微服务的情况下，当前scope域中信息刷新为最新的配置信息 需要所有的controller层加
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    /**
     * 自定义属性 注入 "${name}"
     */
    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String demo() {
        log.info("demo ok!现在服务环境是：" + name);
        return "demo ok!现在服务环境是：  " + name;
    }

    /**
     * 获取远端配置信息后在处理
     * A component required a bean named 'configServerRetryInterceptor' that could not be found.
     * Consider defining a bean named 'configServerRetryInterceptor' in your configuration.
     */
}
