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

import com.service.Yasak_BusinessService;
import com.struts.form.OptBranchInfoForm;

/** 
 * MyEclipse Struts
 * Creation date: 08-22-2008
 * 
 * XDoclet definition:
 * @struts.action
 */
public class Yasak_BillListAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	private Yasak_BusinessService ybs;
	public Yasak_BusinessService getYbs() {
		return ybs;
	}
	public void setYbs(Yasak_BusinessService ybs) {
		this.ybs = ybs;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		
		if(start==null){
			start="0";
		}
		if(limit==null){
			limit="10";
		}
		request.setAttribute("bill_start", start);
		request.setAttribute("bill_limit", limit);
		OptBranchInfoForm bi = (OptBranchInfoForm) request.getSession(true).getAttribute("loginBranch");
		String str = bi.getBranchid();
		Vector vcbill = ybs.getBillbu().findByBillAll(str);
		request.setAttribute("vcbill", vcbill);
		
		return mapping.findForward("billlist");
	}
}