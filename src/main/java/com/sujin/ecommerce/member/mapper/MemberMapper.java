package com.sujin.ecommerce.member.mapper;

import com.sujin.ecommerce.member.vo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    /**
    *
    * method : create
    *
    * @param : member
    * @result : param
    *
    * @author keti
    * @version 1.0.0
    * @dtae 2023-09-09
    *
    **/
    @Insert("insert into Member(id, name, email, password, phoneNumber, address, gender, birthDate, profileImage, emailNotifications) " +
            "values(#{id}, #{name}, #{email}, #{password}, #{phoneNumber}, #{address}, #{gender}, #{birthDate}, #{profileImage}, #{emailNotifications})")
    int create(Member param);

    @Select("SELECT seq,id,password FROM member WHERE id = #{param} AND password = #{password}")
    Member findById(String param, String password);
}
