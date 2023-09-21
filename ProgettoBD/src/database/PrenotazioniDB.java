package database;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;

public class PrenotazioniDB {
	//Dati per accesso al database
	private final static String URL = "jdbc:mysql://localhost:3306/piattaformaprenotazioni";
    private final static String USER = "root";
    private final static String PASSWORD = "1234";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    static Scanner scanner = new Scanner(System.in);
    
    //REGISTRAZIONE DI UN CLIENTE
    static void op1(Connection con) {
    	try{
    		//Query con prepared statement
    		String query1 = "INSERT INTO cliente (codice_fiscale, nome, cognome, data_nascita, telefono, email) VALUES (?,?,?,?,?,?)";
    		String query2 = "INSERT INTO tessera (cliente, tipo, validita, scadenza) VALUES (?,?,?,?)";
    		PreparedStatement pst1=con.prepareStatement(query1);
    		PreparedStatement pst2=con.prepareStatement(query2);
    		String cf = null; //codice fiscale
    		
    		//Inserimento dati cliente
    		System.out.println("\n\n<------------------------------------- REGISTRAZIONE CLIENTE -------------------------------->");
    		System.out.println("Codice Fiscale:");
    		cf=scanner.nextLine();
    		pst1.setString(1,cf);
    		System.out.println("Nome:");
    		pst1.setString(2,scanner.nextLine());
    		System.out.println("Cognome:");
    		pst1.setString(3,scanner.nextLine());
    		System.out.println("Data di Nascita:");
    		pst1.setDate(4,Date.valueOf(scanner.nextLine()));
    		System.out.println("Numero di Telefono:");
    		pst1.setString(5,scanner.nextLine());
    		
    		//Inserimento e-mail (opzionale)
    		System.out.println("il cliente ha una mail?   0-NO  1-SI");
    		if(Integer.parseInt(scanner.nextLine())==0) {
    			pst1.setNull(6, Types.VARCHAR);
    		}
    		else {
    			System.out.println("E-mail:");
        		pst1.setString(6,scanner.nextLine());
    		}
    		
    		//-----------------------Registrazione eseguita correttamente--------------------------
    		if(pst1.executeUpdate()==1) {
    			System.out.println("<------------------------------------------ CLIENTE REGISTRATO! ---------------------------------->");
    			
    			//Inserimento tessera per il cliente registrato
    			System.out.println("\n<----------------------------------------- CREAZIONE TESSERA ----------------------------------->");
    			pst2.setString(1, cf);
    			pst2.setString(2, "Basic"); //tipo valore costante Basic
    			pst2.setString(3, "3 Anni"); //validita valore costante 3 anni
    			
    			//Generazione data di scadenza (data attuale + 3 anni)
    			LocalDate data = LocalDate.now();
    			data = data.plusYears(3);
    			pst2.setDate(4, java.sql.Date.valueOf(data));
    			
    			//Creazione eseguita correttamente
    			if(pst2.executeUpdate()==1) {
    				System.out.println("<----------------------------------------- TESSERA CREATA! ------------------------------------>");
    			}
    			//Creazione Fallita
    			else {
    				System.out.println("<------------------------------- CREAZIONE TESSERA FALLITA! -------------------------------->");
    			}
    		}
    		//---------------------------------------------------------------------------------------
    		
    		//-----------------------Registrazione fallita----------------------------
    		else {
    			System.out.println("<----------------------------------------- REGISTRAZIONE CLIENTE FALLITA! ------------------------------------>");
    		}
    		//------------------------------------------------------------------------
		}
		catch(Exception e) {System.out.println("<----------------------------------------- ERRORE QUERY! ------------------------------------>");}
    }
	
