package com.sujin.ecommerce.member.mapper;

import com.sujin.ecommerce.member.vo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("insert into Member(id, name, email, password, phoneNumber, address, gender, birthDate, profileImage, emailNotifications) " +
            "values(#{id}, #{name}, #{email}, #{password}, #{phoneNumber}, #{address}, #{gender}, #{birthDate}, #{profileImage}, #{emailNotifications})")
    int create(Member param);
}
