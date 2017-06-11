package com.hrm.service;

import java.util.List;

import com.hrm.vo.Bio;
import com.hrm.vo.BioDj;
import com.hrm.vo.ZjDwgd;
import com.hrm.vo.ZjDwzpdjb;

public interface ZjDwgdService {
	public List<BioDj> getAll(ZjDwgd dwgd);
}
