/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 08-27-2008
 * 
 * XDoclet definition:
 * @struts.form name="marsJfreeCharBranchForm"
 */
public class MarsJfreeCharBranchForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** count property */
	private String count;

	/** branchid property */
	private String branchid;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the count.
	 * @return String
	 */
	public String getCount() {
		return count;
	}

	/** 
	 * Set the count.
	 * @param count The count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/** 
	 * Returns the branchid.
	 * @return String
	 */
	public String getBranchid() {
		return branchid;
	}

	/** 
	 * Set the branchid.
	 * @param branchid The branchid to set
	 */
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
}