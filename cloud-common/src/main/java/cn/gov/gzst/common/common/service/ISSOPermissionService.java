package cn.gov.gzst.common.common.service;

import java.util.List;

public interface ISSOPermissionService {

	List<String> getAuthorities(String userId);

	List<String> getResources(String userId);

}