# hibernate-code-generate 生成 java 代码
# fork from https://github.com/yupengj/hibernate-reverse

## 实现技术
基于 spring-boot(2.2.0, web, thymeleaf, jdbc)  + velocity（V1.4.7）实现。构建工具 maven

## 支持数据库
mysql

## 如何配置与扩展
- 生成代码模板在 resources/codes 目录下可自行修改
- application.yml 文件中 allowSchema 属性是,允许生成代码的 schema 集合

## 使用方法-源码
1. clone 源码 `git clone https://github.com/v2future/hibernate-code-generate`
2. 使用 maven 构建
3. 修改 application.yml 文件数据库连接
4. 运行 GenerateCodeApplication 类中的 main 方法 
5. 启动成功后访问 http://localhost:8080

# 页面说明

### 左侧表单页面
![](https://github.com/yupengj/hibernate-reverse/blob/master/src/main/resources/doc/fp.png?raw=true)
- **作者** : 生成代码的人,类上的@author注解的值
- **Java 包跟路径**: 如: `package com.gantang.xxxx;`

**包名前缀和包名后缀是相对 schema 来说的, 如: java 包 'com.gantang.a.schema.b.xxx;' a 就是包名前缀, 支持多层级带"."的名称, b 就是包名后缀, 支持多层级带"."的名称**

- **Java 模块**: Java 要生成代码的模块,默认全部生成
- **表名**: 右侧选择过来的表名
- **生成路径**: 代码生成路径

### 右侧查询列表页面
![](https://github.com/yupengj/hibernate-reverse/blob/master/src/main/resources/doc/lp.png?raw=true)
- **表名**: 输入一个表名然后按回车键`Enter`进行查询

## 更新记录
- [x] 采用 spring-boot web页面配置生成代码信息
