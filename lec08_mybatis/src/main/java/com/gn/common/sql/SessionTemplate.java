package com.gn.common.sql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	public static SqlSession getSqlSession() {
		
		SqlSession session= null;
		try {
			// 1. mybatis-config.xml의 설정 정보를 InputStream을 통해 읽어옴
			String path = "/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(path);
			// 2. SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			// 3. SqlSessionFactoryBuilder 객체의 build() 메소드 활용
			// SqlSessionFactory 객체 생성
			SqlSessionFactory factory = sfb.build(is);
			// 4. SqlSessionFactory 객체의 openSession() 메소드 활용
			// SqlSession 객체 생성
			// 매개변수로 AutoCommit 여부 지정(기본값 : true)
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
