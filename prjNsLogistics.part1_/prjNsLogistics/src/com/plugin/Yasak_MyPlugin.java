package com.plugin;

import java.util.Vector;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.service.Yasak_BusinessService;

public class Yasak_MyPlugin implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet servlet, ModuleConfig arg1)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("�����������........");
		//��ȡspring�����������Ĺ�ϵ����
		ApplicationContext ctx = new FileSystemXmlApplicationContext(servlet.getServletContext().getRealPath("")+"/WEB-INF/Yasak_Spring.xml");
		System.out.println("��ȡspring�����������Ĺ�ϵ���.........");
		//��ȡ�������
		Yasak_BusinessService ybs=(Yasak_BusinessService) ctx.getBean("Yasak_BusinessService");
		//��ȡ�ֹ�˾�ֿ������
		Vector vcbranch = ybs.getBranchbu().findAll();
		System.out.println("�ֹ�˾�ֿ�����------->"+vcbranch.size());
		//���ֹ�˾�ֿ��������õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("Yasak_vcbranch", vcbranch);
		System.out.println("����������........");
	}

}
