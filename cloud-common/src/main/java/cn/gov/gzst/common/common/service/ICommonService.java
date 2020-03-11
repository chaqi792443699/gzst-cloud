package cn.gov.gzst.common.common.service;

import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import cn.gov.gzst.common.common.data.DuplicateValid;
import cn.gov.gzst.common.query.data.Page;
import cn.gov.gzst.common.query.data.Queryable;

public interface ICommonService<T> extends IService<T> {

	public T save(T entity);

	public T saveOrUpdate(T entity);

	public Page<T> list(Queryable queryable);
	
	public Page<T> list(Queryable queryable, Wrapper<T> wrapper);

	public List<T> listWithNoPage(Queryable queryable);

	public List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

	Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}