package com.fx.hmwac.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreateID {
	public static CreateID singleCreateID = new CreateID();
	private CreateID(){};
	public String madeID() {
		String result = "";
		Calendar nowTime = new GregorianCalendar();
		result += (""+nowTime.get(Calendar.YEAR)).substring(2);
		result += (""+nowTime.get(Calendar.MONTH));
		result += (""+nowTime.get(Calendar.DATE));
		result += (""+nowTime.get(Calendar.HOUR));
		result += (""+nowTime.get(Calendar.MINUTE));
		result += (""+nowTime.get(Calendar.SECOND));
		return result;
	}
}
