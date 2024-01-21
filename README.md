# 我们在街头


<p align=center>
   我们在街头，为所有轮滑、滑板等街头运动爱好者提供线上交流学习的平台
</p>
<p align="center">
<a target="_blank" href="https://github.com/heart14/jtmax">
    	<img src="https://img.shields.io/badge/license-MIT-blue" ></img>
		<img src="https://img.shields.io/badge/JDK-1.8+-green.svg" ></img>
        <img src="https://img.shields.io/badge/nodejs-14.x-green" ></img>
        <img src="https://img.shields.io/badge/springboot-2.2.2.RELEASE-green" ></img>
        <img src="https://img.shields.io/badge/SpringCloud-Hoxton.RELEASE-brightgreen" ></img>
        <img src="https://img.shields.io/badge/vue-2.5.17-green" ></img>
        <img src="https://img.shields.io/badge/swagger-3.0.0-brightgreen" ></img>
        <img src="https://img.shields.io/badge/mybatis--plus-3.1.2-green" ></img>
</a></p>


## 项目介绍

JTMAX是一个**基于微服务架构的前后端分离系统**。**Web** 端使用 **Vue** + **vue-admin-template模版** 。后端使用 **SpringCloud** + **SpringBoot** + **Mybatis-plus**进行开发，使用 **Jwt** + **SpringSecurity** 做登录验证和权限校验，使用 **ElasticSearch** 和 **Solr** 作为全文检索服务，使用 **Github Actions**完成博客的持续集成，使用 **ElasticStack** 收集博客日志，文件支持**上传本地**、**七牛云** 和 **Minio**.

- 大部分功能是个人开发，因能力有限，其中很多技术都是一边学习一边使用的，也是一个我用来熟悉技术的项目，所以很多地方可能考虑不周，故有能改正的地方，还请各位指出~
- 现在挺多是SSM或者SSH的系统，想用 **SpringBoot** + **SpringCloud**  + **Vue** 的微服务架构进行尝试项目的构建，里面很多功能可能只是**为了满足自己的学习需求**而引入的，大家可以**根据自己服务器配置来选择启动的服务**，因此本系统也是一个非常好的 **SpringBoot**、**SpringCloud**以及 **Vue** 技术的入门学习项目。



## 项目结构

- jtmax
- - bean ：相关Java bean
- - common ：通用公共组件
- - dao ：数据库操作层
- - dashboard-service ：管理后台服务
- - doc ：相关文档
- - pig ：pig组件
- - service ：业务逻辑层
- - site-service ：门户网站服务

## 项目特点

