class Bank {
    long[] account;

    public Bank(long[] balance) {
        this.account = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!validateLen(this, account1) || !validateLen(this, account2))
            return false;
        if(!validateMon(this, account1, money)) return false;
        this.account[account1-1] -= money;
        this.account[account2-1] += money; 
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!validateLen(this, account)) return false;
        this.account[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!validateLen(this, account)) return false;
        if(!validateMon(this, account, money)) return false;
        this.account[account-1] -= money;
        return true;
    }

    private boolean validateLen(Bank bank, int x) {
        if(x-1 < 0 ||x > bank.account.length)
            return false;
        return true;
    }

    private boolean validateMon(Bank bank, int x, long money) {
        if(bank.account[x-1] < money) return false;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */