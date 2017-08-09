package com.pangu.repository;

import com.pangu.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DongHao on 2017/8/7.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByUseridAndPassword(String userid, String password);
}
