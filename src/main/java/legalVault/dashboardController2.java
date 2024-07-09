package legalVault;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import legalVault.data.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class dashboardController2 implements Initializable {

    @FXML
    private TextField casesCaseID;

    @FXML
    private Button casesClearBtn;

    @FXML
    private TableColumn<CaseData, String> casesColCaseID;

    @FXML
    private TableColumn<CaseData, String> casesColCourtID;

    @FXML
    private TableColumn<CaseData, String> casesColDefendantID;

    @FXML
    private TableColumn<CaseData, String> casesColEndDate;

    @FXML
    private TableColumn<CaseData, String> casesColJudgeID;

    @FXML
    private TableColumn<CaseData, String> casesColNextHearing;

    @FXML
    private TableColumn<CaseData, String> casesColOffenseID;

    @FXML
    private TableColumn<CaseData, String> casesColProsecutorID;

    @FXML
    private TableColumn<CaseData, String> casesColStartDate;

    @FXML
    private TableColumn<CaseData, String> casesColStatus;

    @FXML
    private TextField casesCourtID;

    @FXML
    private TextField casesDefendantID;

    @FXML
    private Button casesDeleteBtn;

    @FXML
    private TextField casesEndDate;

    @FXML
    private AnchorPane casesForm;

    @FXML
    private Button casesInsertBtn;

    @FXML
    private TextField casesJudgeID;

    @FXML
    private TextField casesNextHearing;

    @FXML
    private TextField casesOffenseID;

    @FXML
    private TextField casesProsecutorID;

    @FXML
    private TextField casesSearch;

    @FXML
    private TextField casesStartDate;

    @FXML
    private TextField casesStatus;

    @FXML
    private TableView<CaseData> casesTableView;

    @FXML
    private Button casesUpdateBtn;

    @FXML
    private Button cases_btn;

    @FXML
    private Button close_btn;

    @FXML
    private TextField courtsAddress;

    @FXML
    private Button courtsClearBtn;

    @FXML
    private TableColumn<CourtData, String> courtsColAdress;

    @FXML
    private TableColumn<CourtData, Integer> courtsColCourtID;

    @FXML
    private TextField courtsCourtID;

    @FXML
    private Button courtsDeleteBtn;

    @FXML
    private AnchorPane courtsForm;

    @FXML
    private Button courtsInsertBtn;

    @FXML
    private TextField courtSearch;

    @FXML
    private TableView<CourtData> courtsTableView;

    @FXML
    private Button courtsUpdateBtn;

    @FXML
    private Button courts_btn;

    @FXML
    private PieChart homeCaseDPieDistribution;

    @FXML
    private AnchorPane homeForm;

    @FXML
    private Label homeTotalCases;

    @FXML
    private Label homeTotalJudges;

    @FXML
    private Label homeTotalLawyers;

    @FXML
    private Label homeTotalWitnesses;

    @FXML
    private Button home_btn;

    @FXML
    private TextField judgesAddress;

    @FXML
    private Button judgesClearBtn;

    @FXML
    private TableColumn<JudgeData, String> judgesColAddress;

    @FXML
    private TableColumn<JudgeData, String> judgesColCourtAddress;

    @FXML
    private TableColumn<JudgeData, String> judgesColCourtID;

    @FXML
    private TableColumn<JudgeData, String> judgesColDOB;

    @FXML
    private TableColumn<JudgeData, String> judgesColFirstName;

    @FXML
    private TableColumn<JudgeData, String> judgesColJudgeID;

    @FXML
    private TableColumn<JudgeData, String> judgesColLastName;

    @FXML
    private TableColumn<JudgeData, String> judgesColMobile;

    @FXML
    private TableColumn<JudgeData, String> judgesColPersonID;

    @FXML
    private TextField judgesCourtID;

    @FXML
    private TextField judgesCourtAddress;

    @FXML
    private TextField judgesDOB;

    @FXML
    private Button judgesDeleteBtn;

    @FXML
    private TextField judgesFirstName;

    @FXML
    private AnchorPane judgesForm;

    @FXML
    private Button judgesInsertBtn;

    @FXML
    private TextField judgesJudgeID;

    @FXML
    private TextField judgesLastName;

    @FXML
    private TextField judgesMob;

    @FXML
    private TextField judgesPersonID;

    @FXML
    private TextField judgesSearch;

    @FXML
    private TableView<JudgeData> judgesTableView;

    @FXML
    private Button judgesUpdateBtn;

    @FXML
    private Button judges_btn;

    @FXML
    private TextField lawyersAddress;

    @FXML
    private Button lawyersClearBtn;

    @FXML
    private TableColumn<LawyerData, String> lawyersColAddress;

    @FXML
    private TableColumn<LawyerData, String> lawyersColCourtAddress;

    @FXML
    private TableColumn<LawyerData, String> lawyersColCourtID;

    @FXML
    private TableColumn<LawyerData, String> lawyersColDateOfBirth;

    @FXML
    private TableColumn<LawyerData, String> lawyersColFirstName;

    @FXML
    private TableColumn<LawyerData, String> lawyersColLastName;

    @FXML
    private TableColumn<LawyerData, String> lawyersColLawyerID;

    @FXML
    private TableColumn<LawyerData, String> lawyersColMobileNumber;

    @FXML
    private TableColumn<LawyerData, String> lawyersColPersonID;

    @FXML
    private TextField lawyersCourtID;

    @FXML
    private TextField lawyersDOB;

    @FXML
    private Button lawyersDeleteBtn;

    @FXML
    private TextField lawyersFirstName;

    @FXML
    private AnchorPane lawyersForm;

    @FXML
    private Button lawyersInsertBtn;

    @FXML
    private TextField lawyersLastName;

    @FXML
    private TextField lawyersLawyerID;

    @FXML
    private TextField lawyersMobNo;

    @FXML
    private TextField lawyersPersonID;

    @FXML
    private TextField lawyersCourtAddress;

    @FXML
    private TextField lawyersSearch;

    @FXML
    private TableView<LawyerData> lawyersTableView;

    @FXML
    private Button lawyersUpdateBtn;

    @FXML
    private Button lawyers_btn;

    @FXML
    private Button logout;

    @FXML
    private Button minimize_btn;

    @FXML
    private Label username;

    @FXML
    private TextField witnessesAddress;

    @FXML
    private TextField witnessesCaseID;

    @FXML
    private Button witnessesClearBtn;

    @FXML
    private TableColumn<WitnessData, String> witnessesColAddress;

    @FXML
    private TableColumn<WitnessData, String> witnessesColCaseID;

    @FXML
    private TableColumn<WitnessData, String> witnessesColDOB;

    @FXML
    private TableColumn<WitnessData, String> witnessesColFirstName;

    @FXML
    private TableColumn<WitnessData, String> witnessesColLastName;

    @FXML
    private TableColumn<WitnessData, String> witnessesColMobile;

    @FXML
    private TableColumn<WitnessData, String> witnessesColPersonID;

    @FXML
    private TableColumn<WitnessData, String> witnessesColWitnessID;

    @FXML
    private TextField witnessesDOB;

    @FXML
    private Button witnessesDeleteBtn;

    @FXML
    private TextField witnessesFirstName;

    @FXML
    private AnchorPane witnessesForm;

    @FXML
    private Button witnessesInsertBtn;

    @FXML
    private TextField witnessesLastName;

    @FXML
    private TextField witnessesMobile;

    @FXML
    private TextField witnessesPersonID;

    @FXML
    private TextField witnessesSearch;

    @FXML
    private TableView<WitnessData> witnessesTableView;

    @FXML
    private Button witnessesUpdateBtn;

    @FXML
    private TextField witnessesWitnessID;

    @FXML
    private Button witnesses_btn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Label homeAvgTime;

        public void logout() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentFrontend.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardclose() {
        System.exit(0);
    }
    public void dashboardminimize() {
        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    public void displayUsername(){
            username.setText(LoginController.currentUsername);
    }

    public void getHomeTotalCases() throws Exception {

        Connection connection=Connector.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT COUNT(case_id) FROM Cases");
        int countCases = 0;
            while (rs.next()) {
                countCases= rs.getInt("COUNT(case_id)");
            }

            homeTotalCases.setText(String.valueOf(countCases));
    }
    public void getHomeTotalJudges() throws Exception {

        Connection connection=Connector.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT COUNT(judge_id) FROM Judges");
        int countJudges = 0;
        while (rs.next()) {
            countJudges= rs.getInt("COUNT(judge_id)");
        }

        homeTotalJudges.setText(String.valueOf(countJudges));
    }
    public void getHomeTotalLawyers() throws Exception {

        Connection connection=Connector.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT COUNT(lawyer_id) FROM lawyers");
        int count = 0;
        while (rs.next()) {
            count= rs.getInt("COUNT(lawyer_id)");
        }

        homeTotalLawyers.setText(String.valueOf(count));
    }
    public void getHomeTotalWitnesses() throws Exception {

        Connection connection=Connector.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT COUNT(witness_id) FROM Witnesses");
        int count = 0;
        while (rs.next()) {
            count= rs.getInt("COUNT(witness_id)");
        }

        homeTotalWitnesses.setText(String.valueOf(count));
    }


    public void switchForm(ActionEvent actionEvent) {
        if (actionEvent.getSource() == home_btn) {
            homeForm.setVisible(true);
            casesForm.setVisible(false);
            courtsForm.setVisible(false);
            judgesForm.setVisible(false);
            lawyersForm.setVisible(false);
            witnessesForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            cases_btn.setStyle("-fx-background-color:transparent");
            courts_btn.setStyle("-fx-background-color:transparent");
            judges_btn.setStyle("-fx-background-color:transparent");
            lawyers_btn.setStyle("-fx-background-color:transparent");
            witnesses_btn.setStyle("-fx-background-color:transparent");


            try {
                getHomeTotalCases();
                getHomeTotalJudges();
                getHomeTotalLawyers();
                getHomeTotalWitnesses();
                getHomeAvgTime();
                setHomeCaseDPieDistribution();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (actionEvent.getSource() == cases_btn) {
            homeForm.setVisible(false);
            casesForm.setVisible(true);
            courtsForm.setVisible(false);
            judgesForm.setVisible(false);
            lawyersForm.setVisible(false);
            witnessesForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:transparent");
            cases_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            courts_btn.setStyle("-fx-background-color:transparent");
            judges_btn.setStyle("-fx-background-color:transparent");
            lawyers_btn.setStyle("-fx-background-color:transparent");
            witnesses_btn.setStyle("-fx-background-color:transparent");

            casesShowListData();


        } else if (actionEvent.getSource() ==courts_btn ) {
            homeForm.setVisible(false);
            casesForm.setVisible(false);
            courtsForm.setVisible(true);
            judgesForm.setVisible(false);
            lawyersForm.setVisible(false);
            witnessesForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:transparent");
            cases_btn.setStyle("-fx-background-color:transparent");
            courts_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            judges_btn.setStyle("-fx-background-color:transparent");
            lawyers_btn.setStyle("-fx-background-color:transparent");
            witnesses_btn.setStyle("-fx-background-color:transparent");

            courtsShowListData();


        } else if (actionEvent.getSource() ==judges_btn ) {
            homeForm.setVisible(false);
            casesForm.setVisible(false);
            courtsForm.setVisible(false);
            judgesForm.setVisible(true);
            lawyersForm.setVisible(false);
            witnessesForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:transparent");
            cases_btn.setStyle("-fx-background-color:transparent");
            courts_btn.setStyle("-fx-background-color:transparent");
            judges_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            lawyers_btn.setStyle("-fx-background-color:transparent");
            witnesses_btn.setStyle("-fx-background-color:transparent");

            judgesShowListData();


        } else if (actionEvent.getSource() ==lawyers_btn ) {
            homeForm.setVisible(false);
            casesForm.setVisible(false);
            courtsForm.setVisible(false);
            judgesForm.setVisible(false);
            lawyersForm.setVisible(true);
            witnessesForm.setVisible(false);

            home_btn.setStyle("-fx-background-color:transparent");
            cases_btn.setStyle("-fx-background-color:transparent");
            courts_btn.setStyle("-fx-background-color:transparent");
            judges_btn.setStyle("-fx-background-color:transparent");
            lawyers_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            witnesses_btn.setStyle("-fx-background-color:transparent");

            lawyersShowListData();


        } else if (actionEvent.getSource() ==witnesses_btn ) {
            homeForm.setVisible(false);
            casesForm.setVisible(false);
            courtsForm.setVisible(false);
            judgesForm.setVisible(false);
            lawyersForm.setVisible(false);
            witnessesForm.setVisible(true);

            home_btn.setStyle("-fx-background-color:transparent");
            cases_btn.setStyle("-fx-background-color:transparent");
            courts_btn.setStyle("-fx-background-color:transparent");
            judges_btn.setStyle("-fx-background-color:transparent");
            lawyers_btn.setStyle("-fx-background-color:transparent");
            witnesses_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");

            witnessesShowListData();


        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courtsShowListData();
        lawyersShowListData();
        judgesShowListData();
        witnessesShowListData();
        casesShowListData();
        displayUsername();
        switchForm(new ActionEvent(home_btn, null));
        try {
            setHomeCaseDPieDistribution();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    // COURTS
    public ObservableList<CourtData> courtsListData(){
        ObservableList<CourtData> listData = FXCollections.observableArrayList();
        try {
            ResultSet rs=MainUtils.getCourts("TRUE");
            CourtData courtD;
            while (rs.next()){

                courtD=new CourtData(rs.getInt("court_id"),rs.getString("address"));
                listData.add(courtD);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listData;

    }
    //showing courts table
    private ObservableList<CourtData> courtsList;
    public void courtsShowListData() {
        courtsList = courtsListData();

        courtsColCourtID.setCellValueFactory(new PropertyValueFactory<>("courtId"));
        courtsColAdress.setCellValueFactory(new PropertyValueFactory<>("courtAddress"));
        courtsTableView.setItems(courtsList);

    }
    public void courtResetClicked() {
        courtsCourtID.setText("");
        courtsAddress.setText("");
    }

    public void courtDeleteClicked(){
        try {

            Alert alert;
            if (courtsCourtID.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the CourtID field");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE CourtID: " + courtsCourtID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    MainUtils.deleteCourt(courtsCourtID.getText());

                    courtsShowListData();
                    courtResetClicked();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void courtInsertClicked(){

        try {
            Alert alert;
            if (courtsAddress.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter CourtAddress Field");
                alert.showAndWait();
            } else {
                MainUtils.createCourt(courtsAddress.getText());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                courtsShowListData();
            }



    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void courtUpdateClicked(){
        try {
            Alert alert;
            if (courtsCourtID.getText().isEmpty()
                    || courtsAddress.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE CourtID: " + courtsCourtID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    MainUtils.updateCourt(courtsCourtID.getText(),courtsAddress.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    courtsShowListData();
                    courtResetClicked();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void courtsSearch() {

        FilteredList<CourtData> filter = new FilteredList<>(courtsList, e -> true);

        courtSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCourtData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCourtData.getCourtId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCourtData.getCourtAddress().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<CourtData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(courtsTableView.comparatorProperty());
        courtsTableView.setItems(sortList);
    }

    public void courtsSelect() {
        CourtData employeeD = courtsTableView.getSelectionModel().getSelectedItem();
        int num = courtsTableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        courtsCourtID.setText(String.valueOf(employeeD.getCourtId()));
        courtsAddress.setText(employeeD.getCourtAddress());
    }


    // LAWYERS
    public ObservableList<LawyerData> lawyersListData(){
        ObservableList<LawyerData> listData = FXCollections.observableArrayList();
        try {
            ResultSet rs= MainUtils.getLawyers("TRUE");
            LawyerData lawyerD;
            while (rs.next()){

                lawyerD=new LawyerData(rs.getString("person_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("mob_no"), rs.getString("date_of_birth"), rs.getString("persons.address"), rs.getString("lawyer_id"), rs.getString("court_id"), rs.getString("courts.address"));
                listData.add(lawyerD);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listData;

    }
    //showing lawyers table
    private ObservableList<LawyerData> lawyersList;
    public void lawyersShowListData() {
        lawyersList = lawyersListData();

        lawyersColPersonID.setCellValueFactory(new PropertyValueFactory<>("personId"));
        lawyersColFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lawyersColLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lawyersColMobileNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        lawyersColDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        lawyersColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        lawyersColLawyerID.setCellValueFactory(new PropertyValueFactory<>("lawyerId"));
        lawyersColCourtID.setCellValueFactory(new PropertyValueFactory<>("courtId"));
        lawyersColCourtAddress.setCellValueFactory(new PropertyValueFactory<>("courtAddress"));
        lawyersTableView.setItems(lawyersList);

    }
    public void lawyerResetClicked() {
        lawyersPersonID.setText("");
        lawyersFirstName.setText("");
        lawyersLastName.setText("");
        lawyersMobNo.setText("");
        lawyersDOB.setText("");
        lawyersAddress.setText("");
        lawyersLawyerID.setText("");
        lawyersCourtID.setText("");
        lawyersCourtAddress.setText("");
    }

    public void lawyerDeleteClicked(){
        try {

            Alert alert;
            if (lawyersLawyerID.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the LawyerID field");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE LawyerID: " + lawyersLawyerID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    MainUtils.deleteLawyer(lawyersLawyerID.getText());

                    lawyersShowListData();
                    lawyerResetClicked();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lawyerInsertClicked(){

        try {
            Alert alert;
            if (lawyersFirstName.getText().isEmpty() || lawyersLastName.getText().isEmpty() || lawyersDOB.getText().isEmpty() || lawyersAddress.getText().isEmpty() || lawyersMobNo.getText().isEmpty() || lawyersCourtID.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all Fields");
                alert.showAndWait();
            } else {
                MainUtils.createLawyer(lawyersFirstName.getText(), lawyersLastName.getText(), lawyersMobNo.getText(), lawyersAddress.getText(), lawyersDOB.getText(), lawyersCourtID.getText());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                lawyersShowListData();
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lawyerUpdateClicked(){
        try {
            Alert alert;
            if (lawyersFirstName.getText().isEmpty() || lawyersLastName.getText().isEmpty() || lawyersMobNo.getText().isEmpty() || lawyersAddress.getText().isEmpty() || lawyersCourtID.getText().isEmpty() || lawyersDOB.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE LawyerID: " + lawyersLawyerID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    MainUtils.updateLawyer(lawyersLawyerID.getText(), lawyersFirstName.getText(), lawyersLastName.getText(), lawyersMobNo.getText(), lawyersAddress.getText(), lawyersDOB.getText(), lawyersCourtID.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    lawyersShowListData();
                    lawyerResetClicked();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lawyersSearch() {

        FilteredList<LawyerData> filter = new FilteredList<>(lawyersList, e -> true);

        lawyersSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateLawyerData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateLawyerData.getLawyerId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateLawyerData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return predicateLawyerData.getLastName().toLowerCase().contains(searchKey);
                }
            });
        });
        SortedList<LawyerData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(lawyersTableView.comparatorProperty());
        lawyersTableView.setItems(sortList);
    }

    public void lawyersSelect() {
        LawyerData employeeD = lawyersTableView.getSelectionModel().getSelectedItem();
        int num = lawyersTableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        lawyersPersonID.setText(employeeD.getPersonId());
        lawyersDOB.setText(employeeD.getDateOfBirth());
        lawyersLawyerID.setText(employeeD.getLawyerId());
        lawyersFirstName.setText(employeeD.getFirstName());
        lawyersLastName.setText(employeeD.getLastName());
        lawyersAddress.setText(employeeD.getAddress());
        lawyersMobNo.setText(employeeD.getMobileNumber());
        lawyersCourtID.setText(employeeD.getCourtId());
    }



    // JUDGES
    public ObservableList<JudgeData> judgesListData(){
        ObservableList<JudgeData> listData = FXCollections.observableArrayList();
        try {
            ResultSet rs= MainUtils.getJudges("TRUE");
            JudgeData judgeD;
            while (rs.next()){

                judgeD=new JudgeData(rs.getString("person_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("mob_no"), rs.getString("date_of_birth"), rs.getString("persons.address"), rs.getString("judge_id"), rs.getString("court_id"), rs.getString("courts.address"));
                listData.add(judgeD);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listData;

    }
    //showing judges table
    private ObservableList<JudgeData> judgesList;
    public void judgesShowListData() {
        judgesList = judgesListData();

        judgesColPersonID.setCellValueFactory(new PropertyValueFactory<>("personId"));
        judgesColFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        judgesColLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        judgesColMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        judgesColDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        judgesColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        judgesColJudgeID.setCellValueFactory(new PropertyValueFactory<>("judgeId"));
        judgesColCourtID.setCellValueFactory(new PropertyValueFactory<>("courtId"));
        judgesColCourtAddress.setCellValueFactory(new PropertyValueFactory<>("courtAddress"));
        judgesTableView.setItems(judgesList);

    }
    public void judgeResetClicked() {
        judgesPersonID.setText("");
        judgesFirstName.setText("");
        judgesLastName.setText("");
        judgesMob.setText("");
        judgesDOB.setText("");
        judgesAddress.setText("");
        judgesJudgeID.setText("");
        judgesCourtID.setText("");
        judgesCourtAddress.setText("");
    }

    public void judgeDeleteClicked(){
        try {

            Alert alert;
            if (judgesJudgeID.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the JudgeID field");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE JudgeID: " + judgesJudgeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    MainUtils.deleteJudge(judgesJudgeID.getText());

                    judgesShowListData();
                    judgeResetClicked();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void judgeInsertClicked(){

        try {
            Alert alert;
            if (judgesFirstName.getText().isEmpty() || judgesLastName.getText().isEmpty() || judgesDOB.getText().isEmpty() || judgesAddress.getText().isEmpty() || judgesMob.getText().isEmpty() || judgesCourtID.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all Fields");
                alert.showAndWait();
            } else {
                MainUtils.createJudge(judgesFirstName.getText(), judgesLastName.getText(), judgesMob.getText(), judgesAddress.getText(), judgesDOB.getText(), judgesCourtID.getText());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                judgesShowListData();
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void judgeUpdateClicked(){
        try {
            Alert alert;
            if (judgesFirstName.getText().isEmpty() || judgesLastName.getText().isEmpty() || judgesMob.getText().isEmpty() || judgesAddress.getText().isEmpty() || judgesCourtID.getText().isEmpty() || judgesDOB.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE JudgeID: " + judgesJudgeID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    MainUtils.updateJudge(judgesJudgeID.getText(), judgesFirstName.getText(), judgesLastName.getText(), judgesMob.getText(), judgesAddress.getText(), judgesDOB.getText(), judgesCourtID.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    judgesShowListData();
                    judgeResetClicked();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void judgesSearch() {

        FilteredList<JudgeData> filter = new FilteredList<>(judgesList, e -> true);

        judgesSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateJudgeData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateJudgeData.getJudgeId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateJudgeData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return predicateJudgeData.getLastName().toLowerCase().contains(searchKey);
                }
            });
        });
        SortedList<JudgeData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(judgesTableView.comparatorProperty());
        judgesTableView.setItems(sortList);
    }

    public void judgesSelect() {
        JudgeData employeeD = judgesTableView.getSelectionModel().getSelectedItem();
        int num = judgesTableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        judgesPersonID.setText(employeeD.getPersonId());
        judgesJudgeID.setText(employeeD.getJudgeId());
        judgesFirstName.setText(employeeD.getFirstName());
        judgesLastName.setText(employeeD.getLastName());
        judgesDOB.setText(employeeD.getDateOfBirth());
        judgesAddress.setText(employeeD.getAddress());
        judgesMob.setText(employeeD.getMobileNumber());
        judgesCourtID.setText(employeeD.getCourtId());
    }



    // WITNESSES
    public ObservableList<WitnessData> witnessesListData(){
        ObservableList<WitnessData> listData = FXCollections.observableArrayList();
        try {
            ResultSet rs= MainUtils.getWitnesses("TRUE");
            WitnessData witnessD;
            while (rs.next()){

                witnessD=new WitnessData(rs.getString("person_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("mob_no"), rs.getString("date_of_birth"), rs.getString("persons.address"), rs.getString("witness_id"), rs.getString("case_id"));
                listData.add(witnessD);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listData;

    }
    //showing witnesses table
    private ObservableList<WitnessData> witnessesList;
    public void witnessesShowListData() {
        witnessesList = witnessesListData();

        witnessesColPersonID.setCellValueFactory(new PropertyValueFactory<>("personId"));
        witnessesColFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        witnessesColLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        witnessesColMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        witnessesColDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        witnessesColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        witnessesColWitnessID.setCellValueFactory(new PropertyValueFactory<>("witnessId"));
        witnessesColCaseID.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        witnessesTableView.setItems(witnessesList);

    }
    public void witnessResetClicked() {
        witnessesPersonID.setText("");
        witnessesFirstName.setText("");
        witnessesLastName.setText("");
        witnessesMobile.setText("");
        witnessesDOB.setText("");
        witnessesAddress.setText("");
        witnessesWitnessID.setText("");
        witnessesCaseID.setText("");
    }

    public void witnessDeleteClicked(){
        try {

            Alert alert;
            if (witnessesWitnessID.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the WitnessID field");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE WitnessID: " + witnessesWitnessID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    MainUtils.deleteWitness(witnessesWitnessID.getText());

                    witnessesShowListData();
                    witnessResetClicked();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void witnessInsertClicked(){

        try {
            Alert alert;
            if (witnessesFirstName.getText().isEmpty() || witnessesLastName.getText().isEmpty() || witnessesDOB.getText().isEmpty() || witnessesAddress.getText().isEmpty() || witnessesMobile.getText().isEmpty() || witnessesCaseID.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all Fields");
                alert.showAndWait();
            } else {
                MainUtils.createWitness(witnessesFirstName.getText(), witnessesLastName.getText(), witnessesMobile.getText(), witnessesAddress.getText(), witnessesDOB.getText(), witnessesCaseID.getText());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                witnessesShowListData();
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void witnessUpdateClicked(){
        try {
            Alert alert;
            if (witnessesFirstName.getText().isEmpty() || witnessesLastName.getText().isEmpty() || witnessesMobile.getText().isEmpty() || witnessesAddress.getText().isEmpty() || witnessesCaseID.getText().isEmpty() || witnessesDOB.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE WitnessID: " + witnessesWitnessID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    MainUtils.updateWitness(witnessesWitnessID.getText(), witnessesFirstName.getText(), witnessesLastName.getText(), witnessesMobile.getText(), witnessesAddress.getText(), witnessesDOB.getText(), witnessesCaseID.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    witnessesShowListData();
                    witnessResetClicked();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void witnessesSearch() {

        FilteredList<WitnessData> filter = new FilteredList<>(witnessesList, e -> true);

        witnessesSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateWitnessData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateWitnessData.getWitnessId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateWitnessData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return predicateWitnessData.getLastName().toLowerCase().contains(searchKey);
                }
            });
        });
        SortedList<WitnessData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(witnessesTableView.comparatorProperty());
        witnessesTableView.setItems(sortList);
    }

    public void witnessesSelect() {
        WitnessData employeeD = witnessesTableView.getSelectionModel().getSelectedItem();
        int num = witnessesTableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        witnessesPersonID.setText(employeeD.getPersonId());
        witnessesDOB.setText(employeeD.getDateOfBirth());
        witnessesWitnessID.setText(employeeD.getWitnessId());
        witnessesFirstName.setText(employeeD.getFirstName());
        witnessesLastName.setText(employeeD.getLastName());
        witnessesAddress.setText(employeeD.getAddress());
        witnessesMobile.setText(employeeD.getMobileNumber());
        witnessesCaseID.setText(employeeD.getCaseId());
    }



    // CASES
    public ObservableList<CaseData> casesListData(){
        ObservableList<CaseData> listData = FXCollections.observableArrayList();
        try {
            ResultSet rs= MainUtils.getCases("TRUE");
            CaseData caseD;
            while (rs.next()){

                caseD=new CaseData(rs.getString("case_id"), rs.getString("court_id"), rs.getString("prosecution_lawyers.lawyer_id"), rs.getString("defending_lawyers.lawyer_id"), rs.getString("judge_id"), rs.getString("case_status"), rs.getString("start_date"), rs.getString("end_date"), rs.getString("next_hearing"), rs.getString("offense_id"));
                listData.add(caseD);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listData;

    }
    //showing cases table
    private ObservableList<CaseData> casesList;
    public void casesShowListData() {
        casesList = casesListData();

        casesColCaseID.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        casesColCourtID.setCellValueFactory(new PropertyValueFactory<>("courtId"));
        casesColProsecutorID.setCellValueFactory(new PropertyValueFactory<>("prosecutorId"));
        casesColDefendantID.setCellValueFactory(new PropertyValueFactory<>("defenseId"));
        casesColJudgeID.setCellValueFactory(new PropertyValueFactory<>("judgeId"));
        casesColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        casesColStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        casesColEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        casesColNextHearing.setCellValueFactory(new PropertyValueFactory<>("nextHearing"));
        casesColOffenseID.setCellValueFactory(new PropertyValueFactory<>("offenseId"));
        casesTableView.setItems(casesList);

    }
    public void caseResetClicked() {
        casesCaseID.setText("");
        casesCourtID.setText("");
        casesProsecutorID.setText("");
        casesDefendantID.setText("");
        casesJudgeID.setText("");
        casesStatus.setText("");
        casesStartDate.setText("");
        casesEndDate.setText("");
        casesNextHearing.setText("");
        casesOffenseID.setText("");
    }

    public void caseDeleteClicked(){
        try {

            Alert alert;
            if (casesCaseID.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the CaseID field");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE CaseID: " + casesCaseID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    MainUtils.deleteCase(casesCaseID.getText());

                    casesShowListData();
                    caseResetClicked();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void caseInsertClicked(){

        try {
            Alert alert;
            if (casesCourtID.getText().isEmpty() || casesProsecutorID.getText().isEmpty() || casesDefendantID.getText().isEmpty() || casesJudgeID.getText().isEmpty() || casesOffenseID.getText().isEmpty() || casesStatus.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all required Fields");
                alert.showAndWait();
            } else {
                MainUtils.createCase(casesCourtID.getText(), casesProsecutorID.getText(), casesDefendantID.getText(), casesJudgeID.getText(), casesOffenseID.getText());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Inserted!");
                alert.showAndWait();
                casesShowListData();
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void caseUpdateClicked(){
        try {
            Alert alert;
            if (casesCourtID.getText().isEmpty() || casesProsecutorID.getText().isEmpty() || casesDefendantID.getText().isEmpty() || casesJudgeID.getText().isEmpty() || casesOffenseID.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cofirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE CaseID: " + casesCaseID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    MainUtils.updateCase(casesCaseID.getText(), casesProsecutorID.getText(), casesDefendantID.getText(), casesJudgeID.getText(), casesStatus.getText(), casesEndDate.getText(), casesNextHearing.getText(), casesOffenseID.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    casesShowListData();
                    caseResetClicked();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void casesSearch() {

        FilteredList<CaseData> filter = new FilteredList<>(casesList, e -> true);

        casesSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCaseData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCaseData.getCaseId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCaseData.getProsecutorId().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateCaseData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return predicateCaseData.getDefenseId().toLowerCase().contains(searchKey);
                }
            });
        });
        SortedList<CaseData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(casesTableView.comparatorProperty());
        casesTableView.setItems(sortList);
    }

    public void casesSelect() {
        CaseData employeeD = casesTableView.getSelectionModel().getSelectedItem();
        int num = casesTableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        casesCaseID.setText(employeeD.getCaseId());
        casesCourtID.setText(employeeD.getCourtId());
        casesProsecutorID.setText(employeeD.getProsecutorId());
        casesDefendantID.setText(employeeD.getDefenseId());
        casesJudgeID.setText(employeeD.getJudgeId());
        casesStatus.setText(employeeD.getStatus());
        casesStartDate.setText(employeeD.getStartDate());
        casesEndDate.setText(employeeD.getEndDate());
        casesNextHearing.setText(employeeD.getNextHearing());
        casesOffenseID.setText(employeeD.getOffenseId());
    }

    public void setHomeCaseDPieDistribution() throws Exception{

        homeCaseDPieDistribution.getData().clear();

        int count1=0;int count2=0;int count3=0;

        ResultSet rs=MainUtils.getCaseCount("case_status='Open'");
        rs.next();
        count1=rs.getInt("C");
        rs=MainUtils.getCaseCount("case_status='Closed'");
        rs.next();
        count2=rs.getInt("C");
        rs=MainUtils.getCaseCount("case_status='Pending'");
        rs.next();
        count3=rs.getInt("C");


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Open Cases", count1),
                        new PieChart.Data("Pending Cases", count3),
                        new PieChart.Data("Closed Cases", count2));


        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        homeCaseDPieDistribution.getData().addAll(pieChartData);
    }

    public void getHomeAvgTime() throws SQLException {
        String avgTime=MainUtils.getAvgTimeToResolve();
        homeAvgTime.setText(avgTime);
    }

}
