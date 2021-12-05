package command;

import java.util.Iterator;
import java.util.List;import command.BankAccountCommand.Action;

public class BankAccount {
	private int amount = 0;
	private final int overdraftlimit = -500;

	public void deposite(int money) {
		if (money <= 0)
			return;
		System.out.println("Deposited amount");
		this.amount += money;
	}

	public void withdraw(int money) {
		if (this.amount - money >= overdraftlimit) {
			System.out.println("Withdraw amount" + money);
		} else {
			System.err.println("Not able to withdraw given amount");
		}
	}
}

interface Command {
	void call();
}

class BankAccountCommand implements Command {
	private Action action;
	private BankAccount account;
	private int amount;

	public enum Action {
		DEPOSITE, WITHDRAW,
	}

	public BankAccountCommand(Action action, BankAccount account, int amount) {
		super();
		this.action = action;
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void call() {
		switch (action) {
		case DEPOSITE:
			this.account.deposite(amount);
			return;
		case WITHDRAW:
			this.account.withdraw(amount);
			return;
		}
	}

}

class BankAcountDemo {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		List<BankAccountCommand> commands =  List.of(
			new BankAccountCommand(Action.WITHDRAW, ba, 400),
			new BankAccountCommand(Action.DEPOSITE, ba, 10000),
			new BankAccountCommand(Action.DEPOSITE, ba, 20000)
		);
		for (BankAccountCommand bac: commands) {
			bac.call();
		}
		
	}
}