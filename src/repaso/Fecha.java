
package repaso;
/**
 * @author franco
 */
public class Fecha {
    private int dia;
    private int mes;
    private int ano;
    
    /**
     * constructor
     */
    public Fecha(){
        dia = 0;
        mes = 0;
        ano = 0;
    }
    
    public Fecha(int dia,int mes ,int ano){
        if(dia > -1 && dia < 31 && mes > 0 && mes < 13){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else{
            dia = 0;
            mes = 0;
            ano = 0;
        }
    }
    
    
    //observadores
    /**
     * obtenemos el dia definido
     * @return 
     */
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.dia;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    //modificadores
    
    public boolean setDia(int dia){
        boolean retorno = false;
        if(dia > -1 && dia < 32){
            this.dia = dia;
            retorno = true;
        }
        return retorno;
    }
    
    public boolean setMes(int mes){
        boolean retorno = false;
        if(mes > 0 && mes < 13){
            this.mes = mes;
            retorno = true;
        }
        return retorno;
    }
    
    public boolean setAno(int ano){
        this.ano = ano;
        return true;
    }
    
    public String toString(){
        String dia;
        String mes;
        String ano;
        if(this.dia < 10){
            dia = "0"+this.dia;
        }else{
            dia = ""+this.dia;
        }
        
        if(this.mes < 10){
            mes = "0"+this.mes;
        }else{
            mes = ""+this.mes;
        }
        
        if(this.ano < 10){
            ano = "000"+this.ano;
        }else{
            if(this.ano < 100){
                ano = "00"+this.ano;
            }else{
                if(this.ano < 1000){
                    ano = "0"+this.ano;
                }else{
                    ano = ""+this.ano;
                }
            }
        }
        return dia+"/"+mes+"/"+ano;
    }
    
    
}
