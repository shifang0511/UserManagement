# UserManage

一个基于Spring Boot的用户管理系统，提供用户的增删改查、分页查询、登录认证等功能。

## 项目结构

```
.gitattributes
.gitignore
.idea/
.mvn/
.vscode/
HELP.md
mvnw
mvnw.cmd
pom.xml
src/
    main/
    test/
target/
```

## 主要功能

- 用户管理：用户的增删改查
- 分页查询：支持分页获取用户列表
- 登录认证：基于JWT的登录认证
- 全局异常处理：统一的异常处理机制
- 文件上传：支持上传文件到阿里云OSS

## 依赖

- Spring Boot
- MyBatis
- MySQL
- JWT
- PageHelper
- 阿里云OSS SDK

## 快速开始

### 环境要求

- JDK 17
- Maven 3.9.9
- MySQL

### 配置数据库

在 `src/main/resources/application.properties`文件中配置数据库连接信息：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 运行项目

1. 克隆项目到本地：

```sh
git clone https://github.com/yourusername/UserManage.git
```

2. 进入项目目录：

```sh
cd UserManage
```

3. 使用Maven构建项目：

```sh
./mvnw clean install
```

4. 运行项目：

```sh
./mvnw spring-boot:run
```

项目启动后，可以通过访问

http://localhost:8080

来使用用户管理系统。

### API接口

#### 用户管理

- 获取用户列表（分页）：
  - URL: `/user`
  - Method: `GET`
  - 参数:

page

（页码）,

pageSize

（每页数量）

- 获取用户详情：
  - URL: `/user/{id}`
  - Method: `GET`
  - 参数:

id

（用户ID）

- 添加用户：
  - URL: `/user`
  - Method: `POST`
  - 参数:

User

对象

- 更新用户：
  - URL: `/user`
  - Method: `PUT`
  - 参数:

User

对象

- 删除用户：
  - URL: `/user/{id}`
  - Method:

DELETE

- 参数:

id

（用户ID）

#### 登录认证

- 登录：
  - URL: `/login`
  - Method: `POST`
  - 参数:

User

对象（包含用户名和密码）

### 项目结构说明

controller

：控制器层，处理HTTP请求
------------------------

service

：服务层，包含业务逻辑
----------------------

mapper

：数据访问层，使用MyBatis进行数据库操作
---------------------------------------

pojo

：实体类
--------

util

：工具类
--------

resources

：资源文件目录，包含配置文件

### 贡献

欢迎提交Pull Request或Issue来贡献代码和反馈问题。

### 许可证

该项目使用Apache 2.0许可证，详情请参见LICENSE。

---

如有任何问题，请联系项目维护者。
