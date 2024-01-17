package com.linzi.boot;

import com.linzi.boot.bean.Cat;
import com.linzi.boot.bean.Dog;
import com.linzi.boot.bean.Person;
import com.linzi.boot.bean.Pig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302InitializrApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302InitializrApplication.class, args);

//        for (String s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println(s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(Dog.class)) {
//            System.out.println(s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(Person.class)) {
//            System.out.println("Person:" + s);
//        }

        Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);

    }

}
