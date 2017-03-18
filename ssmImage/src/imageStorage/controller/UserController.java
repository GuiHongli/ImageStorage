package imageStorage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import imageStorage.entity.FindUserVo;
import imageStorage.entity.ShowData;
import imageStorage.entity.User;
import imageStorage.service.UserService;

@Controller
//这里指定类中的所有方法对应url的根路径，正确的访问路径是根路径+子路径
@RequestMapping("/user")
public class UserController {
	@Autowired
	//自动注入
	public UserService userService;
	
	@RequestMapping("/queryUsersbyProjectName")
	public ModelAndView  queryUsersByProjectName() throws Exception{
		//此时的查询条件为空
		FindUserVo fdv=null;
		List<ShowData> userList=userService.findUserList(fdv);	
		
		//返回ModelAndView
		ModelAndView modelAndView=new ModelAndView();
		//相当于request的setAttribute方法,在jsp页面中可以通过itemsList取数据
		modelAndView.addObject("userList", userList);
		//指定视图
		modelAndView.setViewName("user/queryUserList");
		//所以自己要建一个视图，在WEB-INF中建一个目录jsp,再建一个子目录items
		return modelAndView;
	}
	
	@RequestMapping("/enterUsers")
	public ModelAndView  enterUsers(HttpServletRequest request) throws Exception{
		//测试forward后，request数据是否能够共享
		//System.out.println(request.getParameter("id"));
		
		List<User> userList=userService.findUserList();	
		
		//返回ModelAndView
		ModelAndView modelAndView=new ModelAndView();
		//相当于request的setAttribute方法,在jsp页面中可以通过userList取数据
		modelAndView.addObject("userList", userList);
		//指定视图
		modelAndView.setViewName("user/enterUsers");
		//所以自己要建一个视图，在WEB-INF中建一个目录jsp,再建一个子目录user
		return modelAndView;
	}

	//商品信息修改页面展示
	//@RequestMapping("/editUser")
	//限制http请求的方法:可以写两个get各post都写
//	@RequestMapping(value="/editUser",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editUser() throws Exception{
//		//调用service查询用户的信息，前一个页面需要将用户的id传到此方法
//		User user=userService.findUserById("612325199606152827");
//		//返回ModelAndView
//		ModelAndView modelAndView =new ModelAndView();
//		//将查询所得数据放入Model中
//		modelAndView.addObject("user", user);
//		//商品修改页面
//		modelAndView.setViewName("user/editUser");
//		return modelAndView;
//	}
	@RequestMapping(value="/editUser",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam(value="指定request传入的参数名")String 要绑定的形参名
	//可以写多个参数绑定注解
	//required:指定该参数是否必须要传
	public String editUser(Model model,@RequestParam(value="id",required=true)String userId) throws Exception{
		//这时就没有view什么事了，模型数据可以通过形参传到页面
		//这个时候能直接使用id，而且能正确拿到，是因为上一个页面enterUser.jsp点击链接时传过来
		 //了叫id的一个值，如果两边的名称不一致，则要使用一个注解
		User user=userService.findUserById(userId);
		model.addAttribute("user", user);
		return "user/editUser";
	}
//	@RequestMapping("/editUserSumbit")
//	//提交修改的用户信息
//	public ModelAndView editUserSubmit() throws Exception{
//		//调用service更新用户信息，页面需要将用户信息传到此方法
//		ModelAndView modelAndView =new ModelAndView();
//		//返回一个提交成功的页面
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	@RequestMapping("/editUserSumbit")
	//提交修改的用户信息
	public String editUserSubmit(HttpServletRequest request,String userId,User user) throws Exception{
		//通过调用service来更新数据表中的用户信息
		userService.updateUserById(userId, user);
		//返回逻辑视图名
		return "success";
		
		//进行重定向
		//return "redirect:enterUsers.action";
		
		//页面转发:浏览器的地址栏中的地址不会改变，所以不会根据转发的这个url，调用controller中的方法
		//return "forward:enterUsers.action";
		
		
	}
}
