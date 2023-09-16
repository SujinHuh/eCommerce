package com.sujin.ecommerce.member.mapper;

import com.sujin.ecommerce.member.vo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
    @Options(useGeneratedKeys = true, keyProperty = "seq")
    int create(Member param);

    @Select("SELECT seq,id,password FROM member WHERE id = #{id} AND password = #{password}")
    Member findById(Member member);

    @Select("SELECT id,email FROM member WHERE id = #{id} or email = #{email}")
    Member idAndEmailCheck(Member member);
}
