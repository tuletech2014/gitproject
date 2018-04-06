package com.plugin;

import java.util.Vector;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.service.CarmackBusinessService;

public class Carmark_PlugIn implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet servlet, ModuleConfig arg1)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Carmack�������������......");

		// ��ȡSpring���������Ĺ�ϵ����
		ApplicationContext ctx = new FileSystemXmlApplicationContext(servlet
				.getServletContext().getRealPath("")
				+ "/WEB-INF/Carmack_Spring.xml");

		//��ȡCarmackҵ�������
		CarmackBusinessService cbus = (CarmackBusinessService) ctx.getBean("carmackbusinessservice");
		
		//��ȡ�����ͺż�����Ϣ
		Vector tmvc = cbus.getTruckmodelbu().findAll();
		System.out.println("�����ͺ����ݳ��ȣ�"+tmvc.size());
		
		//��������Ϣ���õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("CarmackTMvc", tmvc);
		
		System.out.println("Carmack����������......");
	}

}
