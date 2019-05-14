package com.qianxue.window.config.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.qianxue.window.dao.win"}, sqlSessionTemplateRef = "winSqlSessionTemplate")
public class MybatisWinDataSourceConfig {
    @Bean(name = "winDataSource")
    @ConfigurationProperties(prefix = "spring.win.datasource") // prefix值必须是application.properteis中对应属性的前缀
    @Primary //默认数据源
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "winSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("winDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "winSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("winSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }
}