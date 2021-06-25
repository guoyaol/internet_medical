package org.linlinjava.internetmedical.db.service;

import org.linlinjava.internetmedical.db.dao.InternetmedicalSystemMapper;
import org.linlinjava.internetmedical.db.domain.InternetmedicalSystem;
import org.linlinjava.internetmedical.db.domain.InternetmedicalSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InternetmedicalSystemConfigService {
    @Resource
    private InternetmedicalSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        InternetmedicalSystemExample example = new InternetmedicalSystemExample();
        example.or().andDeletedEqualTo(false);

        List<InternetmedicalSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (InternetmedicalSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        InternetmedicalSystemExample example = new InternetmedicalSystemExample();
        example.or().andKeyNameLike("internetmedical_mall_%").andDeletedEqualTo(false);
        List<InternetmedicalSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(InternetmedicalSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        InternetmedicalSystemExample example = new InternetmedicalSystemExample();
        example.or().andKeyNameLike("internetmedical_wx_%").andDeletedEqualTo(false);
        List<InternetmedicalSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(InternetmedicalSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        InternetmedicalSystemExample example = new InternetmedicalSystemExample();
        example.or().andKeyNameLike("internetmedical_order_%").andDeletedEqualTo(false);
        List<InternetmedicalSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(InternetmedicalSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        InternetmedicalSystemExample example = new InternetmedicalSystemExample();
        example.or().andKeyNameLike("internetmedical_express_%").andDeletedEqualTo(false);
        List<InternetmedicalSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(InternetmedicalSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            InternetmedicalSystemExample example = new InternetmedicalSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            InternetmedicalSystem system = new InternetmedicalSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        InternetmedicalSystem system = new InternetmedicalSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
