package org.linlinjava.internetmedical.wx.service;

import org.linlinjava.internetmedical.db.domain.InternetmedicalRegion;
import org.linlinjava.internetmedical.db.service.InternetmedicalRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private InternetmedicalRegionService regionService;

	private static List<InternetmedicalRegion> internetmedicalRegions;

	protected List<InternetmedicalRegion> getInternetmedicalRegions() {
		if(internetmedicalRegions==null){
			createRegion();
		}
		return internetmedicalRegions;
	}

	private synchronized void createRegion(){
		if (internetmedicalRegions == null) {
			internetmedicalRegions = regionService.getAll();
		}
	}
}
