package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {
    // @Bean memberService -> new MememoryMemberRespository()
    // @Bean orderService -> new MemmoryMemberRepository()
    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService()    {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository() , discountPolicy());
//        return null;
    }
    @Bean
    public MemberRepository memberRepository(){
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRespository();
    }
    @Bean
    public MemberGH memberGH(){
        System.out.println("GH호출");
        return new MemberGH();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
