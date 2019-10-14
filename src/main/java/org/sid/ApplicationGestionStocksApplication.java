package org.sid;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.sid.dao.ArticlesRepository;
import org.sid.dao.EntreesRepository;
import org.sid.dao.FamilleRepository;
import org.sid.dao.FournisseurRepository;
import org.sid.dao.SortiesRepository;
import org.sid.dao.UnitesRepository;
import org.sid.dao.UsagesRepository;
import org.sid.dao.UsersRepository;
import org.sid.dao.Users_rolesRepository;
import org.sid.entities.Articles;
import org.sid.entities.Entrees;
import org.sid.entities.Famille;
import org.sid.entities.Fournisseur;
import org.sid.entities.Sorties;
import org.sid.entities.Unites;
import org.sid.entities.Usages;
import org.sid.entities.Users;
import org.sid.entities.Users_roles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationGestionStocksApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException{
		ApplicationContext ctx= SpringApplication.run(ApplicationGestionStocksApplication.class, args);
		ArticlesRepository articlesRepository=ctx.getBean(ArticlesRepository.class);
		EntreesRepository entreesRepository=ctx.getBean(EntreesRepository.class);
		SortiesRepository sortiesRepository=ctx.getBean(SortiesRepository.class);
		FamilleRepository familleRepository=ctx.getBean(FamilleRepository.class);
		FournisseurRepository fournisseurRepository=ctx.getBean(FournisseurRepository.class);
		UsagesRepository usagesRepository=ctx.getBean(UsagesRepository.class);
		UnitesRepository unitesRepository=ctx.getBean(UnitesRepository.class);
		UsersRepository usersRepository=ctx.getBean(UsersRepository.class);
		Users_rolesRepository users_rolesRepository=ctx.getBean(Users_rolesRepository.class);
		
		
		/*
		 * articlesRepository.save(new Articles("001A", "Papier Canson", 110, 10,
		 * 200,2200,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "feuille"));
		 * articlesRepository.save(new Articles("002A", "Odinateur", 20, 3,
		 * 250000,5000000,new Date(), "machine", "AM01B01", "FasoTech", "info", "pc"));
		 * articlesRepository.save(new Articles("003A", "Papier Rame", 40, 10,
		 * 2000,80000,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "paquet"));
		 * articlesRepository.save(new Articles("004A", "Papier Canson", 110, 10,
		 * 200,2200,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "feuille"));
		 * articlesRepository.save(new Articles("005A", "Odinateur", 20, 3,
		 * 250000,5000000,new Date(), "machine", "AM01B01", "FasoTech", "info", "pc"));
		 * articlesRepository.save(new Articles("006A", "Papier Rame", 40, 10,
		 * 2000,80000,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "paquet"));
		 * articlesRepository.save(new Articles("007A", "Papier Canson", 110, 10,
		 * 200,2200,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "feuille"));
		 * articlesRepository.save(new Articles("008A", "Odinateur", 20, 3,
		 * 250000,5000000,new Date(), "machine", "AM01B01", "FasoTech", "info", "pc"));
		 * articlesRepository.save(new Articles("009A", "Papier Rame", 40, 10,
		 * 2000,80000,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "paquet"));
		 * articlesRepository.save(new Articles("0010A", "Papier Canson", 110, 10,
		 * 200,2200,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "feuille"));
		 * articlesRepository.save(new Articles("0011A", "Odinateur", 20, 3,
		 * 250000,5000000,new Date(), "machine", "AM01B01", "FasoTech", "info", "pc"));
		 * articlesRepository.save(new Articles("0012A", "Papier Rame", 40, 10,
		 * 2000,80000,new Date(), "Papier", "AM01B01", "FasoTech", "SGR", "paquet"));
		 * 
		 * articlesRepository.findAll().forEach(a->System.out.println(a.getDesi()) );
		 */

		
		
		/*
		 * entreesRepository.save(new Entrees("E001A", "Papier Canson", 200, 3000, new
		 * Date(), "Papier", "FasoTech")); entreesRepository.save(new Entrees("E002A",
		 * "Stylo Bic", 100, 30000, new Date(), "Papier", "YAMEOGO"));
		 * entreesRepository.save(new Entrees("E003A", "Ordinateur", 200000, 10, new
		 * Date(), "Machine", "FasoTech")); entreesRepository.save(new Entrees("E004A",
		 * "Serpière", 700, 100, new Date(), "Hygène", "Natacha"));
		 * entreesRepository.save(new Entrees("E005A", "Ancre", 10000, 30, new Date(),
		 * "Papier", "FasoTech")); entreesRepository.save(new Entrees("E006A",
		 * "Papier Canson", 200, 3000, new Date(), "Papier", "FasoTech"));
		 * entreesRepository.save(new Entrees("E007A", "Stylo Bic", 100, 30000, new
		 * Date(), "Papier", "YAMEOGO")); entreesRepository.save(new Entrees("E008A",
		 * "Ordinateur", 200000, 10, new Date(), "Machine", "FasoTech"));
		 * entreesRepository.save(new Entrees("E009A", "Serpière", 700, 100, new Date(),
		 * "Hygène", "Natacha")); entreesRepository.save(new Entrees("E0010A", "Ancre",
		 * 10000, 30, new Date(), "Papier", "FasoTech")); entreesRepository.save(new
		 * Entrees("E0011A", "Papier Canson", 200, 3000, new Date(), "Papier",
		 * "FasoTech")); entreesRepository.save(new Entrees("E0012A", "Stylo Bic", 100,
		 * 30000, new Date(), "Papier", "YAMEOGO")); entreesRepository.save(new
		 * Entrees("E0013A", "Ordinateur", 200000, 10, new Date(), "Machine",
		 * "FasoTech")); entreesRepository.save(new Entrees("E0014A", "Serpière", 700,
		 * 100, new Date(), "Hygène", "Natacha")); entreesRepository.save(new
		 * Entrees("E0015A", "Ancre", 10000, 30, new Date(), "Papier", "FasoTech"));
		 * 
		 * entreesRepository.findAll().forEach(e->System.out.println(e.getDesi()) );
		 */
		 
		
		/*
		 * sortiesRepository.save(new Sorties("S001A", "Papier Canson", 200, 3000, new
		 * Date(), "Papier", "Maintenance","SAWADOGO")); sortiesRepository.save(new
		 * Sorties("S002A","Stylo Bic", 100, 30000, new Date(), "Papier",
		 * "Informatique","YAMEOGO")); sortiesRepository.save(new Sorties("S003A",
		 * "Ordinateur", 200000, 10, new Date(), "Machine","SGR","SAWADOGO"));
		 * sortiesRepository.save(new Sorties("S004A","Serpière", 700, 100, new Date(),
		 * "Hygène","SGR","BAMBARA")); sortiesRepository.save(new Sorties("S005A",
		 * "Ancre", 10000, 30, new Date(),"Papier", "SGR","YAMEOGO"));
		 * sortiesRepository.save(new Sorties("S006A", "Papier Canson", 200, 3000, new
		 * Date(), "Papier", "Maintenance","SAWADOGO")); sortiesRepository.save(new
		 * Sorties("S007A","Stylo Bic", 100, 30000, new Date(), "Papier",
		 * "Informatique","YAMEOGO")); sortiesRepository.save(new Sorties("S008A",
		 * "Ordinateur", 200000, 10, new Date(), "Machine","SGR","SAWADOGO"));
		 * sortiesRepository.save(new Sorties("S009A","Serpière", 700, 100, new Date(),
		 * "Hygène","SGR","BAMBARA")); sortiesRepository.save(new Sorties("S0010A",
		 * "Ancre", 10000, 30, new Date(),"Papier", "SGR","YAMEOGO"));
		 * sortiesRepository.save(new Sorties("S0011A", "Papier Canson", 200, 3000, new
		 * Date(), "Papier", "Maintenance","SAWADOGO")); sortiesRepository.save(new
		 * Sorties("S0012A","Stylo Bic", 100, 30000, new Date(), "Papier",
		 * "Informatique","YAMEOGO")); sortiesRepository.save(new Sorties("S0013A",
		 * "Ordinateur", 200000, 10, new Date(), "Machine","SGR","SAWADOGO"));
		 * sortiesRepository.save(new Sorties("S0014A","Serpière", 700, 100, new Date(),
		 * "Hygène","SGR","BAMBARA")); sortiesRepository.save(new Sorties("S0015A",
		 * "Ancre", 10000, 30, new Date(),"Papier", "SGR","YAMEOGO"));
		 * 
		  sortiesRepository.findAll().forEach(s->System.out.println(s.getDesi()) );
		 */
		/*
		 * familleRepository.save(new Famille("Informatique",
		 * "Clés USB, Cordon USB, Disque SSD, Mémoire, etc.."));
		 * familleRepository.save(new Famille("Electricité",
		 * "Ampoule, fusible, câble, etc..")); familleRepository.save(new
		 * Famille("Entretien", "Nettoyant divers, savon, balai, serpiaire"));
		 * familleRepository.save(new Famille("Mécanique",
		 * "Vis, Ecrous, Clous, outillage")); familleRepository.save(new
		 * Famille("Sucrerie", "bonbon, lait"));
		 familleRepository.findAll().forEach(fa->System.out.println(fa.getNom()) );*/
		
		/*
		 * fournisseurRepository.save(new Fournisseur("YAMEOGO", "01 BP 507 OUAGA 01",
		 * "Burkina", "45674328", "yamsam@gmail.com")); fournisseurRepository.save(new
		 * Fournisseur("CONRAD", "01 BP 507 PARIS 01", "France", "033 45674328",
		 * "conrad@gmail.com"));
		
		fournisseurRepository.findAll().forEach(fo->System.out.println(fo.getNom()) ); */
		
		/*
		 * usagesRepository.save(new Usages("Véhicules", "Voitures et camionette"));
		 * usagesRepository.save(new Usages("Bureaux", "Bureaux administratifs"));
		 * usagesRepository.save(new Usages("Atelier", "Pour l'atelier"));
		 * usagesRepository.save(new Usages("Jardin", "Pour le jardinnage"));
		 * usagesRepository.save(new Usages("Batiment",
		 * "Pour le batiment, garage, locaux")); usagesRepository.save(new
		 * Usages("Machines", "Pour les machines"));
		 
		usagesRepository.findAll().forEach(usa->System.out.println(usa.getNom()));*/
		/*
		 * unitesRepository.save(new Unites("PC", "Par Pièces"));
		 * unitesRepository.save(new Unites("PQ", "Par Paquet"));
		 * unitesRepository.save(new Unites("Kg", "Par Kilogrammes"));
		 
		unitesRepository.findAll().forEach(uni->System.out.println(uni.getNom()));*/
		
		
		/*
		 * String pass="123456"; MessageDigest md = MessageDigest.getInstance("MD5");
		 * md.update(pass.getBytes()); byte[] digest = md.digest(); String myHash =
		 * DatatypeConverter .printHexBinary(digest).toUpperCase();
		 * usersRepository.save(new Users("005A", "YAMEOGO", "Nathalie", "2019-04-30",
		 * "Nathalie",myHash));
		 */
		 
		
		
		/*
		 * users_rolesRepository.save(new Users_roles("Nathalie", "ADMIN"));
		 * users_rolesRepository.save(new Users_roles("Nathalie", "USER"));
		 */
		 
		 
	}

}
