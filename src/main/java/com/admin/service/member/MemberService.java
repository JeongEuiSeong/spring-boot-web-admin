package com.admin.service.member;

import com.admin.domain.member.Member;
import com.admin.domain.member.MemberRepository;
import com.admin.web.dto.MemberListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService
{
    private final MemberRepository MemberRepository;

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDesc() {
        return MemberRepository.findAllDesc().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

}
