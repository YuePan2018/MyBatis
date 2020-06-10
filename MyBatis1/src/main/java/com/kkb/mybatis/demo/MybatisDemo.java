package com.kkb.mybatis.demo;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kkb.mybatis.po.User;

public class MybatisDemo {
	
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * @Before注解的方法会在@Test注解的方法之前执行
	 * 
	 * @throws Exception
	 */
	@Before
	public void init() throws Exception {
		//指定全局配置文件路径
		String resource = "SqlMapConfig.xml";
		//加载资源文件（全局配置文件和映射文件）
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//还有构建者模式，去创建SqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );
		
		//设计模式分三类23种：创建型（5）、结构型（7）、行为型（11）
	}
	
	// Test: select by user id
	@Test
	public void testSelect() {
		//由SqlSessionFactory工厂去创建SqlSession（会话）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//调用sqlsession接口，去实现数据库的增删改查操作，第二个parameter就是id
		User user = sqlSession.selectOne("test.findUserById", 10);
		
		System.out.println(user);
		//释放资源
		sqlSession.close();
	}
	// 根据用户名称模糊查询用户信息
	@Test
	public void testFindUserByUsername() {
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 查询单个记录，根据用户id查询用户信息
			List<User> list = sqlSession.selectList("test.findUserByUsername", "小明");
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testInsert() {
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			User user = new User();
			user.setUsername("张小明");
			user.setAddress("河南");
			sqlSession.insert("test.insertUser", user);
			//提交事务
			sqlSession.commit();
			// print selectKey
			System.out.println(user.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