    //REGISTRAZIONE DI UNA STRUTTURA RICETTIVA
    static void op2(Connection con) {
    	try{
    		PreparedStatement pst = null; //Prepared Statement per query inserimento struttura
    		String query = null; //query inserimento struttura
    		String tipologia = null; //tipo di struttura
    		String codice = null; //codice struttura
    		
    		//Inserimento della struttura ricettiva
    		System.out.println("<----------------------------------------- REGISTRAZIONE STRUTTURA RICETTIVA ------------------------------------>");
    		System.out.println("Codice Struttura:");
    		codice=scanner.nextLine();
    		System.out.println("Tipologia di struttura:");
    		tipologia=scanner.nextLine();
    		
    		//Switch per vari tipi di struttura ricettiva
    		switch(tipologia) {
    		
    		//Struttura tipo appartamento
    		case "Appartamento":
    			query="INSERT INTO struttura_ricettiva (codice_struttura, nome, tipo, anno_iscrizione, servizi, via, citta, cap, vani, posti_letto, prezzo, mq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    			pst=con.prepareStatement(query);
    			pst.setString(1, codice);
    			System.out.println("Nome Appartamento:");
    			pst.setString(2, scanner.nextLine());
    			pst.setString(3, tipologia);
    			System.out.println("Anno di iscrizione:");
    			pst.setInt(4, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Servizi:");
    			pst.setString(5, scanner.nextLine());
    			System.out.println("Via:");
    			pst.setString(6, scanner.nextLine());
    			System.out.println("Città:");
    			pst.setString(7, scanner.nextLine());
    			System.out.println("CAP:");
    			pst.setString(8, scanner.nextLine());
    			System.out.println("Vani:");
    			pst.setInt(9, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Posti letto:");
    			pst.setInt(10, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Prezzo a notte:");
    			pst.setObject(11, scanner.nextLine(), java.sql.Types.DECIMAL);
    			System.out.println("Metri Quadrati:");
    			pst.setInt(12, Integer.parseInt(scanner.nextLine()));
    			break;
    		
    		//Struttura tipo ostello
    		case "Ostello":
    			query="INSERT INTO struttura_ricettiva (codice_struttura, nome, tipo, anno_iscrizione, servizi, via, citta, cap, posti_letto, prezzo) VALUES (?,?,?,?,?,?,?,?,?,?)";
    			pst=con.prepareStatement(query);
    			pst.setString(1, codice);
    			System.out.println("Nome Ostello:");
    			pst.setString(2, scanner.nextLine());
    			pst.setString(3, tipologia);
    			System.out.println("Anno di iscrizione:");
    			pst.setInt(4, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Servizi:");
    			pst.setString(5, scanner.nextLine());
    			System.out.println("Via:");
    			pst.setString(6, scanner.nextLine());
    			System.out.println("Città:");
    			pst.setString(7, scanner.nextLine());
    			System.out.println("CAP:");
    			pst.setString(8, scanner.nextLine());
    			System.out.println("Posti letto:");
    			pst.setInt(9, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Prezzo a notte per persona:");
    			pst.setObject(10, scanner.nextLine(), java.sql.Types.DECIMAL);
    			break;
    			
    		//Struttura tipo hotel
    		case "Hotel":
    			query="INSERT INTO struttura_ricettiva (codice_struttura, nome, tipo, anno_iscrizione, servizi, via, citta, cap) VALUES (?,?,?,?,?,?,?,?)";
    			pst=con.prepareStatement(query);
    			pst.setString(1, codice);
    			System.out.println("Nome Hotel:");
    			pst.setString(2, scanner.nextLine());
    			pst.setString(3, tipologia);
    			System.out.println("Anno di iscrizione:");
    			pst.setInt(4, Integer.parseInt(scanner.nextLine()));
    			System.out.println("Servizi:");
    			pst.setString(5, scanner.nextLine());
    			System.out.println("Via:");
    			pst.setString(6, scanner.nextLine());
    			System.out.println("Città:");
    			pst.setString(7, scanner.nextLine());
    			System.out.println("CAP:");
    			pst.setString(8, scanner.nextLine());
    			break;
    		
    		//tipo struttura non supportato
    		default:
    			System.out.println("<----------------------------------------- ERRORE: TIPOLOGIA DI STRUTTURA NON SUPPORTATA! ------------------------------------>");
    		}
    		
    		//-------------------------Registrazione Struttura ricettiva riuscita---------------------------------------
    		if(pst.executeUpdate()==1) {
    			System.out.println("<----------------------------------------- STRUTTURA RICETTIVA REGISTRATA! ------------------------------------>");
    			
    			//Inserimento camere per struttura di tipo hotel
    			if(tipologia.equals("Hotel")) {
    				int nRoom = 0; //numero camere
        			System.out.println("Quante camere ci sono?");
        			nRoom=Integer.parseInt(scanner.nextLine());
        			String roomQuery = "INSERT INTO camera (numero, hotel, tipologia, prezzo, max_ospiti) VALUES (?,?,?,?,?)"; //query inserimento camere
        			PreparedStatement roomPst = con.prepareStatement(roomQuery); //prepared statement per query inserimento camere
        			roomPst.setString(2, codice);
        			System.out.println("\n\n<----------------------------------------- REGISTRAZIONE CAMERE! ------------------------------------>");
        			for(int i=0; i<nRoom; i++) {
        				System.out.println("\n-- Camera " +(i+1)+" --");
        				System.out.println("Numero della Camera: ");
        				roomPst.setInt(1, Integer.parseInt(scanner.nextLine()));
        				System.out.println("Tipologia: ");
        				roomPst.setString(3, scanner.nextLine());
        				System.out.println("Prezzo a notte: ");
        				roomPst.setObject(4, scanner.nextLine(), java.sql.Types.DECIMAL);
        				System.out.println("Capienza Massima: ");
        				roomPst.setInt(5, Integer.parseInt(scanner.nextLine()));
        				
        				//Inserimento i-esima camera riuscito
        				if(roomPst.executeUpdate()==1) {
        					System.out.println("-- Camera Registata --");
        				}
        				//Inserimento i-esima camera fallito
        				else {
        					System.out.println("-- Errore Registrazione Camera  --");
        					i--; //decremento i consentendo di riprovare l`inserimento fallito
        				}
        			}
        			System.out.println("<----------------------------------------- REGISTRAZIONE CAMERE COMPLETATA! ------------------------------------>");
    			}
    			
    			//Inserimento numeri di telefono
    			System.out.println("\n\n<----------------------------------------- REGISTRAZIONE RECAPITI TELEFONICI ------------------------------------>");
    			int nTel=0; //numero di recapiti telefonici della struttura
    			System.out.println("Quanti Numeri di telefono ha la struttura ricettiva?");
    			nTel=Integer.parseInt(scanner.nextLine());
    			String telQuery = "INSERT INTO telefono_struttura (numero, struttura_ricettiva) VALUES (?,?)"; //query inserimento recapiti telefonici
    			PreparedStatement telPst = con.prepareStatement(telQuery); //prepared statement per query inserimento recapiti telefonici
    			telPst.setString(2, codice);
    			for(int i=0; i<nTel; i++) {
    				System.out.println("\n-- Recapito Telefonico " +(i+1)+" --");
    				System.out.println("Numero: ");
    				telPst.setString(1, scanner.nextLine());
    				
    				//Inserimento i-esimo recapito telefonico riuscito
    				if(telPst.executeUpdate()==1) {
    					System.out.println("-- Recapito Telefonico Registato --");
    				}
    				//Inserimento i-esimo recapito telefonico fallito
    				else {
    					System.out.println("-- Errore Registrazione Recapito Telefonico  --");
    					i--; //decremento i consentendo di riprovare l`inserimento fallito
    				}
    			}
    			System.out.println("<----------------------------------------- REGISTRAZIONE RECAPITI TELEFONICI COMPLETATA! ------------------------------------>");		
    		}
    		//-------------------------------------------------------------------------------------------------------
    		
    		//-----------------Registrazione Struttura ricettiva fallita---------------------------------
    		else {
    			System.out.println("<----------------------------------------- REGISTRAZIONE STRUTTURA RICETTIVA FALLITA ------------------------------------>");
    		}
    		//-------------------------------------------------------------------------------------------
    	}
    	catch(Exception e) {
    		System.out.println("<----------------------------------------- ERRORE QUERY! ------------------------------------>");
    	}
    }
    
    //PRENOTAZIONE DI UNA STRUTTURA RICETTIVA DA PARTE DI UN CLIENTE
    static void op3(Connection con) {
    	try {
    		//######################################## Controllo Prenotazioni Attive ############################################
    		String queryPA = "SELECT COUNT(IF(p.check_out > CURDATE(), p.codice_prenotazione, NULL)) AS p_attive "
    					+ "FROM prenotazione as p "
    					+ "WHERE p.cliente = ?";
    		
    		PreparedStatement pstPA = con.prepareStatement(queryPA);
    		
    		System.out.println("\n\n<----------------------------------------- REGISTRAZIONE PRENOTAZIONE ------------------------------------>");
    		System.out.println("Inserire il codice fiscale del cliente:");
    		String cliente = scanner.nextLine();
    		pstPA.setString(1,cliente);
    		ResultSet rsPA = pstPA.executeQuery();
    		rsPA.next();
    		//###################################################################################################################
    		
    		
    		if(rsPA.getInt("p_attive")<2) {
    			//################################################################ Controllo disponibilità Struttura ############################################################
    			
    			//Inserimento dati
    			System.out.println("Inserisci la data di check-in:");
        		java.sql.Date checkIn = Date.valueOf(scanner.nextLine());
        		System.out.println("Inserisci la data di check-out:");
        		java.sql.Date checkOut = Date.valueOf(scanner.nextLine());
        		System.out.println("Inserire il codice della struttura ricettiva:");
        		String struttura = scanner.nextLine();
        		
        		//---------------Selezione tipo di struttura-----------------
        		String queryT = "SELECT tipo FROM struttura_ricettiva "
        					+ "WHERE codice_struttura = ?";
        		PreparedStatement pstT = con.prepareStatement(queryT);
        		pstT.setString(1,struttura);
        		ResultSet rsT = pstT.executeQuery();
        		rsT.next();
        		String tipo = rsT.getString("tipo");
        		//-----------------------------------------------------------
        		
        		String queryD = null; //Query controllo disponibilità
        		PreparedStatement pstD = null; //Prepared statement per queryD
        		ResultSet rsD = null; //Result set per queryD
        		Boolean disp = false; //numero prenotazioni nella finestra temporale specificata
        		int pl_disp = 0; //Posti letto disponibili
        		int camera = 0; //numero camera
        		BigDecimal prezzo = null; //Prezzo Totale
        		
        		
        		//------------------------------- Disponibilità appartamento -----------------------------
        		if(tipo.equals("Appartamento")) {
        			queryD="SELECT COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL)) as np "
        					+ "FROM prenotazione as p "
        					+ "WHERE p.struttura_ricettiva = ?";
        			
        			pstD = con.prepareStatement(queryD);
        			pstD.setDate(1, checkIn);
        			pstD.setDate(2, checkOut);
        			pstD.setDate(3, checkIn);
        			pstD.setDate(4, checkOut);
        			pstD.setString(5, struttura);
   
        			rsD = pstD.executeQuery();
        			rsD.next();
        			if(rsD.getInt("np")==0) {
        				disp = true; //Appartamento disponibile
        			}
        		}
        		//-----------------------------------------------------------------------------------------
        		
        		//------------------------------------ Disponibilità Hotel ------------------------------------
        		if(tipo.equals("Hotel")) {
        			System.out.println("Inserire il numero della camera:");
        			camera = Integer.valueOf(scanner.nextLine());
        			queryD="SELECT COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL)) as np "
        					+ "FROM prenotazione as p "
        					+ "WHERE p.struttura_ricettiva = ? AND p.camera = ?";
        			
        			pstD = con.prepareStatement(queryD);
        			pstD.setDate(1, checkIn);
        			pstD.setDate(2, checkOut);
        			pstD.setDate(3, checkIn);
        			pstD.setDate(4, checkOut);
        			pstD.setString(5, struttura);
        			pstD.setInt(6, camera);
   
        			rsD = pstD.executeQuery();
        			rsD.next();
        			if(rsD.getInt("np")==0) {
        				disp = true; //Camera disponibile
        			}
        		}
        		//------------------------------------------------------------------------------------------
        		
        		
        		//----------------------------------- Disponibilità Ostello ------------------------------------
        		if(tipo.equals("Ostello")) {
        			queryD="SELECT prezzo, s.posti_letto - SUM(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.persone , 0)) AS pl_disponibili "
        					+ "FROM struttura_ricettiva AS s "
        					+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
        					+ "WHERE s.codice_struttura = ?";
        			
        			pstD = con.prepareStatement(queryD);
        			pstD.setDate(1, checkIn);
        			pstD.setDate(2, checkOut);
        			pstD.setDate(3, checkIn);
        			pstD.setDate(4, checkOut);
        			pstD.setString(5, struttura);
   
        			rsD = pstD.executeQuery();
        			rsD.next();
        			prezzo = rsD.getBigDecimal("prezzo");
        			pl_disp = rsD.getInt("pl_disponibili");
        			if(pl_disp > 0) {
        				disp = true; //Appartamento disponibile
        			}
        		}
        		//-----------------------------------------------------------------------------------------------
        		//#################################################################################################################################################################
        		
        		if(disp==true) {
        			//########################################################### Controllo Capienza Struttura ########################################################################
        			System.out.println("Inserire il numero di persone:");
        			int persone = Integer.valueOf(scanner.nextLine());
        			String queryC = null; //Query controllo capienza
        			PreparedStatement pstC = null; //Prepared statement per queryC
        			ResultSet rsC = null; //Result set per queryC
        		
        			//Viene selezionato anche il prezzo a notte per il successivo calcolo del prezzo totale
        			if(tipo.equals("Appartamento")) {
        				queryC = "SELECT posti_letto, prezzo FROM struttura_ricettiva WHERE codice_struttura = ?";
        				pstC = con.prepareStatement(queryC);
        				pstC.setString(1, struttura);
        				rsC = pstC.executeQuery();
        				rsC.next();
        				pl_disp = rsC.getInt("posti_letto");
        				prezzo = rsC.getBigDecimal("prezzo");
        			}
        		
        			if(tipo.equals("Hotel")) {
        				queryC = "SELECT max_ospiti, prezzo FROM camera WHERE numero = ? AND hotel = ?";
        				pstC = con.prepareStatement(queryC);
        				pstC.setInt(1, camera);
        				pstC.setString(2, struttura);
        				rsC = pstC.executeQuery();
        				rsC.next();
        				pl_disp = rsC.getInt("max_ospiti");
        				prezzo = rsC.getBigDecimal("prezzo");
        			}
        			//###############################################################################################################################################################
        		
        			if(persone <= pl_disp) {
        				//#################################################### Calcolo Prezzo #######################################################################
        				System.out.println("Inserire l`agenzia:");
            			int agenzia = Integer.valueOf(scanner.nextLine());
            			System.out.println("Inserire eventuali note:");
                		String note = scanner.nextLine();
                		
                		//---------------------------- Calcolo dei giorni ---------------------------
                		java.util.Date utilDateIn = new java.util.Date(checkIn.getTime());
                		java.util.Date utilDateOut = new java.util.Date(checkOut.getTime());
                		long diffInMillies = Math.abs(utilDateOut.getTime() - utilDateIn.getTime());
                	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                	    //---------------------------------------------------------------------------
                	    
                	    prezzo = prezzo.multiply(new BigDecimal (diff));
                		
                		if(tipo.equals("Ostello")) {
                			prezzo = prezzo.multiply(new BigDecimal (persone));
            			}
                	    
                	    //----------------------------- Calcolo Sconto -------------------------------
                	    String queryS = "SELECT sconto FROM tessera WHERE cliente = ?";
                	    PreparedStatement pstS = con.prepareStatement(queryS);
                	    pstS.setString(1, cliente);
                	    ResultSet rsS = pstS.executeQuery();
                	    rsS.next();
                	    BigDecimal sconto = null;
                	    sconto = rsS.getBigDecimal("sconto");
                	    
                	    if(sconto != null) {
                	    	sconto = (prezzo.divide(new BigDecimal(100))).multiply(sconto);
                	    	prezzo = prezzo.subtract(sconto);
                	    }
                	    //----------------------------------------------------------------------------
                	    //############################################################################################################################################
        			
                	    //################################################### Inserimento Prenotazione ###############################################################
                	    System.out.println("Inserire il codice della prenotazione:");
                	    String codice = scanner.nextLine();
                	    String queryI = null;
                	    PreparedStatement pstI = null;
                	    
                	    if (tipo.equals("Appartamento") || tipo.equals("Ostello")) {
                	    	queryI="INSERT INTO prenotazione (codice_prenotazione, note, persone, prezzo_totale, check_in, check_out, cliente, agenzia, struttura_ricettiva) "
                	    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                	    	pstI = con.prepareStatement(queryI);
                	    	pstI.setString(1, codice);
                	    	pstI.setString(2, note);
                	    	pstI.setInt(3, persone);
                	    	pstI.setBigDecimal(4, prezzo);
                	    	pstI.setDate(5, checkIn);
                	    	pstI.setDate(6, checkOut);
                	    	pstI.setString(7, cliente);
                	    	pstI.setInt(8, agenzia);
                	    	pstI.setString(9, struttura);  	
                	    }
                	    
                	    if (tipo.equals("Hotel")) {
                	    	queryI="INSERT INTO prenotazione (codice_prenotazione, note, persone, prezzo_totale, check_in, check_out, cliente, agenzia, struttura_ricettiva, camera) "
                	    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                	    	pstI = con.prepareStatement(queryI);
                	    	pstI.setString(1, codice);
                	    	pstI.setString(2, note);
                	    	pstI.setInt(3, persone);
                	    	pstI.setBigDecimal(4, prezzo);
                	    	pstI.setDate(5, checkIn);
                	    	pstI.setDate(6, checkOut);
                	    	pstI.setString(7, cliente);
                	    	pstI.setInt(8, agenzia);
                	    	pstI.setString(9, struttura);
                	    	pstI.setInt(10, camera);
                	    }
                	    
                	    if(pstI.executeUpdate()==1) {
                	    	System.out.println("<----------------------------------------- PRENOTAZIONE REGISTRATA! ------------------------------------>");
                	    }
                	    else {
                	    	System.out.println("<----------------------------------------- REGISTRAZIONE PRENOTAZIONE FALLITA ------------------------------------>");
                	    }
                	    
                	    //############################################################################################################################################
        			}
        			else {
        				System.out.println("<----------------------------------------- ERRORE: CAPIENZA STRUTTURA NON SUFFICIENTE ------------------------------------>");
        			}
        		}
        		else {
        			System.out.println("<----------------------------------------- ERRORE: STRUTTURA NON DISPONIBILE ------------------------------------>");
        		}
    		}
    		else {
    			System.out.println("<----------------------------------------- ERRORE: IL CLIENTE HA GIÀ 2 PRENOTAZIONI ATTIVE ------------------------------------>");
    		}
    		
    	}
    	catch(Exception e) {System.out.println("<----------------------------------------- ERRORE QUERY ------------------------------------>");}
    }
    
    //ATTRIBUZIONE AD UN CLIENTE DI UNA TESSERA CON FIDELIZZAZIONE PREMIUM
    static void op4(Connection con) {
    	try{
    		String query = "UPDATE tessera SET tipo=?, validita=?, scadenza=?, sconto=? WHERE cliente=?";
    		PreparedStatement pst = con.prepareStatement(query);
    		LocalDate data = LocalDate.now();
			data = data.plusYears(1);
			System.out.println("\n\n<----------------------------------------- ASSEGNAZIONE TESSERA PREMIUM ------------------------------------>");
    		System.out.println("Inserire il codice del cliente a cui attribuire la fidelizzazione premium:");
    		pst.setString(5, scanner.nextLine());
    		pst.setString(1, "Premium");
    		pst.setString(2, "1 Anno");
    		pst.setDate(3, java.sql.Date.valueOf(data));
    		pst.setObject(4, "10" , java.sql.Types.DECIMAL);
    		
    		if(pst.executeUpdate()>0) {
    			System.out.println("<----------------------------------------- ASSEGNAZIONE COMPLETATA ------------------------------------>");
    		}
    		else {
    			System.out.println("<----------------------------------------- ASSEGNAZIONE FALLITA ------------------------------------>");
    		}
    		
    	}
    	catch(Exception e) {System.out.println("<----------------------------------------- ERRORE QUERY ------------------------------------>");}
    }
    
    //VISUALIZZAZIONE DI TUTTE LE STRUTTURE RICETTIVE PER CITTÀ
    static void op5(Connection con) {
    	try {
        	String queryC = "SELECT DISTINCT citta FROM struttura_ricettiva"; //query per selezionare tutte le città in cui si trovano le varie strutture del DB
        	Statement stmC = con.createStatement(); //statement per queryC
        	ResultSet rsC = stmC.executeQuery(queryC); //Result set per risultato queryC
        	
        	String query = "SELECT codice_struttura, nome FROM struttura_ricettiva WHERE citta = ?"; //query per selezionare le strutture per ogni citta
        	PreparedStatement pst = con.prepareStatement(query); //Prepared statement per query
        	
        	System.out.println("<----------------------------------------- STRUTTURE RICETTIVE NELLE VARIE CITTÀ ------------------------------------>");
        	
        	//------------------------Scorri il result set di queryC-------------------------------
        	while(rsC.next()) {
        		String citta = rsC.getString("citta"); //estrai elemento da rsC
        		pst.setString(1, citta); //modifica il prepared statement
        		ResultSet rs = pst.executeQuery(); //esegui query per l`elemento estratto
        		System.out.println("\n--- " + citta.toUpperCase() + " ---");
        		
        		//----------------Stampa result set di query---------------
        		while(rs.next()) {
        			String codice = rs.getString("codice_struttura");
        			String nome = rs.getString("nome");
        			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome);
        		}
        		//---------------------------------------------------------
        	}
        	//--------------------------------------------------------------------------------------
        	
        	System.out.println("<----------------------------------------------------------------------------------------------------------------------->");
    	}
    	catch(Exception e) { System.out.println("<----------------------------------------- ERRORE QUERY ------------------------------------>");}

    }
    
    //VISUALIZZAZIONE DI TUTTE LE STRUTTURE RICETTIVE DISPONIBILI IN UN PERIODO DI TEMPO SPECIFICATO
    static void op6(Connection con) {
    	try {
    		//Query per selezionare appartamenti disponibili
    		String queryApp = "SELECT s.codice_struttura, s.nome FROM struttura_ricettiva AS s "
    				+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    				+ "WHERE s.tipo = 'Appartamento' "
    				+ "GROUP BY s.codice_struttura "
    				+ "HAVING COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL))=0";
    		
    		PreparedStatement pstApp = con.prepareStatement(queryApp); //Prepared Statement per queryApp
    		
    		//Query per selezionare Camere degli hotel disponibili
    		String queryHot = "SELECT c.numero, c.hotel, s.nome FROM camera as c "
    				+ "LEFT JOIN prenotazione AS p ON c.hotel = p.struttura_ricettiva AND c.numero = p.camera "
    				+ "INNER JOIN struttura_ricettiva AS s ON c.hotel = s.codice_struttura "
    				+ "GROUP BY c.numero, c.hotel "
    				+ "HAVING COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL))=0";
    		
    		PreparedStatement pstHot = con.prepareStatement(queryHot); //Prepared Statement per queryHot
    		
    		//Query per selezionare Ostelli disponibili 
    		String queryOst = "SELECT s.codice_struttura, s.nome, "
    				+ "s.posti_letto - SUM(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.persone , 0)) AS pl_disponibili "
    				+ "FROM struttura_ricettiva AS s "
    				+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    				+ "WHERE s.tipo = 'Ostello' "
    				+ "GROUP BY s.codice_struttura "
    				+ "HAVING pl_disponibili>0";
    		
    		PreparedStatement pstOst = con.prepareStatement(queryOst); //Prepared Statement per queryOst
    		
    		//Finestra temporale nel quale verificare la disponibilità
    		System.out.println("Inserisci la data in cui desideri effettuare il check-in:");
    		java.sql.Date dataIn = Date.valueOf(scanner.nextLine());
    		System.out.println("Inserisci la data in cui desideri effettuare il check-out:");
    		java.sql.Date dataOut = Date.valueOf(scanner.nextLine());
    		
    		//---------------Impostazione date nei prepared statement-----------------
    		pstApp.setDate(1, dataIn);
    		pstApp.setDate(2, dataOut);
    		pstApp.setDate(3, dataIn);
    		pstApp.setDate(4, dataOut);
    		
    		pstHot.setDate(1, dataIn);
    		pstHot.setDate(2, dataOut);
    		pstHot.setDate(3, dataIn);
    		pstHot.setDate(4, dataOut);
    		
    		pstOst.setDate(1, dataIn);
    		pstOst.setDate(2, dataOut);
    		pstOst.setDate(3, dataIn);
    		pstOst.setDate(4, dataOut);
    		//-------------------------------------------------------------------------
    		
    		ResultSet rsApp = pstApp.executeQuery(); //Result set per queryApp
    		ResultSet rsHot = pstHot.executeQuery(); //Result set per queryHot
    		ResultSet rsOst = pstOst.executeQuery(); //Result set per queryOst
    		
    		System.out.println("<------------------------------------ REPORT: STRUTTURE RICETTIVE DISPONIBILI TRA IL " + dataIn + " E IL " + dataOut + " --------------------------------------->\n");
    		
    		//Stampa appartamenti
    		System.out.println("---------------------- APPARTAMENTI ---------------------");
    		while(rsApp.next()) {
    			String codice = rsApp.getString("codice_struttura");
    			String nome = rsApp.getString("nome");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome);
    		}
    		System.out.println("-----------------------------------------------------------");
    		
    		//Stampa Camere degli hotel
    		System.out.println("\n---------------------- CAMERE D'HOTEL ---------------------");
    		while(rsHot.next()) {
    			String codice = rsHot.getString("hotel");
    			String nome = rsHot.getString("nome");
    			int num = rsHot.getInt("numero");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + "		NUMERO CAMERA: " + num);
    		}
    		System.out.println("-----------------------------------------------------------");
    		
    		//Stampa Ostelli
    		System.out.println("---------------------- OSTELLI ---------------------");
    		while(rsOst.next()) {
    			String codice = rsOst.getString("codice_struttura");
    			String nome = rsOst.getString("nome");
    			int pld = rsOst.getInt("pl_disponibili");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + "		POSTI LETTO DISPONIBILI: " + pld);
    		}
    		System.out.println("-----------------------------------------------------------");
    		System.out.println("\n\n-------------------------------------------------------------- REPORT TERMINATO -------------------------------------------------------------------->");
    	}
    	catch(Exception e) {System.out.println("<----------------------------------------- ERRORE QUERY ------------------------------------>");}
    }
    
  //VISUALIZZAZIONE DI TUTTE LE STRUTTURE RICETTIVE DISPONIBILI IN UN PERIODO DI TEMPO SPECIFICATO IL CUI PREZZO A NOTTE NON SUPERI I 50€
    static void op7(Connection con) {
    	try {
    		//Query per selezionare appartamenti disponibili con prezzo a notte minore di 50 €
    		String queryApp = "SELECT s.codice_struttura, s.nome, s.prezzo FROM struttura_ricettiva AS s "
    				+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    				+ "WHERE s.tipo = 'Appartamento' AND s.prezzo <=50 "
    				+ "GROUP BY s.codice_struttura "
    				+ "HAVING COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL))=0";
    		
    		PreparedStatement pstApp = con.prepareStatement(queryApp); //Prepared Statement per queryApp
    		
    		//Query per selezionare camere degli Hotel disponibili con prezzo a notte minore di 50 €
    		String queryHot = "SELECT c.numero, c.hotel, c.prezzo, s.nome FROM camera as c "
    				+ "LEFT JOIN prenotazione AS p ON c.hotel = p.struttura_ricettiva AND c.numero = p.camera "
    				+ "INNER JOIN struttura_ricettiva AS s ON c.hotel = s.codice_struttura "
    				+ "WHERE c.prezzo <=50 "
    				+ "GROUP BY c.numero, c.hotel "
    				+ "HAVING COUNT(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.codice_prenotazione , NULL))=0";
    		
    		PreparedStatement pstHot = con.prepareStatement(queryHot); //Prepared Statement per queryHot
    		
    		//Query per selezionare Ostelli disponibili con prezzo a notte minore di 50 €
    		String queryOst = "SELECT s.codice_struttura, s.nome, s.prezzo, "
    				+ "s.posti_letto - SUM(IF((p.check_in >= ? AND p.check_in <= ?) OR (p.check_out >= ? AND p.check_out <= ?), p.persone , 0)) AS pl_disponibili "
    				+ "FROM struttura_ricettiva AS s "
    				+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    				+ "WHERE s.tipo = 'Ostello' AND prezzo<=50 "
    				+ "GROUP BY s.codice_struttura "
    				+ "HAVING pl_disponibili>0";
    		
    		PreparedStatement pstOst = con.prepareStatement(queryOst); //Prepared Statement per queryOst
    		
    		//Finestra temporale nel quale verificare la disponibilità
    		System.out.println("Inserisci la data in cui desideri effettuare il check-in:");
    		java.sql.Date dataIn = Date.valueOf(scanner.nextLine());
    		System.out.println("Inserisci la data in cui desideri effettuare il check-out:");
    		java.sql.Date dataOut = Date.valueOf(scanner.nextLine());
    		
    		//------------------------Impostazione date nel prepared statement-------------------------
    		pstApp.setDate(1, dataIn);
    		pstApp.setDate(2, dataOut);
    		pstApp.setDate(3, dataIn);
    		pstApp.setDate(4, dataOut);
    		
    		pstHot.setDate(1, dataIn);
    		pstHot.setDate(2, dataOut);
    		pstHot.setDate(3, dataIn);
    		pstHot.setDate(4, dataOut);
    		
    		pstOst.setDate(1, dataIn);
    		pstOst.setDate(2, dataOut);
    		pstOst.setDate(3, dataIn);
    		pstOst.setDate(4, dataOut);
    		//-----------------------------------------------------------------------------------------
    		
    		ResultSet rsApp = pstApp.executeQuery(); //Result set per queryApp
    		ResultSet rsHot = pstHot.executeQuery(); //Result set per queryHot
    		ResultSet rsOst = pstOst.executeQuery(); //Result set per queryOst
    		
    		System.out.println("<------------------------- REPORT: STRUTTURE RICETTIVE DISPONIBILI TRA IL " + dataIn + " E IL " + dataOut + " CON PREZZO A NOTTE MINORE DI 50€ -------------------------->\n");
    		
    		//Stampa appartamenti
    		System.out.println("---------------------- APPARTAMENTI ---------------------");
    		while(rsApp.next()) {
    			String codice = rsApp.getString("codice_struttura");
    			String nome = rsApp.getString("nome");
    			BigDecimal prezzo = rsApp.getBigDecimal("prezzo");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + "  	PREZZO A NOTTE: " + prezzo);
    		}
    		System.out.println("-----------------------------------------------------------");
    		
    		//Stampa Camere degli hotel
    		System.out.println("\n---------------------- CAMERE D'HOTEL ---------------------");
    		while(rsHot.next()) {
    			String codice = rsHot.getString("hotel");
    			String nome = rsHot.getString("nome");
    			int num = rsHot.getInt("numero");
    			BigDecimal prezzo = rsHot.getBigDecimal("prezzo");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + "		NUMERO CAMERA: " + num + "		PREZZO A NOTTE: " + prezzo);
    		}
    		System.out.println("-----------------------------------------------------------");
    		
    		//Stampa Ostelli
    		System.out.println("---------------------- OSTELLI ---------------------");
    		while(rsOst.next()) {
    			String codice = rsOst.getString("codice_struttura");
    			String nome = rsOst.getString("nome");
    			BigDecimal prezzo = rsOst.getBigDecimal("prezzo");
    			int pld = rsOst.getInt("pl_disponibili");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + "  	PREZZO A NOTTE: " + prezzo + "		POSTI LETTO DISPONIBILI: " + pld);
    		}
    		System.out.println("-----------------------------------------------------------");
    		System.out.println("\n\n-------------------------------------------------------------- REPORT TERMINATO -------------------------------------------------------------------->");
    	}
    	catch(Exception e) {System.out.println("<----------------------------------------- ERRORE QUERY ------------------------------------>");}
    }
    
    //VISUALIZZAZIONE DEL NUMERO DI PRENOTAZIONI EFFETTUATE DA TUTTI I CLIENTI NELL`ULTIMO MESE
    static void op8(Connection con) {
    	try {
    		String query = "SELECT c.codice_fiscale, c.nome, c.cognome, "
    				+"COUNT( IF(p.check_in BETWEEN CURDATE()-30 AND CURDATE() , p.codice_prenotazione, NULL)) AS lastMonthP "
    				+ "FROM cliente AS c LEFT JOIN prenotazione AS p ON c.codice_fiscale = p.cliente "
    				+ "GROUP BY c.codice_fiscale";
    		
    		Statement stm = con.createStatement();
    		ResultSet rs = stm.executeQuery(query);
    		
    		System.out.println("\n\n<----------------------------------------- REPORT: NUMERO PRENOTAZIONI EFFETTUATE DAI CLIENTI NELL`ULTIMO MESE ------------------------------------>\n\n");
    		
    		while(rs.next()) {
    			String cf = rs.getString("codice_fiscale");
    			String nome = rs.getString("nome");
    			String cognome = rs.getString("cognome");
    			int np = rs.getInt("lastMonthP");
    			
    			System.out.println("CODICE FISCALE: " + cf + "	NOME: " + nome + " 		COGNOME: " + cognome + "		PRENOTAZIONI: " + np);
    		}
    		System.out.println("\n\n<-------------------------------------------------------------- REPORT TERMINATO ------------------------------------------------------------------>\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<----------------------------------------- ERRORE QUERY ------------------------------------>\n\n");
		}
    }
    
    //VISUALIZZAZIONE DEI MIGLIORI 10 CLIENTI PREMIUM CHE ABBIANO EFFETTUATO IL MAGGIOR NUMERO DI PRENOTAZIONI NELLE DIVERSE STRUTTURE RICETTIVE
    static void op9(Connection con) {
    	try {
    		//Query per op9
    		String query = "SELECT c.codice_fiscale, c.nome, c.cognome, COUNT(p.codice_prenotazione) AS np "
    					+ "FROM cliente AS c "
    					+ "INNER JOIN prenotazione AS p ON c.codice_fiscale = p.cliente "
    					+ "INNER JOIN tessera AS t ON c.codice_fiscale = t.cliente "
    					+ "WHERE t.tipo = 'Premium' "
    					+ "GROUP BY c.codice_fiscale "
    					+ "ORDER BY np DESC "
    					+ "LIMIT 10";
    		
    		Statement stm = con.createStatement(); //Statement per query
    		ResultSet rs = stm.executeQuery(query); //Result set per risultati query
    		
    		System.out.println("\n\n<----------------------------------- REPORT: TOP 10 CLIENTI PREMIUM CON PIÙ PRENOTAZIONI ----------------------------->\n\n");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			String cf = rs.getString("codice_fiscale");
    			String nome = rs.getString("nome");
    			String cognome = rs.getString("cognome");
    			int np = rs.getInt("np");
    			
    			System.out.println("CODICE FISCALE: " + cf + "	NOME: " + nome + "		COGNOME: " + cognome + "		PRENOTAZIONI EFFETTUATE: " + np);
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY ----------------------------------------------------->\n\n");}
    }
    
    //VISUALIZZAZIONE DEGLI OSTELLI PER I QUALI NON È STATA MAI REGISTRATA UNA PRENOTAZIONE DI PIÙ DI 7 GIORNI
    static void op10(Connection con) {
    	try {
    		//Query per op10
    		String query = "SELECT s.codice_struttura, s.nome FROM struttura_ricettiva AS s "
    					+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    					+ "WHERE s.tipo = 'Ostello' "
    					+ "GROUP BY s.codice_struttura "
    					+ "HAVING COUNT(IF((p.check_out - p.check_in)>7 , p.codice_prenotazione, NULL))=0";
    		
    		Statement stm = con.createStatement(); //Statement per query
    		ResultSet rs = stm.executeQuery(query); //Result set per risultati query
    		
    		System.out.println("\n\n<----------------------------------- REPORT: OSTELLI SENZA PRENOTAZIONI DI PIÙ DI 7 GIORNI ----------------------------->\n\n");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			String codice = rs.getString("codice_struttura");
    			String nome = rs.getString("nome");
    			
    			System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome);
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY ----------------------------------------------------->\n\n");}
    }
    
    //VISUALIZZAZIONE DELLE STRUTTURE RICETTIVE CHE HANNO UNA DISTANZA DI 10KM SPECIFICA DA UN PUNTO DI INTERESSE
    static void op11(Connection con) {
    	try {
    		int codP = 0; //codice punto di interesse
    		System.out.println("Inserire il codice del punto d`interesse:");
    		codP=Integer.parseInt(scanner.nextLine());
    		
    		String queryPI = "SELECT nome FROM punto_interesse WHERE id=?"; //query per selezionare il nome del punto di interesse (usata solo per un controllo e per la stampa)
    		PreparedStatement pstPI = con.prepareStatement(queryPI); //Prepared Statement per queryPI
    		pstPI.setInt(1, codP);
    		ResultSet rsPI = pstPI.executeQuery(); //Result set per risultati queryPI
    		
    		//-----------------------------------------------------------Punto di interesse trovato----------------------------------------------------------------
    		if(rsPI.next()) {
    			System.out.println("\n\n<-------------------------- REPORT: STRUTTURE RICETTIVE NEL RAGGIO DI 10KM DA "+ rsPI.getString("nome").toUpperCase() +" ------------------------->\n\n");
    			
    			//Query per op11
        		String query = "SELECT s.codice_struttura, s.nome, eg.distanza FROM struttura_ricettiva AS s "
        				+ "INNER JOIN essere_collegati AS eg ON s.codice_struttura = eg.struttura_ricettiva "
        				+ "WHERE eg.punto_interesse = ? AND eg.distanza <= 10";
        		
        		PreparedStatement pst = con.prepareStatement(query); //Prepared Statement per query
    			pst.setInt(1, codP);
    			ResultSet rs = pst.executeQuery(); //Result set per risultati query
    			
    			//Stampa risultati query
    			while(rs.next()) {
    				String codice = rs.getString("codice_struttura");
    				String nome = rs.getString("nome");
    				BigDecimal dist = rs.getBigDecimal("distanza");
    				
    				System.out.println("CODICE STRUTTURA: " + codice + "	NOME: " + nome + " 		DISTANZA: " + dist +"Km");
    			}
    			
    			System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    		}
    		//-----------------------------------------------------------------------------------------------------------------------------------------------------
    		
    		//----------------------------Punto di interesse non trovato----------------------
    		else {
    			System.out.println("\n\n<------------------------------------------- ERRORE: PUNTO DI INTERESSE INESISTENTE ----------------------------------------------------->\n\n");
    		}
    		//---------------------------------------------------------------------------------
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
    
    //VISUALIZZAZIONE DELLA SOMMA DEGLI INCASSI OTTENUTI DALLE STRUTTURE RICETTIVE REGISTRATE SULLA PIATTAFORMA
    static void op12(Connection con) {
    	try {
    		//Query per op12
    		String query = "SELECT s.codice_struttura, s.nome, SUM(p.prezzo_totale) AS incasso "
    						+ "FROM struttura_ricettiva as s "
    						+ "LEFT JOIN prenotazione as p ON s.codice_struttura = p.struttura_ricettiva "
    						+ "GROUP BY s.codice_struttura";
    		
    		Statement stm = con.createStatement(); //Statement per query
    		ResultSet rs = stm.executeQuery(query); //Result set per risultati query
    		
    		System.out.println("\n\n<------------------------------------------- REPORT: INCASSO TOTALE DELLE STRUTTURE RICETTIVE ----------------------------------------------------->\n\n");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			String codice = rs.getString("codice_struttura");
    			String nome = rs.getString("nome");
    			BigDecimal incasso = rs.getBigDecimal("incasso");
    			
    			//Stampa struttura senza alcun incasso
    			if(incasso==null) {
    				System.out.println("CODICE STRUTTURA: " + codice + "		NOME: " + nome + "		INCASSO TOTALE: 0$\n\n");
    			}
    			
    			//Stampa struttura con incasso 
    			else {
    				System.out.println("CODICE STRUTTURA: " + codice + "		NOME: " + nome + "		INCASSO TOTALE: " + incasso + "$\n\n");
    			}
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    		
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
    
    //STAMPA DEI DATI DEI CLIENTI CHE HANNO PRENOTATO SOLO APPARTAMENTI E OSTELLI
    static void op13(Connection con) {
    	try {
    		//Query per op13
    		String query = "SELECT c.codice_fiscale, c.nome, c.cognome, c.data_nascita, c.telefono, c.email FROM cliente AS c "
    					+ "INNER JOIN prenotazione AS p ON c.codice_fiscale = p.cliente "
    					+ "GROUP BY c.codice_fiscale "
    					+ "HAVING COUNT(IF(p.camera IS NOT NULL , p.codice_prenotazione, NULL))=0";
    		
    		Statement stm = con.createStatement(); //Statement per query
    		ResultSet rs = stm.executeQuery(query); //Result set per risultati query
    		
    		System.out.println("\n\n<----------------------------------- REPORT: CLIENTI CHE NON HANNO MAI PRENOTATO HOTEL ----------------------------->\n\n");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			String cf = rs.getString("codice_fiscale");
    			String nome = rs.getString("nome");
    			String cognome = rs.getString("cognome");
    			java.sql.Date data = rs.getDate("data_nascita");
    			String telefono = rs.getString("telefono");
    			String email = rs.getString("email");
    			
    			System.out.println("CODICE FISCALE: " + cf + "	NOME: " + nome + "	COGNOME: " + cognome + 
    							"\nDATA DI NASCITA: " + data + "	TELEFONO: " + telefono + "	E-MAIL: " + email + "\n");
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
    
    //STAMPA DI UN REPORT CHE MOSTRI I DATI DELLE AGENZIE DI VIAGGIO COMPRESO IL NUMERO TOTALE DI PRENOTAZIONI EFFETTUATE
    static void op14(Connection con) {
    	try {
    		//Query per op14
    		String query = "SELECT a.id_agenzia, a.nome, COUNT(p.codice_prenotazione) AS num_prenotazioni FROM agenzia AS a "
    					+ "LEFT JOIN prenotazione AS p ON a.id_agenzia = p.agenzia "
    					+ "GROUP BY a.id_agenzia";
    		Statement stm = con.createStatement(); //statement per query
    		ResultSet rs = stm.executeQuery(query); //Result set per query
    		
    		String queryWS = "SELECT website FROM disponibilita WHERE agenzia = ?"; //query per selezionare i siti web di ogni agenzia
    		PreparedStatement pstWS = con.prepareStatement(queryWS); //Prepared statement per queryWS
    		
    		System.out.println("\n\n<----------------------------------- REPORT: DATI AGENZIE DI VIAGGIO E NUMERO PRENOTAZIONI EFFETTUATE ----------------------------->");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			int id = rs.getInt("id_agenzia");
    			String nome = rs.getString("nome");
    			int np = rs.getInt("num_prenotazioni");
    			
    			System.out.println("\n\n\nID AGENZIA: " + id + "	NOME: " + nome + "	PRENOTAZIONI EFFETTUATE: " + np + "\n");
    			
    			//--------------------Stampa dei siti web----------------------------
    			System.out.println("SITI WEB SU CUI È DISPONIBILE " + nome +":");
    			pstWS.setInt(1, id);
    			ResultSet rsWS = pstWS.executeQuery();
    			while(rsWS.next()) {
    				System.out.print(rsWS.getString("website") + "		");
    			}
    			//-------------------------------------------------------------------
    		
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n\n<----------------------------------- REPORT TERMINATO ----------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
    
    //STAMPA DI UN REPORT CHE MOSTRI I DATI DELLE STRUTTURE RICETTIVE PER UNA SPECIFICA CITTÀ E CHE HANNO RICEVUTO MENO DI 3 PRENOTAZIONI
    static void op15(Connection con) {
    	try {
    		//Query per op15
    		String query = "SELECT s.codice_struttura, s.nome, s.tipo, s.anno_iscrizione, s.servizi, s.via, s.cap, s.vani, s.posti_letto, s.prezzo, s.mq "
    					+ "FROM struttura_ricettiva AS s "
    					+ "LEFT JOIN prenotazione AS p ON s.codice_struttura = p.struttura_ricettiva "
    					+ "WHERE s.citta = ? "
    					+ "GROUP BY s.codice_struttura "
    					+ "HAVING COUNT(p.codice_prenotazione) < 3";
    		
    		PreparedStatement pst = con.prepareStatement(query); //Prepared Statement per query
    		
    		//Inserimento città
    		System.out.println("Inserire la città: ");
    		String city = scanner.nextLine();
    		pst.setString(1, city);
    		
    		ResultSet rs = pst.executeQuery(); //Result set per risultati query
    		
    		String queryT = "SELECT numero FROM telefono_struttura WHERE struttura_ricettiva = ?"; //query per selezionare i recapiti telefonici delle strutture ricettive
    		PreparedStatement pstT = con.prepareStatement(queryT); //Prepared statement per queryT
    		
    		System.out.println("\n\n<----------------------------------- REPORT: STRUTTURE RICETTIVE A " + city.toUpperCase() + " CON MENO DI 3 PRENOTAZIONI ----------------------------->");
    		
    		//-------------------------------------------------------------Stampa del result set------------------------------------------------------
    		while(rs.next()) {
    			String codice = rs.getString("codice_struttura");
    			String nome = rs.getString("nome");
    			String tipo = rs.getString("tipo");
    			int anno = rs.getInt("anno_iscrizione");
    			String servizi = rs.getString("servizi");
    			String via = rs.getString("via");
    			String cap = rs.getString("cap");
    			int vani = rs.getInt("vani");
    			int pl = rs.getInt("posti_letto");
    			BigDecimal prezzo = rs.getBigDecimal("prezzo");
    			int mq = rs.getInt("mq");
    			
    			System.out.println("\n\n\nCODICE STRUTTURA: " + codice + "	NOME: " + nome + "	TIPO: " + tipo + 
    							"\nANNO DI ISCRIZIONE: " + anno + "	SERVIZI: " + servizi + "	VIA: " + via + "	CAP: " + cap);
    			
    			if(tipo.equals("Ostello")) {
    				System.out.println("POSTI LETTO: " + pl + " 	PREZZO A NOTTE: " + prezzo );
    			}
    			else if(tipo.equals("Appartamento")) {
    				System.out.println("VANI: " + vani + "		POSTI LETTO: " + pl + " 		PREZZO A NOTTE: " + prezzo + "		METRI QUADRI: " + mq );
    			}
    			
    			//--------------------Stampa dei recapiti telefonici----------------------------
    			System.out.println("\nRECAPITI TELEFONICI DI " + nome +":");
    			pstT.setString(1, codice);
    			ResultSet rsT = pstT.executeQuery();
    			while(rsT.next()) {
    				System.out.print(rsT.getString("numero") + "		");
    			}
    			//------------------------------------------------------------------------------
    							
    		}
    		//-------------------------------------------------------------------------------------------------------------------------------------
    		
    		System.out.println("\n\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
    
    //STAMPA DI UN REPORT CHE MOSTRI I DATI DELLE PRENOTAZIONI CHE ANCORA NON SONO STATE EFFETTUATE (COSTO COMPRESO)
    static void op16(Connection con) {
    	try {
    		String query="SELECT * FROM prenotazione WHERE (check_in > CAST(CURRENT_TIMESTAMP AS DATE))"; //query per op16
    		Statement stm = con.createStatement(); //statemente per query
    		ResultSet rs = stm.executeQuery(query); //result set per risultati query
    		
    		System.out.println("\n\n<------------------------------------------- REPORT: PRENOTAZIONI NON ANCORA EFFETTUATE ----------------------------------------------------->\n\n");
    		
    		//-----------------Stampa del result set-----------------------
    		while(rs.next()) {
    			String codice = rs.getString("codice_prenotazione");
    			String note = rs.getString("note");
    			int np = rs.getInt("persone");
    			BigDecimal prezzo = rs.getBigDecimal("prezzo_totale");
    			java.sql.Date checkIn = rs.getDate("check_in");
    			java.sql.Date checkOut = rs.getDate("check_out");
    			String cliente = rs.getString("cliente");
    			int agenzia = rs.getInt("agenzia");
    			String struttura = rs.getString("struttura_ricettiva");
    			int camera = rs.getInt("camera");
    			
    			//valore camera non nullo
    			if(camera!=0) {
    			System.out.println("CODICE PRENOTAZIONE: " + codice + "		NOTE: " + note + 
    								"\nPERSONE: " + np + "	PREZZO TOTALE: " + prezzo + "	DATA CHECK-IN: " + checkIn + "	DATA CHECK-OUT: " + checkOut + 
    								"\nCODICE CLIENTE: " + cliente + "	CODICE AGENZIA: " + agenzia + " 		CODICE STRUTTURA: " + struttura + " 	CAMERA: " + camera +"\n\n");
    			}
    			
    			//valore camera nullo
    			else {
    				System.out.println("CODICE PRENOTAZIONE: " + codice + "		NOTE: " + note + 
							"\nPERSONE: " + np + "	PREZZO TOTALE: " + prezzo + "	DATA CHECK-IN: " + checkIn + "	DATA CHECK-OUT: " + checkOut + 
							"\nCODICE CLIENTE: " + cliente + "	CODICE AGENZIA: " + agenzia + "		CODICE STRUTTURA: " + struttura +"\n\n");
    			}
    		}
    		//----------------------------------------------------------
    		
    		System.out.println("\n\n<------------------------------------------- REPORT COMPLETATO ----------------------------------------------------->\n\n");
    	}
    	catch(Exception e) {System.out.println("\n\n<------------------------------------------- ERRORE QUERY! ----------------------------------------------------->\n\n");}
    }
	
    //STAMPA LISTA DELLE OPERAZIONI
    static void opList() {
    	System.out.println("<---------------------------------------------------- LISTA DELLE OPERAZIONI DISPONIBILI --------------------------------------------------------->");
    	System.out.println("0 - Esci");
    	System.out.println("1 - Registrazione di un cliente");
    	System.out.println("2 - Registrazione di una struttura ricettiva");
    	System.out.println("3 - Prenotazione di una struttura ricettiva da parte di un cliente");
    	System.out.println("4 - Attribuzione ad un cliente di una tessera con fidelizzazione premium");
    	System.out.println("5 - Visualizzazione di tutte le strutture ricettive per città");
    	System.out.println("6 - Visualizzazione di tutte le strutture ricettive disponibili in un periodo di tempo specificato");
    	System.out.println("7 - Visualizzazione di tutte le strutture ricettive disponibili in un periodo di tempo specificato il cui prezzo a notte non superi i 50€");
    	System.out.println("8 - Visualizzazione del numero di prenotazioni effettuate da tutti i clienti nell`ultimo mese");
    	System.out.println("9 - Visualizzazione dei migliori dieci clienti premium che abbiano effettuato il maggior numero di prenotazioni nelle diverse strutture ricettive");
    	System.out.println("10 - Visualizzazione degli ostelli per i quali non è stata mai registrata una prenotazione di più di sette giorni");
    	System.out.println("11 - Visualizzazione delle strutture ricettive che hanno una distanza di massimo dieci km da un punto di interesse");
    	System.out.println("12 - Visualizzazione della somma degli incassi ottenuti dalle strutture ricettive registrate sulla piattaforma");
    	System.out.println("13 - Stampa dei dati dei clienti che hanno prenotato solo appartamenti e ostelli");
    	System.out.println("14 - Stampa di un report che mostri i dati delle agenzie di viaggio compreso il numero totale di prenotazioni effettuate");
    	System.out.println("15 - Stampa di un report che mostri i dati delle strutture ricettive per una specifica città e che hanno ricevuto meno di tre prenotazioni");
    	System.out.println("16 - Stampa di un report che mostri i dati delle prenotazioni che ancora non sono state effettuate ed il costo di ognuna di esse");
    	System.out.println("<--------------------------------------------------------------------------------------------------------------------------------------------------->");
    }
    
    public static void main(String[] args) {
		
		//----------CONNESSIONE AL DATABASE-------------
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("CONNESSO AL DATABASE!");
		}
		catch (Exception e) {System.out.println("CONNESSIONE FALLITA!");}
		//---------------------------------------------------
		
		int scelta=0;
		do {
			System.out.println("\n\nINSERIRE IL NUMERO DELL`OPERAZIONE (17-Lista delle operazioni): ");
			scelta=Integer.parseInt(scanner.nextLine());
			
			switch(scelta) {
			
			case 1:
				PrenotazioniDB.op1(con);
				break;
				
			case 2:
				PrenotazioniDB.op2(con);
				break;
				
			case 3:
				PrenotazioniDB.op3(con); 
				break;
				
			case 4:
				PrenotazioniDB.op4(con);
				break;
				
			case 5:
				PrenotazioniDB.op5(con);
				break;
				
			case 6:
				PrenotazioniDB.op6(con);
				break;
				
			case 7:
				PrenotazioniDB.op7(con);
				break;
			
			case 8:
				PrenotazioniDB.op8(con);
				break;
				
			case 9:
				PrenotazioniDB.op9(con);
				break;
				
			case 10:
				PrenotazioniDB.op10(con);
				break;

			case 11:
				PrenotazioniDB.op11(con);
				break;
				
			case 12:
				PrenotazioniDB.op12(con);
				break;
				
			case 13:
				PrenotazioniDB.op13(con);
				break;
				
			case 14:
				PrenotazioniDB.op14(con);
				break;
				
			case 15:
				PrenotazioniDB.op15(con);
				break;
				
			case 16:
				PrenotazioniDB.op16(con);
				break;
			
			case 17:
				PrenotazioniDB.opList();
				break;
			}
		}while(scelta!=0);
		
		System.out.println("\n\nCONNESSIONE TERMINATA");
	}
	
    
}