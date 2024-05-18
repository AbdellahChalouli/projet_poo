package projet_poo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous {

		private String nomClient;
		private String prenomClient;
        private LocalDate dateRdv;
        private LocalTime heureRdv;
		private String adresseBien;
		private int numTelephone;

    

		public RendezVous(String nomClient,String prenomClient, LocalDate dateRdv, LocalTime heureRdv, String adresseBien,int numTelephone) {
       	this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateRdv = dateRdv;
        this.heureRdv = heureRdv;
        this.adresseBien = adresseBien;
        this.numTelephone = numTelephone;
        }
       

		public String getNomClient() {
			return nomClient;
		}

		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}
		public String getPrenomClient() {
				return prenomClient;
		}

		public void setPrenomClient(String prenomClient) {
				this.prenomClient = prenomClient;
		}


		public LocalDate getDateRdv() {
			return dateRdv;
		}

		public void setDateRdv(LocalDate dateRdv) {
			this.dateRdv = dateRdv;
		}

		public LocalTime getHeureRdv() {
			return heureRdv;
		}

		public void setHeureRdv(LocalTime heureRdv) {
			this.heureRdv = heureRdv;
		}

		public String getAdresseBien() {
			return adresseBien;
		}

		public void setAdresseBien(String adresseBien) {
			this.adresseBien = adresseBien;
		}
	    public int getNumTelephone() {
				return numTelephone;
			}


		public void setNumTelephone(int numTelephone) {
				this.numTelephone = numTelephone;
			}


        }
