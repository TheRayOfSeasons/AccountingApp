package Objects;

public class CashRecieptAEntry
{
    private String
        date,
        particular,
        referenceNo,
        typeOfLoanLR,
        accountNoLR,
        accountNoSD,
        accountNoTD,
        accountNoII,
        accountNoSA,
        debitCOH,
        debitSA,
        creditCOH,
        creditLR,
        creditSD,
        creditTD,
        creditII,
        creditSA;

    public CashRecieptAEntry(String date, String particular, String referenceNo)
    {
        this.date = date;
        this.particular = particular;
        this.referenceNo = referenceNo;
        this.typeOfLoanLR = "";
        this.accountNoLR = "";
        this.accountNoSD = "";
        this.accountNoTD = "";
        this.accountNoII = "";
        this.accountNoSA = "";
        this.debitCOH = "";
        this.debitSA = "";
        this.creditCOH = "";
        this.creditLR = "";
        this.creditSD = "";
        this.creditTD = "";
        this.creditII = "";
        this.creditSA = "";
    }

    public CashRecieptAEntry(
            String date, String particular, String referenceNo, String typeOfLoanLR, String accountNoLR, String accountNoSD,
            String accountNoTD, String accountNoII, String accountNoSA, String debitCOH, String debitSA,
            String creditCOH, String creditLR, String creditSD, String creditTD, String creditII, String creditSA)
    {
        this.date = date;
        this.particular = particular;
        this.referenceNo = referenceNo;
        this.typeOfLoanLR = typeOfLoanLR;
        this.accountNoLR = accountNoLR;
        this.accountNoSD = accountNoSD;
        this.accountNoTD = accountNoTD;
        this.accountNoII = accountNoII;
        this.accountNoSA = accountNoSA;
        this.debitCOH = debitCOH;
        this.debitSA = debitSA;
        this.creditCOH = creditCOH;
        this.creditLR = creditLR;
        this.creditSD = creditSD;
        this.creditTD = creditTD;
        this.creditII = creditII;
        this.creditSA = creditSA;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public void setTypeOfLoanLR(String typeOfLoanLR) { this.typeOfLoanLR = typeOfLoanLR; }

    public void setAccountNoLR(String accountNoLR) {
        this.accountNoLR = accountNoLR;
    }

    public void setAccountNoSD(String accountNoSD) {
        this.accountNoSD = accountNoSD;
    }

    public void setAccountNoTD(String accountNoTD) {
        this.accountNoTD = accountNoTD;
    }

    public void setAccountNoII(String accountNoII) {
        this.accountNoII = accountNoII;
    }

    public void setAccountNoSA(String accountNoSA) {
        this.accountNoSA = accountNoSA;
    }

    public void setDebitCOH(String debitCOH) {
        this.debitCOH = debitCOH;
    }

    public void setDebitSA(String debitSA) {
        this.debitSA = debitSA;
    }

    public void setCreditCOH(String creditCOH) {
        this.creditCOH = creditCOH;
    }

    public void setCreditLR(String creditLR) {
        this.creditLR = creditLR;
    }

    public void setCreditSD(String creditSD) {
        this.creditSD = creditSD;
    }

    public void setCreditTD(String creditTD) {
        this.creditTD = creditTD;
    }

    public void setCreditII(String creditII) {
        this.creditII = creditII;
    }

    public void setCreditSA(String creditSA) { this.creditSA = creditSA; }

    public String getDate() {
        return date;
    }

    public String getParticular() {
        return particular;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public String getTypeOfLoanLR() { return typeOfLoanLR; }

    public String getAccountNoLR() {
        return accountNoLR;
    }

    public String getAccountNoSD() {
        return accountNoSD;
    }

    public String getAccountNoTD() {
        return accountNoTD;
    }

    public String getAccountNoII() {
        return accountNoII;
    }

    public String getAccountNoSA() {
        return accountNoSA;
    }

    public String getDebitCOH() {
        return debitCOH;
    }

    public String getDebitSA() {
        return debitSA;
    }

    public String getCreditCOH() {
        return creditCOH;
    }

    public String getCreditLR() {
        return creditLR;
    }

    public String getCreditSD() {
        return creditSD;
    }

    public String getCreditTD() {
        return creditTD;
    }

    public String getCreditII() {
        return creditII;
    }

    public String getCreditSA() { return creditSA; }
}
