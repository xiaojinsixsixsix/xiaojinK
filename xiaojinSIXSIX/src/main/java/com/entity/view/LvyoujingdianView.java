package com.entity.view;

import com.entity.LvyoujingdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 旅游景点
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-06 14:36:31
 */
@TableName("lvyoujingdian")
public class LvyoujingdianView  extends LvyoujingdianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LvyoujingdianView(){
	}
 
 	public LvyoujingdianView(LvyoujingdianEntity lvyoujingdianEntity){
 	try {
			BeanUtils.copyProperties(this, lvyoujingdianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}