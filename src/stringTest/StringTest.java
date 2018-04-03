package stringTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.utils.DateUtils;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "机房维护费(2017-08-21~2018-08-20)维护费 ";
		String reg = "[1-9]\\d{4}[-][1-9]\\d{2}[-]\\d{2}";
		
		Pattern pattern = Pattern.compile (reg);
		Matcher matcher = pattern.matcher (str);
		
		while (matcher.find()){
			System.out.println (matcher.group ());//打印找到的日期
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (map.containsKey("ok")) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		
		StringBuffer pinBuff = new StringBuffer();
		String[] properties = new String[]{"贫困人口", "贫困低保人口", "贫困非低保人口", "低保贫困人口", "非低保贫困人口"};
		for (String strPro : properties) {
			if (strPro.startsWith("贫困")) {
				pinBuff.append(strPro + ", ");
			}
		}
		
		System.out.println("贫困人员：" + pinBuff.toString());
		
		System.out.println("BigDecimal.ZERO = " + BigDecimal.ZERO.toString());
		
		String akc120 = "AAC120############11";
		
		String[] arrs = akc120.split("#+");
		
		int len = arrs.length;
		System.out.println("length = " + len);
		
		for (int i = 0; i < len; i++) {
			System.out.println("arrs[" + i + "] = " + arrs[i]);
		}
		/*while (len >= 0) {
			System.out.println("arrs[" + len + "] = " + arrs[len]);
			len--;
		}*/
	}

}
