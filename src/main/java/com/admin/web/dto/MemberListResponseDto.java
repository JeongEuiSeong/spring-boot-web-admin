package com.admin.web.dto;


import com.admin.domain.member.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberListResponseDto {
    private Long id;
    private String USERID;
    private String PWD;
    private LocalDateTime modifiedDate;

    public MemberListResponseDto(Member entity)
    {
        this.id = entity.getId();
        this.USERID = entity.getUSERID();
        this.PWD = entity.getPWD();
        this.modifiedDate = entity.getModifiedDate();
    }
}
