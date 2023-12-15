package sky.demo.oautn2auth.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    /**
     * 权限
     */
    @NotNull
    private String authority;
}
