package sky.demo.oautn2auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import sky.demo.oautn2auth.model.User;

public interface UserMapper extends BaseMapper<User> {

    User findByUsername(@Param("username") String username);
}
