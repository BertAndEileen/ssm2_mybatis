package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@SuppressWarnings("all")
public interface UserMapper {

    /**
     *  @Insert 配置 insert的sql语句 <br/>
     *  @SelectKey 配置一个查询语句( 主要用于配置一个Select语句,用于查询主键 ) <br>
     *          statement 配置你的sql语句 <br>
     *          before 配置是否是先执行selectKey中语句 <br/>
     *          keyProperty 配置查询回来的Key主键给哪个属性赋值 <br/>
     *          resultType 属性配置返回的主键数据类型
     * @param user
     * @return
     */
    @SelectKey(statement = "select last_insert_id()",before = false, keyProperty = "id",resultType = Integer.class)
    @Insert("insert into t_user(`last_name`,`sex`) values(#{lastName},#{sex})")
    public int saveUser(User user);

    /**
     * @Update 配置 update语句
     * @param user
     * @return
     */
    @Update("update t_user set `last_name` = #{lastName} , `sex` = #{sex} where id = #{id}")
    public int updateUserById(User user);

    /**
     * @Delete 注解 配置 delete 语句
     * @param id
     * @return
     */
    @Delete("delete from t_user where id = #{id}")
    public int deleteUserById(Integer id);

    /**
     *@Select 注解配置 select语句
     * @param id
     * @return
     */
    @Select("select `id`, `last_name` lastName,`sex` from t_user where id = #{id}")
    public User queryUserById(Integer id);

    /**
     * @Select 注解配置 select语句
     * @return
     **/
    @Select("select `id`, `last_name` lastName,`sex` from t_user")
    public List<User> queryUsers();

}
