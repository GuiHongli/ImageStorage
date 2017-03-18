package imageStorage.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import imageStorage.entity.FindUserVo;
import imageStorage.entity.Project;
import imageStorage.entity.ShowData;
import imageStorage.mapper.UserProjectProjectListMapper;

public class UserProjectProjectListMapperTest {
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");;
	
	}

	@Test
	public void test() throws Exception {
		UserProjectProjectListMapper upp=(UserProjectProjectListMapper) applicationContext.getBean("userProjectProjectListMapper");
		FindUserVo fuv=new FindUserVo();
		Project project=new Project();
		project.setProjectName("CT");
		fuv.setProject(project);
		List<ShowData> userList=upp.findUserByProjectName(fuv);
		System.out.println(userList);
	}

}
