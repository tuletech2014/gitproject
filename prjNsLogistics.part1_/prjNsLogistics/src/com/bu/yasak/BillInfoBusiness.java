package com.bu.yasak;

import java.util.*;

import com.struts.form.*;
import com.po.*;
import com.service.*;

public class BillInfoBusiness implements IBusiness {
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
	//�鿴���л�Ʊ��Ϣ
	/* (non-Javadoc)
	 * @see com.bu.yasak.IBusiness#findAll()
	 */
	public Vector findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	//������Ʊ��Ϣ
	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		Yasak_BillInfoForm ybf = (Yasak_BillInfoForm) ob;
		BillInfo bf = new BillInfo();
		//���÷����ͻ����ݣ���ȡ�����ͻ�����
		CustomerInfo send = daos.getCustomerinfodao().findById(new Integer(ybf.getSendId()));
		bf.setCustomerInfoBySendId(send);
		//�����ջ��ͻ����ݣ���ȡ�ջ��ͻ�����
		CustomerInfo receive = daos.getCustomerinfodao().findById(new Integer(ybf.getReceiveId()));
		bf.setCustomerInfoByReceiveId(receive);
		//�����û����ݣ���ȡ�û�����
		UserInfo us = daos.getUserinfodao().findById(new Integer(ybf.getUserId()));
		bf.setUserInfo(us);
		//��ȡ�Ƶ�ʱ��
		bf.setBillData(ybf.getBillData());
		//���û�Ʊ״̬���ݣ���ȡ��Ʊ״̬����
		BillState bstate = daos.getBillstatedao().findById(new Integer(ybf.getBillDataId()));
		bf.setBillState(bstate);
		//���÷����ֹ�˾�ֿ����ݣ���ȡ�����ֹ�˾����
		BranchInfo sendbran = daos.getBranchinfodao().findById(new Integer(ybf.getSendBranchId()));
		bf.setBranchInfoBySendBranchId(sendbran);
		//�����ջ��ֹ�˾�ֿ����ݣ���ȡ�ջ���˾����
		BranchInfo receivebran = daos.getBranchinfodao().findById(new Integer(ybf.getReceiveBranchId()));
		bf.setBranchInfoByReceiveBranchId(receivebran);
		try {
			//�����Ʊ��Ϣ
			daos.getBillinfodao().save(bf);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//�޸Ļ�Ʊ��Ϣ
	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		Yasak_BillInfoForm ybf = (Yasak_BillInfoForm) ob;
		BillInfo bf = daos.getBillinfodao().findById(new Integer(ybf.getBillId()));
		//���÷����ͻ����ݣ���ȡ�����ͻ�����
		CustomerInfo send = daos.getCustomerinfodao().findById(new Integer(ybf.getSendId()));
		bf.setCustomerInfoBySendId(send);
		//�����ջ��ͻ����ݣ���ȡ�ջ��ͻ�����
		CustomerInfo receive = daos.getCustomerinfodao().findById(new Integer(ybf.getReceiveId()));
		bf.setCustomerInfoByReceiveId(receive);
		//�����û����ݣ���ȡ�û�����
		UserInfo us = daos.getUserinfodao().findById(new Integer(ybf.getUserId()));
		bf.setUserInfo(us);
		//��ȡ�Ƶ�ʱ��
		bf.setBillData(ybf.getBillData());
		//���û�Ʊ״̬���ݣ���ȡ��Ʊ״̬����
		BillState bstate = daos.getBillstatedao().findById(new Integer(ybf.getBillDataId()));
		bf.setBillState(bstate);
		//���÷����ֹ�˾�ֿ����ݣ���ȡ�����ֹ�˾����
		BranchInfo sendbran = daos.getBranchinfodao().findById(new Integer(ybf.getSendBranchId()));
		bf.setBranchInfoBySendBranchId(sendbran);
		//�����ջ���˾�ֿ����ݣ���ȡ�ջ���˾����
		BranchInfo receivebran = daos.getBranchinfodao().findById(new Integer(ybf.getReceiveBranchId()));
		bf.setBranchInfoByReceiveBranchId(receivebran);
		try {
			//�޸Ļ�Ʊ��Ϣ
			daos.getBillinfodao().attachDirty(bf);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector findByBillAll(String str) {
		// TODO Auto-generated method stub
		Vector vcbill = new Vector();
		List ls = daos.getBillinfodao().findByAll(str);
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
			if (!id.equals("1000")) {
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

}
