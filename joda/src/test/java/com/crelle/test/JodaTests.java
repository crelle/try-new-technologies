package com.crelle.test;

import lombok.Data;
import org.joda.money.BigMoney;
import org.joda.money.BigMoneyProvider;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.RoundingMode;

@SpringBootTest
@Data
class JodaTests {

	@Test
	void test1() {
		Money money  = Money.parse("USD 23.87");

		//add another amount with safe double conversion
		CurrencyUnit usd = 	CurrencyUnit.of("USD");
		money = money.plus(Money.of(usd,12.43d));
		System.out.println("#############plus########result="+money.toString());

		//subtracts an amount in dollars
		money = money.minusMajor(2);
		System.out.println("#############minusMajor########result="+money.toString());

		//multiplies by 3.5 with rounding
		money = money.multipliedBy(3.4d, RoundingMode.UNNECESSARY);
		System.out.println("###############multiplie############result="+money.toString());

		//compare two amounts
		BigMoneyProvider bigMoneyProvider = Money.parse("USD 200");
		boolean isGreaterThen = money.isGreaterThan(bigMoneyProvider);
		System.out.println("#######isGreaterThen#####result="+isGreaterThen);

		// convert to GBP using a supplied rate
//		BigDecimal conversionRate = ...;  // obtained from code outside Joda-Money
//		Money moneyGBP = money.convertedTo(CurrencyUnit.GBP, conversionRate, RoundingMode.HALF_EVEN);

		// use a BigMoney for more complex calculations where scale matters
		BigMoney moneyCalc = money.toBigMoney();
		System.out.println("#########toBigMoney######result="+moneyCalc.toString());
	}

}
