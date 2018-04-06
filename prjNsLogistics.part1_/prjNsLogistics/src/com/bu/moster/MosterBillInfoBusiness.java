package com.bu.moster;

import java.util.*;

import com.service.*;
import com.po.*;
import com.struts.form.*;


public class MosterBillInfoBusiness implements MosterBusiness {

	private DAOService ds;
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector findAll() {
		// TODO Auto-generated method stub
		List ls = ds.getBillinfodao().findAll();
		Vector vcbi = new Vector();
		for (Object object : ls) {
			BillInfo bi = (BillInfo)object;
			//������Ʊ��Ϣ��Ķ���
			MosterBillInfoForm mobif = new MosterBillInfoForm();
			
			mobif.setBillID(bi.getBillId().toString());
			//��ȡ����������
			mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
			mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
			//��ȡ�ջ�������
			mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
			mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
			mobif.setTruckLine(bi.getTruckLine());
			mobif.setPayerName(bi.getPayerName());
			//��ȡ�û�����
			mobif.setUserID(bi.getUserInfo().getUserId().toString());
			mobif.setUserName(bi.getUserInfo().getUserName());
			mobif.setBillData(bi.getBillData());
			//��ȡ��Ʊ��Ϣ����
			mobif.setBillStateID(bi.getBillState().getBillStateId().toString());
			mobif.setBillStateName(bi.getBillState().getBillStateName());
			mobif.setBillMemo(bi.getBillMemo());
			//��ȡ��������˾����
			mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
			mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
			//��ȡ�ջ�����˾����
			mobif.setReceiveBranchID(bi.getBranchInfoByReceiveBranchId().getBranchId().toString());
			mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
			
			//�������Ｏ�϶���
			Vector cargos=new Vector();
			//��ȡ���Ｏ��
			Set cgi = bi.getCargoVectors();
			if(cgi!=null||!cgi.isEmpty()){
				Iterator it = cgi.iterator();
				//��ȡ���Ｏ�϶���
				while(it.hasNext()){
					CargoVector cv = (CargoVector) it.next();
					//ͨ�����Ｏ�϶����ȡ������󣬲����õ����Ｏ����
					CargoInfo ci = cv.getCargoInfo();
					MosterCargoInfoForm mocif = new MosterCargoInfoForm();
					mocif.setCargoID(ci.getCargoId().toString());
					mocif.setCargoName(ci.getCargoName());
					mocif.setCargoWeight(ci.getCargoWeight());
					mocif.setCargoBulk(ci.getCargoBulk());
					mocif.setCargoNum(ci.getCargoNum());
					mocif.setCargoUnit(ci.getCargoUnit());
					mocif.setCargoValue(ci.getCargoValue());
					mocif.setCargoFreight(ci.getCargoFreight());
					mocif.setCargoAmends(ci.getCargoAmends());
					mocif.setCargoMemo(ci.getCargoMemo());
					if(ci.getCargoState()==0){
						mocif.setCargoState("���");
					}
					if(ci.getCargoState()==1){
						mocif.setCargoState("��;");
					}
					if(ci.getCargoState()==2){
						mocif.setCargoState("����");
					}
					
					
					//��ȡ��˾����
					mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
					mocif.setBranchName(ci.getBranchInfo().getBranchName());				
					mocif.setCargoStartData(ci.getCargoStartData());
					mocif.setCargoEndData(ci.getCargoEndData());
					cargos.add(mocif);
				}				
			}
			mobif.setCargos(cargos);
			vcbi.add(mobif);
			
		}
		return vcbi;
	}

