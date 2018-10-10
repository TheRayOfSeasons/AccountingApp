package Pages;

import Java.DatabaseHandler;
import Java.Events;
import Java.Initialize;
import Java.Scenes;
import Objects.CashRecieptAEntry;
import Objects.CreditTitles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ViewDatabase extends DatabaseHandler
{
    private VBox mainLayout;

    private Button
        backToMain;

    private TableView<CashRecieptAEntry> table;

    public ViewDatabase () {}

    public Scene GetScene ()
    {
        SetupLayouts();
        SetupContents();

        Scene scene = new Scene(mainLayout, Initialize.StandardWindowMinWidth(), Initialize.StandardWindowMinHeight());
        return scene;
    }

    private void SetupLayouts ()
    {
        mainLayout = new VBox(20);
        Initialize.StandardVBOX(mainLayout);
    }

    private void SetupContents ()
    {
        SetupTable();

        backToMain = new Button();
        backToMain.setText("Return to Main");
        backToMain.setOnAction(event -> Events.SwitchSceneTo(Scenes.MainMenuLayout()));

        mainLayout.getChildren().addAll(table, backToMain);
    }

    private void SetupTable ()
    {
        table = new TableView<>();
        table.setEditable(false);

        TableColumn<CashRecieptAEntry, String>
                date = new TableColumn("Date"),
                particulars = new TableColumn("Particulars"),
                referenceNo = new TableColumn("REF NO.");

        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        particulars.setCellValueFactory(new PropertyValueFactory<>("particular"));
        referenceNo.setCellValueFactory(new PropertyValueFactory<>("referenceNo"));

        //Cash on hand
        TableColumn COH = new TableColumn("Cash On Hand");
        TableColumn<CashReceiptsRegister, Float>
                debitCOH = new TableColumn("Debit"),
                creditCOH = new TableColumn("Credit");
        COH.getColumns().addAll(debitCOH, creditCOH);

        debitCOH.setCellValueFactory(new PropertyValueFactory<>("debitCOH"));
        creditCOH.setCellValueFactory(new PropertyValueFactory<>("creditCOH"));

        //Loans Receivable
        TableColumn LR = new TableColumn("Loans Receivable");
        TableColumn<CashRecieptAEntry, String>  typeOfLoanLR = new TableColumn("Type of Loan No.");
        TableColumn<CashReceiptsRegister, Float>
                accountNoLR = new TableColumn("ACCT. NO."),
                creditLR = new TableColumn("Credit");
        LR.getColumns().addAll(typeOfLoanLR, accountNoLR, creditLR);

        typeOfLoanLR.setCellValueFactory(new PropertyValueFactory<>("typeOfLoanLR"));
        accountNoLR.setCellValueFactory(new PropertyValueFactory<>("accountNoLR"));
        creditLR.setCellValueFactory(new PropertyValueFactory<>("creditLR"));

        //Savings Deposit
        TableColumn SD = new TableColumn("Savings Deposit");
        TableColumn<CashRecieptAEntry, String>  accountNoSD = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, Float>  creditSD = new TableColumn("Credit");
        SD.getColumns().addAll(accountNoSD, creditSD);

        accountNoSD.setCellValueFactory(new PropertyValueFactory<>("accountNoSD"));
        creditSD.setCellValueFactory(new PropertyValueFactory<>("creditSD"));

        //Time Deposit
        TableColumn TD = new TableColumn("Time Deposit");
        TableColumn<CashRecieptAEntry, String>  accountNoTD = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, Float>  creditTD = new TableColumn("Credit");
        TD.getColumns().addAll(accountNoTD, creditTD);

        accountNoTD.setCellValueFactory(new PropertyValueFactory<>("accountNoTD"));
        creditTD.setCellValueFactory(new PropertyValueFactory<>("creditTD"));

        //Int Inc
        TableColumn II = new TableColumn("Int. Inc.");
        TableColumn<CashRecieptAEntry, String>  accountNoII = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, Float>  creditII = new TableColumn("Credit");
        II.getColumns().addAll(accountNoII, creditII);

        accountNoII.setCellValueFactory(new PropertyValueFactory<>("accountNoII"));
        creditII.setCellValueFactory(new PropertyValueFactory<>("creditII"));

        //Sundry Accounts
        TableColumn SA = new TableColumn("Sundry Accounts");
        TableColumn<CashRecieptAEntry, String>  accountNoSA = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, Float>  debitSA = new TableColumn("Debit");
        TableColumn<CashReceiptsRegister, Float>  creditSA = new TableColumn("Credit");
        SA.getColumns().addAll(accountNoSA, debitSA, creditSA);

        accountNoSA.setCellValueFactory(new PropertyValueFactory<>("accountNoSA"));
        debitSA.setCellValueFactory(new PropertyValueFactory<>("debitSA"));
        creditSA.setCellValueFactory(new PropertyValueFactory<>("creditSA"));

        table.setItems(GetEntries());
        table.getColumns().addAll(date, particulars, referenceNo, COH, LR, SD, TD, II, SA);
    }

    public ObservableList<CashRecieptAEntry> GetEntries()
    {
        ObservableList<CashRecieptAEntry> entries = FXCollections.observableArrayList();

        for (int i = 0; i < 1; i++)
        {
            entries.add(new CashRecieptAEntry
                    (
                        GetDates().get(i),
                        GetParticulars().get(i),
                        GetReferenceNo().get(i),
                        GetTypeOfLoan().get(i),
                        GetAccountNo(CreditTitles.Loans_Receivable).get(i),
                        GetAccountNo(CreditTitles.Savings_Deposit).get(i),
                        GetAccountNo(CreditTitles.Time_Deposit).get(i),
                        GetAccountNo(CreditTitles.INT_INC).get(i),
                        GetAccountNo(CreditTitles.Sundry_Accounts).get(i),
                        GetDebits(CreditTitles.Cash_On_Hand).get(i),
                        GetDebits(CreditTitles.Sundry_Accounts).get(i),
                        GetCredits(CreditTitles.Cash_On_Hand).get(i),
                        GetCredits(CreditTitles.Loans_Receivable).get(i),
                        GetCredits(CreditTitles.Savings_Deposit).get(i),
                        GetCredits(CreditTitles.Time_Deposit).get(i),
                        GetCredits(CreditTitles.INT_INC).get(i),
                        GetCredits(CreditTitles.Sundry_Accounts).get(i)
                    )
            );
        }

        return entries;
    }
}
