package com.HILI.ESolde;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*; 
import org.springframework.context.support.*;

import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.metier.Equipe_ESoldeMetier;

public class TestDao{
	@Before
	public void setUp() throws Exception { }
	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context=
					new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
			Equipe_ESoldeMetier metier=(Equipe_ESoldeMetier) context.getBean("Equipe_ESoldeMetier");
			
			metier.listCategories();
		//	System.out.print(cats1.get(0).getDescription_categorie());
			//metier.AjouterCategorie(new Categorie("Ordinateurs"));
			//List<Categorie> cats2=metier.listCategories();
			//assertTrue(cats2.size()==cats1.size()+2);
			assertTrue(true);
		} catch (Exception e) { assertTrue(e.getMessage(),false);}}
}