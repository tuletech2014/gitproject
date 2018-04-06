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
import com.bu.*;
import com.po.BranchInfo;
import com.service.*;
import com.struts.form.*;
/** 
 * MyEclipse Struts
 * Creation date: 08-20-2008
 * 
 * XDoclet definition:
 * @struts.action
 */
public class Mars_driverinfo_findAllAction extends Action {
	/*
	 * Generated Methods
	 */
	private MarsBusinessservice bs;
	public MarsBusinessservice getBs() {
		return bs;
	}
	public void setBs(MarsBusinessservice bs) {
		this.bs = bs;
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
		OptBranchInfoForm branch=(OptBranchInfoForm)request.getSession(true).getAttribute("loginBranch");
		Vector drivervc=bs.getDriverinfobusiness().findByBranchID(branch.getBranchid().toString());
		request.getSession(true).setAttribute("drivervc", drivervc);
		return mapping.findForward("list");
		
	}
}