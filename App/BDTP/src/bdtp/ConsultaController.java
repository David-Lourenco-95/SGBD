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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
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

public class ConsultaController implements Initializable {

    @FXML
    private TableView<Tab_Consulta> Tabela_Consulta;

    @FXML
    private TableColumn<?, ?> Con_Atual;

    @FXML
    private TableColumn<?, ?> Con_Proveniente;

    @FXML
    private TableColumn<?, ?> Con_Sintoma;

    @FXML
    private TableColumn<?, ?> Con_Diagnostico;

    @FXML
    private TableColumn<?, ?> Con_Descricao;

    @FXML
    private TableColumn<?, ?> con_Tipo;

    @FXML
    private TableColumn<?, ?> Con_Estado;

    @FXML
    private TableColumn<?, ?> Con_Especialidade;

    @FXML
    private TableColumn<?, ?> Con_Ano;
    
    @FXML
    private TableColumn<?, ?> Con_Mes;
    
    @FXML
    private TableColumn<?, ?> Con_Hora;
    
    @FXML
    private TableColumn<?, ?> Con_Dia;
    
    @FXML
    private TableColumn<?, ?> Con_Minuto;
   

    @FXML
    private TableColumn<?, ?> Con_Sala;

    @FXML
    private TableColumn<?, ?> Con_Equipa;

    @FXML
    private TableColumn<?, ?> Con_Utente;

    @FXML
    private ChoiceBox<String> EscolhaConsulta;

    @FXML
    private TextField Sintoma;

    @FXML
    private TextField Diagnostico;

    @FXML
    private TextField Descricao;

    @FXML
    private TextField Tipo;

    @FXML
    private TextField Estado;

    

    
    
    @FXML
    private ChoiceBox<?> Ano;
    
    @FXML
    private ChoiceBox<?> Mes;
    
    @FXML
    private ChoiceBox<?> Dia;

    @FXML
    private ChoiceBox<?> Hora;
    
    @FXML
    private ChoiceBox<?> Minuto;
    @FXML
    private ChoiceBox<?> Sala;

    @FXML
    private ChoiceBox<?> Equipa;

    @FXML
    private ChoiceBox<?> Utente;
    
    @FXML
    private ChoiceBox<?> Especialidade;
    
    private String s67;
    
    private String s68;
    
    
       private String s69;
       
       Connection con = null; // coneção com a Base de Dados
    PreparedStatement st = null;
    PreparedStatement st3 = null;
    ResultSet rs = null;
     ResultSet rs3 = null;
    
     @FXML // função que permite visualizar todos os dados da base de dados
    private void VerConsulta(ActionEvent event) throws SQLException {
        String escolha = EscolhaConsulta.getValue();
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st = con.prepareStatement("select * from Intervencao where Intervencao_ID='" + escolha + "'");
            st3 = con.prepareStatement("select Intervencao_Proveniente_ID from Atribuicao_Intervencao where Intervencao_Atual_ID='" + escolha + "'");
             con.setAutoCommit(false);
            rs = st.executeQuery();
            rs3 = st3.executeQuery();
            
            while (rs3.next()) {
                
                s67= rs3.getString("Intervencao_Proveniente_ID");
                
                           }
            while (rs.next()) {
                tabela1.add(new Tab_Consulta(rs.getString("Intervencao_ID"), s67, rs.getString("Sintomas"), rs.getString("Diagnostico"), rs.getString("Descricao"), rs.getString("Tipo"), rs.getString("Estado"), rs.getString("Especialidade_ID"), rs.getString("ano"), rs.getString("mes"),rs.getString("dia"),rs.getString("hora"),rs.getString("minuto"), rs.getString("Sala_ID"), rs.getString("Equipa_ID"),rs.getString("Utente_ID")));
                
                           }
            
            
            Tabela_Consulta.setItems(tabela1);
            
           
            st.executeUpdate();
            st3.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con.rollback();
        }
    }

    

    private ObservableList<Tab_Consulta> tabela1 = FXCollections.observableArrayList();
    ObservableList lista = FXCollections.observableArrayList();
 ObservableList lista2 = FXCollections.observableArrayList();
