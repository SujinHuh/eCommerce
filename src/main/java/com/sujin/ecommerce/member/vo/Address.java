package com.sujin.ecommerce.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Address {
    /**
     * class : Address
     *
     */

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

}
