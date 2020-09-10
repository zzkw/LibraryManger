package bigsubject.util;

/**
 *字符串工具类 
 * @author Administrator
 *
 */
public class Stringutil {
	/**
	 * 判断输入是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}
