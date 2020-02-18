package cn.xiahou.service;

import cn.xiahou.dao.JdItemDao;
import cn.xiahou.entity.JdItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdItemServiceImpl implements JdItemService {

    @Autowired
    private JdItemDao jddao;

    @Transactional
    public void save(JdItem item) {
        this.jddao.save(item);
    }

    public List<JdItem> find(JdItem item) {
        //声明查询条件
        Example<JdItem> example = Example.of(item);
        //查询
        List<JdItem> jdItems = this.jddao.findAll(example);
        return jdItems;
    }
}
