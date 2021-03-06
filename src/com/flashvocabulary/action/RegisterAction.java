package com.flashvocabulary.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.flashvocabulary.dto.User;
import com.flashvocabulary.service.UserInfoService;
import com.flashvocabulary.utils.IConstants;
import com.flashvocabulary.utils.WebUtils;
import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action{
    private UserInfoService userInfoService = new UserInfoService();
    @Override
    public String execute() throws Exception {
	
	HttpServletRequest request = ServletActionContext.getRequest();
	User user = new User(request.getParameter("uname"),request.getParameter("pwd"));
	if ((user.getUname().equals("")) || (user.getUname() == null)) {
	    request.setAttribute("message", "请输入合法的账号名！");
	    return IConstants.WARNING;
	}
	else if ((user.getPwd().equals("")) || (user.getPwd() == null)) {
	    request.setAttribute("message", "请输入合法的密码！");
	    return IConstants.WARNING;
	}
	//WebUtils.write2Bean(request, User.class);
	try {
		if(!userInfoService.isAcountExisted(user.getUname()))
		{
			user.setCurrentLib(12);  //12为默认词库Default
			user.setDailyCount(30);
			user = userInfoService.userRegister(user);
			request.getSession().setAttribute("user", user);
			return IConstants.REGISTER_SUCCESS;
		}
		else
		{
			request.setAttribute("message", "账号已存在！请直接登陆");
			return IConstants.REGISTER_FAILURE;
		}

	} catch (Exception e) {
		// TODO: handle exception
		request.setAttribute("message", "注册失败");
		return IConstants.REGISTER_FAILURE;

	}
    }
    
}
