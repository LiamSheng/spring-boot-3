package com.linzi.boot.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ConfigurationProperties(prefix = "pig") // 亦可以标注在方法上，用 AppConfig 类中的自定义构造函数做验证。
public class Pig {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
