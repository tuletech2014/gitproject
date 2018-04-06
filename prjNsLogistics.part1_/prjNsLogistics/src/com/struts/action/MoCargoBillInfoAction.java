/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.*;
import com.service.MosterBuService;
import com.struts.form.OptBranchInfoForm;
import com.struts.form.OptUserInfoForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-16-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class MoCargoBillInfoAction extends Action {
	/*
	 * Generated Methods
	 */
	private MosterBuService mobs;
	public MosterBuService getMobs() {
		return mobs;
	}
	public void setMobs(MosterBuService mobs) {
		this.mobs = mobs;
	}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//从Sessions中获取当前登陆用户信息，获取该用户身份以及所属分公司编号
		OptUserInfoForm ui = (OptUserInfoForm) request.getSession(true).getAttribute("loginer");
		
		OptBranchInfoForm bi = (OptBranchInfoForm) request.getSession(true).getAttribute("loginBranch");
		
		Vector vcbill = mobs.getMobillinfobuss().findByBranchID(new Integer(bi.getBranchid()));

		request.setAttribute("movcbill", vcbill);
		return mapping.findForward("mocargobill");
	}
}