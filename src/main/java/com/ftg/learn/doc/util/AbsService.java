package com.ftg.learn.doc.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public abstract class AbsService {

    private final SqlSession session;
    private final SqlSessionFactory ssf;
    {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        Configuration r = new Configuration();
        MysqlDataSource s = new MysqlDataSource();
        s.setUser("root");
        s.setPassword("ykong");
        s.setURL("jdbc:mysql://localhost:3306/db2");
        Environment e = new Environment("yko",new JdbcTransactionFactory(),s);
        r.setEnvironment(e);
        ssf = ssfb.build(r);

        ssf.getConfiguration().addMappers("com.ftg.learn.doc.mapper");
        session = ssf.openSession(true);

    }

    public SqlSession getSession(){
        if(session == null){
            ssf.openSession();
        }
        return session;
    }
}
