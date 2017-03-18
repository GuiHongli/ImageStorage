package imageStorage.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import imageStorage.entity.FindUserVo;
import imageStorage.entity.ShowData;
import imageStorage.entity.User;
import imageStorage.entity.UserExample;
import imageStorage.mapper.UserMapper;
import imageStorage.mapper.UserProjectProjectListMapper;
import imageStorage.service.UserService;

/**
 *<p>Title:UserServiceImpl.java</p>
 *<p>Description:用户管理</p>
 * @author guihongli
 * @date 2017年3月15日
 */
public class UserServiceImpl  implements UserService{
	//这个注解表示自动注入
	@Autowired
	
	private UserProjectProjectListMapper upplm;
	
	@Autowired
	
	private UserMapper userMapper;
	
	@Override
	public List<ShowData> findUserList(FindUserVo fdv) throws Exception {
		//通过UserProjectProjectListMapper查询数据库
		List<ShowData> showDataList=upplm.findUserByProjectName(fdv);
		Calendar a=Calendar.getInstance();
		int currentYear= a.get(Calendar.YEAR);//得到年
		for(ShowData item:showDataList){
			item.setYear(currentYear);
		}
		return showDataList;
	}
	
	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		//这样就表示没有查询条件
		return userMapper.selectByExample(example);
	}
	
	@Override
	public User findUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		//若查出来的是基本类型，但是要返回的是该基本类型的扩展类型，在里面进行处理
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	//id其实就是userId
	public void updateUserById(String id, User user) throws Exception {
		//对关键参数进行校验,校验id是否为空,如果为空抛出异常
		if(id!=null&&id!=""){
			if(user!=null){
				//根据id更新表中的所有字段
				//必须存在id,一样的设置了也没事，就怕是空的
				user.setUserId(id);
				userMapper.updateByPrimaryKey(user);
			}
		}		
		
	}
	

}
