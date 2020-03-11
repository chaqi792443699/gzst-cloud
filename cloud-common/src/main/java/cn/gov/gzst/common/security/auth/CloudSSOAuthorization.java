package cn.gov.gzst.common.security.auth;

import cn.gov.gzst.common.common.service.ISSOPermissionService;
import cn.gov.gzst.common.utils.StringUtils;
import com.baomidou.kisso.SSOAuthorization;
import com.baomidou.kisso.security.token.SSOToken;

import java.util.List;

public class CloudSSOAuthorization implements SSOAuthorization {

    ISSOPermissionService permissionService;

    /**
     * 检验是否具有访问权限
     * @param token
     * @param permission
     * @return
     */
    @Override
    public boolean isPermitted(SSOToken token, String permission) {
        if (StringUtils.isEmpty(permission)) {
            return true;
        }
        List<String> authes = permissionService.getAuthorities(token.getId());
        if (authes == null) {
            return false;
        }
        if (authes.size() == 0) {
            return false;
        }
        String[] permissions = permission.split(",");
        boolean flag = false;
        for (String perm : permissions) {
            if (authes.contains(perm)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public ISSOPermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(ISSOPermissionService permissionService) {
        this.permissionService = permissionService;
    }
}
