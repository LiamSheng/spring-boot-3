package com.linzi.boot.config;

import com.alibaba.druid.FastsqlException;
import com.linzi.boot.bean.Cat;
import com.linzi.boot.bean.Dog;
import com.linzi.boot.bean.Person;
import com.linzi.boot.bean.Pig;
import org.apache.catalina.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableConfigurationProperties(Pig.class)
public class AppConfig {
    //@ConfigurationProperties(prefix = "pig") // 仍然可以和配置文件绑定
    //@Bean
    public Pig pig() {
        return new Pig();
    }

    // 如果 pom 文件中导入了 FastsqlException 这个类，给容器中放一个 Cat 组件，名 cat01。
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01() {
        return new Cat();
    }

    // 如果 pom 文件中没有导入 FastsqlException 这个类，给容器中放一个 Dog 组件，名dog01。
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01() {
        return new Dog();
    }

    // 如果系统中有 dog01 这个组件，就给容器中放一个 User 组件，名 zhangsan，否则，就放一个 User，名叫 lisi。
    @ConditionalOnBean(value = Dog.class, name = "dog01")
    @Bean
    public Person zhangsan() {
        return new Person();
    }

    @ConditionalOnMissingBean(value = Dog.class, name = "dog01")
    @Bean
    public Person lisi() {
        return new Person();
    }

}
