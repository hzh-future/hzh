package com.hzh.common;


import com.hzh.vip.entity.ClientEntity;
import com.hzh.vip.entity.UserEntity;
import com.hzh.vip.entity.VIPEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbstractDao {
    //插入
    void insertClient(ClientEntity client) throws Exception;
    int vipInsert(VIPEntity vipEntity);

    //更新
    void update(UserEntity userEntity) throws Exception;
    int vipUpdate(ClientEntity client);
    int updateClient(@Param("id") int id,@Param("code") String code,@Param("name") String name) throws Exception;
    int updateRecord(@Param("code") String code,@Param("name") String name,@Param("phone") String phone);



    //删除
    void consumeDelete(@Param("code") String code) throws Exception;
    void clientDelete(@Param("id") int id) throws Exception;

    //查询
    UserEntity select(@Param("key") String ukfield, @Param("value") Object value) throws Exception;
    String selectIdClient(@Param("id") int id) throws Exception;
    ClientEntity selectClient(@Param("code") String code) throws Exception;
    List<VIPEntity> selectAllX() throws Exception;
    List<VIPEntity> selectCodeAllX(@Param("code") String code) throws Exception;
    List<ClientEntity> selectAllC() throws Exception;
    List<ClientEntity> selectCodeAllC(@Param("code") String code);



    Boolean exsits(@Param("key") String ukfiled, @Param("value") Object value) throws Exception;
    //List<T> selectLike(@Param("key") String key) throws Exception;
}
