package com.linzi.boot;

import com.alibaba.druid.FastsqlException;
import com.linzi.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot301DemoWithInitializrApplication {

    public static void main(String[] args) {
        // SpringApplication.run(Boot301DemoWithInitializrApplication.class, args);

        // 1.查看容器中所有的组件。
//        for (String name : SpringApplication.run(Boot301DemoWithInitializrApplication.class, args)
//                .getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

        // 2.查看容器中特定类型的組件是否存在。
        String[] forType = SpringApplication.run(Boot301DemoWithInitializrApplication.class, args)
                .getBeanNamesForType(FastsqlException.class);

        for (String type : forType) {
            System.out.println(type);
        }
    }

}
