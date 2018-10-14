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

import java.util.List;

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
        TableColumn<CashReceiptsRegister, String>
                debitCOH = new TableColumn("Debit"),
                creditCOH = new TableColumn("Credit");
        COH.getColumns().addAll(debitCOH, creditCOH);

        debitCOH.setCellValueFactory(new PropertyValueFactory<>("debitCOH"));
        creditCOH.setCellValueFactory(new PropertyValueFactory<>("creditCOH"));

        //Loans Receivable
        TableColumn LR = new TableColumn("Loans Receivable");
        TableColumn<CashRecieptAEntry, String>  typeOfLoanLR = new TableColumn("Type of Loan No.");
        TableColumn<CashReceiptsRegister, String>
                accountNoLR = new TableColumn("ACCT. NO."),
                creditLR = new TableColumn("Credit");
        LR.getColumns().addAll(typeOfLoanLR, accountNoLR, creditLR);

        typeOfLoanLR.setCellValueFactory(new PropertyValueFactory<>("typeOfLoanLR"));
        accountNoLR.setCellValueFactory(new PropertyValueFactory<>("accountNoLR"));
        creditLR.setCellValueFactory(new PropertyValueFactory<>("creditLR"));

        //Savings Deposit
        TableColumn SD = new TableColumn("Savings Deposit");
        TableColumn<CashRecieptAEntry, String>  accountNoSD = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, String>  creditSD = new TableColumn("Credit");
        SD.getColumns().addAll(accountNoSD, creditSD);

        accountNoSD.setCellValueFactory(new PropertyValueFactory<>("accountNoSD"));
        creditSD.setCellValueFactory(new PropertyValueFactory<>("creditSD"));

        //Time Deposit
        TableColumn TD = new TableColumn("Time Deposit");
        TableColumn<CashRecieptAEntry, String>  accountNoTD = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, String>  creditTD = new TableColumn("Credit");
        TD.getColumns().addAll(accountNoTD, creditTD);

        accountNoTD.setCellValueFactory(new PropertyValueFactory<>("accountNoTD"));
        creditTD.setCellValueFactory(new PropertyValueFactory<>("creditTD"));

        //Int Inc
        TableColumn II = new TableColumn("Int. Inc.");
        TableColumn<CashRecieptAEntry, String>  accountNoII = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, String>  creditII = new TableColumn("Credit");
        II.getColumns().addAll(accountNoII, creditII);

        accountNoII.setCellValueFactory(new PropertyValueFactory<>("accountNoII"));
        creditII.setCellValueFactory(new PropertyValueFactory<>("creditII"));

        //Sundry Accounts
        TableColumn SA = new TableColumn("Sundry Accounts");
        TableColumn<CashRecieptAEntry, String>  accountNoSA = new TableColumn("ACCT. NO.");
        TableColumn<CashReceiptsRegister, String>  debitSA = new TableColumn("Debit");
        TableColumn<CashReceiptsRegister, String>  creditSA = new TableColumn("Credit");
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
        int entryCount = GetUUID().size();

        for (int i = 0; i < entryCount; i++) {
//            int typeOfLoanCtr = 0,
//                accountNoLRCtr = 0,
//                accountNoSDCtr = 0,
//                accountNoTDCtr = 0,
//                accountNoIICtr = 0,
//                accountNoSACtr = 0,
//                debitCOHCtr = 0,
//                debitSACtr = 0,
//                creditCOHCtr = 0,
//                creditLRCtr = 0,
//                creditSDCtr = 0,
//                creditTDCtr = 0,
//                creditIICtr = 0,
//                creditSACtr = 0;

            String uuid = GetUUID().get(i);

            List<String>
                    typeOfLoansList = GetAccountNo(uuid, CreditTitles.Loans_Receivable),
                    accountNoLRList = GetAccountNo(uuid, CreditTitles.Loans_Receivable),
                    accountNoSDList = GetAccountNo(uuid, CreditTitles.Savings_Deposit),
                    accountNoTDList = GetAccountNo(uuid, CreditTitles.Time_Deposit),
                    accountNoIIList = GetAccountNo(uuid, CreditTitles.INT_INC),
                    accountNoSAList = GetAccountNo(uuid, CreditTitles.Sundry_Accounts),
                    debitCOHList = GetDebit(uuid, CreditTitles.Cash_On_Hand),
                    debitSAList = GetDebit(uuid, CreditTitles.Sundry_Accounts),
                    creditCOHList = GetCredit(uuid, CreditTitles.Cash_On_Hand),
                    creditLRList = GetCredit(uuid, CreditTitles.Loans_Receivable),
                    creditSDList = GetCredit(uuid, CreditTitles.Savings_Deposit),
                    creditTDList = GetCredit(uuid, CreditTitles.Time_Deposit),
                    creditIIList = GetCredit(uuid, CreditTitles.INT_INC),
                    creditSAList = GetCredit(uuid, CreditTitles.Sundry_Accounts);

            List<String>[] allLists = new List[]
                    {
                        typeOfLoansList, accountNoLRList, accountNoSDList, accountNoTDList, accountNoIIList,
                        accountNoSAList, debitCOHList, debitSAList, creditCOHList, creditLRList, creditSDList,
                        creditTDList, creditIIList, creditSAList
                    };

            for (List<String> list : allLists)
                list.add("");

            for (int owo = 0; owo < GetSimilarUUIDCount(uuid); owo++)
            {
                if (owo == 0)
                    entries.add(new CashRecieptAEntry
                            (
                                    GetDate(uuid),
                                    GetParticular(uuid),
                                    GetReferenceNo(uuid),
                                    typeOfLoansList.get(owo),
                                    accountNoLRList.get(owo),
                                    accountNoSDList.get(owo),
                                    accountNoTDList.get(owo),
                                    accountNoIIList.get(owo),
                                    accountNoSAList.get(owo),
                                    debitCOHList.get(owo),
                                    debitSAList.get(owo),
                                    creditCOHList.get(owo),
                                    creditLRList.get(owo),
                                    creditSDList.get(owo),
                                    creditTDList.get(owo),
                                    creditIIList.get(owo),
                                    creditSAList.get(owo)
                            )
                    );
                else {
                    int ctr = 0;

                    String[] strings = {
                            typeOfLoansList.get(UpdateCtr(typeOfLoansList, owo)),
                            accountNoLRList.get(UpdateCtr(accountNoLRList, owo)),
                            accountNoSDList.get(UpdateCtr(accountNoSDList, owo)),
                            accountNoTDList.get(UpdateCtr(accountNoTDList, owo)),
                            accountNoIIList.get(UpdateCtr(accountNoIIList, owo)),
                            accountNoSAList.get(UpdateCtr(accountNoSAList, owo)),

                            debitCOHList.get(UpdateCtr(debitCOHList, owo)),
                            debitSAList.get(UpdateCtr(debitSAList, owo)),

                            creditCOHList.get(UpdateCtr(creditCOHList, owo)),
                            creditLRList.get(UpdateCtr(creditLRList, owo)),
                            creditSDList.get(UpdateCtr(creditSDList, owo)),
                            creditTDList.get(UpdateCtr(creditTDList, owo)),
                            creditIIList.get(UpdateCtr(creditIIList, owo)),
                            creditSAList.get(UpdateCtr(creditSAList, owo))
                    };

                    for (String s : strings)
                    {
                        if (s == "")
                            ctr++;
                    }


                    if (ctr != strings.length)
                        entries.add(new CashRecieptAEntry
                            (
                                    "",
                                    "",
                                    "",
                                    typeOfLoansList.get(UpdateCtr(typeOfLoansList, owo)),
                                    accountNoLRList.get(UpdateCtr(accountNoLRList, owo)),
                                    accountNoSDList.get(UpdateCtr(accountNoSDList, owo)),
                                    accountNoTDList.get(UpdateCtr(accountNoTDList, owo)),
                                    accountNoIIList.get(UpdateCtr(accountNoIIList, owo)),
                                    accountNoSAList.get(UpdateCtr(accountNoSAList, owo)),

                                    debitCOHList.get(UpdateCtr(debitCOHList, owo)),
                                    debitSAList.get(UpdateCtr(debitSAList, owo)),

                                    creditCOHList.get(UpdateCtr(creditCOHList, owo)),
                                    creditLRList.get(UpdateCtr(creditLRList, owo)),
                                    creditSDList.get(UpdateCtr(creditSDList, owo)),
                                    creditTDList.get(UpdateCtr(creditTDList, owo)),
                                    creditIIList.get(UpdateCtr(creditIIList, owo)),
                                    creditSAList.get(UpdateCtr(creditSAList, owo))
                            )
                    );
                }
            }
        }

        return entries;
    }

    private int UpdateCtr(List<String> list, int loopCtr)
    {
        if (loopCtr < list.size()) {
            return loopCtr;
        }

        return list.size() - 1;
    }
}
