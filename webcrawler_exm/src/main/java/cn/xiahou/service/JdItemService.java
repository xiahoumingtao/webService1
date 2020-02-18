package cn.xiahou.service;

import cn.xiahou.entity.JdItem;

import java.util.List;

public interface JdItemService {

    /**
     * 保存商品
     * @param item
     */
    public void save (JdItem item);

    /**
     * 查询商品
     * @param item
     * @return
     */
    public List<JdItem> find(JdItem item);
}
