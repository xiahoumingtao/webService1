package conf.mapper;

import cn.xiahou.entity.JdItem;
import cn.xiahou.entity.JdItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    long countByExample(JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int deleteByExample(JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int deleteByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int insert(JdItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int insertSelective(JdItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    List<JdItem> selectByExampleWithBLOBs(JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    List<JdItem> selectByExample(JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    JdItem selectByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByExampleSelective(@Param("record") JdItem record, @Param("cn.xiahou.example") JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") JdItem record, @Param("cn.xiahou.example") JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByExample(@Param("record") JdItem record, @Param("cn.xiahou.example") JdItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByPrimaryKeySelective(JdItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(JdItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JD_ITEM
     *
     * @mbg.generated Fri Feb 14 10:53:39 CST 2020
     */
    int updateByPrimaryKey(JdItem record);
}