package org.linlinjava.internetmedical.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.internetmedical.admin.vo.RegionVo;
import org.linlinjava.internetmedical.core.util.ResponseUtil;
import org.linlinjava.internetmedical.db.domain.InternetmedicalRegion;
import org.linlinjava.internetmedical.db.service.InternetmedicalRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private InternetmedicalRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<InternetmedicalRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<InternetmedicalRegion> internetmedicalRegions = regionService.getAll();
        Map<Byte, List<InternetmedicalRegion>> collect = internetmedicalRegions.stream().collect(Collectors.groupingBy(InternetmedicalRegion::getType));
        byte provinceType = 1;
        List<InternetmedicalRegion> provinceList = collect.get(provinceType);
        byte cityType = 2;
        List<InternetmedicalRegion> city = collect.get(cityType);
        Map<Integer, List<InternetmedicalRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(InternetmedicalRegion::getPid));
        byte areaType = 3;
        List<InternetmedicalRegion> areas = collect.get(areaType);
        Map<Integer, List<InternetmedicalRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(InternetmedicalRegion::getPid));

        for (InternetmedicalRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<InternetmedicalRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (InternetmedicalRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(cityVo.getId());
                cityVO.setName(cityVo.getName());
                cityVO.setCode(cityVo.getCode());
                cityVO.setType(cityVo.getType());

                List<InternetmedicalRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (InternetmedicalRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
