import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrm.dao.BioMapper;
import com.hrm.service.BioService;
import com.hrm.service.impl.BioServiceImpl;
import com.hrm.vo.Bio;

public class TestBio {
	@Autowired
	static	BioService bioService;
	@Autowired
	static BioMapper bioMapper;
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
//		String resource="config.xml";
//		InputStream inputStream=Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession sqlSession=sqlSessionFactory.openSession();
//		BioMapper biodao=sqlSession.getMapper(BioMapper.class);
		
//		biodao.insert(new Bio("1234", "aa", "aa", "dd", "ss", "Sf", "ss", "sss", "vv", "gg", "f", "ew"));
//		
//		biodao.update(new Bio("123", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2"));
//		
//		biodao.delete("123");
//		System.out.println("123");
//		List<Bio> bios=biodao.getAll();
//		for (Bio bio : bios) {
//			System.out.print(bio);
//		}
//		
//		Bio bio=biodao.getOnebyId("1");
//		System.out.println(biodao.getOnebyId("1234"));
////		Bio bio2=biodao.getOnebyNo("2");
//		System.out.println(biodao.getOnebyNo("2"));
//		sqlSession.commit();
//		sqlSession.close();
		
		
		
//		bioService.delete("1");
		System.out.println(bioMapper.getClass().getName());
		
		
	}

}
