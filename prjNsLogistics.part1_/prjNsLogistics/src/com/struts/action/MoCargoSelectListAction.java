/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.service.MosterBuService;
import com.struts.form.OptBranchInfoForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-25-2008
 * 
 * XDoclet definition:
 * @struts.action
 */
public class MoCargoSelectListAction extends Action {
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
		//获取分页参数
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		if (start == null) {
			start = "0";
		}
		if (limit == null) {
			limit = "10";
		}
		//将分页参数重新放置到域中
		request.setAttribute("start", start);
		request.setAttribute("limit", limit);
				
		//从Sessions中获取当前登陆分公司
		OptBranchInfoForm bi = (OptBranchInfoForm) request.getSession(true).getAttribute("loginBranch");
		
		Vector vcci = mobs.getMocargoinfobuss().findByBranchID(new Integer(bi.getBranchid()));
		request.setAttribute("mocargovc",vcci);
		
		return mapping.findForward("mocargoselectlist");
	}
}