package com.admin.domain.member;


import ch.qos.logback.classic.db.names.TableName;
import com.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="TBL_RA_USER")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String USERID;

    @Column(length = 100, nullable = false)
    private String PWD;


    @Builder
    public Member(String USERID, String PWD) {
        this.USERID = USERID;
        this.PWD = PWD;
    }

    public void setPassword(String PWD) {
        this.PWD = PWD;
    }

}
