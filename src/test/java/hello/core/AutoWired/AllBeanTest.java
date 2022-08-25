package hello.core.AutoWired;

import hello.core.AutoAppConfig;
import hello.core.Grade;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService =  ac.getBean(DiscountService.class);
        Member member = new Member(1l, "userA", Grade.VIP);
        int discountPirce = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPirce).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(discountPirce).isEqualTo(1000 );

    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList" + policies);
        }

        public int discount(Member member,int price , String discountCode)  {
            DiscountPolicy discountPolicy =  policyMap.get(discountCode);
            System.out.println("1.  " + policyMap.get(discountCode));
            System.out.println("2.   " + policyMap.get(discountCode));
            return  discountPolicy.discount(member, price);
        }
    }
}
