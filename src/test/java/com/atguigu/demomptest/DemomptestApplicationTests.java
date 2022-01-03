package com.atguigu.demomptest;

import com.atguigu.demomptest.entity.User;
import com.atguigu.demomptest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemomptestApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void findAll(){
        List<User> users=userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void testAdd(){
        User user=new User();
        user.setName("lucy1");
        user.setAge(20);
        user.setEmail("1243@qq.com");
        int insert=userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(1477912194359250945L);
        user.setName("lucymary");
        int count=userMapper.updateById(user);
        System.out.println(count);
    }
    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        User user=userMapper.selectById(1L);
        user.setName("张四");
        userMapper.updateById(user);
    }

    //查询
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }
    //条件查询
    @Test
    public void testSelect2() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }
    //分页查询
    @Test
    public void testSeletPage(){
        Page<User> page=new Page(1,3);
        Page<User> userPage =userMapper.selectPage(page,null);

        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }
    //测试逻辑删除
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }
    //逻辑删除后查询
    @Test
    public void testLogicDeleteSelect() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //条件构造器
    @Test
    public void testSelect(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.ge("age",21);
        List<User> users=userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    @Test
    public void testSelectMaps() {
        QueryWrapper<User>queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("name", "age")
                .like("name", "l")
                .likeRight("email", "1");
        List<Map<String, Object>>maps = userMapper.selectMaps(queryWrapper);//返回值是Map列表
        maps.forEach(System.out::println);
    }
    @Test
    public void testSelectListOrderBy() {
        QueryWrapper<User>queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age", "id");
        List<User>users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void contextLoads() {
    }

}
