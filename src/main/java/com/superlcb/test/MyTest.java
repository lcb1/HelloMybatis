package com.superlcb.test;

import com.superlcb.entity.UserAutoEntity;
import com.superlcb.entity.UserAutoEntityExample;
import com.superlcb.entity.UserBean;
import com.superlcb.mapper.UserAutoMapper;
import com.superlcb.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.superlcb.util.MyUtilTools.myPrint;

/***
 * @author: lcb
 * @date: 2019-7-22 19:32
 * Description: 
 */
public class MyTest {
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private UserBean userBean = null;
    private UserBean[] userBeans = null;
    private UserMapper userMapper = null;
    private UserAutoEntity userAutoEntity = new UserAutoEntity();
    private UserAutoEntity[] userAutoEntities = null;
    private UserAutoMapper userAutoMapper = null;
    private UserAutoEntityExample userAutoEntityExample=new UserAutoEntityExample();

    @Before
    public void beforeMethod() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config/MybatisConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        userAutoMapper = sqlSession.getMapper(UserAutoMapper.class);
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 19:32
     * MethodDescription:
     */
    @Test
    public void testHelloJunit() {
        System.out.println("Hello Junit");
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 19:46
     * MethodDescription:
     */
    @Test
    public void testUserMapperSelectAllUsers() {
        userBeans = userMapper.selectAllUsers();
        myPrint(userBeans);
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 20:48
     * MethodDescription:
     */
    @Test
    public void testUserAtoMapperSelect() {
        userAutoEntities = userAutoMapper.selectByExample(null).toArray(new UserAutoEntity[0]);
        myPrint(userAutoEntities);
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 21:03
     * MethodDescription:
     */
    @Test
    public void testUserAutoMapperDelete() {
        userAutoMapper.deleteByPrimaryKey(14);
        sqlSession.commit();
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 21:06
     * MethodDescription: 
     */
    @Test
    public void testUserAutoMapperInsert() {
        userAutoEntity.setPassword("password");
        System.out.println(userAutoMapper.insert(userAutoEntity));
        sqlSession.commit();
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 21:20
     * MethodDescription:
     */
    @Test
    public void testUserAutoMapperUpdate() {
        userAutoEntity.setId(16);
        userAutoEntity.setUsername("userName");
//        userAutoEntity.setPassword("password");
        System.out.println(userAutoEntity);
        userAutoMapper.updateByPrimaryKey(userAutoEntity);
        sqlSession.commit();
    }

    /***
     * @author: lcb
     * @date : 2019-7-22 21:52
     * MethodDescription:
     */
    @Test
    public void testCriteria() {
        UserAutoEntityExample.Criteria criteria = userAutoEntityExample.createCriteria();
        criteria.andIdBetween(1,3);
        userAutoEntities = userAutoMapper.selectByExample(userAutoEntityExample).toArray(new UserAutoEntity[0]);
        myPrint(userAutoEntities);
    }

    @After
    public void afterMethod() {
        sqlSession.close();
    }
}
