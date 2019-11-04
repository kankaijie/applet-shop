#### 这是一个分布式的项目，采用的架构技术是springcloud+mybatis+maven+redis+es+mysql
####微服务的项目。微服务中用到了Eureka+Feign+zuul

####遇到的问题有
     1. springboot版本的问题
     
     
     2. 用feign远程调用服务时候出错，包服务名已存在或为空，需要在application.yml
     文件中覆盖服务名(即调用的服务)
     
     解决办法:
        spring:
          application:
            name: shop-goods
          ##解决feign远程调用服务名称重复的问题
          main:
            allow-bean-definition-overriding: true