package cn.xiahou.dao;

import cn.xiahou.entity.JdItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA支持的dao只需要创建接口即可
 */

public interface JdItemDao extends JpaRepository<JdItem, Long> {

}
