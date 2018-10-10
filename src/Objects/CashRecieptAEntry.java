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
        accountNoSA;

    private float
        debitCOH,
        debitSA,
        creditCOH,
        creditLR,
        creditSD,
        creditTD,
        creditII,
        creditSA;

    public CashRecieptAEntry(
            String date, String particular, String referenceNo, String typeOfLoanLR, String accountNoLR, String accountNoSD,
            String accountNoTD, String accountNoII, String accountNoSA, float debitCOH, float debitSA,
            float creditCOH, float creditLR, float creditSD, float creditTD, float creditII, float creditSA)
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

    public void setDebitCOH(float debitCOH) {
        this.debitCOH = debitCOH;
    }

    public void setDebitSA(float debitSA) {
        this.debitSA = debitSA;
    }

    public void setCreditCOH(float creditCOH) {
        this.creditCOH = creditCOH;
    }

    public void setCreditLR(float creditLR) {
        this.creditLR = creditLR;
    }

    public void setCreditSD(float creditSD) {
        this.creditSD = creditSD;
    }

    public void setCreditTD(float creditTD) {
        this.creditTD = creditTD;
    }

    public void setCreditII(float creditII) {
        this.creditII = creditII;
    }

    public String getDate() {
        return date;
    }

    public String getParticular() {
        return particular;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

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

    public float getDebitCOH() {
        return debitCOH;
    }

    public float getDebitSA() {
        return debitSA;
    }

    public float getCreditCOH() {
        return creditCOH;
    }

    public float getCreditLR() {
        return creditLR;
    }

    public float getCreditSD() {
        return creditSD;
    }

    public float getCreditTD() {
        return creditTD;
    }

    public float getCreditII() {
        return creditII;
    }
}
