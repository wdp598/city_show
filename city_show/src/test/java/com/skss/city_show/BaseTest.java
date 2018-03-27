package com.skss.city_show;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WEIDP
 * 整合spring和junit,使junit启动时加载SpringIOC容器
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//该注解是告诉spring,junit使用的类
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})//该注解是用来告诉junit，spring的配置文件的位置
public class BaseTest {

}
