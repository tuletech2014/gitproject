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
 * Creation date: 08-15-2008
 * 
 * XDoclet definition:
 * @struts.form name="marsAfficheInfoForm"
 */
public class MarsAfficheInfoForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** userid property */
	private String userid;

	/** affichecontent property */
	private String affichecontent;

	/** afficheid property */
	private String afficheid;

	/** branchid property */
	private String branchid;

	/** affichetitle property */
	private String affichetitle;

	/** affichedata property */
	private String affichedata;

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
	 * Returns the userid.
	 * @return String
	 */
	public String getUserid() {
		return userid;
	}

	/** 
	 * Set the userid.
	 * @param userid The userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/** 
	 * Returns the affichecontent.
	 * @return String
	 */
	public String getAffichecontent() {
		return affichecontent;
	}

	/** 
	 * Set the affichecontent.
	 * @param affichecontent The affichecontent to set
	 */
	public void setAffichecontent(String affichecontent) {
		this.affichecontent = affichecontent;
	}

	/** 
	 * Returns the afficheid.
	 * @return String
	 */
	public String getAfficheid() {
		return afficheid;
	}

	/** 
	 * Set the afficheid.
	 * @param afficheid The afficheid to set
	 */
	public void setAfficheid(String afficheid) {
		this.afficheid = afficheid;
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

	/** 
	 * Returns the affichetitle.
	 * @return String
	 */
	public String getAffichetitle() {
		return affichetitle;
	}

	/** 
	 * Set the affichetitle.
	 * @param affichetitle The affichetitle to set
	 */
	public void setAffichetitle(String affichetitle) {
		this.affichetitle = affichetitle;
	}

	/** 
	 * Returns the affichedata.
	 * @return String
	 */
	public String getAffichedata() {
		return affichedata;
	}

	/** 
	 * Set the affichedata.
	 * @param affichedata The affichedata to set
	 */
	public void setAffichedata(String affichedata) {
		this.affichedata = affichedata;
	}
}