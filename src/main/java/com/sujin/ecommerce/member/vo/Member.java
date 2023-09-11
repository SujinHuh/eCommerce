package com.sujin.ecommerce.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {

    private String id; // 회원 식별자
    private String name; // 이름
    private String email; // 이메일 주소
    private String password; // 비밀번호
    private String phoneNumber; // 전화번호
    private String address; // 주소 정보
    private String gender; // 성별
    private Date birthDate; // 생년월일
    private String profileImage; // 프로필 이미지 URL
    private boolean emailNotifications; // 이메일 알림 설정 (광고동의)

}
