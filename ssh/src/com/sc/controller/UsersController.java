package com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;
import com.sc.service.UsersService;

@Controller
@RequestMapping("/usersctrl")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav ){
		System.out.println("查询用户列表！");
		//查询list集合
		List<Users> list = usersService.select();
		mav.addObject("list", list);//list集合存入模型
		mav.setViewName("userslist");// 路径是：/WEB-INF/userslist.jsp
		return mav;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav,Users u){
		System.out.println("删除用户！"+u);
		this.usersService.delete(u);
		mav.setViewName("redirect:list.do");//重定向到list方法
		return mav;
	}
	
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav,Users u){
		System.out.println("跳转到修改页面！"+u);
		Users users = this.usersService.get(u.getUid());
		mav.addObject("u", users);
		mav.setViewName("usersupdate");
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,
			MultipartFile upload,
			HttpServletRequest req,
			Users u) throws IllegalStateException, IOException{
		System.out.println("开始上传文件"+u);
		
		//如果用户选择文件，那么执行上传代码
		if(upload!=null){
			String filename=upload.getOriginalFilename();//文件名
			if(filename!=null&&!filename.equals("")){
				//获取upload文件夹所在路径
				String path=req.getSession().
						getServletContext().getRealPath("upload");
				//形如：26456456435.jpg
				filename=System.currentTimeMillis()
						+filename.substring(filename.lastIndexOf("."));
				//目的地文件对象
				File file=new File(path+"/"+filename);
				upload.transferTo(file);//转换存储文件
				
				//设置图片名称
				u.setPic(filename);
			}
		}
		
		this.usersService.update(u);
		mav.setViewName("redirect:list.do");//重定向到list方法
		return mav;
	}
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav,
			MultipartFile add,
			HttpServletRequest req,
			Users u) throws IllegalStateException, IOException{
System.out.println("开始上传文件"+u);
		
		//如果用户选择文件，那么执行上传代码
		if(add!=null){
			String filename=add.getOriginalFilename();//文件名
			if(filename!=null&&!filename.equals("")){
				//获取upload文件夹所在路径
				String path=req.getSession().
						getServletContext().getRealPath("upload");
				//形如：26456456435.jpg
				filename=System.currentTimeMillis()
						+filename.substring(filename.lastIndexOf("."));
				//目的地文件对象
				File file=new File(path+"/"+filename);
				add.transferTo(file);//转换存储文件
				
				//设置图片名称
				u.setPic(filename);
			}
		}
		
		
		this.usersService.add(u);
		mav.setViewName("redirect:list.do");
		return mav;
		
	}
	
	
	
	
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav) {

		mav.setViewName("usersadd");
		return mav;
		
	}
}
