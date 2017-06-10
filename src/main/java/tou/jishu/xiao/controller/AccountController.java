package tou.jishu.xiao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tou.jishu.xiao.mapping.AccountMapper;
import tou.jishu.xiao.po.Account;

@Controller
@RequestMapping("/Account")
public class AccountController {

	@Resource
	private AccountMapper accountMapper;

	// 商品查询
	@RequestMapping("/queryItems")
	public String queryItems(HttpServletRequest request, Model model) {
		
		int accountid = Integer.parseInt(request.getParameter("id"));
		Account account = this.accountMapper.selectByPrimaryKey(accountid);
		if(account!=null){
		model.addAttribute("account", account);
		return "showUser";
		}
		return "error";
	}

}
