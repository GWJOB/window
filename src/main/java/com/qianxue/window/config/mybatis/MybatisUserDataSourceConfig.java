package com.qianxue.window.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.qianxue.window.dao.user", sqlSessionFactoryRef = "userSqlSessionTemplate")
public class MybatisUserDataSourceConfig {

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.user.datasource")// prefix值必须是application.properteis中对应属性的前缀
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }
}
