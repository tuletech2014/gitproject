package com.bu.yasak;

import java.util.*;

import com.struts.form.*;
import com.po.*;
import com.service.*;

public class BillInBranchBusiness implements IBusiness {
	private DAOService daos;
	public DAOService getDaos() {
		return daos;
	}

	public void setDaos(DAOService daos) {
		this.daos = daos;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector findByBillAll(String str) {
		// TODO Auto-generated method stub
		Vector vcbill = new Vector();
		List ls = daos.getBillinfodao().findByAllTwo(str);
		for (Object object : ls) {
			BillInfo bf = (BillInfo) object;
			Yasak_BillInfoForm ybf = new Yasak_BillInfoForm();
			ybf.setBillId(bf.getBillId().toString());
			//��ȡ����������
			ybf.setSendId(bf.getCustomerInfoBySendId().getCustomerId().toString());
			ybf.setSendName(bf.getCustomerInfoBySendId().getCustomerName());
			//��ȡ�ջ�������
			ybf.setReceiveId(bf.getCustomerInfoByReceiveId().getCustomerId().toString());
			ybf.setReceiveName(bf.getCustomerInfoByReceiveId().getCustomerName());
			//��ȡ�û�����
			ybf.setUserId(bf.getUserInfo().getUserId().toString());
			ybf.setUserName(bf.getUserInfo().getUserName());
			//��ȡ�Ƶ�ʱ��
			ybf.setBillData(bf.getBillData());
			//��ȡ��Ʊ״̬����
			ybf.setBillDataId(bf.getBillState().getBillStateId().toString());
			ybf.setBillDataName(bf.getBillState().getBillStateName());
			String id = bf.getBillState().getBillStateId().toString();
			if (!id.equals("1006")) {
				continue;
			}
			//��ȡ������˾�ֿ�����
			ybf.setSendBranchId(bf.getBranchInfoBySendBranchId().getBranchId().toString());
			ybf.setSendBranchName(bf.getBranchInfoBySendBranchId().getBranchName());
			//��ȡ�ջ���˾�ֿ�����
			ybf.setReceiveBranchId(bf.getBranchInfoByReceiveBranchId().getBranchId().toString());
			ybf.setReceiveBranchName(bf.getBranchInfoByReceiveBranchId().getBranchName());
			vcbill.add(ybf);
		}
		return vcbill;
	}

	public Object findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		return false;
	}

}
