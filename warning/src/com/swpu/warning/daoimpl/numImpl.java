package com.swpu.warning.daoimpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.swpu.warning.dao.num;
import com.swpu.warning.entity.user;
import com.swpu.warning.utils.JdbcUtil;

public class numImpl implements num {



	@Override
	public void recharge() {
		String sql = "update deadnum set deadNum=28800";
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date()); 
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;
		SimpleDateFormat df = new SimpleDateFormat("HH");//设置日期格式
		String date =df.format(new Date());// new Date()为获取当前系统时间
		if(week == 1){
			if(date =="00")
			{
				try {
					JdbcUtil.updateMethod(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int numLeft() {
		List list = new ArrayList();
		int num;
		Object temp;
		user u;
		String sql = "select deadNum from deadnum";
		user user;
		try {
			list = JdbcUtil.selectMethod(user.class, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u = (user) list.get(0);
		return u.getdeadNum();
	}

	@Override
	public int start() {
		int numLeft = 0;
		numLeft = numLeft();
		if(numLeft > 0)
		{
			return numLeft; 
		}
		else{
			return 0;
		}
	}

	@Override
	public boolean end(int time) {
		// TODO Auto-generated method stub
		String sql = "update deadnum set deadNum = ?";
		try {
			JdbcUtil.updateMethod(sql,time);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
