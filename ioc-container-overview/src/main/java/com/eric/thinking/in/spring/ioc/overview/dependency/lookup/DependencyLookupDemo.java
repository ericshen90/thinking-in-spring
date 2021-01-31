package com.eric.thinking.in.spring.ioc.overview.dependency.lookup;

import com.eric.thinking.in.spring.ioc.overview.annotation.Super;
import com.eric.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 *
 * @author EricShen
 * @date 2021-01-28
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 读取XML文件获取Spring应用上下文
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("/META-INF/dependency-lookup-demo-context.xml");
        // 实时获取
        lookUpInRealTime(beanFactory);
        // 懒加载
        lookUpInLazyModel(beanFactory);
        // 类型加载
        lookUpByType(beanFactory);
        // 集合类型加载
        lookUpByCollectionType(beanFactory);
        // 注解加载
        lookUpByAnnotation(beanFactory);
    }

    private static void lookUpInRealTime(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.println("get in real time ->" + user);
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("get by type ->" + user);
    }

    private static void lookUpByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("get by collection type ->" + users);
        }
    }

    private static void lookUpByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users =(Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("get by annotation ->" + users);
        }
    }

    private static void lookUpInLazyModel(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory", ObjectFactory.class);
        User user = objectFactory.getObject();
        System.out.println("get in lazy model ->" + user);
    }


}
