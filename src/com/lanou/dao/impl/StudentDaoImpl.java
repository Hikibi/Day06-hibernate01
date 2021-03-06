package com.lanou.dao.impl;

import com.lanou.dao.StudentDao;
import com.lanou.domain.Student;
import com.lanou.util.HibernateUtil;
import org.hibernate.Query;
import org.junit.Test;

import java.util.List;

/**
 * Created by dllo on 17/10/17.
 */
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

    /**
     * 登录
     */
    @Override
    public boolean login(String sname, String password) {

        String hql = "from Student where sname=?";

        Query query = HibernateUtil.getSession().createQuery(hql);

        query.setString(0, sname);  // 设置查询语句的参数

        List<Student> students = query.list();

//        根据查询结果集进行返回, 如果结果集大于0, 则返回 true, 否则返回false
        return students.size() > 0;
    }

    @Test
    public void login(){

        StudentDao dao = new StudentDaoImpl();

        boolean result = dao.login("栾彬", "123");

        System.out.println("登录结果: " + result);

    }


}