- 友好的代码结构及注释，便于阅读及二次开发
- 实现前后端分离，通过 **Json** 进行数据交互，前端再也不用关注后端技术
- 页面交互使用 **Vue2.x**，极大的提高了开发效率。
- 引入**Swagger** 文档支持，方便编写 **API** 接口文档。
- 引入**RabbitMQ** 消息队列，用于邮件发送、更新 **Redis** 和 **Solr**
- 引入**JustAuth** 第三方登录开源库，支持 **Gitee**、**Github** 账号登录。
- 引入**ElasticSearch** 和 **Solr** 作为全文检索服务，并支持可插拔配置
- 引入**Github Actions** 工作流，完成博客的持续集成、持续部署。
- 引入七牛云对象存储，同时支持本地文件存储
- 引入 **RBAC** 权限管理设计，灵活的权限控制，按钮级别的细粒度权限控制，满足绝大部分的权限需求
- 引入 **Zipkin** 链路追踪，聚合各业务系统调用延迟数据，可以一眼看出延迟高的服务
- 采用**自定义参数校验注解**，轻松实现后端参数校验
- 采用 **AOP** + 自定义注解 + **Redis** 实现限制IP接口访问次数
- 采用自研的评论模块，实现评论邮件通知
- 采用 **Nacos** 作为服务发现和配置中心，轻松完成项目的配置的维护
- 采用 **Sentinel** 流量控制框架，通过配置再也不怕网站被爆破
- 支持多种文本编辑器，**Markdown** 编辑器([Vditor](https://github.com/Vanessa219/vditor))和富文本编辑器([CKEditor](https://github.com/ckeditor/ckeditor4))随心切换
- 采用 **ElasticStack**【**ElasticSearch** + **Beats** + **Kibana** + **Logstash**】搭建博客日志收集


## 项目地址

目前项目托管在 **Github** 平台上

- Github地址：https://github.com/heart14/jtmax

## 技术选型

### 后端技术

|      技术      |           说明            |                             官网                             |
| :------------: | :-----------------------: | :----------------------------------------------------------: |
|   SpringBoot   |          MVC框架          | [ https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) |
|  SpringCloud   |        微服务框架         |           https://spring.io/projects/spring-cloud/           |
| SpringSecurity |      认证和授权框架       |          https://spring.io/projects/spring-security          |
|  MyBatis-Plus  |          ORM框架          |                   https://mp.baomidou.com/                   |
|   Swagger-UI   |       文档生产工具        | [ https://github.com/swagger-api/swagger-ui](https://github.com/swagger-api/swagger-ui) |
|     Kibana     |     分析和可视化平台      |               https://www.elastic.co/cn/kibana               |
| Elasticsearch  |         搜索引擎          | [ https://github.com/elastic/elasticsearch](https://github.com/elastic/elasticsearch) |
|     Beats      |     轻量型数据采集器      |               https://www.elastic.co/cn/beats/               |
|    Logstash    | 用于接收Beats的数据并处理 |              https://www.elastic.co/cn/logstash              |
|      Solr      |         搜索引擎          |                http://lucene.apache.org/solr/                |
|    RabbitMQ    |         消息队列          |   [ https://www.rabbitmq.com/](https://www.rabbitmq.com/)    |
|     Redis      |        分布式缓存         |                      https://redis.io/                       |
|     Docker     |        容器化部署         |      [ https://www.docker.com](https://www.docker.com/)      |
|     Druid      |       数据库连接池        | [ https://github.com/alibaba/druid](https://github.com/alibaba/druid) |
|     七牛云     |     七牛云 - 对象储存     |         https://developer.qiniu.com/sdk#official-sdk         |
|      JWT       |        JWT登录支持        |                 https://github.com/jwtk/jjwt                 |
|     SLF4J      |         日志框架          |                    http://www.slf4j.org/                     |
|     Lombok     |     简化对象封装工具      | [ https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok) |
|     Nginx      |  HTTP和反向代理web服务器  |                      http://nginx.org/                       |
|    JustAuth    |     第三方登录的工具      |             https://github.com/justauth/JustAuth             |
|     Hutool     |      Java工具包类库       |                  https://hutool.cn/docs/#/                   |
|    阿里大于    |       短信发送平台        |            https://doc.alidayu.com/doc2/index.htm            |
| Github Actions |        自动化部署         |              https://help.github.com/en/actions              |
|     Zipkin     |         链路追踪          |             https://github.com/openzipkin/zipkin             |
| Flexmark-java  |     Markdown转换Html      |            https://github.com/vsch/flexmark-java             |
|   Ip2region    |     离线IP地址定位库      |          https://github.com/lionsoul2014/ip2region           |
|     Minio      |     本地对象存储服务      |                       https://min.io/                        |
| Docker Compose |      Docker容器编排       |               https://docs.docker.com/compose/               |
|   Portainer    |     Docker可视化管理      |            https://github.com/portainer/portainer            |

### 前端技术

|         技术          |                  说明                   |                             官网                             |
| :-------------------: | :-------------------------------------: | :----------------------------------------------------------: |
|        Vue.js         |                前端框架                 |                      https://vuejs.org/                      |
|      Vue-router       |                路由框架                 |                  https://router.vuejs.org/                   |
|         Vuex          |            全局状态管理框架             |                   https://vuex.vuejs.org/                    |
|        Nuxt.js        |        创建服务端渲染 (SSR) 应用        |                    https://zh.nuxtjs.org/                    |
|        Element        |               前端ui框架                |    [ https://element.eleme.io](https://element.eleme.io/)    |
|         Axios         |              前端HTTP框架               | [ https://github.com/axios/axios](https://github.com/axios/axios) |
|        Echarts        |                图表框架                 |                      www.echartsjs.com                       |
|       CKEditor        |              富文本编辑器               |                    https://ckeditor.com/                     |
|     Highlight.js      |            代码语法高亮插件             |         https://github.com/highlightjs/highlight.js          |
|        Vditor         |             Markdown编辑器              |             https://github.com/Vanessa219/vditor             |
|      vue-cropper      |              图片裁剪组件               |           https://github.com/xyxiao001/vue-cropper           |
| vue-image-crop-upload |           vue图片剪裁上传组件           |      https://github.com/dai-siki/vue-image-crop-upload       |
|   vue-emoji-comment   |          Vue Emoji表情评论组件          |       https://github.com/pppercyWang/vue-emoji-comment       |
|     clipboard.js      |            现代化的拷贝文字             |                  http://www.clipboardjs.cn/                  |
|      js-beautify      |           美化JavaScript代码            |         https://github.com/beautify-web/js-beautify          |
|     FileSaver.js      |            保存文件在客户端             |           https://github.com/eligrey/FileSaver.js            |
|      SortableJS       |       功能强大的JavaScript 拖拽库       |                  http://www.sortablejs.com/                  |
|   vue-side-catalog    |               目录导航栏                |        https://github.com/yaowei9363/vue-side-catalog        |
|        uniapp         |            移动端跨平台语言             |                  https://uniapp.dcloud.io/                   |
|        colorUi        |         专注视觉的小程序组件库          |             https://github.com/weilanwl/ColorUI              |
|       showdown        | 用Javascript编写的Markdown 到Html转换器 |            https://github.com/showdownjs/showdown            |
|       turndown        | 用JavaScript编写的HTML到Markdown转换器  |           https://github.com/domchristie/turndown            |

## 快速开始

- clone仓库代码，准备相关开发环境

- 管理后台
- - 启动dashboard-service服务，访问localhost:8080/dashboard

- 门户网站
- - 启动site-service服务，访问localhost:8080


## 环境搭建

### 开发工具

|         工具         |       说明        |                                                 官网                                                  |
|:------------------:| :---------------: |:---------------------------------------------------------------------------------------------------:|
|        IDEA        |    Java开发IDE    |                               https://www.jetbrains.com/idea/download                               |
| visual studio code |    前端开发IDE    |                                   https://code.visualstudio.com/                                    |
|    RedisDesktop    |  Redis可视化工具  |               [ https://redisdesktop.com/download](https://redisdesktop.com/download)               |
|    SwitchHosts     |   本地Host管理    |                                 https://oldj.github.io/SwitchHosts/                                 |
|      X-shell       | Linux远程连接工具 |                                   https://xshell.en.softonic.com/                                   |
|       X-ftp        | Linux文件传输工具 |                             https://www.netsarang.com/zh/all-downloads/                             |
|       SQLyog       |  数据库连接工具   |                                   https://sqlyog.en.softonic.com/                                   |
|    ScreenToGif     |    Gif录制工具    |                    [ https://www.screentogif.com/](https://www.screentogif.com/)                    |

### 开发环境

|     工具      | 版本号 |                             下载                             |
| :-----------: | :----: | :----------------------------------------------------------: |
|      JDK      |  1.8   | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
|     Maven     | 3.3.0+ |                   http://maven.apache.org/                   |
| Elasticsearch | 6.3.0  |               https://www.elastic.co/downloads               |
|     Solr      |  7.0   |                http://lucene.apache.org/solr/                |
|     MySQL     |  5.6   |                    https://www.mysql.com/                    |
|    Erlang     |  20.3  |                   https://www.erlang.org/                    |
|   RabbitMQ    | 3.7.4  |            http://www.rabbitmq.com/download.html             |
|     Nginx     |  1.10  |              http://nginx.org/en/download.html               |
|     Redis     | 3.3.0  |                  https://redis.io/download                   |
|    Zipkin     | 2.12.5 | https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec |
|     Nacos     | 1.3.2  |          https://github.com/alibaba/nacos/releases           |
|   Sentinel    | 1.7.2  |         https://github.com/alibaba/Sentinel/releases         |

## 开源协议

遵循MIT开源协议