	public Object findById(String id) {
		// TODO Auto-generated method stub
		BillInfo bi = ds.getBillinfodao().findById(new Integer(id));
		//������Ʊ��Ϣ�����
		MosterBillInfoForm mobif = new MosterBillInfoForm();
		mobif.setBillID(bi.getBillId().toString());
		//��ȡ����������
		mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
		mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
		//��ȡ�ջ�������
		mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
		mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
		mobif.setTruckLine(bi.getTruckLine());
		mobif.setPayerName(bi.getPayerName());
		//��ȡ�û�����
		mobif.setUserID(bi.getUserInfo().getUserId().toString());
		mobif.setUserName(bi.getUserInfo().getUserName());
		mobif.setBillData(bi.getBillData());
		//��ȡ��Ʊ��Ϣ����
		mobif.setBillStateID(bi.getBillState().getBillStateId().toString());
		mobif.setBillStateName(bi.getBillState().getBillStateName());
		mobif.setBillMemo(bi.getBillMemo());
		//��ȡ��������˾����
		mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
		mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
		//��ȡ�ջ�����˾����
		mobif.setReceiveBranchID(bi.getBranchInfoByReceiveBranchId().getBranchId().toString());
		mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
		
		//�������Ｏ�϶���
		Vector cargos=new Vector();
		//��ȡ���Ｏ��
		Set cgi = bi.getCargoVectors();
		if(cgi!=null||!cgi.isEmpty()){
			Iterator it = cgi.iterator();
			//��ȡ���Ｏ�϶���
			while(it.hasNext()){
				CargoVector cv = (CargoVector) it.next();
				//ͨ�����Ｏ�϶����ȡ������󣬲����õ����Ｏ����
				CargoInfo ci = cv.getCargoInfo();
				MosterCargoInfoForm mocif = new MosterCargoInfoForm();
				mocif.setCargoID(ci.getCargoId().toString());
				mocif.setCargoName(ci.getCargoName());
				mocif.setCargoWeight(ci.getCargoWeight());
				mocif.setCargoBulk(ci.getCargoBulk());
				mocif.setCargoNum(ci.getCargoNum());
				mocif.setCargoUnit(ci.getCargoUnit());
				mocif.setCargoValue(ci.getCargoValue());
				mocif.setCargoFreight(ci.getCargoFreight());
				mocif.setCargoAmends(ci.getCargoAmends());
				mocif.setCargoMemo(ci.getCargoMemo());
				if(ci.getCargoState()==0){
					mocif.setCargoState("���");
				}
				if(ci.getCargoState()==1){
					mocif.setCargoState("��;");
				}
				if(ci.getCargoState()==2){
					mocif.setCargoState("����");
				}
				//��ȡ��˾����
				mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
				mocif.setBranchName(ci.getBranchInfo().getBranchName());				
				mocif.setCargoStartData(ci.getCargoStartData());
				mocif.setCargoEndData(ci.getCargoEndData());
				cargos.add(mocif);
			}				
		}
		mobif.setCargos(cargos);
		return mobif;
	}

