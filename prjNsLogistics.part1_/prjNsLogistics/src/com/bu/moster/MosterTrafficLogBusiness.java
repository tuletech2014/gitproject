package com.bu.moster;

import java.util.*;

import com.service.*;
import com.struts.form.*;
import com.po.*;

public class MosterTrafficLogBusiness implements MosterBusiness {

	private DAOService ds;
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public Vector findAll() {
		// TODO Auto-generated method stub
		List ls = ds.getTrafficlogdao().findAll();
		Vector vc = new Vector();
		for (Object object : ls) {
			TrafficLog tl = (TrafficLog) object;
			//���������¼�����
			MosterTrafficLogForm motlf = new MosterTrafficLogForm();
			motlf.setTrafficLogID(tl.getTrafficLogId().toString());
			motlf.setBillID(tl.getBillInfo().getBillId().toString());
			motlf.setBranchID(tl.getBranchInfo().getBranchId().toString());
			motlf.setBillstate(tl.getBillInfo().getBillState().getBillStateId().toString());
			motlf.setBillStateName(tl.getBillInfo().getBillState().getBillStateName());
			String state= tl.getBillInfo().getBillState().getBillStateId().toString();
			
			if(!state.equals("1003"))
				continue;
						
			motlf.setTLID(tl.getTruckLog().getTlid().toString());
			motlf.setBranchName(tl.getBranchInfo().getBranchName());
			vc.add(motlf);
			
		}
		return vc;
	}
	

	public Object findById(String id) {
		// TODO Auto-generated method stub
		TrafficLog tl = ds.getTrafficlogdao().findById(new Integer(id));
		//���������¼�����
		MosterTrafficLogForm motlf = new MosterTrafficLogForm();
		motlf.setTrafficLogID(tl.getTrafficLogId().toString());
		motlf.setBillID(tl.getBillInfo().getBillId().toString());
		motlf.setBranchID(tl.getBranchInfo().getBranchId().toString());
		motlf.setTLID(tl.getTruckLog().getTlid().toString());
		return motlf;
	}

	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		MosterTrafficLogForm motlf = (MosterTrafficLogForm) ob;
		TrafficLog tl = new TrafficLog();
		//��ȡ��Ʊ�������û�Ʊ��Ϣ
		BillInfo bi = ds.getBillinfodao().findById(new Integer(motlf.getBillID()));
		tl.setBillInfo(bi);
		//��ȡ��˾����,���ù�˾��Ϣ
		BranchInfo br = ds.getBranchinfodao().findById(new Integer(motlf.getBranchID()));
		tl.setBranchInfo(br);
		//��ȡ���ζ���,���ó�����Ϣ
		TruckLog tr = ds.getTrucklogdao().findById(new Integer(motlf.getTLID()));
		tl.setTruckLog(tr);
		try {
			ds.getTrafficlogdao().save(tl);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ���ݻ�Ʊ״̬�Լ���˾ID��ѯ�����¼
	 * @param int ��Ʊ״̬���
	 * @param int �û���˾���
	 * @return Vector ��Ʊ����
	 * */
	public Vector findByStateID(int billstateID,int branchID) {
		// TODO Auto-generated method stub
		List ls = ds.getTrafficlogdao().findAll();
		
		//�����û���˾ID��ѯ
		//�����˾IDΪ0����Ϊ��������Ա����ѯ�����������¼
		if (branchID==0) {
			ls=ds.getTrafficlogdao().findAll();
			
			Vector vc = new Vector();
			for (Object object : ls) {
				TrafficLog tl = (TrafficLog) object;
				//���������¼�����
				MosterTrafficLogForm motlf = new MosterTrafficLogForm();
				motlf.setTrafficLogID(tl.getTrafficLogId().toString());
				motlf.setTLID(tl.getTruckLog().getTlid().toString());
				
				Integer state= tl.getBillInfo().getBillState().getBillStateId();			
				if(state!=billstateID){
					continue;
				}
				motlf.setBillID(tl.getBillInfo().getBillId().toString());
				motlf.setBranchID(tl.getBranchInfo().getBranchId().toString());
				motlf.setBillstate(tl.getBillInfo().getBillState().getBillStateId().toString());
				motlf.setBillStateName(tl.getBillInfo().getBillState().getBillStateName());
				motlf.setBranchName(tl.getBranchInfo().getBranchName());
				motlf.setTruckNum(tl.getTruckLog().getTruckInfo().getTruckNum());
				vc.add(motlf);
				
			}
			return vc;
		}
		//�粻Ϊ0����ֻ��ѯ���û�������˾�����������¼
		else{
			ls=ds.getTrafficlogdao().findAll();
			Vector vc = new Vector();
			for (Object object : ls) {
				TrafficLog tl = (TrafficLog) object;
				//���������¼�����
				MosterTrafficLogForm motlf = new MosterTrafficLogForm();
				motlf.setTrafficLogID(tl.getTrafficLogId().toString());
				motlf.setTLID(tl.getTruckLog().getTlid().toString());
				
				Integer state= tl.getBillInfo().getBillState().getBillStateId();			
				if(state!=billstateID){
					continue;
				}
				//����һ���������������û�Ʊ���ջ���˾��ID
				Integer branch = tl.getBillInfo().getBranchInfoByReceiveBranchId().getBranchId();
				if(branch!=branchID){
					continue;
				}
				motlf.setBillID(tl.getBillInfo().getBillId().toString());
				motlf.setBranchID(tl.getBranchInfo().getBranchId().toString());
				motlf.setBillstate(tl.getBillInfo().getBillState().getBillStateId().toString());
				motlf.setBillStateName(tl.getBillInfo().getBillState().getBillStateName());
				motlf.setBranchName(tl.getBranchInfo().getBranchName());
				motlf.setTruckNum(tl.getTruckLog().getTruckInfo().getTruckNum());
				vc.add(motlf);
				
			}
			return vc;
		}
		
		
	}
	

	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public DAOService getDs() {
		return ds;
	}

	public void setDs(DAOService ds) {
		this.ds = ds;
	}

}
