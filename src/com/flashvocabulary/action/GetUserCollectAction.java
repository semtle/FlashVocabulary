package com.flashvocabulary.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.flashvocabulary.dto.User;
import com.flashvocabulary.dto.Word;
import com.flashvocabulary.service.UserCollectLibService;
import com.flashvocabulary.utils.IConstants;
import com.opensymphony.xwork2.Action;

public class GetUserCollectAction implements Action{
	
	private UserCollectLibService userCollectLibService = new UserCollectLibService();
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Word> wordList = new ArrayList<Word>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
		    return IConstants.SESSION_EXPIRED;
		}
		int uid = user.getId();
		
		wordList = userCollectLibService.getUserCollectLibByUid(uid);
		String showstr1 = "";
		String showstr2 = "";
		String showstr3 = "";
		String showstr4 = "";
		Word word = null;
		int a=0,b=0,c=0,d=0;

		for(int i=0;i<wordList.size();i++)
		{
			word = wordList.get(i);
			if(word.getLib_id()==1){
				a++;
				request.setAttribute("libName1", "CET-4");
				showstr1+="<div><p>"+a+"."+word.getWord()
						+word.getPhonetics()+"</p><p>"
						+word.getTranslation().split("\\|")[0]+"</p>"
						+"<a href=\"GetWordDetailsAction?wid="+word.getId()+"&libid=1\">Details</a></div>";
			}
			else if(word.getLib_id()==3){
				b++;
				request.setAttribute("libName2", "CET-6");
				showstr2+="<div><p>"+b+"."+word.getWord()
						+word.getPhonetics()+"</p><p>"
						+word.getTranslation().split("\\|")[0]+"</p>"
						+"<a href=\"GetWordDetailsAction?wid="+word.getId()+"&libid=3\">Details</a></div>";
			}
			else if(word.getLib_id()==6){
				c++;
				request.setAttribute("libName3", "GRE3000");
				showstr3+="<div><p>"+c+"."+word.getWord()
						+word.getPhonetics()+"</p><p>"
						+word.getTranslation().split("\\|")[0]+"</p>"
						+"<a href=\"GetWordDetailsAction?wid="+word.getId()+"&libid=6\">Details</a></div>";
			}
			else if(word.getLib_id()==10){
				d++;
				request.setAttribute("libName4", "TOEFL");
				showstr4+="<div><p>"+d+"."+word.getWord()
						+word.getPhonetics()+"</p><p>"
						+word.getTranslation().split("\\|")[0]+"</p>"
						+"<a href=\"GetWordDetailsAction?wid="+word.getId()+"&libid=10\">Details</a></div>";
			}
		}
		request.setAttribute("longSTR1", showstr1);
		request.setAttribute("longSTR2", showstr2);
		request.setAttribute("longSTR3", showstr3);
		request.setAttribute("longSTR4", showstr4);
		
		return IConstants.GET_COLLECTION;
			
	}

}
