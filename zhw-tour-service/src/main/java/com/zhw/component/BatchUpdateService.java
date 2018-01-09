package com.zhw.component;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.zhw.annotion.Batch;
import com.zhw.response.BaseResult;

@Component("batchUpdateService")
public class BatchUpdateService {
	private static final int DEFAULT_COUNT = 100;
	private static final int DEFAULT_INDEX = 1;
	
	@Resource(name="sqlSessionFactoryMysql")
	private SqlSessionFactory sqlSessionFactoryOra;
	
	public <T> BaseResult batchUpdate(List<T> list,Class<?> clazz,int annotationIndex,boolean autoFreeList) throws Exception{
		return batchUpdate(list,DEFAULT_COUNT, clazz,annotationIndex,autoFreeList);
	}
	public <T> BaseResult batchUpdate(List<T> list,Class<?> clazz,boolean autoFreeList) throws Exception{
		return batchUpdate(list,DEFAULT_COUNT, clazz,DEFAULT_INDEX,autoFreeList);
	}
	public <T> BaseResult batchUpdate(List<T> list,int count,Class<?> clazz,boolean autoFreeList) throws Exception{
		return batchUpdate(list, count, clazz,DEFAULT_INDEX,autoFreeList);
	}
	
	/**
	 * 功能描述：mybatis分页批量操作，事物自处理，建议最后调用此方法。
	 * 
	 * @param list
	 *            需分页操作的数据
	 * @param count
	 *            单批次插入的数量
	 * @param clazz
	 *            Mapper.class
	 * @param methodIndex
	 *            方法索引，指定使用第几个添加@Batch注解的方法为此方法调用
	 * @param autoFreeList
	 *            是否自动清空集合{true清空，false 不清空}
	 * @return
	 * @throws Exception
	 */
	public <T> BaseResult batchUpdate(List<T> list,int count,Class<?> clazz,int annotationIndex,boolean autoFreeList) throws Exception{
		SqlSession session = null;
		try{
			session = sqlSessionFactoryOra.openSession(ExecutorType.BATCH, false);
			
			Method batchMethod = this.getBatchMethod(clazz,annotationIndex);
			if(batchMethod == null) return BaseResult.failedInstance("没有在方法上添加@Batch注解或者方法索引不对！");
			
			Object mapper = session.getMapper(clazz);
			int lastIndex = count;
			for(int index = 0; index <list.size();){
				if(lastIndex >= list.size()){
					lastIndex = list.size();
					batchMethod.invoke(mapper, new Object[]{list.subList(index, lastIndex)});
					break;
				}else{
					batchMethod.invoke(mapper, new Object[]{list.subList(index, lastIndex)});
					index = lastIndex;
					lastIndex = index+count-1;
				}
			}
			session.commit();
			if(autoFreeList) list =null;
		}catch(Exception e){
			session.rollback();
			throw e;
		}finally{
			if(session != null) session.close();
		}
		return BaseResult.sucessInstance().setMsg("操作成功！");
	}
	
	private Method getBatchMethod(Class<?> clazz,int index){
		if(clazz == null) return null;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method:methods){
			Batch batch = method.getAnnotation(Batch.class);
			if(batch == null) 	continue;
			if(batch.index() == index)	return method;
		}
		return null;
	}
	
}
