package com.bu.opt;

import java.util.Vector;

/**
 * ҵ����ʲ�ӿ�
 * */
public interface IBusiness {
	/**
	 * ��������
	 * @param Object,ͨ��Ϊʵ�����
	 * @return boolean
	 * */
	public boolean save(Object ob);
	
	/**
	 * ɾ������
	 * @param String,ͨ��Ϊ���ݱ�����ֵ
	 * @return boolean
	 * */
	public boolean delete(String pkid);
	
	/**
	 * ��������
	 * @param Object,ͨ��Ϊʵ�����
	 * @return boolean
	 * */
	public boolean update(Object ob);
	
	/**
	 * ����������������Ϣ
	 * @return Vector,ͨ��Ϊ��Ϣ����ļ���
	 * */
	public Vector findAll();
	
	/**
	 * ����������ѯָ����Ϣ
	 * @param String,ͨ��Ϊ���ݱ�����ֵ
	 * @return Object,ͨ��Ϊʵ�����
	 * */
	public Object findByID(String pkid);
}
