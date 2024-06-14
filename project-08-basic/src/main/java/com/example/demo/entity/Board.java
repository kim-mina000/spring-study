package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no; //글번호

    @Column(length = 100, nullable = false)
    String title; //제목

    @Column(length = 1500, nullable = false)
    String content; //내용

//    @Column(length = 50, nullable = false)
//    String writer; //작성자
    
    // 외래키 연결하기
    // 타입을 Member로 설정하면 자동으로 Member의 PK를 참조함
    @ManyToOne // 관계 차수 1:N
    Member writer;

}
