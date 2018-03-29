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

import com.service.CarmackBusinessService;

/** 
 * MyEclipse Struts
 * Creation date: 08-16-2008
 * 
 * XDoclet definition:
 * @struts.action 
 */
public class CarmackBranchInfoDeleteAction extends Action {
	/*
	 * Generated Methods
	 */
	private CarmackBusinessService bs;
	public CarmackBusinessService getBs()
	{
		return bs;
	}
	public void setBs(CarmackBusinessService bs)
	{
		this.bs=bs;
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
		String id=request.getParameter("BranchID");
		System.out.println(id);
		boolean bl=bs.getBranchinfobu().delete(id);
		if(bl){
			return mapping.findForward("bidel");
		}
		return null;
	}
}