package com.bu.carmack;

import java.util.*;

import com.po.*;
import com.struts.form.*;
import com.service.*;

public class DriverInfoBusiness implements IBusiness {
	private DAOService daos;
	public DAOService getDaos()
	{
		return daos;
	}
	public void setDaos(DAOService daos)
	{
		this.daos=daos;
	}
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		DriverInfo di=daos.getDriverinfodao().findById(new Integer(id));
		try {
			daos.getDriverinfodao().delete(di);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector findAll() {
		// TODO Auto-generated method stub
		Vector vcDriverInfo=new Vector();
		List ls=daos.getDriverinfodao().findAll();
		for(Object object:ls)
		{
			DriverInfo di=(DriverInfo) object;
			OptDriverInfoForm cdif=new OptDriverInfoForm();
			cdif.setDriverid(di.getDriverId().toString());
			cdif.setBranchid(di.getBranchInfo().getBranchId().toString());
			cdif.setBranchname(di.getBranchInfo().getBranchName());
			cdif.setDrivername(di.getDriverName());
			cdif.setDriverage(di.getDriverAge());
			cdif.setDriversex(di.getDriverSex());
			cdif.setDriverphoto(di.getDriverPhoto());
			cdif.setDriverdrivecardid(di.getDriverDriveCardId());
			cdif.setDrivercardid(di.getDriverCardId());
			cdif.setDriverphone(di.getDriverPhone());
			cdif.setDrivermemo(di.getDriverMemo());
			cdif.setDriverisvacancy(di.getDriverIsVacancy().toString());
			
			vcDriverInfo.add(cdif);
		}
		return vcDriverInfo;
	}

	public Object findById(String id) {
		// TODO Auto-generated method stub
		DriverInfo di=daos.getDriverinfodao().findById(new Integer(id));
		OptDriverInfoForm cdif=new OptDriverInfoForm();
		cdif.setDriverid(di.getDriverId().toString());
		cdif.setBranchid(di.getBranchInfo().getBranchId().toString());
		cdif.setBranchname(di.getBranchInfo().getBranchName());
		cdif.setDrivername(di.getDriverName());
		cdif.setDriverage(di.getDriverAge());
		cdif.setDriversex(di.getDriverSex());
		cdif.setDriverphoto(di.getDriverPhoto());
		cdif.setDriverdrivecardid(di.getDriverDriveCardId());
		cdif.setDrivercardid(di.getDriverCardId());
		cdif.setDriverphone(di.getDriverPhone());
		cdif.setDrivermemo(di.getDriverMemo());
		cdif.setDriverisvacancy(di.getDriverIsVacancy().toString());
		return cdif;
	}

	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		OptDriverInfoForm cdif=(OptDriverInfoForm) ob;
		DriverInfo di=new DriverInfo();
		BranchInfo bi=daos.getBranchinfodao().findById(new Integer(cdif.getBranchid()));
		di.setBranchInfo(bi);
		di.setDriverName(cdif.getDrivername());
		di.setDriverAge(cdif.getDriverage());
		di.setDriverSex(cdif.getDriversex());
		di.setDriverPhoto(cdif.getDriverphoto());
		di.setDriverDriveCardId(cdif.getDriverdrivecardid());
		di.setDriverCardId(cdif.getDrivercardid());
		di.setDriverPhone(cdif.getDriverphone());
		di.setDriverMemo(cdif.getDrivermemo());
		di.setDriverIsVacancy(new Integer(cdif.getDriverisvacancy()));
		
		try {
			daos.getDriverinfodao().save(di);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		OptDriverInfoForm cdif=(OptDriverInfoForm) ob;
		DriverInfo di=daos.getDriverinfodao().findById(new Integer(cdif.getDriverid()));
		BranchInfo bi=daos.getBranchinfodao().findById(new Integer(cdif.getBranchid()));
		di.setBranchInfo(bi);
		di.setDriverName(cdif.getDrivername());
		di.setDriverAge(cdif.getDriverage());
		di.setDriverSex(cdif.getDriversex());
		di.setDriverPhoto(cdif.getDriverphoto());
		di.setDriverDriveCardId(cdif.getDriverdrivecardid());
		di.setDriverCardId(cdif.getDrivercardid());
		di.setDriverPhone(cdif.getDriverphone());
		di.setDriverMemo(cdif.getDrivermemo());
		di.setDriverIsVacancy(new Integer(cdif.getDriverisvacancy()));
		
		try {
			daos.getDriverinfodao().attachDirty(di);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ��ѯָ����˾������˾��
	 * @param int ��˾���
	 * @return List ˾������
	 * */
	public Vector findByBranchID(int branchID){
		Vector vcDriverInfo=new Vector();
		List ls=daos.getDriverinfodao().findByBranchID(branchID);
		for(Object object:ls)
		{
			DriverInfo di=(DriverInfo) object;
			OptDriverInfoForm cdif=new OptDriverInfoForm();
			cdif.setDriverid(di.getDriverId().toString());
			cdif.setBranchid(di.getBranchInfo().getBranchId().toString());
			cdif.setBranchname(di.getBranchInfo().getBranchName());
			cdif.setDrivername(di.getDriverName());
			cdif.setDriverage(di.getDriverAge());
			cdif.setDriversex(di.getDriverSex());
			cdif.setDriverphoto(di.getDriverPhoto());
			cdif.setDriverdrivecardid(di.getDriverDriveCardId());
			cdif.setDrivercardid(di.getDriverCardId());
			cdif.setDriverphone(di.getDriverPhone());
			cdif.setDrivermemo(di.getDriverMemo());
			cdif.setDriverisvacancy(di.getDriverIsVacancy().toString());
			
			vcDriverInfo.add(cdif);
		}
		return vcDriverInfo;
	}

}
