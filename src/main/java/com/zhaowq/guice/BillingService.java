package com.zhaowq.guice;

public interface BillingService {

    /**
     * 通过信用卡支付。无论支付成功与否都需要记录交易信息。
     *
     * @return 交易回执。支付成功时返回成功信息，否则记录失败原因。
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}