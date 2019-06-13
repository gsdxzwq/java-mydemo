package com.zhaowq.guice;

/**
 * @author zhaowq
 * @date 2017/7/25
 */
public class RealBillingService implements BillingService {
    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        return null;
    }
}
