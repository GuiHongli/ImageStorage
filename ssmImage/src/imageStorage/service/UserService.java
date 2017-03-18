package imageStorage.service;

import java.util.List;

import imageStorage.entity.FindUserVo;
import imageStorage.entity.ShowData;
import imageStorage.entity.User;

/**
 *<p>Title:UserService.java</p>
 *<p>Description:用户管理的serviee</p>
 * @author guihongli
 * @date 2017年3月15日
 */
public interface UserService {
	//用户的查询列表:这里是高级的综合查询,这个是多表操作
	public List<ShowData> findUserList(FindUserVo fdv) throws Exception;
	
	//用户查询，仅仅是信息录入员的
	public List<User> findUserList() throws Exception;
	
	//根据用户的Id查询用户，信息录入员的，修改信息时使用
	public User findUserById(String id) throws Exception;
	
	//根据id修改用户，基本信息录入员修改的
	public void updateUserById(String id,User user) throws Exception;
}