ObservableList lista3 = FXCollections.observableArrayList();
ObservableList lista4 = FXCollections.observableArrayList();
ObservableList lista5 = FXCollections.observableArrayList();
ObservableList lista6 = FXCollections.observableArrayList();
ObservableList lista7 = FXCollections.observableArrayList();
ObservableList lista8 = FXCollections.observableArrayList();
ObservableList lista9 = FXCollections.observableArrayList();
ObservableList lista10 = FXCollections.observableArrayList();
ObservableList lista11 = FXCollections.observableArrayList();
ObservableList lista12 = FXCollections.observableArrayList();
// Adicionar
 
 Connection con4 = null; // coneção com a Base de Dados
    PreparedStatement st4 = null;
    PreparedStatement st5 = null;
    ResultSet rs4 = null;
     ResultSet rs5 = null;

    @FXML // função que permite visualizar todos os dados da base de dados
    private void VerConsulta4(ActionEvent event) throws SQLException {
        String escolha = EscolhaConsulta.getValue();
        try {
            con4 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st4 = con4.prepareStatement("select * from Intervencao");
            st5 = con4.prepareStatement("select Intervencao_Proveniente_ID from Atribuicao_Intervencao");
             con4.setAutoCommit(false);
            rs4 = st4.executeQuery();
            rs5 = st5.executeQuery();
             int i=0;
             int j=0;
             int po=0;
             String nome="";
            List<String> lista5 = new ArrayList<String>(); 
            while (rs5.next()) {
                
 lista5.add (rs5.getString("Intervencao_Proveniente_ID"));
               
                
                           }
            
            while (rs4.next()) {
                
                
                
              
                    nome=lista5.get(j);
                  
                
               
                tabela1.add(new Tab_Consulta(rs4.getString("Intervencao_ID"), nome, rs4.getString("Sintomas"), rs4.getString("Diagnostico"), rs4.getString("Descricao"), rs4.getString("Tipo"), rs4.getString("Estado"), rs4.getString("Especialidade_ID"), rs4.getString("ano"), rs4.getString("mes"),rs4.getString("dia"),rs4.getString("hora"),rs4.getString("minuto"), rs4.getString("Sala_ID"), rs4.getString("Equipa_ID"),rs4.getString("Utente_ID")));
               
                ++j;
                
                           }
            
            
            Tabela_Consulta.setItems(tabela1);
            
           
            st4.executeUpdate();
            st5.executeUpdate();
            con4.commit();
            con4.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con4.rollback();
        }
    }
    
    Connection con2 = null; // coneção com a Base de Dados
    PreparedStatement st2 = null;
    ResultSet rs2 = null;


    private void loadData() throws SQLException  {

        //tabela1.removeAll();
        
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Intervencao_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Intervencao_ID");
                lista2.addAll(s1);
                s69=s1;
                
                           }
            int result = Integer.parseInt(s69);	
            int result2 = result+1;
            s68 = Integer.toString(result2);	
           EscolhaConsulta.getItems().addAll(lista2);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
        
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Sala_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Sala_ID");
                lista3.addAll(s1);
                
                
                           }
           Sala.getItems().addAll(lista3);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
         
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Equipa_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Equipa_ID");
                lista4.addAll(s1);
                
                
                           }
           Equipa.getItems().addAll(lista4);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
         
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Utente_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Utente_ID");
                lista5.addAll(s1);
                
                
                           }
           Utente.getItems().addAll(lista5);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
        try {
            int yu=0;
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Especialidade_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Especialidade_ID");
             if(s1==null){
                yu++;
             }
             if(yu==0||yu==1){
                lista6.addAll(s1);
             }
                
                           }
           Especialidade.getItems().addAll(lista6);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
      
            
             for(int i=0;i<=18;i++){
                 String numberAsString = Integer.toString(i);
                lista8.addAll(numberAsString);
                
             }
                
                                         
          Ano.getItems().addAll(lista8);
          
          for(int i=1;i<=12;i++){
              
              String numberAsString = Integer.toString(i);
                 
                lista9.addAll(numberAsString);
             }
                
                                         
          Mes.getItems().addAll(lista9);
          
          for(int i=1;i<=31;i++){
                 String numberAsString = Integer.toString(i);
                lista10.addAll(numberAsString);
             }
                
                                         
          Dia.getItems().addAll(lista10);
          
          for(int i=1;i<=24;i++){
                 String numberAsString = Integer.toString(i);
                lista11.addAll(numberAsString);
             }
                
                                         
          Hora.getItems().addAll(lista11);
          
          for(int i=0;i<4;i++){
                 String numberAsString = Integer.toString(i*15);
                lista12.addAll(numberAsString);
             }
                
                                         
          Minuto.getItems().addAll(lista12);
           
        
       
        
    }

    @FXML
    private void AddConsulta(ActionEvent event) throws SQLException {
       con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");


        // inserção de um novo cargo na base de dados
        String query2 = ("INSERT INTO Intervencao(Tipo,Sintomas,Diagnostico,Especialidade_ID,Descricao,Estado,ano,mes,dia,hora,minuto,Sala_ID,Equipa_ID,Utente_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      String query3= ("INSERT INTO Atribuicao_Intervencao(Intervencao_Atual_ID,Intervencao_Proveniente_ID) VALUES(?,?)");
        st = null;
        try {
            st = con.prepareStatement(query2);

            st.setString(1, Tipo.getText());
            st.setString(2, Sintoma.getText());
            st.setString(3, Diagnostico.getText());
            st.setString(4, (String) Especialidade.getValue());
            st.setString(5, Descricao.getText());
            st.setString(6, Estado.getText());
            st.setString(7, (String) Ano.getValue());
            st.setString(8, (String) Mes.getValue());
            st.setString(9, (String) Dia.getValue());
            st.setString(10, (String) Hora.getValue());
            st.setString(11,(String) Minuto.getValue());
            st.setString(12, (String) Sala.getValue());
            st.setString(13, (String) Equipa.getValue());
            st.setString(14, (String) Utente.getValue());

            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TP2018;user=sa;password={sapo6230512}");
            st2 = con2.prepareStatement("select distinct Intervencao_ID from Intervencao");
             con2.setAutoCommit(false);
            rs2 = st2.executeQuery();
            while (rs2.next()) {
             String s1= rs2.getString("Intervencao_ID");
                lista2.addAll(s1);
                s69=s1;
                
                           }
            
           EscolhaConsulta.getItems().addAll(s69);
           
            st2.executeUpdate();
            con2.commit();
            con2.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            con2.rollback();
        }
        
        st2 = null;
        try {
            st2 = con.prepareStatement(query3);

            st2.setString(1, s69);
            st2.setString(2, null);
         
            st2.execute();
            st2.close();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        
        Sintoma.clear();
        Diagnostico.clear();
        Descricao.clear();
        Tipo.clear();
        Estado.clear();
        Especialidade.setValue(null);
      Ano.setValue(null);
      Mes.setValue(null);
      Dia.setValue(null);
      Hora.setValue(null);
      Minuto.setValue(null);
        Sala.setValue(null);
        Equipa.setValue(null);
        Utente.setValue(null);
        
    }

    @FXML
    private void Cancelar (ActionEvent event) throws IOException {

         Parent DepartManager = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
            Scene DepartManagerScene = new Scene(DepartManager);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(DepartManagerScene);
            app_stage.show();

    }
    
     @FXML
    private void LimparTabela(ActionEvent event) {

        tabela1.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        Con_Atual.setCellValueFactory(new PropertyValueFactory<>("tab_Atual"));
        Con_Proveniente.setCellValueFactory(new PropertyValueFactory<>("tab_Proveniente"));
        Con_Sintoma.setCellValueFactory(new PropertyValueFactory<>("tab_Sintoma"));
        Con_Diagnostico.setCellValueFactory(new PropertyValueFactory<>("tab_Diagnostico"));
        Con_Descricao.setCellValueFactory(new PropertyValueFactory<>("tab_Descricao"));
        con_Tipo.setCellValueFactory(new PropertyValueFactory<>("tab_Tipo"));
        Con_Estado.setCellValueFactory(new PropertyValueFactory<>("tab_Estado"));
        Con_Especialidade.setCellValueFactory(new PropertyValueFactory<>("tab_Especialidade"));
        Con_Ano.setCellValueFactory(new PropertyValueFactory<>("tab_Ano"));
        Con_Mes.setCellValueFactory(new PropertyValueFactory<>("tab_Ano"));
        Con_Dia.setCellValueFactory(new PropertyValueFactory<>("tab_Dia"));
        Con_Hora.setCellValueFactory(new PropertyValueFactory<>("tab_Hora"));
        Con_Minuto.setCellValueFactory(new PropertyValueFactory<>("tab_Minuto"));
        Con_Sala.setCellValueFactory(new PropertyValueFactory<>("tab_Sala"));
        Con_Equipa.setCellValueFactory(new PropertyValueFactory<>("tab_Equipa"));
        Con_Utente.setCellValueFactory(new PropertyValueFactory<>("tab_Utente"));

    }

}
