package sky.demo.oautn2auth.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


/**
 * 用户
 */
@Data
@NoArgsConstructor
@TableName("user")
public class User implements UserDetails {
    /**
     * 帐号id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 帐号启用
     */
    @TableLogic(value = "1")
    private boolean enabled = true;
    /**
     * 帐号非过期
     */
    private boolean accountNonExpired = true;
    /**
     * 帐号非锁定
     */
    private boolean accountNonLocked = true;
    /**
     * 密钥是非过期
     */
    private boolean credentialsNonExpired = true;

    @TableField(exist = false)
    private Set<Authority> authorities;
}
