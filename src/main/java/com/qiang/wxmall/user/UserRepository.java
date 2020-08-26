package com.qiang.wxmall.user;

import com.qiang.wxmall.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
