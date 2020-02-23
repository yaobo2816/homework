Home
=========================


![Spring Boot 2.0](https://img.shields.io/badge/Spring%20Boot-2.0-brightgreen.svg)
![JDK 1.8](https://img.shields.io/badge/JDK-1.8-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.5.0-yellowgreen.svg)


---

## 项目介绍

**项目技术**
- 开发框架:Springboot +Thymeleaf模板 
- 日志框架：logback
- Json解析框架：Jackson
- API接口调用：HttpClient
- 项目依赖包：maven

**运行项目**

- 本地运行
  ##### mvn clean package
  ##### 直接执行ThymeleafApplication Main 函数

- Docker 部署
  ##### docker build -t  backend .
  ##### docker run  -d -i  --name=backend  -p 8989:8989  backend

**项目文档**
- 项目文档目录：spring-boot-web-backend/document
