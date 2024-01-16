package com.linzi.boot;

import com.alibaba.druid.FastsqlException;
import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//主程序：com.linzi.boot
//@SpringBootApplication(scanBasePackages = "com.linzi")
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.linzi")
@SpringBootApplication //这是一个SpringBoot应用
public class MainApplication {

    public static void main(String[] args) {
//         SpringApplication.run(MainApplication.class, args);
//
        // 1.查看容器中所有的组件。
//        for (String name : SpringApplication.run(MainApplication.class, args)
//                .getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

        // 2.查看容器中特定类型的組件是否存在。
        String[] forType = SpringApplication.run(MainApplication.class, args)
                .getBeanNamesForType(FastsqlException.class);

        for (String type : forType) {
            System.out.println(type);
        }
    }

}
