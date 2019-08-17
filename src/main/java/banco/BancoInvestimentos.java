package banco;

public class BancoInvestimentos implements QualquerBanco {

  public double saldoTotal(){
    return 1000;
  }

  public int numContas(){
    return 12;
  }
  
  public void m(){
	  System.out.println("Banco de investimento");
  }

}  