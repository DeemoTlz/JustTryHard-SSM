package com.qjh.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qjh.crud.bean.Clazz;
import com.qjh.crud.bean.Student;
import com.qjh.crud.dao.ClazzMapper;
import com.qjh.crud.dao.StudentMapper;

/**
 * 
 * @author Arman
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接autowired要使用的组件
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
	
	@Autowired
	ClazzMapper clazzMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试Clazz
	 */
	@Test
	public void testCrud() {
		/*// 1.创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.从容器中获取mapper
		Clazz bean = ioc.getBean(Clazz.class);*/
		
		System.out.println(clazzMapper);
		
		/*clazzMapper.insertSelective(new Clazz(null, "三年二班", "sneb", "周杰伦"));
		clazzMapper.insertSelective(new Clazz(null, "三年三班", "sneb", "刘德华"));*/
		
		//studentMapper.insertSelective(new Student(null, "唐丽猪", 18, true, 1));
		
		// 批量插入：使用可以执行批量操作的sqlSession
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5);
			mapper.insertSelective(new Student(null, "唐丽猪" + uuid, 18, true, 1));
		}
	}

}
