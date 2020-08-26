package com.qiang.wxmall.user;

import com.google.gson.reflect.TypeToken;
import com.qiang.wxmall.conf.BaseConfiguration;

import javax.persistence.AttributeConverter;

public class UserInfoConvert implements AttributeConverter<UserInfo, String> {
    @Override
    public String convertToDatabaseColumn(UserInfo attribute) {
        return BaseConfiguration.generalGson().toJson(attribute);
    }

    @Override
    public UserInfo convertToEntityAttribute(String dbData) {
        return BaseConfiguration.generalGson().fromJson(dbData, new TypeToken<UserInfo>(){}.getType());
    }
}
