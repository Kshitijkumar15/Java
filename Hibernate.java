/App.java
	
package hibernate;

import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration; 


public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student();
        student.setRoll(1);
        student.setName("abc");
        student.setMarks(90);
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class);       
        SessionFactory sessionFactory=configuration.buildSessionFactory(); 
        Session session=sessionFactory.openSession(); 
        Transaction transaction=session.beginTransaction();  
	session.save(student);
        transaction.commit(); 
        session.close(); 
        sessionFactory.close(); 
     } 
 } 
 *****************************************************************************************
 hibernate.cfg.xml
 
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.password">740654sk</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hbm2ddl.auto">update</property>
    </session-factory>
</hibernate-configuration>
 *****************************************************************************************
 student.java
 
 package com.kshitij.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int roll;
	private String name;
	private int marks;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}
 *****************************************************************************************
 pom.xml
 
 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.kshitij</groupId>
  <artifactId>hibernate</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>hibernate</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.2.5.Final</version>
    <type>pom</type>
</dependency>
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
  </dependencies>
</project>

*****************************************************************************************
*****************************************************************************************
steps
STEP 1 :GO TO MARKET PLACE AND DOWNLOAD JBOSS
STEP 2 :CRETAE MAVEN PROJECT > SELECT INTERNAL AND TYPE QIUCK, GIVE GROUP ID AND ARTIFACT ID
STEP 3 :GOTO POM.XML ADD DEPENDECIES FROM MAVEN DEPENDECIES WEBSITE(HIBERNATE AND MYSQL DEPENDENCY)
STEP 4 : CREATE SCEMA IN MY SQL WORKBENCH
STEP 5 : CRETA A JAVA FILE(CLASS) GIVE NAME AND STUDENT.JAVA
STEP 6 :THAN APP.JAVA(IT WILL BE AUTOMATCIALLY CREATED JUST COPY PASTE ABOVE CODE)
STEP 7 :ADD PROPERTY TO HIBERNATE.CFG.XML(<property name="hbm2ddl.auto">update</property>). RIGHT CLICK ON HIBERNATE PROJECT,NEW>OTHER>SEARCH FOR HIBERNATE(GIBERNAT.CFG.XML)
DO THE SETUP BY GIVING CONNECTION NAME(jdbc:mysql://localhost:3306/(name of schema) .
