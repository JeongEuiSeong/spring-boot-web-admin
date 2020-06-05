package com.admin.domain.member;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup()
    {
        memberRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기()
    {
        String userid = "테스트 게시물";
        String password = "테스트 콘테텐츠 입니다.";

        memberRepository.save(Member.builder().USERID(userid).PWD(password).build());

        List<Member> memberList = memberRepository.findAll();

        Member member = memberList.get(0);

        assertThat(member.getUSERID()).isEqualTo(userid);
        assertThat(member.getPWD()).isEqualTo(password);

    }

    @Test
    public void BaseTimeEntity_등록()
    {
        LocalDateTime now = LocalDateTime.of(2020,6,3,0,0,0);
        memberRepository.save(Member.builder()
                .USERID("jes8")
                .PWD("pwd12345")
                .build());

        List<Member> postsList = memberRepository.findAll();

        Member posts = postsList.get(0);

        System.out.println(">>>>> createDate="+posts.getCreateDate()+", modifiedDate="+posts.getModifiedDate() );

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
