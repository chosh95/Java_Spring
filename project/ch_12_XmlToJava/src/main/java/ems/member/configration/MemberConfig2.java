package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;

@Configuration
public class MemberConfig2 {
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo dataBaseConnectionInfo = new DataBaseConnectionInfo();
		dataBaseConnectionInfo.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataBaseConnectionInfo.setUserId("scott");
		dataBaseConnectionInfo.setUserPw("tiger");
		return dataBaseConnectionInfo;
	}
	
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo dataBaseConnectionInfo = new DataBaseConnectionInfo();
		dataBaseConnectionInfo.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		dataBaseConnectionInfo.setUserId("masterid");
		dataBaseConnectionInfo.setUserPw("masterpw");
		return dataBaseConnectionInfo;
	}
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Education Management System program was developed in 2015.");
		info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2015);
		info.setsMonth(1);
		info.setsDay(1);
		info.seteYear(2015);
		info.seteMonth(2);
		info.seteDay(28);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Cheney.");
		list.add("Eloy.");
		list.add("Jasper.");
		list.add("Dillon.");
		list.add("Kian.");
		info.setDevelopers(list);
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("Cheney", "cheney@springPjt.org");
		map.put("Jasper", "jasper@springPjt.org");
		info.setAdministrators(map);
		
		Map<String,DataBaseConnectionInfo> map2 = new HashMap<String, DataBaseConnectionInfo>();
		map2.put("dev", dataBaseConnectionInfoDev());
		map2.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(map2);
		
		return info;
	}
}
