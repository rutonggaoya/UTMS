# UTMS 大学毕业设计管理系统
> 《企业级软件应用课程设计》课程成果 

## 主要功能
1. 毕业设计选题（教师发布、管理员审核、学生教师双向选择） 
2. 毕业设计相关文档管理（上传、下载、评价） 
3. 毕业设计论文的查重、打分
4. 毕业设计有关公告的发布、浏览

## 运行
- Chrome/Safari/Firefox浏览器
- demo: http://utms.wj-ecust.xyz:8080/
	- 学生账号：110161870  密码：1870@a
	- 教师账号：510100003  密码：0003@a
	- 管理员账号： 002  密码：001

## 开发工具
- IntelliJ IDEA
- Maven
- Navicat for MySQL
- Sublime Text

## 开发环境
- Java 1.8
- Spring Boot 2.1.5
- Thymeleaf 
- MyBatis 2.0.1
- MySQL 5.6
- Druid 1.1.17
- Bootstrap 3.3.7
- Bootstrap-table
- jQuery 2.1.1

## 编译运行
- Maven安装依赖并打包
- `nohup java -jar utms-0.0.1-SNAPSHOT.jar --file.upload-folder=/root/utms/static/`
