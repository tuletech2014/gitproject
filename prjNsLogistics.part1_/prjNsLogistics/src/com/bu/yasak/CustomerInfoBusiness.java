package com.bu.yasak;

import java.util.*;

import com.po.*;
import com.service.*;
import com.struts.form.*;

public class CustomerInfoBusiness implements IBusiness {
	private DAOService daos; 
	public DAOService getDaos() {
		return daos;
	}

	public void setDaos(DAOService daos) {
		this.daos = daos;
	}
	//�� id ɾ���ͻ���Ϣ
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		CustomerInfo cusinfo = daos.getCustomerinfodao().findById(new Integer(id));
		try {
			//ɾ���ͻ���Ϣ����
			daos.getCustomerinfodao().delete(cusinfo);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//�������пͻ���Ϣ
	public Vector findAll() {
		// TODO Auto-generated method stub
		Vector vccus=new Vector();
		List ls = daos.getCustomerinfodao().findAll();
		for (Object object : ls) {
			CustomerInfo cusinfo = (CustomerInfo) object;
			Yasak_CustomerForm ycf = new Yasak_CustomerForm();
			ycf.setCustomerId(cusinfo.getCustomerId().toString());
			ycf.setCustomerName(cusinfo.getCustomerName());
			ycf.setCustomerLinkMan(cusinfo.getCustomerLinkMan());
			ycf.setCustomerSex(cusinfo.getCustomerSex());
			ycf.setCustomerPhone(cusinfo.getCustomerPhone());
			ycf.setCustomerFax(cusinfo.getCustomerFax());
			ycf.setCustomerPostId(cusinfo.getCustomerPostId());
			ycf.setCustomerEmail(cusinfo.getCustomerEmail());
			ycf.setCustomerRegData(cusinfo.getCustomerRegData());
			//��ȡ�ֹ�˾�ֿ�����
			ycf.setBranchId(cusinfo.getBranchInfo().getBranchId().toString());
			ycf.setBranchName(cusinfo.getBranchInfo().getBranchName());
			vccus.add(ycf);
		}
		return vccus;
	}
	//���ݿͻ�Id���ҿͻ���Ϣ
	public Object findById(String id) {
		// TODO Auto-generated method stub
		CustomerInfo cusinfo = daos.getCustomerinfodao().findById(new Integer(id));
		Yasak_CustomerForm ycf = new Yasak_CustomerForm();
		ycf.setCustomerId(cusinfo.getCustomerId().toString());
		ycf.setCustomerName(cusinfo.getCustomerName());
		ycf.setCustomerLinkMan(cusinfo.getCustomerLinkMan());
		ycf.setCustomerSex(cusinfo.getCustomerSex());
		ycf.setCustomerPhone(cusinfo.getCustomerPhone());
		ycf.setCustomerFax(cusinfo.getCustomerFax());
		ycf.setCustomerPostId(cusinfo.getCustomerPostId());
		ycf.setCustomerEmail(cusinfo.getCustomerEmail());
		ycf.setCustomerRegData(cusinfo.getCustomerRegData());
		//��ȡ�ֹ�˾�ֿ�����
		ycf.setBranchId(cusinfo.getBranchInfo().getBranchId().toString());
		ycf.setBranchName(cusinfo.getBranchInfo().getBranchName());
		
		return ycf;
	}
	//�����ݿ��б���ͻ�����
	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		Yasak_CustomerForm ycf = (Yasak_CustomerForm) ob;
		CustomerInfo cusinfo = new CustomerInfo();
		cusinfo.setCustomerName(ycf.getCustomerName());
		cusinfo.setCustomerLinkMan(ycf.getCustomerLinkMan());
		cusinfo.setCustomerSex(ycf.getCustomerSex());
		cusinfo.setCustomerPhone(ycf.getCustomerPhone());
		cusinfo.setCustomerFax(ycf.getCustomerFax());
		cusinfo.setCustomerPostId(ycf.getCustomerPostId());
		cusinfo.setCustomerEmail(ycf.getCustomerEmail());
		cusinfo.setCustomerRegData(ycf.getCustomerRegData());
		//���÷ֹ�˾�ֿ����ݣ���ȡ�ֹ�˾�ֿ����
		BranchInfo bran = daos.getBranchinfodao().findById(new Integer(ycf.getBranchId()));
		cusinfo.setBranchInfo(bran);
		try {
			//����ͻ���Ϣ����
			daos.getCustomerinfodao().save(cusinfo);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//���ݿͻ�Id���¿ͻ���Ϣ
	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		Yasak_CustomerForm ycf = (Yasak_CustomerForm) ob;
		CustomerInfo cusinfo = daos.getCustomerinfodao().findById(new Integer(ycf.getCustomerId()));
		cusinfo.setCustomerName(ycf.getCustomerName());
		cusinfo.setCustomerLinkMan(ycf.getCustomerLinkMan());
		cusinfo.setCustomerSex(ycf.getCustomerSex());
		cusinfo.setCustomerPhone(ycf.getCustomerPhone());
		cusinfo.setCustomerFax(ycf.getCustomerFax());
		cusinfo.setCustomerPostId(ycf.getCustomerPostId());
		cusinfo.setCustomerEmail(ycf.getCustomerEmail());
		cusinfo.setCustomerRegData(ycf.getCustomerRegData());
		//���÷ֹ�˾�ֿ����ݣ���ȡ�ֹ�˾����
		BranchInfo bran = daos.getBranchinfodao().findById(new Integer(ycf.getBranchId()));
		cusinfo.setBranchInfo(bran);
		try {
			//���¿ͻ���Ϣ����
			daos.getCustomerinfodao().attachDirty(cusinfo);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector findByBillAll(String str) {
		// TODO Auto-generated method stub
		Vector vccus=new Vector();
		List ls = daos.getCustomerinfodao().findByAll(str);
		for (Object object : ls) {
			CustomerInfo cusinfo = (CustomerInfo) object;
			Yasak_CustomerForm ycf = new Yasak_CustomerForm();
			ycf.setCustomerId(cusinfo.getCustomerId().toString());
			ycf.setCustomerName(cusinfo.getCustomerName());
			ycf.setCustomerLinkMan(cusinfo.getCustomerLinkMan());
			ycf.setCustomerSex(cusinfo.getCustomerSex());
			ycf.setCustomerPhone(cusinfo.getCustomerPhone());
			ycf.setCustomerFax(cusinfo.getCustomerFax());
			ycf.setCustomerPostId(cusinfo.getCustomerPostId());
			ycf.setCustomerEmail(cusinfo.getCustomerEmail());
			ycf.setCustomerRegData(cusinfo.getCustomerRegData());
			//��ȡ�ֹ�˾�ֿ�����
			ycf.setBranchId(cusinfo.getBranchInfo().getBranchId().toString());
			ycf.setBranchName(cusinfo.getBranchInfo().getBranchName());
			vccus.add(ycf);
		}
		return vccus;
	}
	



}
