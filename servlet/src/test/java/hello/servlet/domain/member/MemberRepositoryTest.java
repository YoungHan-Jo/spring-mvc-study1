package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();


    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
       //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    public void findAll() throws Exception {
       //given
        Member member1 = new Member("hello1", 21);
        Member member2 = new Member("hello2", 22);
       //when
        memberRepository.save(member1);
        memberRepository.save(member2);

       //then
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);

    }
    





}