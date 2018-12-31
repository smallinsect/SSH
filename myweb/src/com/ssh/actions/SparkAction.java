package com.ssh.actions;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ssh.staticc.UserInfo;
import com.ssh.util.URLConUtil;

public class SparkAction {

	public static String USER_INFO = "http://spark.bokecc.com/api/user";
	public static String VIDEO_INFO = "http://spark.bokecc.com/api/video/v4";

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public SparkAction() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
	}
	
	/**
	 * 	获取用户信息
	 * @return
	 */
	public String getUserInfo() {
//		HttpServletResponse response = ServletActionContext.getResponse();

		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", UserInfo.USER_ID);
		params.put("format", "json");
		String json = URLConUtil.retrieve(USER_INFO, params);
		try {
			System.out.println(json);
			//响应数据编码设为utf-8
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 	获取视频信息
	 * @return
	 */
	public String getVideoInfo() {
		String videoid = request.getParameter("videoid");
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", UserInfo.USER_ID);
		params.put("videoid", videoid);
		params.put("format", "json");
		
		String json = URLConUtil.retrieve(VIDEO_INFO, params);
		try {
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", UserInfo.USER_ID);
		params.put("format", "json");
		String str = URLConUtil.retrieve(USER_INFO, params);
		try {
			System.out.println(str);
			String str1 = new String(str.getBytes("ISO-8859-1"), "utf-8");
			System.out.println(str1);
			String str2 = new String(str.getBytes("gb2312"), "utf-8");
			System.out.println(str2);
			String str3 = new String(str.getBytes("gbk"), "utf-8");
			System.out.println(str3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
