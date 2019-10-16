## 第一章：三层架构和MVC

### 1. 三层架构 

1. 咱们开发服务器端程序，一般都基于两种形式，一种C/S架构程序，一种B/S架构程序 
2. 使用Java语言基本上都是开发B/S架构的程序，B/S架构又分成了三层架构 
3. 三层架构
     1. 表现层：WEB层，用来和客户端进行数据交互的。表现层一般会采用MVC的设计模型 
     2. 业务层：处理公司具体的业务逻辑的 
     3. 持久层：用来操作数据库的 
### 2. MVC模型 

1. MVC全名是Model View Controller 模型视图控制器，每个部分各司其职。 
2. Model：数据模型，JavaBean的类，用来进行数据封装。
3. View：指JSP、HTML用来展示数据给用户
4. Controller：用来接收用户的请求，整个流程的控制器。用来进行数据校验等。 

##  第二章：SpringMVC的入门案例 

### 1. SpringMVC概述

1. 是一种基于Java实现的MVC设计模型的请求驱动类型的轻量级WEB框架。
2. Spring MVC属于SpringFrameWork的后续产品，已经融合在Spring Web Flow里面。Spring 框架提供 了构建 Web 应用程序的全功能 MVC 模块。
3. 使用 Spring 可插入的 MVC 架构，从而在使用Spring进行WEB开发时，可以选择使用Spring的 SpringMVC框架或集成其他MVC开发框架，如Struts1(现在一般不用)，Struts2等。
SpringMVC在三层架构中的位置：表现层框架 

### 2. 入门程序

1. 导入依赖

   ```xml
   <!-- 版本锁定 -->
   <properties>
   	<spring.version>5.0.2.RELEASE</spring.version>
   </properties>
   <dependencies>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>${spring.version}</version>
       </dependency>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-web</artifactId>
           <version>${spring.version}</version>
       </dependency>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-webmvc</artifactId>
           <version>${spring.version}</version>
       </dependency>
       <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>servlet-api</artifactId>
           <version>2.5</version>
           <scope>provided</scope>
       </dependency>
       <dependency>
           <groupId>javax.servlet.jsp</groupId>
           <artifactId>jsp-api</artifactId>
           <version>2.0</version>
           <scope>provided</scope>
       </dependency>
   </dependencies>
   ```

2.  配置核心的控制器（配置DispatcherServlet） 

   - 在`web.xml`配置文件中	控制器`DispatcherServlet `

     ```xml
     <!DOCTYPE web-app PUBLIC
      "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
      "http://java.sun.com/dtd/web-app_2_3.dtd" >
     
     <web-app>
       <display-name>Archetype Created Web Application</display-name>
       <!--配置核心控制器-->
       <servlet>
         <servlet-name>dispatcherServlet</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <!--配置载入配置文件-->
         <init-param>
           <param-name>contextConfigLocation</param-name>
           <param-value>classpath:springmvc.xml</param-value>
         </init-param>
         <!--配置启动时初始化-->
         <load-on-startup>1</load-on-startup>
       </servlet>
       <!--配置核心控制器映射-->
       <servlet-mapping>
         <servlet-name>dispatcherServlet</servlet-name>
         <url-pattern>/</url-pattern>
       </servlet-mapping>
     </web-app>
     ```

   - 编写`springmvc.xml`配置文件

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:context="http://www.springframework.org/schema/context"
            xmlns:mvc="http://www.springframework.org/schema/mvc"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd
            http://www.springframework.org/schema/mvc
            http://www.springframework.org/schema/mvc/spring-mvc.xsd">
         <!--包扫描-->
         <context:component-scan base-package="com.ajacker"/>
         <!--视图解析器-->
         <bean id="resolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
             <property name="prefix" value="/WEB-INF/pages/"/>
             <property name="suffix" value=".jsp"/>
         </bean>
         <!--mvc注解支持-->
         <mvc:annotation-driven/>
     </beans>
     ```

   - 编写控制器类

     ```java
     /**
      * @author ajacker
      * @date 2019/10/16 11:54
      */
     @Controller
     public class HelloController {
         @RequestMapping("/hello")
         public String sayHello(){
             System.out.println("hello springmvc!");
             return "success";
         }
     }
     ```

   - 编写页面

     `index.jsp`

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>Title</title>
     </head>
     <body>
         <h3>入门程序</h3>
         <a href="/hello">入门程序</a>
     </body>
     </html>
     ```

     `WEB-INF/pages/sucess.jsp`

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>入门成功</title>
     </head>
     <body>
         <h3>成功！</h3>
     </body>
     </html>
     ```

### 3. 入门案例的执行流程分析

1. 启动Tomcat服务器时,由于配置了`<load-on-startup>`标签,所以首先创建`DispatcherServlet`对象并加载`springmvc.xml`配置文件

2. 由于`springmvc.xml`中开启了注解扫描,`HelloController`对象被创建并加入Spring容器中
3. 浏览器请求`index.jsp`,请求会先到达`DispatcherServlet`核心控制器,根据配置`@RequestMapping`注解找到具体要执行的方法`sayHello()`
4. 执行方法`sayHello()`,得到返回值
5. 视图解析器解析返回值,查找到对应的JSP文件`success.jsp`
6. Tomcat服务器渲染页面,做出响应 ![在这里插入图片描述](SpringMVC笔记.assets/20190708192440136.jpg) 

