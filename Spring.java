//Student.java 
 
package com.pu; 
 
public class Student { 
private String name;   
   
public String getName() {   
    return name;   
}   
   
public void setName(String name) {   
    this.name = name;   
}   
   
public void displayInfo(){   
    System.out.println("Hello: "+name);   
}   
} 
 ********************************************************
applicationContext.xml 

<?xml version="1.0" encoding="UTF-8"?>   
<beans   
    xmlns="http://www.springframework.org/schema/beans"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
    xmlns:p="http://www.springframework.org/schema/p"   
    xsi:schemaLocation="http://www.springframework.org/schema/beans   
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">   
   
<bean id="studentbean" class="com.pu.Student">   
<property name="name" value="God Bless You"></property>   
</bean>   
   
</beans>   
 
 
 ********************************************************
Test.java 
package com.pu; 
 
import org.springframework.beans.factory.BeanFactory;   
import org.springframework.beans.factory.xml.XmlBeanFactory;   
import org.springframework.core.io.ClassPathResource;   
import org.springframework.core.io.Resource;   
 
public class Test { 
 
public static void main(String[] args) { 
// TODO Auto-generated method stub 
Resource resource=new ClassPathResource("applicationContext.xml");   
    BeanFactory factory=new XmlBeanFactory(resource);   
       
    Student student=(Student)factory.getBean("studentbean");   
    student.displayInfo(); 
} 
 
} 
 
