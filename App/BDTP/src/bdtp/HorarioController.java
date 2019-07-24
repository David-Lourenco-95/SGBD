/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdtp;

import java.awt.HeadlessException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class HorarioController implements Initializable {

    @FXML
    private TableView<Tab_HorarioPessoal> TabelaFunc;

    @FXML
    private TableColumn<?, ?> TabHorasFunc;

    @FXML
    private TableColumn<?, ?> TabMinutosFunc;

    @FXML
    private TableColumn<?, ?> TabDiaFunc;

    @FXML
    private TableColumn<?, ?> TabMesFunc;

    @FXML
    private TableColumn<?, ?> TabAnoFunc;

    @FXML
    private TableColumn<?, ?> TabUtenteFunc;

    @FXML
    private TableColumn<?, ?> TabIntervencaoFunc;

    @FXML
    private ChoiceBox<String> EscolhaFunc;

    @FXML
    private TextField Func1;

    @FXML
    private TextField Utente1;

    @FXML
    private TextField Intervencao1;

    @FXML
    private TextField Horas1;

    @FXML
    private TextField Minutos1;

    @FXML
    private TextField Ano1;

    @FXML
    private TextField Mes1;

    @FXML
    private TextField Dia1;

    @FXML
    private TableView<Tab_HorarioMaterial> TabelaSala;

    @FXML
    private TableColumn<?, ?> TabHorasSala;

    @FXML
    private TableColumn<?, ?> TabMinutosSala;

    @FXML
    private TableColumn<?, ?> TabDiaSala;

    @FXML
    private TableColumn<?, ?> TabMesSala;

    @FXML
    private TableColumn<?, ?> TabAnoSala;

    @FXML
    private TableColumn<?, ?> TabUtenteSala;

    @FXML
    private TableColumn<?, ?> TabIntervencaoSala;

    @FXML
    private TextField Sala2;

    @FXML
    private TextField Utente2;

    @FXML
    private TextField Horas2;

    @FXML
    private TextField Minutos2;

    @FXML
    private TextField Dia2;

    @FXML
    private TextField Mes2;

    @FXML
    private TextField Ano2;

    @FXML
    private TextField Intervencao2;

    @FXML
    private ChoiceBox<String> EscolhaSala;

    @FXML
    private TableView<Tab_HorarioRegisto> TabelaRegClinico;

    @FXML
    private TableColumn<?, ?> TabHorasRegClinico;

    @FXML
    private TableColumn<?, ?> TabMinutosRegClinico;

    @FXML
    private TableColumn<?, ?> TabDiaRegClinico;

    @FXML
    private TableColumn<?, ?> TabMesRegClinico;

    @FXML
    private TableColumn<?, ?> TabAnoRegClinico;

    @FXML
    private TableColumn<?, ?> TabUtenteRegClinico;

    @FXML
    private TableColumn<?, ?> TabIntervencaoRegClinico;

    @FXML
    private ChoiceBox<String> EscolhaRegClinico;

    @FXML
    private TextField RegClinico3;

    @FXML
    private TextField Utente3;

    @FXML
    private TextField Intervencao3;

    @FXML
    private TextField Horas3;

    @FXML
    private TextField Minutos3;

    @FXML
    private TextField Dia3;

    @FXML
    private TextField Mes3;

    @FXML
    private TextField Ano3;

    private String s67;

    private String s68;

    private String s69;

    private final ObservableList<Tab_HorarioPessoal> tabela1 = FXCollections.observableArrayList();
     private final ObservableList<Tab_HorarioMaterial> tabela2 = FXCollections.observableArrayList();
      private final ObservableList<Tab_HorarioRegisto> tabela3 = FXCollections.observableArrayList();
    ObservableList lista = FXCollections.observableArrayList();
    ObservableList lista2 = FXCollections.observableArrayList();
    ObservableList lista3 = FXCollections.observableArrayList();
    ObservableList lista4 = FXCollections.observableArrayList();
    ObservableList lista5 = FXCollections.observableArrayList();
    ObservableList lista6 = FXCollections.observableArrayList();
    ObservableList lista7 = FXCollections.observableArrayList();// Adicionar

    Connection con2 = null; // coneção com a Base de Dados
    PreparedStatement st2 = null;
    PreparedStatement st5 = null;
    ResultSet rs2 = null;
    ResultSet rs5 = null;

    Connection con = null; // coneção com a Base de Dados
    PreparedStatement st = null;
    PreparedStatement st3 = null;
    ResultSet rs = null;
    ResultSet rs3 = null;

     @FXML
    private void ListarFuncionario(ActionEvent event) throws SQLException {
        String escolha = EscolhaFunc.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            // st = con.prepareStatement("select * from Funcionario");
            st = con.prepareStatement("select * from Horario_Funcionario");
            con.setAutoCommit(false);
            rs = st.executeQuery();
            
            while (rs.next()) {
                tabela1.add(new Tab_HorarioPessoal(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_ID")));

            }

            TabelaFunc.setItems(tabela1);

            st.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }
    
      @FXML
    private void VerFuncionario(ActionEvent event) throws SQLException {
        String escolha = EscolhaFunc.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            
         st = con.prepareStatement("select * from Horario_Funcionario where Funcionario_ID='" + escolha + "'");
            con.setAutoCommit(false);
            rs = st.executeQuery();
            // rs3 = st3.executeQuery();

            //  while (rs3.next()) {
            //    s67= rs3.getString("Intervencao_Proveniente_ID");
            //             }
            while (rs.next()) {
                tabela1.add(new Tab_HorarioPessoal(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_ID")));

            }

            TabelaFunc.setItems(tabela1);

            st.executeUpdate();
            st3.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }

      private void loadData() throws SQLException {

        //tabela1.removeAll();
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select  distinct Funcionario_ID from Horario_Funcionario");
            con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
                String s1 = rs2.getString("Funcionario_ID");
                lista2.addAll(s1);

            }
            EscolhaFunc.getItems().addAll(lista2);

            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select  distinct Sala_ID from Horario_Sala");
            con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
                String s1 = rs2.getString("Sala_ID");
                lista3.addAll(s1);

            }
            EscolhaSala.getItems().addAll(lista3);

            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select  distinct Utente_ID from Registo_Clinico");
            con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
                String s1 = rs2.getString("Utente_ID");
                lista4.addAll(s1);

            }
            EscolhaRegClinico.getItems().addAll(lista4);

            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
      }
        
        
        
        @FXML
    private void AddHorarioFunc (ActionEvent event) throws SQLException {
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");

       // inserção de um novo cargo na base de dados
        String query2 = ("INSERT INTO Horario_Funcionario (Funcionario_ID,hora,minuto,dia,mes,ano,Intervencao_ID) VALUES (?,?,?,?,?,?,?)");

        st = null;
        try {
            st = con.prepareStatement(query2);

            st.setString(1, Func1.getText());
            st.setString(2, Horas1.getText());
            st.setString(3, Minutos1.getText());
            st.setString(4, Dia1.getText());
            st.setString(5, Mes1.getText());
            st.setString(6, Ano1.getText());
            st.setString(7, Intervencao1.getText());

            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        Func1.clear();
       Horas1.clear();
       Minutos1.clear();
       Dia1.clear();
        Mes1.clear();
       Ano1.clear();
       Intervencao1.clear();
    }
    
      @FXML
    private void ListarSala (ActionEvent event) throws SQLException {
        String escolha = EscolhaFunc.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            // st = con.prepareStatement("select * from Funcionario");
            st = con.prepareStatement("select * from Horario_Sala");
            con.setAutoCommit(false);
            rs = st.executeQuery();
            
            while (rs.next()) {
                tabela2.add(new Tab_HorarioMaterial(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_ID")));

            }

            TabelaSala.setItems(tabela2);

            st.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }
    
    @FXML
    private void VerSala (ActionEvent event) throws SQLException {
        String escolha = EscolhaSala.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            // st = con.prepareStatement("select * from Funcionario");
            st = con.prepareStatement("select * from Horario_Sala where Sala_ID='" + escolha + "'");
    
            con.setAutoCommit(false);
            rs = st.executeQuery();
            
            while (rs.next()) {
                tabela2.add(new Tab_HorarioMaterial(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_ID")));

            }

            TabelaSala.setItems(tabela2);

            st.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }
    
       @FXML
    private void AddHorarioSala (ActionEvent event) throws SQLException {
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Teste3;user=sa;password={lasvegas17}");

       // inserção de um novo cargo na base de dados
        String query2 = ("INSERT INTO Horario_Sala (Sala_ID,hora,minuto,dia,mes,ano,Intervencao_ID) VALUES (?,?,?,?,?,?,?)");

        st = null;
        try {
            st = con.prepareStatement(query2);

            st.setString(1, Sala2.getText());
            st.setString(2, Horas2.getText());
            st.setString(3, Minutos2.getText());
            st.setString(4, Dia2.getText());
            st.setString(5, Mes2.getText());
            st.setString(6, Ano2.getText());
            st.setString(7, Intervencao2.getText());

            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
         Sala2.clear();
       Horas2.clear();
       Minutos2.clear();
       Dia2.clear();
        Mes2.clear();
       Ano2.clear();
       Intervencao2.clear();
    }
    
    @FXML
    private void LimparTabela1(ActionEvent event) {

        tabela1.clear();

    }
    @FXML
    private void LimparTabela2(ActionEvent event) {

        tabela2.clear();

    }
    @FXML
    private void LimparTabela3(ActionEvent event) {

        tabela3.clear();

    }
    
    
     @FXML
    private void ListarRegisto (ActionEvent event) throws SQLException {
        String escolha = EscolhaFunc.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            // st = con.prepareStatement("select * from Funcionario");
            st = con.prepareStatement("select * from Registo_Clinico");
            con.setAutoCommit(false);
            rs = st.executeQuery();
            
            while (rs.next()) {
                tabela3.add(new Tab_HorarioRegisto(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_Internamento_ID")));

            }

            TabelaRegClinico.setItems(tabela3);

            st.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }
    
    
     @FXML
    private void VerRegisto (ActionEvent event) throws SQLException {
        String escolha = EscolhaRegClinico.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            // st = con.prepareStatement("select * from Funcionario");
            st = con.prepareStatement("select * from Registo_Clinico where Utente_ID='"+escolha+"'");
        
            con.setAutoCommit(false);
            rs = st.executeQuery();
            
            while (rs.next()) {
                tabela3.add(new Tab_HorarioRegisto(rs.getString("hora"), rs.getString("minuto"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"),rs.getString("Intervencao_Internamento_ID")));

            }

            TabelaRegClinico.setItems(tabela3);

            st.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }
    
     @FXML
    private void AddHorarioRegisto(ActionEvent event) throws SQLException {
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");

       // inserção de um novo cargo na base de dados
        String query2 = ("INSERT INTO Registo_Clinico (Utente_ID,hora,minuto,dia,mes,ano,Intervencao_Internamento_ID) VALUES (?,?,?,?,?,?,?)");

        st = null;
        try {
            st = con.prepareStatement(query2);

            st.setString(1,Utente3.getText());
            st.setString(2, Horas3.getText());
            st.setString(3, Minutos3.getText());
            st.setString(4, Dia3.getText());
            st.setString(5, Mes3.getText());
            st.setString(6, Ano3.getText());
            st.setString(7, Intervencao3.getText());

            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
         Utente3.clear();
       Horas3.clear();
       Minutos3.clear();
       Dia3.clear();
        Mes3.clear();
       Ano3.clear();
       Intervencao3.clear();
    }
    
    
    @FXML
     private void Cancelar(ActionEvent event) throws IOException{
     
         Parent DepartManager = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
            Scene DepartManagerScene = new Scene(DepartManager);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(DepartManagerScene);
            app_stage.show();
     
     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       try {
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TabHorasFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal1"));
        TabMinutosFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal2"));
        TabDiaFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal3"));
        TabMesFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal4"));
        TabAnoFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal5"));
        TabIntervencaoFunc.setCellValueFactory(new PropertyValueFactory<>("col_pessoal6"));
        
          TabHorasSala.setCellValueFactory(new PropertyValueFactory<>("col_material1"));
       TabMinutosSala.setCellValueFactory(new PropertyValueFactory<>("col_material2"));
        TabDiaSala.setCellValueFactory(new PropertyValueFactory<>("col_material3"));
       TabMesSala.setCellValueFactory(new PropertyValueFactory<>("col_material4"));
        TabAnoSala.setCellValueFactory(new PropertyValueFactory<>("col_material5"));
        TabIntervencaoSala.setCellValueFactory(new PropertyValueFactory<>("col_material6"));
        
               TabHorasRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabHorasRegClinico"));
      TabMinutosRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabMinutosRegClinico"));
        TabDiaRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabDiaRegClinico"));
      TabMesRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabMesRegClinico"));
       TabAnoRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabAnoRegClinico"));
        TabIntervencaoRegClinico.setCellValueFactory(new PropertyValueFactory<>("TabIntervencaoRegClinico"));
    }

}
