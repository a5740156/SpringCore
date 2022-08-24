package hello.core.order;

import hello.core.AppConfig;
import hello.core.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId= 1L;
        Member memeber = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(memeber);

        Order order = orderService.createOrder(memberId, "itemA" , 10000);

    }


}