package com.sujin.ecommerce.member.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {

    private int seq; // 자동 증가갑

    @NotBlank(message = "아이디를 입력하세요.")
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하로 입력하세요.")
    private String id; // 회원 식별자

    @NotBlank(message = "이름을 입력하세요.")
    private String name; // 이름

    @NotBlank(message = "이메일 주소를 입력하세요.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email; // 이메일 주소

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Size(min = 8, message = "비밀번호는 8자 이상 입력하세요.")
    private String password; // 비밀번호

    @NotBlank(message = "전화번호를 입력하세요.")
    @Pattern(regexp = "\\d{10,11}", message = "유효한 전화번호를 입력하세요.")
    private String phoneNumber; // 전화번호

    @NotBlank(message = "주소를 입력하세요.")
    private String address; // 주소 정보

    @NotBlank(message = "성별을 선택하세요.")
    private String gender; // 성별

    @Past(message = "유효한 생년월일을 입력하세요.")
    private Date birthDate; // 생년월일

    private String profileImage; // 프로필 이미지 URL
    private boolean emailNotifications; // 이메일 알림 설정 (광고동의)

}
