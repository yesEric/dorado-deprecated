package cn.dorado.cms.domain.model.common;

import cn.dorado.util.DateUtil;

/**
 * Created by Eric on 14-4-29.
 */
public class SmartDate {
    String dateValue;
    public SmartDate(){
        this.setDateValue(DateUtil.getToday().toString());
    }

    public String getDateValue() {
        return dateValue;
    }

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }

}
