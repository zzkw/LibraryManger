package bigsubject.util;

/**
 *�ַ��������� 
 * @author Administrator
 *
 */
public class Stringutil {
	/**
	 * �ж������Ƿ�Ϊ��
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
