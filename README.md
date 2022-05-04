1. 编译项目源码
`mvn clean install -Dpmd.skip=true -Dcheckstyle.skip=true -Dmaven.test.skip=true`
```shell
    ## 1. 删除idea编辑器生成的impl文件
    find . -name "*.iml" -type f -print -exec rm -rf {} \;
    
    ## 2. 删除idea编辑器生成的.idea文件夹
    rm -rf .idea
    
    ## 3. 删除maven编译生成的target文件
    mvn clean
```
2. <span style="color:red;font-weight:bold;">seata-mybatis-demo</span>为测试分布式事物写的demo案例,使用的是spring-boot + mybatis实现的,参考github上[seata-sample源码](https://github.com/seata/seata-samples)
3. <span style="color:red;font-weight:bold;">seata-demo</span>为测试分布式事物写的demo案例,使用的是spring-clout + open-feign + hystrix + mybatis-plus实现的


    