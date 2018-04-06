/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.service.OptBuService;
import com.struts.form.OptBranchInfoForm;
import com.struts.form.OptOperationForm;
import com.struts.form.OptRoleInfoForm;
import com.struts.form.OptUserInfoForm;

/**
 * MyEclipse Struts Creation date: 08-16-2007
 * 
 * XDoclet definition:
 * 
 * @struts.action
 */
public class OptOperationTreeAction extends Action {
	/*
	 * Generated Methods
	 */

	// 声明私有的BuService对象
	private OptBuService bus;

	public OptBuService getBus() {
		return bus;
	}

	public void setBus(OptBuService bus) {
		this.bus = bus;
	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OptUserInfoForm uiform = new OptUserInfoForm();
		OptBranchInfoForm bi = new OptBranchInfoForm();
		try {
			uiform = (OptUserInfoForm) request.getSession(true).getAttribute(
					"loginer");
			bi = (OptBranchInfoForm) request.getSession(true).getAttribute(
					"loginBranch");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			return null;
		}

		// 获取登录用户身份的权限对象
		OptRoleInfoForm roform = (OptRoleInfoForm) bus.getRolebuss().findByID(
				uiform.getRoleid());

		// 获取前台传来的树的节点
		String node = request.getParameter("node");

		// 根据条件拼写Json字符串
		Vector opvc = bus.getOperabuss().findByFID(node);

		String json = "[";

		if (node.equals("0")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				if (oof.getOpid().equals("6") && bi.getBranchid().equals("100")) {
					json += "{id:'" + oof.getOpid() + "',text:'"
							+ oof.getOpname() + "',qtip:'" + oof.getOpname()
							+ "',leaf:true,href:'" + oof.getOpurl() + "'}";
				} else {
					if (oof.getOpid().equals("6")) {
						continue;
					}
					json += "{id:'" + oof.getOpid() + "',text:'"
							+ oof.getOpname() + "',qtip:'" + oof.getOpname()
							+ "',href:''}";
				}
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		// 客户服务权限
		if (node.equals("1") && roform.getRoleclient().equals("1")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				json += "{id:'" + oof.getOpid() + "',text:'" + oof.getOpname()
						+ "',qtip:'" + oof.getOpname() + "',leaf:true,href:'"
						+ oof.getOpurl() + "'}";
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		// 仓库管理权限
		if (node.equals("2") && roform.getRolebranch().equals("1")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				json += "{id:'" + oof.getOpid() + "',text:'" + oof.getOpname()
						+ "',qtip:'" + oof.getOpname() + "',leaf:true,href:'"
						+ oof.getOpurl() + "'}";
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		// 物流运输权限
		if (node.equals("3") && roform.getRoletraffic().equals("1")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				json += "{id:'" + oof.getOpid() + "',text:'" + oof.getOpname()
						+ "',qtip:'" + oof.getOpname() + "',leaf:true,href:'"
						+ oof.getOpurl() + "'}";
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		// 综合查询权限
		if (node.equals("4") && roform.getRolequery().equals("1")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				json += "{id:'" + oof.getOpid() + "',text:'" + oof.getOpname()
						+ "',qtip:'" + oof.getOpname() + "',leaf:true,href:'"
						+ oof.getOpurl() + "'}";
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		// 系统设置权限
		if (node.equals("5") && roform.getRolebasicinfo().equals("1")) {
			for (int i = 0; i < opvc.size(); i++) {
				OptOperationForm oof = (OptOperationForm) opvc.get(i);
				json += "{id:'" + oof.getOpid() + "',text:'" + oof.getOpname()
						+ "',qtip:'" + oof.getOpname() + "',leaf:true,href:'"
						+ oof.getOpurl() + "'}";
				if (i + 1 != opvc.size()) {
					json += ",";
				}
			}
		}
		json += "]";

		//将拼写好的Json字符串放置到Request的作用域中
		request.setAttribute("TreeJson", json);

		return mapping.findForward("TreeJson");
	}

}