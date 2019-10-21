package org.sid.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
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
import org.sid.entities.Login;
import org.sid.entities.Sorties;
import org.sid.entities.Unites;
import org.sid.entities.Usages;
import org.sid.entities.Users;
import org.sid.entities.Users_roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controleur {
	@Autowired
	private ArticlesRepository articlesRepository;
	@Autowired
	private EntreesRepository entreesRepository;
	@Autowired
	private SortiesRepository sortiesRepository;
	@Autowired
	private FamilleRepository familleRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private UsagesRepository usagesRepository;
	@Autowired
	private UnitesRepository unitesRepository;
	@Autowired 
	private UsersRepository usersRepository;
	@Autowired 
	private Users_rolesRepository users_rolesRepository;
	 
	
	
	/**********************
	 * PARTIE I: ARTICLES *
	 **********************/
	
	
	  @RequestMapping(value="/articles/user/index")
	  public String index(Model modelA,
			@RequestParam(value="page",defaultValue ="0")int p,
			@RequestParam(value="size",defaultValue ="5")int s,
			@RequestParam(value="motCle",defaultValue ="")String mc) {
		/*
		 * List<Produit> produits=produitRepository.findAll();
		 * model.addAttribute("listProduits", produits);
		 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
		 */
		Page<Articles> pageArticles=articlesRepository.chercher("%"+mc+"%",new PageRequest(p, s));
		modelA.addAttribute("listArticles", pageArticles.getContent());
		int[] pages=new int[pageArticles.getTotalPages()];
		modelA.addAttribute("pages", pages);
		modelA.addAttribute("size", s);
		modelA.addAttribute("pageCourante", p);
		modelA.addAttribute("motCle", mc);
		return "articles/Consulter";
	}
	@RequestMapping(value="/articles/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String delete(Long id, String motCle, int page, int size) {
		articlesRepository.deleteById(id);
		return "redirect:/articles/user/index?page="+page+"&size="+size+"&motCle="+motCle;
	}
	
	@RequestMapping(value="/articles/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String formProduit(Model modelA) {
		modelA.addAttribute("articles", new Articles());
		return "articles/FormulaireArticles";
	}
	
	@RequestMapping(value="/articles/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String edit(Model modelA, Long id) {
		Articles a=articlesRepository.findById(id).get();
		modelA.addAttribute("articles", a);
		return "articles/EditerArticles";
	}
	
	@RequestMapping(value="/articles/admin/articles/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
	public String save(Model modelA, @Valid Articles articles, BindingResult bindingResult) {//
			if (bindingResult.hasErrors())
				return "articles/FormulaireArticles";
			articles.setDate(new Date());
			articles.setPrix_t(articles.getQte()*articles.getPrix_u());
			articlesRepository.save(articles);
		return "articles/ConfirmationArticles";
	}
	
	@RequestMapping(value="/articles/admin/update",method = RequestMethod.PUT)// Si on ne met rien par defaut c est GET 
	public String update(Model modelA, @Valid Articles articles, BindingResult bindingResult) {//
			if (bindingResult.hasErrors())
				return "articles/EditerArticles";
			articles.setDate(new Date());
			articles.setPrix_t(articles.getQte()*articles.getPrix_u());
			articlesRepository.updateA(articles.getRef(), articles.getDesi(), articles.getQte(), 
			articles.getStock_min(), articles.getPrix_u(),articles.getPrix_t(), articles.getDate(), articles.getArt_fam(),
			articles.getArt_rang(), articles.getArt_four(), articles.getArt_usa(), articles.getArt_uni(), articles.getId());

		return "articles/ConfirmationArticles";
	}
	
	
	  @RequestMapping(value="/") public String home() { return
	  "redirect:/acceuil"; }
	 
	 
	  @RequestMapping(value="/403")
	  public String accessDenied() { 
		  return "/403"; 
		  }
	  
	  @RequestMapping(value="/login")
	  public String login() { 
		  return "login"; 
		  }
	
	  @RequestMapping(value="/acceuil")
	  public String acceuil() { 
		  return "acceuil"; 
		  }
	  
	  
	    /**********************
		 * PARTIE II: ENTREES *
		 **********************/
	  

	  @RequestMapping(value="/entrees/user/index")
	    public String indexE(Model modelE,
		@RequestParam(value="page",defaultValue ="0")int p,
		@RequestParam(value="size",defaultValue ="5")int s,
		@RequestParam(value="motCle",defaultValue ="")String mc) {
		/*
		 * List<Produit> produits=produitRepository.findAll();
		 * model.addAttribute("listProduits", produits);
		 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
		 */
		Page<Entrees> pageEntrees=entreesRepository.chercherE("%"+mc+"%",new PageRequest(p, s));
		modelE.addAttribute("listEntrees", pageEntrees.getContent());
		int[] pages=new int[pageEntrees.getTotalPages()];
		modelE.addAttribute("pages", pages);
		modelE.addAttribute("size", s);
		modelE.addAttribute("pageCourante", p);
		modelE.addAttribute("motCle", mc);
		return "entrees/Consulter";
	}
	@RequestMapping(value="/entrees/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String deleteE(Long id, String motCle, int page, int size) {
		entreesRepository.deleteById(id);
		return "redirect:/entrees/user/index?page="+page+"&size="+size+"&motCle="+motCle;
	}
	
	@RequestMapping(value="/entrees/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String formEntrees(Model modelE) {
		modelE.addAttribute("entrees", new Entrees());
		return "entrees/Formulaire";
	}
	
	@RequestMapping(value="/entrees/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String editE(Model modelE, Long id) {
		Entrees e=entreesRepository.findById(id).get();
		modelE.addAttribute("entrees", e);
		return "entrees/Editer";
	}
	
	@RequestMapping(value="/entrees/admin/entrees/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
	public String saveE(Model modelE, @Valid Entrees entrees, BindingResult bindingResult) {//
			if (bindingResult.hasErrors())
				return "entrees/Formulaire";
			entrees.setDate(new Date());
			entreesRepository.save(entrees);
		return "entrees/Confirmation";
	}
	
	@RequestMapping(value="/entrees/admin/update",method = RequestMethod.PUT)// Si on ne met rien par defaut c est GET 
	public String updateE(Model modelE, @Valid Entrees entrees, BindingResult bindingResult) {//
			if (bindingResult.hasErrors())
				return "entrees/Editer";
			entrees.setDate(new Date());
			entreesRepository.updateE(entrees.getRef(), entrees.getDesi(), entrees.getPrix(), entrees.getQte(), 
					entrees.getDate(), entrees.getCondi(),
					entrees.getNomFour(), entrees.getId());

		    return "entrees/Confirmation";
	    }
	
	  
	    /**********************
		 * PARTIE III: SORTIES *
		 **********************/
	
	@RequestMapping(value="/sorties/user/index")
    public String indexS(Model modelS,
	@RequestParam(value="page",defaultValue ="0")int p,
	@RequestParam(value="size",defaultValue ="5")int s,
	@RequestParam(value="motCle",defaultValue ="")String mc) {
	/*
	 * List<Produit> produits=produitRepository.findAll();
	 * model.addAttribute("listProduits", produits);
	 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
	 */
	Page<Sorties> pageSorties=sortiesRepository.chercherS("%"+mc+"%",new PageRequest(p, s));
	modelS.addAttribute("listSorties", pageSorties.getContent());
	int[] pages=new int[pageSorties.getTotalPages()];
	modelS.addAttribute("pages", pages);
	modelS.addAttribute("size", s);
	modelS.addAttribute("pageCourante", p);
	modelS.addAttribute("motCle", mc);
	return "sorties/Consulter";
    }
    @RequestMapping(value="/sorties/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
    public String deleteS(Long id, String motCle, int page, int size) {
    	sortiesRepository.deleteById(id);
	return "redirect:/sorties/user/index?page="+page+"&size="+size+"&motCle="+motCle;
   }

   @RequestMapping(value="/sorties/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String formSorties(Model modelS) {
	modelS.addAttribute("sorties", new Sorties());
	return "sorties/Formulaire";
   }

   @RequestMapping(value="/sorties/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String editS(Model modelS, Long id) {
	Sorties s=sortiesRepository.findById(id).get();
	modelS.addAttribute("sorties", s);
	return "sorties/Editer";
   }

   @RequestMapping(value="/sorties/admin/sorties/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
   public String saveS(Model modelS, @Valid Sorties sorties, BindingResult bindingResult) {//
		if (bindingResult.hasErrors())
			return "sorties/Formulaire";
		sorties.setDate(new Date());
		sortiesRepository.save(sorties);
	return "sorties/Confirmation";
   }

   
	
	          /**********************
	           *  PARTIE IV: FAMILLE *
	           **********************/
   
   @RequestMapping(value="/famille/user/index")
   public String indexF(Model modelF,
	@RequestParam(value="page",defaultValue ="0")int p,
	@RequestParam(value="size",defaultValue ="5")int s,
	@RequestParam(value="motCle",defaultValue ="")String mc) {
	/*
	 * List<Produit> produits=produitRepository.findAll();
	 * model.addAttribute("listProduits", produits);
	 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
	 */
	Page<Famille> pageFamille=familleRepository.chercherF("%"+mc+"%",new PageRequest(p, s));
	modelF.addAttribute("listFamille", pageFamille.getContent());
	int[] pages=new int[pageFamille.getTotalPages()];
	modelF.addAttribute("pages", pages);
	modelF.addAttribute("size", s);
	modelF.addAttribute("pageCourante", p);
	modelF.addAttribute("motCle", mc);
	modelF.addAttribute("famille", new Famille());
	return "famille/Consulter";
   }
   @RequestMapping(value="/famille/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String deleteF(Long id, String motCle, int page, int size) {
	   familleRepository.deleteById(id);
	return "redirect:/famille/user/index?page="+page+"&size="+size+"&motCle="+motCle;
  }

  @RequestMapping(value="/famille/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
  public String formFamille(Model modelF) {
	modelF.addAttribute("famille", new Famille());
	return "famille/Consulter";
  }

  @RequestMapping(value="/famille/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
  public String editF(Model modelF, Long id,
		    @RequestParam(value="page",defaultValue ="0")int p,
			@RequestParam(value="size",defaultValue ="5")int s,
			@RequestParam(value="motCle",defaultValue ="")String mc) {
	  Page<Famille> pageFamille=familleRepository.chercherF("%"+mc+"%",new PageRequest(p, s));
		modelF.addAttribute("listFamille", pageFamille.getContent());
		int[] pages=new int[pageFamille.getTotalPages()];
		modelF.addAttribute("pages", pages);
		modelF.addAttribute("size", s);
		modelF.addAttribute("pageCourante", p);
		modelF.addAttribute("motCle", mc);
	    Famille fa=familleRepository.findById(id).get();
	    modelF.addAttribute("famille", fa);
	return "famille/Editer";
  }

  @RequestMapping(value="/famille/user/famille/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
  public String saveF(Model modelF, @Valid Famille famille, BindingResult bindingResult) {//
		if (bindingResult.hasErrors())
			return "famille/Consulter";
		familleRepository.save(famille);
	return "famille/Confirmation";
  }
  
  @RequestMapping(value="/famille/admin/famille/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
  public String updateF(Model modelF, @Valid Famille famille, BindingResult bindingResult) {//
		if (bindingResult.hasErrors())
			return "famille/Editer";
		familleRepository.save(famille);
	return "famille/Confirmation";
  }

   
   
   
                      /*************************
                       * PARTIE V: FOURNISSEUR *
                       *************************/
    @RequestMapping(value="/fournisseur/user/index")
    public String indexFo(Model modelFo,
	@RequestParam(value="page",defaultValue ="0")int p,
	@RequestParam(value="size",defaultValue ="5")int s,
	@RequestParam(value="motCle",defaultValue ="")String mc) {
	/*
	 * List<Produit> produits=produitRepository.findAll();
	 * model.addAttribute("listProduits", produits);
	 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
	 */
	Page<Fournisseur> pageFournisseur=fournisseurRepository.chercherFo("%"+mc+"%",new PageRequest(p, s));
	modelFo.addAttribute("listFournisseur", pageFournisseur.getContent());
	int[] pages=new int[pageFournisseur.getTotalPages()];
	modelFo.addAttribute("pages", pages);
	modelFo.addAttribute("size", s);
	modelFo.addAttribute("pageCourante", p);
	modelFo.addAttribute("motCle", mc);
	return "fournisseur/Consulter";
    }
   @RequestMapping(value="/fournisseur/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String deleteFo(Long id, String motCle, int page, int size) {
	   fournisseurRepository.deleteById(id);
	  return "redirect:/fournisseur/user/index?page="+page+"&size="+size+"&motCle="+motCle;
    }

    @RequestMapping(value="/fournisseur/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
    public String formFournisseur(Model modelFo) {
	modelFo.addAttribute("fournisseur", new Fournisseur());
	return "fournisseur/Formulaire";
    }

    @RequestMapping(value="/fournisseur/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
    public String editFo(Model modelFo, Long id) {
    	Fournisseur fo=fournisseurRepository.findById(id).get();
	    modelFo.addAttribute("fournisseur", fo);
	    return "fournisseur/Editer";
    }

    @RequestMapping(value="/fournisseur/admin/fournisseur/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
    public String saveFo(Model modelFo, @Valid Fournisseur fournisseur, BindingResult bindingResult) {//
		if (bindingResult.hasErrors())
			return "fournisseur/Formulaire";
		fournisseurRepository.save(fournisseur);
	return "fournisseur/Confirmation";
   }

	


  
                    /*************************
                     *    PARTIE VI: USAGES   *
                     *************************/
    
    @RequestMapping(value="/usages/user/index")
    public String indexUs(Model modelUs,
 	@RequestParam(value="page",defaultValue ="0")int p,
 	@RequestParam(value="size",defaultValue ="5")int s,
 	@RequestParam(value="motCle",defaultValue ="")String mc) {
 	/*
 	 * List<Produit> produits=produitRepository.findAll();
 	 * model.addAttribute("listProduits", produits);
 	 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
 	 */
 	Page<Usages> pageUsages=usagesRepository.chercherUs("%"+mc+"%",new PageRequest(p, s));
 	modelUs.addAttribute("listUsages", pageUsages.getContent());
 	int[] pages=new int[pageUsages.getTotalPages()];
 	modelUs.addAttribute("pages", pages);
 	modelUs.addAttribute("size", s);
 	modelUs.addAttribute("pageCourante", p);
 	modelUs.addAttribute("motCle", mc);
 	modelUs.addAttribute("usages", new Usages());
 	return "usages/Consulter";
    }
    @RequestMapping(value="/usages/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
    public String deleteUs(Long id, String motCle, int page, int size) {
    	usagesRepository.deleteById(id);
 	return "redirect:/usages/user/index?page="+page+"&size="+size+"&motCle="+motCle;
   }

   @RequestMapping(value="/usages/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String formUsages(Model modelUs) {
 	modelUs.addAttribute("usages", new Usages());
 	return "usages/Consulter";
   }

   @RequestMapping(value="/usages/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
   public String editUs(Model modelUs, Long id,
 		    @RequestParam(value="page",defaultValue ="0")int p,
 			@RequestParam(value="size",defaultValue ="5")int s,
 			@RequestParam(value="motCle",defaultValue ="")String mc) {
 	  Page<Usages> pageUsages=usagesRepository.chercherUs("%"+mc+"%",new PageRequest(p, s));
 		modelUs.addAttribute("listUsages", pageUsages.getContent());
 		int[] pages=new int[pageUsages.getTotalPages()];
 		modelUs.addAttribute("pages", pages);
 		modelUs.addAttribute("size", s);
 		modelUs.addAttribute("pageCourante", p);
 		modelUs.addAttribute("motCle", mc);
 		Usages usa=usagesRepository.findById(id).get();
 	    modelUs.addAttribute("usages", usa);
 	    return "usages/Editer";
   }

   @RequestMapping(value="/usages/user/usages/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
   public String saveUs(Model modelUs, @Valid Usages usages, BindingResult bindingResult) {//
 		if (bindingResult.hasErrors())
 			return "usages/Consulter";
 		usagesRepository.save(usages);
 	return "usages/Confirmation";
   }
   
   @RequestMapping(value="/usages/admin/usages/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
   public String updateUs(Model modelUs, @Valid Usages usages, BindingResult bindingResult) {//
 		if (bindingResult.hasErrors())
 			return "usages/Editer";
 		usagesRepository.save(usages);
 	return "usages/Confirmation";
   }

    
    
    
    
    
    
                        /*************************
                         *   PARTIE VII: UNITES  *
                         *************************/
   
		   @RequestMapping(value="/unites/user/index")
		    public String indexUn(Model modelUn,
			@RequestParam(value="page",defaultValue ="0")int p,
			@RequestParam(value="size",defaultValue ="5")int s,
			@RequestParam(value="motCle",defaultValue ="")String mc) {
			
			Page<Unites> pageUnites=unitesRepository.chercherUn("%"+mc+"%",new PageRequest(p, s));
			modelUn.addAttribute("listUnites", pageUnites.getContent());
			int[] pages=new int[pageUnites.getTotalPages()];
			modelUn.addAttribute("pages", pages);
			modelUn.addAttribute("size", s);
			modelUn.addAttribute("pageCourante", p);
			modelUn.addAttribute("motCle", mc);
			modelUn.addAttribute("unites", new Unites());
			return "unites/Consulter";
		   }
		   
		   @RequestMapping(value="/unites/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		   public String deleteUn(Long id, String motCle, int page, int size) {
			   unitesRepository.deleteById(id);
			return "redirect:/unites/user/index?page="+page+"&size="+size+"&motCle="+motCle;
		  }
		
		  @RequestMapping(value="/unites/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		  public String formUnites(Model modelUn) {
			modelUn.addAttribute("unites", new Unites());
			return "unites/Consulter";
		  }
		
		  @RequestMapping(value="/unites/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		  public String editUn(Model modelUn, Long id,
				    @RequestParam(value="page",defaultValue ="0")int p,
					@RequestParam(value="size",defaultValue ="5")int s,
					@RequestParam(value="motCle",defaultValue ="")String mc) {
			    Page<Unites> pageUnites=unitesRepository.chercherUn("%"+mc+"%",new PageRequest(p, s));
				modelUn.addAttribute("listUnites", pageUnites.getContent());
				int[] pages=new int[pageUnites.getTotalPages()];
				modelUn.addAttribute("pages", pages);
				modelUn.addAttribute("size", s);
				modelUn.addAttribute("pageCourante", p);
				modelUn.addAttribute("motCle", mc);
				Unites uni=unitesRepository.findById(id).get();
			    modelUn.addAttribute("unites", uni);
			    return "unites/Editer";
		  }
		
		  @RequestMapping(value="/unites/user/unites/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
		  public String saveUn(Model modelUn, @Valid Unites unites, BindingResult bindingResult) {//
				if (bindingResult.hasErrors())
					return "unites/Consulter";
				unitesRepository.save(unites);
			return "unites/Confirmation";
		  }
		  
		  @RequestMapping(value="/unites/admin/unites/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
		  public String updateUn(Model modelUn, @Valid Unites unites, BindingResult bindingResult) {//
				if (bindingResult.hasErrors())
					return "unites/Editer";
				unitesRepository.save(unites);
			return "unites/Confirmation";
		  }

   
    
    
    
						    /*************************
						     *   PARTIE VIII: USERS  *
						     *************************/
		    @RequestMapping(value="/utilisateur/admin/index")
		    public String indexU(Model modelU,
			@RequestParam(value="page",defaultValue ="0")int p,
			@RequestParam(value="size",defaultValue ="5")int s,
			@RequestParam(value="motCle",defaultValue ="")String mc) {
			
			Page<Users> pageUsers=usersRepository.chercherU("%"+mc+"%",new PageRequest(p, s));
			modelU.addAttribute("listUsers", pageUsers.getContent());
			int[] pages=new int[pageUsers.getTotalPages()];
			modelU.addAttribute("pages", pages);
			modelU.addAttribute("size", s);
			modelU.addAttribute("pageCourante", p);
			modelU.addAttribute("motCle", mc);
			return "utilisateur/Consulter";
		    }
		   @RequestMapping(value="/utilisateur/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		   public String deleteU(Long id, String motCle, int page, int size) {
			   usersRepository.deleteById(id);
			  return "redirect:/utilisateur/admin/index?page="+page+"&size="+size+"&motCle="+motCle;
		    }

		    @RequestMapping(value="/utilisateur/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		    public String formUtilisateur(Model modelU) {
			modelU.addAttribute("users", new Users());
			return "utilisateur/Formulaire";
		    }

		    @RequestMapping(value="/utilisateur/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		    public String editU(Model modelU, Long id) {
		    	Users u=usersRepository.findById(id).get();
			    modelU.addAttribute("users", u);
			    return "utilisateur/Editer";
		    }

		    @RequestMapping(value="/utilisateur/admin/utilisateur/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
		    public String saveU(Model modelU, @Valid Users users, BindingResult bindingResult) throws NoSuchAlgorithmException {//
				if (bindingResult.hasErrors())
					return "utilisateur/Formulaire";
				
				String pass=users.getPass();
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(pass.getBytes()); byte[] digest = md.digest(); 
				String Hash = DatatypeConverter .printHexBinary(digest).toLowerCase();
				users.setPass(Hash);
				usersRepository.save(users);
			return "utilisateur/Confirmation";
		   }
	  
		  
		  
		  

						    /*******************************
						     *   PARTIE VIII: USERS_ROLES  *
						     *******************************/
		  
		    @RequestMapping(value="/role/admin/index")
		    public String indexUr(Model modelUr,
			@RequestParam(value="page",defaultValue ="0")int p,
			@RequestParam(value="size",defaultValue ="5")int s,
			@RequestParam(value="motCle",defaultValue ="")String mc) {
			/*
			 * List<Produit> produits=produitRepository.findAll();
			 * model.addAttribute("listProduits", produits);
			 * Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, s));
			 */
			Page<Users_roles> pageUr=users_rolesRepository.chercherUr("%"+mc+"%",new PageRequest(p, s));
			modelUr.addAttribute("listUr", pageUr.getContent());
			int[] pages=new int[pageUr.getTotalPages()];
			modelUr.addAttribute("pages", pages);
			modelUr.addAttribute("size", s);
			modelUr.addAttribute("pageCourante", p);
			modelUr.addAttribute("motCle", mc);
			modelUr.addAttribute("roles", new Users_roles());
			return "role/Consulter";
		   }
		   @RequestMapping(value="/role/admin/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		   public String deleteUr(Long id, String motCle, int page, int size) {
			   users_rolesRepository.deleteById(id);
			return "redirect:/role/admin/index?page="+page+"&size="+size+"&motCle="+motCle;
		  }
		
		  @RequestMapping(value="/role/admin/form",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		  public String formUr(Model modelUr) {
			modelUr.addAttribute("roles", new Users_roles());
			return "role/Consulter";
		  }
		
		  @RequestMapping(value="/role/admin/edit",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
		  public String editUr(Model modelUr, Long id,
				    @RequestParam(value="page",defaultValue ="0")int p,
					@RequestParam(value="size",defaultValue ="5")int s,
					@RequestParam(value="motCle",defaultValue ="")String mc) {
			    Page<Users_roles> pageUr=users_rolesRepository.chercherUr("%"+mc+"%",new PageRequest(p, s));
				modelUr.addAttribute("listUr", pageUr.getContent());
				int[] pages=new int[pageUr.getTotalPages()];
				modelUr.addAttribute("pages", pages);
				modelUr.addAttribute("size", s);
				modelUr.addAttribute("pageCourante", p);
				modelUr.addAttribute("motCle", mc);
				Users_roles uni=users_rolesRepository.findById(id).get();
				
			    modelUr.addAttribute("roles", uni);
			    return "role/Editer";
		  }
		
		  @RequestMapping(value="/role/admin/role/admin/save",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
		  public String saveUr(Model modelUr, @Valid Users_roles roles, BindingResult bindingResult) {//
				if (bindingResult.hasErrors())
					return "role/Consulter";
				users_rolesRepository.save(roles);
			return "redirect:/role/admin/index";
		  }
		  
		  
		  @RequestMapping(value="/role/admin/role/admin/save1",method = RequestMethod.POST)// Si on ne met rien par defaut c est GET 
		  public String updateUr(Model modelUr, @Valid Users_roles roles, BindingResult bindingResult) {//
				if (bindingResult.hasErrors())
					return "role/Editer";
				   List<Login> lgs=usersRepository.getLogins();
			       modelUr.addAttribute("lgs",lgs);
				users_rolesRepository.save(roles);
			return "redirect:/role/admin/index";
		  }
	 
		 
}
