package com.plugin;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.*;
import org.springframework.context.support.*;
import com.service.*;

import java.util.*;

public class MosterPlugin implements PlugIn {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet servlet, ModuleConfig arg1)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("�����������...");
		//��ȡSPRING�����������Ĺ�ϵ
		ApplicationContext ctx=new FileSystemXmlApplicationContext(servlet.getServletContext().getRealPath("")+"/WEB-INF/Moster_Spring.xml");

		System.out.println("��ȡspring�����������Ĺ�ϵ���....");
		//��ȡҵ����������
		MosterBuService mbs = (MosterBuService)ctx.getBean("mosterbuservice");
		//��ȡ��Ʊ״̬����
		Vector vcbs = mbs.getMobillstatebuss().findAll();
		//����Ʊ״̬�������õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("mostervcbs", vcbs);

		System.out.println("��Ʊ״̬���ݣ�"+vcbs.size());
		//��ȡ��˾����
		Vector vcbi = mbs.getMobribuss().findAll();
		//����˾�������õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("mostervcbr", vcbi);
		System.out.println("��˾���ݣ�"+vcbi.size());
		//��ȡ�û�����
		Vector vcus = mbs.getMousinfobuss().findAll();
		//���û��������õ������Ĺ�ϵ��
		servlet.getServletContext().setAttribute("mostervcus", vcus);
		System.out.println("�û����ݣ�"+vcus.size());
		System.out.println("����������.......");
	}

}
