package pl.pjatk.s32945Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.s32945Bank.Class.ClientStorage;
import pl.pjatk.s32945Bank.Controller.BankService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class S32945BankApplicationTests {

	private BankService bs;//= new BankService();

	@Test
	void contextLoads() {
	}

	@Test
	void transferAndDeposit() {
		/*
		this.bs.getClientStorage().addClient("BoJack","Horseman",99000.0);
		this.bs.transfer(1,8000.0);
		this.bs.deposit(1,550.99);

		assertEquals(91550.99,this.bs.getClientStorage().getClients().get(0).getBalance());
		*/
	}

}