	public boolean save(Object ob) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Object ob) {
		// TODO Auto-generated method stub
		MosterBillInfoForm mobif = (MosterBillInfoForm) ob;

		BillInfo b = ds.getBillinfodao().findById(new Integer(mobif.getBillID()));
		
		
		//��ȡ�û����������û�ID����
		UserInfo ui = ds.getUserinfodao().findById(new Integer(mobif.getUserID()));
		b.setUserInfo(ui);
		//���û�Ʊ״̬���ݣ���ȡ��Ʊ״̬��Ķ���
		BillState bs = ds.getBillstatedao().findById(new Integer(mobif.getBillStateID())); 
		b.setBillState(bs);
		b.setBillMemo(mobif.getBillMemo());
		try {
			//���»�Ʊ��Ϣ
			ds.getBillinfodao().attachDirty(b);
			return true;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	//���ݹ�˾��ţ����ұ���˾���еĻ�Ʊ���
	public Vector findByBranchID(int branchID){
		// TODO Auto-generated method stub
		List ls = ds.getBillinfodao().findByBranchID(branchID);
		Vector vcbill = new Vector();
		for (Object object : ls) {
			BillInfo bi = (BillInfo) object;
			//����������Ϣ�����
			MosterBillInfoForm mobif = new MosterBillInfoForm();
			mobif.setBillID(bi.getBillId().toString());
			vcbill.add(mobif);
			
		}
		return vcbill;
		
	}
	
	public Vector findByBillState(int id){
		// TODO Auto-generated method stub
		List ls = ds.getBillinfodao().findByBillStateID(id);
		Vector vcbi = new Vector();
		for (Object object : ls) {
			BillInfo bi = (BillInfo)object;
			//������Ʊ��Ϣ��Ķ���
			MosterBillInfoForm mobif = new MosterBillInfoForm();
			mobif.setBillID(bi.getBillId().toString());
			//��ȡ����������
			mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
			mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
			//��ȡ�ջ�������
			mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
			mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
			mobif.setTruckLine(bi.getTruckLine());
			mobif.setPayerName(bi.getPayerName());
			//��ȡ�û�����
			mobif.setUserID(bi.getUserInfo().getUserId().toString());
			mobif.setUserName(bi.getUserInfo().getUserName());
			mobif.setBillData(bi.getBillData());
			//��ȡ��Ʊ��Ϣ����
			mobif.setBillStateID(bi.getBillState().getBillStateId().toString());
			mobif.setBillStateName(bi.getBillState().getBillStateName());
			mobif.setBillMemo(bi.getBillMemo());
			//��ȡ��������˾����
			mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
			mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
			//��ȡ�ջ�����˾����
			mobif.setReceiveBranchID(bi.getBranchInfoByReceiveBranchId().getBranchId().toString());
			mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
			
			//�������Ｏ�϶���
			Vector cargos=new Vector();
			//��ȡ���Ｏ��
			Set cgi = bi.getCargoVectors();
			if(cgi!=null||!cgi.isEmpty()){
				Iterator it = cgi.iterator();
				//��ȡ���Ｏ�϶���
				while(it.hasNext()){
					CargoVector cv = (CargoVector) it.next();
					//ͨ�����Ｏ�϶����ȡ������󣬲����õ����Ｏ����
					CargoInfo ci = cv.getCargoInfo();
					MosterCargoInfoForm mocif = new MosterCargoInfoForm();
					mocif.setCargoID(ci.getCargoId().toString());
					mocif.setCargoName(ci.getCargoName());
					mocif.setCargoWeight(ci.getCargoWeight());
					mocif.setCargoBulk(ci.getCargoBulk());
					mocif.setCargoNum(ci.getCargoNum());
					mocif.setCargoUnit(ci.getCargoUnit());
					mocif.setCargoValue(ci.getCargoValue());
					mocif.setCargoFreight(ci.getCargoFreight());
					mocif.setCargoAmends(ci.getCargoAmends());
					mocif.setCargoMemo(ci.getCargoMemo());
					if(ci.getCargoState()==0){
						mocif.setCargoState("���");
					}
					if(ci.getCargoState()==1){
						mocif.setCargoState("��;");
					}
					if(ci.getCargoState()==2){
						mocif.setCargoState("����");
					}
					//��ȡ��˾����
					mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
					mocif.setBranchName(ci.getBranchInfo().getBranchName());				
					mocif.setCargoStartData(ci.getCargoStartData());
					mocif.setCargoEndData(ci.getCargoEndData());
					cargos.add(mocif);
				}				
			}
			mobif.setCargos(cargos);
			vcbi.add(mobif);
			
		}
		return vcbi;
		
	}
	/**
	 * ���ݻ�Ʊ״̬�Լ���˾ID��ѯ��Ʊ��Ϣ
	 * @param int ��Ʊ״̬���
	 * @return Vector ��Ʊ����
	 * */
	public Vector findByBillStateID(int billstateID,int branchID){
		Vector billvc = new Vector();
		List li = new ArrayList();
		if (branchID==0) {
			li=ds.getBillinfodao().findByBillStateID(billstateID);
		}else{
			li = ds.getBillinfodao().findByBillStateID(billstateID,branchID);	
		}
		
		//���־û�����ת��ΪActionForm����
		for (Object object : li) {
			BillInfo bi = (BillInfo) object;
			//������Ʊ��Ϣ��Ķ���
			MosterBillInfoForm mobif = new MosterBillInfoForm();
			mobif.setBillID(bi.getBillId().toString());
			//��ȡ����������
			mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
			mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
			//��ȡ�ջ�������
			mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
			mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
			mobif.setTruckLine(bi.getTruckLine());
			mobif.setPayerName(bi.getPayerName());
			//��ȡ�û�����
			mobif.setUserID(bi.getUserInfo().getUserId().toString());
			mobif.setUserName(bi.getUserInfo().getUserName());
			mobif.setBillData(bi.getBillData());
			//��ȡ��Ʊ��Ϣ����
			mobif.setBillStateID(bi.getBillState().getBillStateId().toString());
			mobif.setBillStateName(bi.getBillState().getBillStateName());
			mobif.setBillMemo(bi.getBillMemo());
			//��ȡ��������˾����
			mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
			mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
			//��ȡ�ջ�����˾����
			mobif.setReceiveBranchID(bi.getBranchInfoByReceiveBranchId().getBranchId().toString());
			mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
			
			//Ϊ��Ʊ��Ϣ��Ӷ�Ӧ�Ļ�����Ϣ�����Լ�����ID����
			Set s = bi.getCargoVectors();
			Vector cargos = new Vector();
			
			if (s!=null||!s.isEmpty()) {
				Iterator it = s.iterator();
				String[] cargoids = new String[s.size()];
				int i=0;
				while(it.hasNext()){
					CargoVector cv = (CargoVector) it.next();
					CargoInfo ci = cv.getCargoInfo();
					MosterCargoInfoForm mocif = new MosterCargoInfoForm();
					mocif.setCargoID(ci.getCargoId().toString());
					mocif.setCargoName(ci.getCargoName());
					mocif.setCargoWeight(ci.getCargoWeight());
					mocif.setCargoBulk(ci.getCargoBulk());
					mocif.setCargoNum(ci.getCargoNum());
					mocif.setCargoUnit(ci.getCargoUnit());
					mocif.setCargoValue(ci.getCargoValue());
					mocif.setCargoFreight(ci.getCargoFreight());
					mocif.setCargoAmends(ci.getCargoAmends());
					mocif.setCargoMemo(ci.getCargoMemo());
					if(ci.getCargoState()==0){
						mocif.setCargoState("���");
					}
					if(ci.getCargoState()==1){
						mocif.setCargoState("��;");
					}
					if(ci.getCargoState()==2){
						mocif.setCargoState("����");
					}
					//��ȡ��˾����
					mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
					mocif.setBranchName(ci.getBranchInfo().getBranchName());				
					mocif.setCargoStartData(ci.getCargoStartData());
					mocif.setCargoEndData(ci.getCargoEndData());
					
					cargos.add(mocif);
					
					cargoids[i]=ci.getCargoId().toString();
					i++;
				}
				
				mobif.setCargoIDs(cargoids);
			}
			
			mobif.setCargos(cargos);
 			
			billvc.add(mobif);
		}
		
		return billvc;
	}
	
	/**
	 * ���ݻ�Ʊ״̬�Լ���˾ID��ѯ��Ʊ��Ϣ
	 * @param int ��Ʊ״̬���
	 * @return Vector ��Ʊ����
	 * */
	public Vector findByBillRecBranchID(int billstateID,int rbranchID){
		Vector billvc = new Vector();
		List li = new ArrayList();
		if (rbranchID==0) {
			li=ds.getBillinfodao().findByBillStateID(billstateID);
			//���־û�����ת��ΪActionForm����
			for (Object object : li) {
				BillInfo bi = (BillInfo) object;
				//������Ʊ��Ϣ��Ķ���
				MosterBillInfoForm mobif = new MosterBillInfoForm();
				mobif.setBillID(bi.getBillId().toString());
				//��ȡ����������
				mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
				mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
				//��ȡ�ջ�������
				mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
				mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
				mobif.setTruckLine(bi.getTruckLine());
				mobif.setPayerName(bi.getPayerName());
				//��ȡ�û�����
				mobif.setUserID(bi.getUserInfo().getUserId().toString());
				mobif.setUserName(bi.getUserInfo().getUserName());
				mobif.setBillData(bi.getBillData());
				//��ȡ��Ʊ��Ϣ����
				Integer state= bi.getBillState().getBillStateId();			
				if(state!=billstateID){
					continue;
				}
				mobif.setBillStateID(state.toString());
				mobif.setBillStateName(bi.getBillState().getBillStateName());
				mobif.setBillMemo(bi.getBillMemo());
				//��ȡ��������˾����
				mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
				mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
				//��ȡ�ջ�����˾����			
				mobif.setReceiveBranchID(bi.getBranchInfoByReceiveBranchId().getBranchId().toString());
				mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
				
				//Ϊ��Ʊ��Ϣ��Ӷ�Ӧ�Ļ�����Ϣ�����Լ�����ID����
				Set s = bi.getCargoVectors();
				Vector cargos = new Vector();
				
				if (s!=null||!s.isEmpty()) {
					Iterator it = s.iterator();
					String[] cargoids = new String[s.size()];
					int i=0;
					while(it.hasNext()){
						CargoVector cv = (CargoVector) it.next();
						CargoInfo ci = cv.getCargoInfo();
						MosterCargoInfoForm mocif = new MosterCargoInfoForm();
						mocif.setCargoID(ci.getCargoId().toString());
						mocif.setCargoName(ci.getCargoName());
						mocif.setCargoWeight(ci.getCargoWeight());
						mocif.setCargoBulk(ci.getCargoBulk());
						mocif.setCargoNum(ci.getCargoNum());
						mocif.setCargoUnit(ci.getCargoUnit());
						mocif.setCargoValue(ci.getCargoValue());
						mocif.setCargoFreight(ci.getCargoFreight());
						mocif.setCargoAmends(ci.getCargoAmends());
						mocif.setCargoMemo(ci.getCargoMemo());
						if(ci.getCargoState()==0){
							mocif.setCargoState("���");
						}
						if(ci.getCargoState()==1){
							mocif.setCargoState("��;");
						}
						if(ci.getCargoState()==2){
							mocif.setCargoState("����");
						}
						//��ȡ��˾����
						mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
						mocif.setBranchName(ci.getBranchInfo().getBranchName());				
						mocif.setCargoStartData(ci.getCargoStartData());
						mocif.setCargoEndData(ci.getCargoEndData());
						
						cargos.add(mocif);
						
						cargoids[i]=ci.getCargoId().toString();
						i++;
					}
					
					mobif.setCargoIDs(cargoids);
				}
				
				mobif.setCargos(cargos);
	 			
				billvc.add(mobif);
			}
		}else{
			li = ds.getBillinfodao().findAll();	
			//���־û�����ת��ΪActionForm����
			for (Object object : li) {
				BillInfo bi = (BillInfo) object;
				//������Ʊ��Ϣ��Ķ���
				MosterBillInfoForm mobif = new MosterBillInfoForm();
				mobif.setBillID(bi.getBillId().toString());
				//��ȡ����������
				mobif.setSendID(bi.getCustomerInfoBySendId().getCustomerId().toString());
				mobif.setSendName(bi.getCustomerInfoBySendId().getCustomerName());
				//��ȡ�ջ�������
				mobif.setReceiveID(bi.getCustomerInfoByReceiveId().getCustomerId().toString());
				mobif.setReceiveName(bi.getCustomerInfoByReceiveId().getCustomerName());
				mobif.setTruckLine(bi.getTruckLine());
				mobif.setPayerName(bi.getPayerName());
				//��ȡ�û�����
				mobif.setUserID(bi.getUserInfo().getUserId().toString());
				mobif.setUserName(bi.getUserInfo().getUserName());
				mobif.setBillData(bi.getBillData());
				//��ȡ��Ʊ��Ϣ����
				Integer state= bi.getBillState().getBillStateId();			
				if(state!=billstateID){
					continue;
				}
				mobif.setBillStateID(state.toString());
				mobif.setBillStateName(bi.getBillState().getBillStateName());
				mobif.setBillMemo(bi.getBillMemo());
				//��ȡ��������˾����
				mobif.setSendBranchID(bi.getBranchInfoBySendBranchId().getBranchId().toString());
				mobif.setSendBranchName(bi.getBranchInfoBySendBranchId().getBranchName());
				//��ȡ�ջ�����˾����
				Integer rbid = bi.getBranchInfoByReceiveBranchId().getBranchId();
				if(rbid!=rbranchID){
					continue;
				}
				mobif.setReceiveBranchID(rbid.toString());
				mobif.setReceiveBranchName(bi.getBranchInfoByReceiveBranchId().getBranchName());
				
				//Ϊ��Ʊ��Ϣ��Ӷ�Ӧ�Ļ�����Ϣ�����Լ�����ID����
				Set s = bi.getCargoVectors();
				Vector cargos = new Vector();
				
				if (s!=null||!s.isEmpty()) {
					Iterator it = s.iterator();
					String[] cargoids = new String[s.size()];
					int i=0;
					while(it.hasNext()){
						CargoVector cv = (CargoVector) it.next();
						CargoInfo ci = cv.getCargoInfo();
						MosterCargoInfoForm mocif = new MosterCargoInfoForm();
						mocif.setCargoID(ci.getCargoId().toString());
						mocif.setCargoName(ci.getCargoName());
						mocif.setCargoWeight(ci.getCargoWeight());
						mocif.setCargoBulk(ci.getCargoBulk());
						mocif.setCargoNum(ci.getCargoNum());
						mocif.setCargoUnit(ci.getCargoUnit());
						mocif.setCargoValue(ci.getCargoValue());
						mocif.setCargoFreight(ci.getCargoFreight());
						mocif.setCargoAmends(ci.getCargoAmends());
						mocif.setCargoMemo(ci.getCargoMemo());
						if(ci.getCargoState()==0){
							mocif.setCargoState("���");
						}
						if(ci.getCargoState()==1){
							mocif.setCargoState("��;");
						}
						if(ci.getCargoState()==2){
							mocif.setCargoState("����");
						}
						//��ȡ��˾����
						mocif.setBranchID(ci.getBranchInfo().getBranchId().toString());
						mocif.setBranchName(ci.getBranchInfo().getBranchName());				
						mocif.setCargoStartData(ci.getCargoStartData());
						mocif.setCargoEndData(ci.getCargoEndData());
						
						cargos.add(mocif);
						
						cargoids[i]=ci.getCargoId().toString();
						i++;
					}
					
					mobif.setCargoIDs(cargoids);
				}
				
				mobif.setCargos(cargos);
	 			
				billvc.add(mobif);
			}
		}
		

		
		return billvc;
	}
	
	public DAOService getDs() {
		return ds;
	}

	public void setDs(DAOService ds) {
		this.ds = ds;
	}

}
