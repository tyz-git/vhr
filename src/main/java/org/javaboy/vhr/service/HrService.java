package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("未找到此用户");
        }
        hr.setRoles(hrMapper.getRoleListByHrId(hr.getId()));
        return hr;
    }


    public List<Hr> getHrList(String hrName) {
        List<Hr> hrList = hrMapper.getHrList(UserUtil.getUser().getId(), hrName);
        return hrList;
    }

    public int updateHr(Hr hr) {
        int result = hrMapper.updateHr(hr);
        return result;
    }

    public int deleteHr(Integer id) {
        int result = hrMapper.deleteHr(id);
        return result;
    }
}
