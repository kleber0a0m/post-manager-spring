package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Address;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Cidade;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Veiculo;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.AddressRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.CidadeRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.VeiculoRepository;

@Component
public class InitializeDatabase implements CommandLineRunner{
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;
	
	@Autowired
	private CidadeRepository cRepo;
	
	@Autowired
	private VeiculoRepository vRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Cidade p = new Cidade();
		p.setName("Poço Fundo");
		p.setState("MG");
		
		Cidade m = new Cidade();
		m.setName("Machado");
		m.setState("MG");
		
		cRepo.save(p);
		cRepo.save(m);
		
		Veiculo palio = new Veiculo();
		palio.setCor("Vermelho");
		palio.setModelo("Palio");
		palio.setPlaca("ABC-1234");
		
		Veiculo celta = new Veiculo();
		celta.setCor("Preto");
		celta.setModelo("Celta");
		celta.setPlaca("RTY-2584");
		
		
		vRepo.save(palio);
		vRepo.save(celta);
		
		Address a = new Address();
		a.setPlace("Rua Dom Pedro I");
		a.setNumber(253);
		a.setZipCode("37757-000");
		a.setCidade(m);
		
		Address b = new Address();
		b.setPlace("Rua Joaquim Pereira");
		b.setNumber(1);
		b.setZipCode("37733-000");
		b.setCidade(p);
		
		aRepo.save(a);
		aRepo.save(b);
		aRepo.flush();
		
		User l = new User();
		l.setName("Lucas");
		l.setEmail("lucas@gmail.com");
		l.setGender("M");
		l.setAddress(a);
		
		
		User k = new User();
		k.setName("Kleber");
		k.setEmail("kleber@gmail.com");
		k.setGender("M");
		k.setAddress(b);
		k.setAddress(a);
		
		
		uRepo.save(l);
		uRepo.save(k);
		
		
	}

}
