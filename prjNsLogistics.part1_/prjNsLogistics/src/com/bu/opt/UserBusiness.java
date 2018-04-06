package com.bu.opt;

import java.util.*;

import com.po.*;
import com.service.DAOService;
import com.struts.form.OptSystemLogForm;
import com.struts.form.OptUserInfoForm;

public class UserBusiness implements IBusiness {

	//����һ��˽�е�DAOService
	private DAOService daos;
	
	public boolean delete(String pkid) {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByID(String pkid) {
		// TODO Auto-generated method stub
		UserInfo ui=daos.getUserinfodao().findById(new Integer(pkid));
		OptUserInfoForm uiform=new OptUserInfoForm();
		uiform.setUserid(ui.getUserId().toString());
		uiform.setUsername(ui.getUserName());
		uiform.setUserpassword(ui.getUserPassword());
		uiform.setBranchid(ui.getBranchInfo().getBranchId().toString());
		uiform.setUserrname(ui.getUserRname());
		uiform.setUsersex(ui.getUserSex());
		uiform.setDepartmentid(ui.getDepartmentInfo().getDepartmentId().toString());
		uiform.setDepartmentname(ui.getDepartmentInfo().getDepartmentName());
		uiform.setUserphone(ui.getUserPhone());
		uiform.setUsercardid(ui.getUserCardId());
		uiform.setRoleid(ui.getRoleInfo().getRoleId().toString());
		uiform.setUserloginnum(ui.getUserLoginNum());
		uiform.setUserlogindata(ui.getUserLoginData());
		uiform.setUserregdata(ui.getUserRegData());
		return uiform;
	}

	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * ��֤��½�Ƿ�ɹ�
	 * @param Object ��½����
	 * @return OptUserInfoForm �ɹ����ص�½����ʧ�ܷ��ؿ�
	 * */
	public OptUserInfoForm loginIsOK(Object ob){
		OptUserInfoForm uiform=(OptUserInfoForm) ob;
		
		//��ActionForm����ת��Ϊ�־û����Ա���DAOʹ��
		UserInfo ui=new UserInfo();
		ui.setUserName(uiform.getUsername());
		ui.setUserPassword(uiform.getUserpassword());
		ui.setBranchInfo(daos.getBranchinfodao().findById(new Integer(uiform.getBranchid())));
		
		//����Dao��������֤��½
		//������ؽ������գ����־û���ת��ΪActionForm
		if (daos.getUserinfodao().loginIsOK(ui)!=null) {
			ui=daos.getUserinfodao().loginIsOK(ui);
			uiform.setUserid(ui.getUserId().toString());
			uiform.setUsername(ui.getUserName());
			uiform.setUserpassword(ui.getUserPassword());
			uiform.setBranchid(ui.getBranchInfo().getBranchId().toString());
			uiform.setUserrname(ui.getUserRname());
			uiform.setUsersex(ui.getUserSex());
			uiform.setDepartmentid(ui.getDepartmentInfo().getDepartmentId().toString());
			uiform.setDepartmentname(ui.getDepartmentInfo().getDepartmentName());
			uiform.setUserphone(ui.getUserPhone());
			uiform.setUsercardid(ui.getUserCardId());
			uiform.setRoleid(ui.getRoleInfo().getRoleId().toString());
			uiform.setUserloginnum(ui.getUserLoginNum());
			uiform.setUserlogindata(ui.getUserLoginData());
			uiform.setUserregdata(ui.getUserRegData());
			
			//ִ��UserInfoDAO���·��������µ�ǰ��½�û��ĵ�½����������¼ʱ��
			UserInfo newui = this.daos.getUserinfodao().findById(new Integer(uiform.getUserid()));
			int loginnum=Integer.parseInt(uiform.getUserloginnum())+1;
			String date=new java.util.Date().toString();
			newui.setUserLoginData(date);
			newui.setUserLoginNum(loginnum+"");
			
			//ִ��SystemLogDAO��ӷ��������ϵͳ��־
			SystemLog sl = new SystemLog();
			sl.setBranchInfo(ui.getBranchInfo());
			sl.setUserInfo(ui);
			sl.setSystemLogMemo("��½��Ϣ:"+uiform.getUserid()+"("+uiform.getUsername()+"),"+date);
			this.daos.getSystemlogdao().save(sl);
			
			//����Dao���������µ�ǰ��¼�û���Ϣ
			this.daos.getUserinfodao().attachDirty(newui);

			
			//���ص�½����
			return uiform;
		}
		return null;
	}

	public DAOService getDaos() {
		return daos;
	}

	public void setDaos(DAOService daos) {
		this.daos = daos;
	}

}
