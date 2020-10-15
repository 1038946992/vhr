package com.kkk.service;

import com.kkk.mapper.MenuMapper;
import com.kkk.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户id查询用户菜单列表
     *
     * @param id
     * @return
     */
    public List<Menu> getMenuByHrId(Integer id) {
        return menuMapper.getMenuByHrId(id);
    }

    /**
     * 获取所有的菜单列表
     * @return
     */
    public List<Menu> getAllMenuWithRole(){
        return menuMapper.getAllMenuWithRole();
    }
}
