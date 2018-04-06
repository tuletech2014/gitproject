package com.po;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * BillInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.BillInfo
 * @author MyEclipse Persistence Tools
 */

public class BillInfoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BillInfoDAO.class);
	// property constants
	public static final String TRUCK_LINE = "truckLine";
	public static final String PAYER_NAME = "payerName";
	public static final String BILL_DATA = "billData";
	public static final String BILL_MEMO = "billMemo";

	protected void initDao() {
		// do nothing
	}

	public void save(BillInfo transientInstance) {
		log.debug("saving BillInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BillInfo persistentInstance) {
		log.debug("deleting BillInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BillInfo findById(java.lang.Integer id) {
		log.debug("getting BillInfo instance with id: " + id);
		try {
			BillInfo instance = (BillInfo) getHibernateTemplate().get(
					"com.po.BillInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BillInfo instance) {
		log.debug("finding BillInfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BillInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BillInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTruckLine(Object truckLine) {
		return findByProperty(TRUCK_LINE, truckLine);
	}

	public List findByPayerName(Object payerName) {
		return findByProperty(PAYER_NAME, payerName);
	}

	public List findByBillData(Object billData) {
		return findByProperty(BILL_DATA, billData);
	}

	public List findByBillMemo(Object billMemo) {
		return findByProperty(BILL_MEMO, billMemo);
	}

	public List findAll() {
		log.debug("finding all BillInfo instances");
		try {
			String queryString = "from BillInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BillInfo merge(BillInfo detachedInstance) {
		log.debug("merging BillInfo instance");
		try {
			BillInfo result = (BillInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BillInfo instance) {
		log.debug("attaching dirty BillInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BillInfo instance) {
		log.debug("attaching clean BillInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BillInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BillInfoDAO) ctx.getBean("BillInfoDAO");
	}
	
	/**
	 * ���ݻ�Ʊ״̬��ѯ���л�Ʊ��Ϣ
	 * @param int ��Ʊ״̬���
	 * @param int ������˾���
	 * @return List ��Ʊ���󼯺�
	 * */
	public List findByBillStateID(int billstateID,int branchid){
		String hql = "from BillInfo where BillStateID = ? and SendBranchID=?";
		Query qy = this.getSession(true).createQuery(hql);
		
		qy.setInteger(0, billstateID);
		qy.setInteger(1, branchid);
		
		List li = qy.list();

		return li;
	}
	
	/**
	 * ���ݻ�Ʊ״̬��ѯ���л�Ʊ��Ϣ
	 * @param int ��Ʊ״̬���
	 * @return List ��Ʊ���󼯺�
	 * */
	public List findByBillStateID(int billstateID){
		String hql = "from BillInfo where BillStateID = ?";
		Query qy = this.getSession(true).createQuery(hql);
		
		qy.setInteger(0, billstateID);
		
		List li = qy.list();
		return li;
	}


		
	/**
	 * ��ѯָ����˾�����л�Ʊ
	 * @param int ��˾���
	 * @return List ��Ʊ��Ϣ
	 * */
	public List findByBranchID(int branchID){
		String hql = "from BillInfo where SendBranchID=?";
		Query qy = this.getSession(true).createQuery(hql);
		
		qy.setInteger(0, branchID);
		
		List li = qy.list();
		
		return li;
	}

	//===============================
	public List findByAll(String str) {
		log.debug("finding all BillInfo instances");
		try {
			String queryString = "from BillInfo where SendBranchID="+str;
			System.out.println("������˾���------>"+str);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//===============================
	public List findByAllTwo(String str) {
		log.debug("finding all BillInfo instances");
		try {
			String queryString = "from BillInfo where ReceiveBranchID="+str;
			System.out.println("�ջ���˾���------>"+str);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//===============================

	/**
	 * ����˾���Ƶ�ʱ������л�Ʊ��
	 * */
	public List findByBranchinf(BranchInfo branch,String billstartdata,String billenddata)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo  b where (b.branchInfoBySendBranchId=? or b.branchInfoByReceiveBranchId=?) and (b.billData>? and b.billData<?) ");
		qy.setEntity(0, branch);
		qy.setEntity(1, branch);
		qy.setString(2, billstartdata);
		qy.setString(3, billenddata);
		List ls=qy.list();
		return ls;
	}
	/**
	 * ����˾���Ƶ�ʱ��,��Ʊ״̬,�����л�Ʊ��
	 * */
	public List findByBranchinf(BranchInfo branch,String billstartdata,String billenddata,BillState billstate)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoBySendBranchId=? or b.branchInfoByReceiveBranchId=?) and (b.billData>? and b.billData<?) and (b.billState=?) ");
		
		//��ȡ������˾����
		//BranchInfo branch = this.daos.getBranchinfodao().findById(new Integer(branchid));
		qy.setEntity(0, branch);
		qy.setEntity(1, branch);
		qy.setString(2, billstartdata);
		qy.setString(3, billenddata);
		
		//��ȡ��Ʊ״̬����
		//BillState billstate=this.daos.getBillstatedao().findById(new Integer(billstateid));
		qy.setEntity(4, billstate);
		List ls=qy.list();
		return ls;
	}
	/***
	 * ����˾��������,�Ƶ�ʱ��鷢���Ļ�Ʊ
	 */
	public List findBySendBranch(BranchInfo branch,String billstartdata,String billenddata)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoBySendBranchId=?) and (b.billData>? and b.billData<?)");
		//��ȡ������˾����
		//BranchInfo branch=this.daos.getBranchinfodao().findById(new Integer(branchid));
		qy.setEntity(0, branch);
		qy.setString(1, billstartdata);
		qy.setString(2,billenddata);
		List ls=qy.list();
		return ls;
	}
	/***
	 * ����˾��������,�Ƶ�ʱ��,��Ʊ״̬�鷢���Ļ�Ʊ
	 */
	public List findBySendBranch(BranchInfo branch,String billstartdata,String billenddata,BillState billstate)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoBySendBranchId=?) and (b.billData>? and b.billData<?) and (b.billState=?)");
		//��ȡ������˾����
		//BranchInfo branch=this.daos.getBranchinfodao().findById(new Integer(branchid));
		qy.setEntity(0, branch);
		qy.setString(1, billstartdata);
		qy.setString(2,billenddata);
		qy.setEntity(3, billstate);
		//��ȡ��Ʊ״̬����
		//BillState billstate=this.daos.getBillstatedao().findById(new Integer(billstateid));
		List ls=qy.list();
		return ls;
	}
	/***
	 * ����˾���ջ������Ƶ�ʱ����ջ��Ļ�Ʊ
	 */
	public List findByReceiveBranch(BranchInfo branch,String billstartdata,String billenddata)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoByReceiveBranchId=?) and (b.billData>? and b.billData<?)");
		//��ȡ�ջ�˾����
		//BranchInfo branch=this.daos.getBranchinfodao().findById(new Integer(branchid));
		qy.setEntity(0, branch);
		qy.setString(1, billstartdata);
		qy.setString(2,billenddata);
		List ls=qy.list();
		return ls;
	}
	/***
	 * ����˾���ջ������Ƶ�ʱ��,��Ʊ״̬,���ջ��Ļ�Ʊ
	 */
	public List findByReceiveBranch(BranchInfo branch,String billstartdata,String billenddata,BillState billstate)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoByReceiveBranchId=?) and (b.billData>? and b.billData<?) and (b.billState=?)");
		//��ȡ�ջ�˾����
		//BranchInfo branch=this.daos.getBranchinfodao().findById(new Integer(branchid));
		qy.setEntity(0, branch);
		qy.setString(1, billstartdata);
		qy.setString(2,billenddata);
		//��ȡ��Ʊ״̬����
		//BillState billstate=this.daos.getBillstatedao().findById(new Integer(billstateid));
		qy.setEntity(3, billstate);
		List ls=qy.list();
		return ls;
	}
	/***\
	 * ���ͻ�,�Ƶ�ʱ������л�Ʊ��Ϣ
	 */
	public List findByCustomer(CustomerInfo customer,String billstartdata,String billenddata,BranchInfo branch)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.customerInfoBySendId=? or b.customerInfoByReceiveId=?) and (b.billData>? and b.billData<?)and(b.branchInfoBySendBranchId=? or b.branchInfoByReceiveBranchId=?)");
		//��ȡ�ͻ�����
		//CustomerInfo customer=this.daos.getCustomerinfodao().findById(new Integer(cussendid));
		qy.setEntity(0, customer);
		qy.setEntity(1, customer);
		qy.setString(2, billstartdata);
		qy.setString(3, billenddata);
		qy.setEntity(4, branch);
		qy.setEntity(5, branch);
		List ls=qy.list();
		return ls;
	}
	/***\
	 * ���ͻ�,�Ƶ�ʱ��,��Ʊ״̬,�����л�Ʊ��Ϣ
	 */
	public List findByCustomer(CustomerInfo customer,String billstartdata,String billenddata,BillState billstate,BranchInfo branch)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.customerInfoBySendId=? or b.customerInfoByReceiveId=?) and (b.billData>? and b.billData<?) and (b.billState=?)and(b.branchInfoBySendBranchId=? or b.branchInfoByReceiveBranchId=?)");
		//��ȡ�ͻ�����
		//CustomerInfo customer=this.daos.getCustomerinfodao().findById(new Integer(cussendid));
		qy.setEntity(0, customer);
		qy.setEntity(1, customer);
		qy.setString(2, billstartdata);
		qy.setString(3, billenddata);
		//��ȡ��Ʊ״̬����
		//BillState billstate=this.daos.getBillstatedao().findById(new Integer(billstateid));
		qy.setEntity(4, billstate);
		qy.setEntity(5, branch);
		qy.setEntity(6, branch);
		List ls=qy.list();
		return ls;
	}
	/***\
	 * ����˾��ɫ(�ջ�),���Ȳ�ѯ
	 */
	public List findByReceiveBranchshare(BranchInfo branch,BillState billstate)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoByReceiveBranchId=?)and(b.billState=?)");
		qy.setEntity(0, branch);
		qy.setEntity(1, billstate);
		List ls=qy.list();
		return ls;
	}
	/***\
	 * ����˾��ɫ(����),���Ȳ�ѯ
	 */
	public List findBySendBranchshare(BranchInfo branch,BillState billstate)
	{
		Session session=this.getSession();
		Query qy=session.createQuery("from BillInfo b where (b.branchInfoBySendBranchId=?)and(b.billState=?)");
		qy.setEntity(0, branch);
		qy.setEntity(1, billstate);
		List ls=qy.list();
		return ls;
	}
	/***
	 * jfreeChar��Ŀͻ���Ϣ 
	 */
	public List findBySendBranchJF()
	{
		Session session=this.getSession();
		String sql="select b.customerInfoBySendId.customerId,count(*) from BillInfo b group by b.customerInfoBySendId.customerId";
		Query qy=session.createQuery(sql);
		List ls=qy.list();
		return ls;
	}
	 /***
	  * jfreeChar�鷢����˾ҵ��
	  */
	public List findByBranchidchar()
	{
		Session session=this.getSession();
		String sql="select b.branchInfoBySendBranchId.branchId,count(*)from BillInfo b group by b.branchInfoBySendBranchId.branchId";
		Query qy=session.createQuery(sql);
		List ls=qy.list();
		return ls;
	}
}