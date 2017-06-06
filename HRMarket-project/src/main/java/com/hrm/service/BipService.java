package com.hrm.service;

import java.util.List;

import com.hrm.utils.HRMResult;
import com.hrm.vo.Bip;

public interface BipService{

	List<Bip> search(Bip bip, String nl1, String nl2, String xl1, String xl2,
			String djrq1, String djrq2, String qzgw, String cxfw);

	HRMResult findBipByBipCitizenid(String bipCitizenid);

	HRMResult findBipByBipName(String bipName);
	
	boolean changeStopState(String bipCitizenid);

	Bip findBipInfoByBipCitizenid(String bipCitizenid);

	boolean getDongjieStateChange(String qzbh);

	void changeState(String bipId, String str, String reason);

	List<Bip> findBipByArray(String sfzhm, String xm, String cxkssj,
			String cxjssj, String sfdj);

	void guidangService(String[] qzbhs);


}
