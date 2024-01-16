package com.linzi.boot.config;

import com.alibaba.druid.FastsqlException;
import com.linzi.boot.bean.Person;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Import(FastsqlException.class) // 导入第三方指定类型的组件更快速的方式，组件的名字默认是全类名:com.alibaba.druid.FastsqlException
@SpringBootConfiguration // 表明这是一个配置类，代替之前的配置文件。配置类本身也是容器中的组件。
public class AppConfig {
    @Bean("User-customizedName") // 替代以前的 Bean 标签。组件在容器中的名字默认是这个方法名。
    @Scope("prototype") // 组件默认是单实例的，使用此注解改为多实例。
    public Person person(){
        var person = new Person();
        person.setAge(18);
        person.setName("Linzi");
        return person;
    }

    @Bean // 导入第三方任意类
    public FastsqlException fastsqlException() {
        return new FastsqlException();
    }
}
