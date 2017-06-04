package com.imti.ldlsc.hrm.common;

import java.util.Hashtable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener,ServletContextListener{
	@SuppressWarnings("rawtypes")
	private static Hashtable ht = new Hashtable();

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		ht.clear();
		
	}

	@SuppressWarnings("rawtypes")
	public void contextInitialized(ServletContextEvent arg0) {
		ht = new Hashtable();
		
	}
	@SuppressWarnings("unchecked")
	public static synchronized void logined(HttpSession session,String userid) {
		if(ht.containsKey(userid)){
			HttpSession vsession = (HttpSession)ht.get(userid);
			vsession.setMaxInactiveInterval(1);
		}
		ht.put(userid, session);		
	}

}
//public class OnlineUser implements HttpSessionListener,ServletContextListener
//{
//  //在线人数
//  private int count = 0;
//  ServletContext ctx = null;
//  //初始化ServletContext
//  public void contextInitialized(ServletContextEvent e)
//  {
//      ctx = e.getServletContext();
//  }
//  //将ServletContext设置成null
//  public void contextDestroyed(ServletContextEvent e)
//  {
//      ctx = null;
//  }
//  //当新创建一个HttpSession对象时，
//  //将当前的在线人数加上1，并且保存到ServletContext(application)中
//  public void sessionCreated(HttpSessionEvent e)
//  {
//      count ++;
//      ctx.setAttribute("OnlineUser",new Integer(count));
//  }
//  //当一个HttpSession被销毁时（过期或者调用了invalidate()方法）
//  //将当前人数减去1，并且保存到ServletContext(application)中
//  public void sessionDestroyed(HttpSessionEvent e)
//  {
//      count --;
//      ctx.setAttribute("OnlineUser",new Integer(count));
//  }    
//}