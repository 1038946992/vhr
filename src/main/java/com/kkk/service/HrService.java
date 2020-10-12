package com.kkk.service;

import com.kkk.mapper.HrMapper;
import com.kkk.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.selectHrByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        return hr;
    }
}
