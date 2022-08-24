package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
//    return 의 할인 대상금액
    int discount(Member member, int price);
}
