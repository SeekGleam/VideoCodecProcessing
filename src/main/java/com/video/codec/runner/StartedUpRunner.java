package com.video.codec.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

import static com.video.codec.constant.CommonConstant.SWAGGER_SUFFIX;


/**
 * @author geekerstar
 * @date 2020/7/7 11:43
 * @description
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class StartedUpRunner implements ApplicationRunner {

    @Value("${server.port:8080}")
    private String port;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("++++++++++++++++++++++++++++++++++++++++++++");
        InetAddress address = InetAddress.getLocalHost();
        String url = String.format("http://%s:%s%s", address.getHostAddress(), port, SWAGGER_SUFFIX);
        log.info("【视频编解码程序】启动成功!");
        log.info("【Swagger】{}", url);
        log.info("++++++++++++++++++++++++++++++++++++++++++++");
    }

}
