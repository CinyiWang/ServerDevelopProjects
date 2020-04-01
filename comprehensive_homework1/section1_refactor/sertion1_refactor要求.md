## section1_refactor要求

1. - [x] 清空web.xml配置，改成java配置类
  
2. - [x] 优化控制层的loginCheck方法，并且添加数据校验功能（@Valid），
        用户名3-6个字符，口令6个字符，并有错误提示
  
3. - [x] 数据库由原来的mysql改成H2内嵌数据库，不要有外部数据库访问依赖，exampledb.sql数据脚本同步修改
  
4. - [x] DAO层实现由现在的jdbc改成JpaRepository自动实现，方法名可以改变
  
5. - [ ] DAO层的findUserByUserName添加缓存功能，缓存用EhCache实现
  
6. - [x] 测试改进：service层的测试将现在直连数据库改成使用mock取代dao层




