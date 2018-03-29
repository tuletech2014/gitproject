package com.plugin;

import java.util.Vector;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

import com.service.CarmackBusinessService;
import com.service.OptBuService;

public class Opt_PlugIn implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet servlet, ModuleConfig arg1)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Opt�������������......");
		
		//��ȡSpring���������Ĺ�ϵ����
		ApplicationContext ctx=new FileSystemXmlApplicationContext(servlet.getServletContext().getRealPath("")+"/WEB-INF/Opt_Spring.xml");
		
		//��ȡOptҵ�������
		OptBuService obus=(OptBuService) ctx.getBean("OptBuService");
		
		//��ȡ�ֹ�˾�����š�Ȩ�޽�ɫ�ȼ�����Ϣ
		Vector depvc = obus.getDepbuss().findAll();
		System.out.println("�������ݳ��ȣ�"+depvc.size());
		Vector branchvc=obus.getBranchbuss().findAll();
		System.out.println("�ֹ�˾���ݳ��ȣ�"+branchvc.size());
		Vector rolevc = obus.getRolebuss().findAll();
		System.out.println("Ȩ�޽�ɫ���ݳ��ȣ�"+rolevc.size());
		Vector drivervc = obus.getDriverbuss().findAll();
		System.out.println("˾�����ݳ��ȣ�"+drivervc.size());
		Vector truckvc = obus.getTruckbuss().findAll();
		System.out.println("�������ݳ��ȣ�"+truckvc.size());
	
		//��������Ϣ���õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("Optdepvc", depvc);
		servlet.getServletContext().setAttribute("Optbranchvc", branchvc);
		servlet.getServletContext().setAttribute("Optrolevc", rolevc);
		servlet.getServletContext().setAttribute("Optdrivervc", drivervc);
		servlet.getServletContext().setAttribute("Opttruckvc", truckvc);
		
		System.out.println("Opt����������......");
	}

}
