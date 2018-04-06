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
 * Creation date: 08-16-2007
 * 
 * XDoclet definition:
 * @struts.form name="optDriverInfoForm"
 */
public class OptDriverInfoForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** driverphone property */
	private String driverphone;

	/** branchname property */
	private String branchname;

	/** driverdrivecardid property */
	private String driverdrivecardid;

	/** driverid property */
	private String driverid;

	/** drivermemo property */
	private String drivermemo;

	/** drivername property */
	private String drivername;

	/** driverisvacancy property */
	private String driverisvacancy;

	/** drivercardid property */
	private String drivercardid;

	/** branchid property */
	private String branchid;

	/** driverage property */
	private String driverage;

	/** driverphoto property */
	private String driverphoto;

	/** driversex property */
	private String driversex;

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
	 * Returns the driverphone.
	 * @return String
	 */
	public String getDriverphone() {
		return driverphone;
	}

	/** 
	 * Set the driverphone.
	 * @param driverphone The driverphone to set
	 */
	public void setDriverphone(String driverphone) {
		this.driverphone = driverphone;
	}

	/** 
	 * Returns the branchname.
	 * @return String
	 */
	public String getBranchname() {
		return branchname;
	}

	/** 
	 * Set the branchname.
	 * @param branchname The branchname to set
	 */
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	/** 
	 * Returns the driverdrivecardid.
	 * @return String
	 */
	public String getDriverdrivecardid() {
		return driverdrivecardid;
	}

	/** 
	 * Set the driverdrivecardid.
	 * @param driverdrivecardid The driverdrivecardid to set
	 */
	public void setDriverdrivecardid(String driverdrivecardid) {
		this.driverdrivecardid = driverdrivecardid;
	}

	/** 
	 * Returns the driverid.
	 * @return String
	 */
	public String getDriverid() {
		return driverid;
	}

	/** 
	 * Set the driverid.
	 * @param driverid The driverid to set
	 */
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	/** 
	 * Returns the drivermemo.
	 * @return String
	 */
	public String getDrivermemo() {
		return drivermemo;
	}

	/** 
	 * Set the drivermemo.
	 * @param drivermemo The drivermemo to set
	 */
	public void setDrivermemo(String drivermemo) {
		this.drivermemo = drivermemo;
	}

	/** 
	 * Returns the drivername.
	 * @return String
	 */
	public String getDrivername() {
		return drivername;
	}

	/** 
	 * Set the drivername.
	 * @param drivername The drivername to set
	 */
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	/** 
	 * Returns the driverisvacancy.
	 * @return String
	 */
	public String getDriverisvacancy() {
		return driverisvacancy;
	}

	/** 
	 * Set the driverisvacancy.
	 * @param driverisvacancy The driverisvacancy to set
	 */
	public void setDriverisvacancy(String driverisvacancy) {
		this.driverisvacancy = driverisvacancy;
	}

	/** 
	 * Returns the drivercardid.
	 * @return String
	 */
	public String getDrivercardid() {
		return drivercardid;
	}

	/** 
	 * Set the drivercardid.
	 * @param drivercardid The drivercardid to set
	 */
	public void setDrivercardid(String drivercardid) {
		this.drivercardid = drivercardid;
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
	 * Returns the driverage.
	 * @return String
	 */
	public String getDriverage() {
		return driverage;
	}

	/** 
	 * Set the driverage.
	 * @param driverage The driverage to set
	 */
	public void setDriverage(String driverage) {
		this.driverage = driverage;
	}

	/** 
	 * Returns the driverphoto.
	 * @return String
	 */
	public String getDriverphoto() {
		return driverphoto;
	}

	/** 
	 * Set the driverphoto.
	 * @param driverphoto The driverphoto to set
	 */
	public void setDriverphoto(String driverphoto) {
		this.driverphoto = driverphoto;
	}

	/** 
	 * Returns the driversex.
	 * @return String
	 */
	public String getDriversex() {
		return driversex;
	}

	/** 
	 * Set the driversex.
	 * @param driversex The driversex to set
	 */
	public void setDriversex(String driversex) {
		this.driversex = driversex;
	}
}