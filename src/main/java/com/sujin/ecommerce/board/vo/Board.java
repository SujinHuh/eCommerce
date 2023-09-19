package com.sujin.ecommerce.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * packageName    : com.sujin.ecommerce.board.vo
 * fileName       : Board
 * author         : sujin
 * date           : 2023-09-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-19        sujin       최초 생성
 */
@Getter
@Setter
@ToString
public class Board {
    private int seq;
    private Long id;
    private String title;
    private String content;
    private String author;
    private Date createDate;
}
