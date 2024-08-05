package org.springframework.boot.exam2.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class ConfigMap {

    @Value("${appConfig.default-page-size}")

    public static int pageSize;
    @Value("${appConfig.default-page-number}")
    public  static int pageNumber;
}
